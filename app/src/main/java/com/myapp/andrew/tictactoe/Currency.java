package com.myapp.andrew.tictactoe;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.android.vending.billing.IInAppBillingService;
import com.knetikcloud.api.InvoicesApi;
import com.knetikcloud.api.PaymentsApi;
import com.knetikcloud.api.StoreShoppingCartsApi;
import com.knetikcloud.api.UsersSubscriptionsApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.InventorySubscriptionResource;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;
import com.knetikcloud.model.PayBySavedMethodRequest;
import com.knetikcloud.model.PaymentMethodResource;
import com.myapp.andrew.tictactoe.util.JsapiCall;
import com.stripe.android.Stripe;

import java.util.List;

import retrofit2.Call;

public class Currency extends AbstractActivity {

    ApiClient client;
    StoreShoppingCartsApi carts;
    InvoicesApi invoices;

    String sku;
    String cartId;
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
    protected void _onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_currency);

        client = ApiClients.getUserClientInstance(getApplicationContext());
        carts = client.createService(StoreShoppingCartsApi.class);
        invoices = client.createService(InvoicesApi.class);

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

        Button button = (Button) view;
        sku = button.getTag().toString();

        // Check if user has a subscription
        UsersSubscriptionsApi subscriptions = client.createService(UsersSubscriptionsApi.class);

        Call<List<InventorySubscriptionResource>> loadSubscriptionCall = subscriptions.getUsersSubscriptionDetails(user.getId());
        JsapiCall<List<InventorySubscriptionResource>> loadSubscriptionTask = new JsapiCall<List<InventorySubscriptionResource>>(this, this::onSubscriptionsLoaded, null);

        loadSubscriptionTask.setTitle("TicTacToe");
        loadSubscriptionTask.setMessage("Checking for subscription...");
        loadSubscriptionTask.execute(loadSubscriptionCall);
    }

    private void onSubscriptionsLoaded(List<InventorySubscriptionResource> subscriptions) {

        if (subscriptions.size() == 0) {
            currencySubscriptionMissingError();
            return;
        }

        // Checking if the user currently has the "VIP Member" subscription
        for (InventorySubscriptionResource rsc : subscriptions) {

            if (rsc.getSku().equals(getString(R.string.vipRecurringSku))) {
                if (rsc.getSubscriptionStatus() == 14) { // 14 = "current"
                    break;
                } else if (rsc.getSubscriptionStatus() == 15) { // 15 = "canceled"
                    currencySubscriptionCancelledError();
                    return;
                }
            }
        }

        // Creates a new shopping cart
        String currencyCode = "USD";

        Call<String> createCartCall = carts.createCart(user.getId(), currencyCode);

        JsapiCall<String> createCartTask = new JsapiCall<String>(this, this::onCartCreated, null);

        createCartTask.setTitle("TicTacToe");
        createCartTask.setMessage("Creating cart...");
        createCartTask.execute(createCartCall);
    }

    private void onCartCreated(String cartId) {

        this.cartId = cartId;

        // Adds selected item to the cart
        CartItemRequest cartItemRequest = new CartItemRequest();
        cartItemRequest.setCatalogSku(sku);
        cartItemRequest.setQuantity(1);

        Call<Void> addItemCall = carts.addItemToCart(cartId, cartItemRequest);

        JsapiCall<Void> addItemTask = new JsapiCall<Void>(this, this::onItemAdded, null);

        addItemTask.setTitle("TicTacToe");
        addItemTask.setMessage("Adding item to cart...");
        addItemTask.execute(addItemCall);
    }

    private void onItemAdded(Void v) {

        // Creates an invoice for the cart
        InvoicesApi invoicesApi = client.createService(InvoicesApi.class);
        InvoiceCreateRequest req = new InvoiceCreateRequest();
        req.setCartGuid(cartId);

        Call<List<InvoiceResource>> createInvoiceCall = invoices.createInvoice(req);

        JsapiCall<List<InvoiceResource>> createInvoiceTask = new JsapiCall<List<InvoiceResource>>(this, this::onInvoiceCreated, null);

        createInvoiceTask.setTitle("TicTacToe");
        createInvoiceTask.setMessage("Creating invoice...");
        createInvoiceTask.execute(createInvoiceCall);
    }

    private void onInvoiceCreated(List<InvoiceResource> invoiceList) {

        invoiceId = invoiceList.get(0).getId();

        String testPublishableKey = getString(R.string.knetikStripeTestPublishableKey);
        Stripe stripe = new Stripe(getApplicationContext(), testPublishableKey);

        // Checking if the user already has a payment method for Stripe
        PaymentsApi payments = client.createService(PaymentsApi.class);

        Call<List<PaymentMethodResource>> loadPmsCall = payments.getPaymentMethods(user.getId(), null, null, null, null, null, null, null);

        JsapiCall<List<PaymentMethodResource>> loadPmsTask = new JsapiCall<List<PaymentMethodResource>>(this, this::onPmsLoaded, null);

        loadPmsTask.setTitle("TicTacToe");
        loadPmsTask.setMessage("Loading available payment methods...");
        loadPmsTask.execute(loadPmsCall);
    }

    private void onPmsLoaded(List<PaymentMethodResource> pms) {

        int paymentMethodId = 0;
        boolean paymentMethodExists = false;

        for (PaymentMethodResource rsc : pms) {
            if (rsc.getName().equals("Stripe Account")) {
                paymentMethodId = rsc.getId().intValue();
                paymentMethodExists = true;
                break;
            }
        }
        // confirms they have a stripe account (which in this case, means a membership)
        if (!paymentMethodExists) {
            currencyPaymentStripeError();
            return;
        }

        // Pays the invoice with the Stripe payment method

        PayBySavedMethodRequest payBySavedMethodRequest = new PayBySavedMethodRequest(); // PayBySavedMethodRequest | Payment info
        payBySavedMethodRequest.setPaymentMethod(paymentMethodId);

        Call<Void> payInvoiceCall = invoices.payInvoice(invoiceId, payBySavedMethodRequest);

        JsapiCall<Void> payInvoiceTask = new JsapiCall<Void>(this, this::onInvoicePayed, null);

        payInvoiceTask.setTitle("TicTacToe");
        payInvoiceTask.setMessage("Paying invoice...");
        payInvoiceTask.execute(payInvoiceCall);
    }

    private void onInvoicePayed(Void v) {
        currencyPurchaseSuccess();
    }

    public void currencyPurchaseError() {

        Bundle bundle = new Bundle();
        bundle.putString("argument", "currencyPurchaseError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void currencyPurchaseSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "currencyPurchaseSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void currencyPaymentStripeError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "currencyPaymentStripeError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void currencySubscriptionMissingError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "currencySubscriptionMissingError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void currencySubscriptionCancelledError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "currencySubscriptionCancelledError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

}