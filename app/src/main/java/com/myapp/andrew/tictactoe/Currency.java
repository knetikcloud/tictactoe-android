package com.myapp.andrew.tictactoe;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.vending.billing.IInAppBillingService;
import com.knetikcloud.api.InvoicesApi;
import com.knetikcloud.api.PaymentsApi;
import com.knetikcloud.api.PaymentsStripeApi;
import com.knetikcloud.api.StoreShoppingCartsApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;
import com.knetikcloud.model.PayBySavedMethodRequest;
import com.knetikcloud.model.PaymentMethodResource;
import com.knetikcloud.model.StripeCreatePaymentMethod;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;
import static com.myapp.andrew.tictactoe.R.id.progressBar;

public class Currency extends AppCompatActivity {
    int userId;
    String username;
    int paymentMethodId;
    Boolean paymentMethodExists = false;
    int invoiceId;

    // Implementing a ServiceConnection to bind the activity to IInAppBillingService and establish a connection with the In-app Billing service on Google Play
    IInAppBillingService mService;
    ServiceConnection mServiceConn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }

        @Override
        public void onServiceConnected(ComponentName name,
                                       IBinder service) {
            mService = IInAppBillingService.Stub.asInterface(service);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");

        Intent serviceIntent =
                new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mService != null) {
            unbindService(mServiceConn);
        }
    }

    public void makePurchase(View view) {
        final Button button = (Button) view;
        final String sku = button.getTag().toString();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                // Creates a new shopping cart
                StoreShoppingCartsApi apiInstance = client.createService(StoreShoppingCartsApi.class);
                String currencyCode = "USD";
                try {
                    Call<String> call = apiInstance.createCart(userId, currencyCode);
                    Response<String> result = call.execute();
                    String cartId = result.body();
                    System.out.println("Cart ID: " + cartId);

                    // Adds selected item to the cart
                    CartItemRequest cartItemRequest = new CartItemRequest();
                    cartItemRequest.setCatalogSku(sku);
                    cartItemRequest.setQuantity(1);

                    try {
                        Call call2 = apiInstance.addItemToCart(cartId, cartItemRequest);
                        Response result2 = call2.execute();

                        // Creates an invoice for the cart
                        InvoicesApi invoicesApi = client.createService(InvoicesApi.class);
                        InvoiceCreateRequest req = new InvoiceCreateRequest();
                        req.setCartGuid(cartId);
                        try {
                            Call<List<InvoiceResource>> call3 = invoicesApi.createInvoice(req);
                            Response<List<InvoiceResource>> result3 = call3.execute();
                            System.out.println(result.body());
                            invoiceId = result3.body().get(0).getId();

                            String testPublishableKey = getString(R.string.knetikStripeTestPublishableKey);
                            Stripe stripe = new Stripe(getApplicationContext(), testPublishableKey);

                            // Checking if the user already has a payment method for Stripe
                            PaymentsApi apiInstance2 = client.createService(PaymentsApi.class);
                            try {
                                Call<List<PaymentMethodResource>> callB = apiInstance2.getPaymentMethods(userId, null, null, null, null, null, null, null);
                                Response<List<PaymentMethodResource>> resultB = callB.execute();
                                System.out.println(result.body());

                                for(PaymentMethodResource rsc : resultB.body()) {
                                    if(rsc.getName().equals("Stripe Account")) {
                                        paymentMethodId = rsc.getId().intValue();
                                        paymentMethodExists = true;
                                        break;
                                    }
                                }
                                // confirms they have a stripe account (which in this case, means a membership)
                                if(!paymentMethodExists) {
                                    System.out.println("Payment Error!!!");
                                    currencyPaymentError();
                                }
                            } catch (IOException e) {
                                //progressBar.setVisibility(View.GONE);
                                System.err.println("Exception when calling PaymentsApi#getPaymentMethods");
                                e.printStackTrace();
                            }

                            // Pays the invoice with the Stripe payment method
                            System.out.println("here 1");
                            InvoicesApi apiInstance3 = client.createService(InvoicesApi.class);
                            PayBySavedMethodRequest payBySavedMethodRequest = new PayBySavedMethodRequest(); // PayBySavedMethodRequest | Payment info
                            payBySavedMethodRequest.setPaymentMethod(paymentMethodId);
                            try {
                                System.out.println("here 2");
                                Call call4 = apiInstance3.payInvoice(invoiceId, payBySavedMethodRequest);
                                Response result4 = call4.execute();
                                System.out.println(result4.body());
                                Currency.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        currencyPurchaseSuccess();
                                    }
                                });
                            } catch (IOException e) {
                                System.err.println("Exception when calling InvoicesApi#payInvoice");
                                e.printStackTrace();
                                currencyPurchaseError();
                            }

                        } catch (IOException e) {
                            System.err.println("Exception when calling InvoicesApi#createInvoice");
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        System.err.println("Exception when calling StoreShoppingCartsApi#addItemToCart");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.err.println("Exception when calling StoreShoppingCartsApi#createCart");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void currencyPurchaseError() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("argument", "currencyPurchaseError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void currencyPurchaseSuccess() {
        System.out.println("in here now");
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("argument", "currencyPurchaseSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void currencyPaymentError() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("argument", "currencyPaymentError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }
}