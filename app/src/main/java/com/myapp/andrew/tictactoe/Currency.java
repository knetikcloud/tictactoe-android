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

import com.android.vending.billing.IInAppBillingService;
import com.knetikcloud.api.InvoicesApi;
import com.knetikcloud.api.PaymentsGoogleApi;
import com.knetikcloud.api.StoreShoppingCartsApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.GooglePaymentRequest;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;

public class Currency extends AppCompatActivity {
    int userId;
    String username;

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
                ApiClient client = ApiClients.getAdminClientInstance(getApplicationContext());

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
                            int invoiceId = result3.body().get(0).getId();

                            // Creates intent to purchase item from Google Play
                            try {
                                Bundle buyIntentBundle = mService.getBuyIntent(3, getPackageName(),
                                        sku, "inapp", Integer.toString(invoiceId));
                                PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");

                                // Response from the following method is sent to the overridden method onActivityResult()
                                try {
                                    startIntentSenderForResult(pendingIntent.getIntentSender(),
                                            1001, new Intent(), Integer.valueOf(0), Integer.valueOf(0),
                                            Integer.valueOf(0));
                                } catch (IntentSender.SendIntentException e) {
                                    System.err.println("Exception when calling startIntentSenderForResult");
                                    e.printStackTrace();
                                }
                            } catch (RemoteException e) {
                                System.err.println("Exception when calling IInAppBillingService#getBuyIntent");
                                e.printStackTrace();
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

    // Receives response from method startIntentSenderForResult()
    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        if (requestCode == 1001) {
            int responseCode = data.getIntExtra("RESPONSE_CODE", 0);
            final String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
            final String dataSignature = data.getStringExtra("INAPP_DATA_SIGNATURE");

            if (resultCode == RESULT_OK) {
                new Thread(new Runnable () {
                    @Override
                    public void run() {
                        ApiClient client = ApiClients.getAdminClientInstance(getApplicationContext());

                        PaymentsGoogleApi apiInstance = client.createService(PaymentsGoogleApi.class);
                        GooglePaymentRequest request = new GooglePaymentRequest(); // GooglePaymentRequest | The request for paying an invoice through a Google in-app payment
                        request.setJsonPayload(purchaseData);
                        request.setSignature(dataSignature);

                        // Attempts to mark the invoice as paid with Google
                        try {
                            Call<Integer> call = apiInstance.handleGooglePayment(request);
                            Response<Integer> result = call.execute();
                            System.out.println(result.body());

                            // Attempts to get purchaseToken from purchaseData and consume the purchase
                            try {
                                JSONObject jo = new JSONObject(purchaseData);
                                String purchaseToken = jo.getString("purchaseToken");
                                try {
                                    int response = mService.consumePurchase(3, getPackageName(), purchaseToken);
                                } catch (RemoteException e) {
                                    System.err.println("Exception when calling IInAppBillingService#consumePurchase");
                                    e.printStackTrace();
                                }
                            } catch (JSONException e) {
                                System.err.println("Exception when parsing JSONObject");
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            System.err.println("Exception when calling PaymentsGoogleApi#handleGooglePayment");
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
}