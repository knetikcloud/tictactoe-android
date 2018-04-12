package com.myapp.andrew.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.knetikcloud.api.InvoicesApi;
import com.knetikcloud.api.PaymentsApi;
import com.knetikcloud.api.PaymentsStripeApi;
import com.knetikcloud.api.StoreShoppingCartsApi;
import com.knetikcloud.api.UsersSubscriptionsApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.InventorySubscriptionResource;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;
import com.knetikcloud.model.PayBySavedMethodRequest;
import com.knetikcloud.model.PaymentMethodResource;
import com.knetikcloud.model.StripeCreatePaymentMethod;
import com.knetikcloud.model.SubscriptionStatusWrapper;
import com.myapp.andrew.tictactoe.util.JsapiCall;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import java.util.List;

import retrofit2.Call;

public class Subscriptions extends AbstractActivity {

    int inventoryId;
    int invoiceId;
    String cartId;

    Boolean vipPurchased = false; // True if VIPMembership is already purchased
    Boolean vipRenew = false; // True if VIPMembership status is 'canceled'

    ApiClient client;
    StoreShoppingCartsApi carts;
    InvoicesApi invoices;

    @Override
    protected void _onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_subscriptions);

        client = ApiClients.getUserClientInstance(getApplicationContext());
        carts = client.createService(StoreShoppingCartsApi.class);
        invoices = client.createService(InvoicesApi.class);

        // Retrieving the user's subscriptions
        UsersSubscriptionsApi subscriptions = client.createService(UsersSubscriptionsApi.class);

        Call<List<InventorySubscriptionResource>> loadSubscriptionsCall = subscriptions.getUsersSubscriptionDetails(user.getId());

        JsapiCall<List<InventorySubscriptionResource>> loadSubscriptionsTask = new JsapiCall<List<InventorySubscriptionResource>>(this, this::onSubscriptionsLoaded, t -> {
            Log.wtf("Store", "unable to load user subscriptions");
        });

        loadSubscriptionsTask.setTitle("Store");
        loadSubscriptionsTask.setMessage("Loading inventory...");
        loadSubscriptionsTask.execute(loadSubscriptionsCall);
    }

    private void onSubscriptionsLoaded(List<InventorySubscriptionResource> subscriptions) {

        // Checking if the user currently has the "VIP Member" subscription
        for (InventorySubscriptionResource rsc : subscriptions) {
            if (rsc.getSku().equals(getString(R.string.vipRecurringSku))) {
                if (rsc.getSubscriptionStatus() == 14) { // 14 = "current"
                    Button purchaseSubscriptionButton = (Button) findViewById(R.id.purchaseSubscriptionButton);
                    purchaseSubscriptionButton.setText("Cancel Subscription");
                    inventoryId = rsc.getInventoryId();
                    vipPurchased = true;
                    break;
                } else if (rsc.getSubscriptionStatus() == 15) { // 15 = "canceled"
                    Button purchaseSubscriptionButton = (Button) findViewById(R.id.purchaseSubscriptionButton);
                    purchaseSubscriptionButton.setText("Renew Subscription");
                    inventoryId = rsc.getInventoryId();
                    vipPurchased = true;
                    vipRenew = true;
                    break;
                }
            }
        }
    }

    // Called when the "Purchase Subscription", "Cancel Subscription", or "Renew Subscription" button is pressed
    public void purchaseSubscription(View view) {

        UsersSubscriptionsApi subscriptions = client.createService(UsersSubscriptionsApi.class);

        if (vipRenew) {

            //Changing the status of the subscription to "current"
            SubscriptionStatusWrapper status = new SubscriptionStatusWrapper(); // StringWrapper | The new status for the subscription. Actual options may differ from the indicated set if the invoice status type data has been altered.  Allowable values: ('current', 'canceled', 'stopped', 'payment_failed', 'suspended')
            status.setValue(SubscriptionStatusWrapper.ValueEnum.CURRENT);

            Call ssCall = subscriptions.setSubscriptionStatus(user.getId(), inventoryId, status);

            JsapiCall<Void> ssTask = new JsapiCall<Void>(this, this::onSubRenewed, null);
            ssTask.setTitle("Subscriptions");
            ssTask.setMessage("Renewing subscription status...");
            ssTask.execute(ssCall);
        }

        // Cancel subscription
        else if (vipPurchased) {

            //Changing the status of the subscription to "current"
            SubscriptionStatusWrapper status = new SubscriptionStatusWrapper(); // StringWrapper | The new status for the subscription. Actual options may differ from the indicated set if the invoice status type data has been altered.  Allowable values: ('current', 'canceled', 'stopped', 'payment_failed', 'suspended')
            status.setValue(SubscriptionStatusWrapper.ValueEnum.CANCELED);

            Call ssCall = subscriptions.setSubscriptionStatus(user.getId(), inventoryId, status);

            JsapiCall<Void> ssTask = new JsapiCall<Void>(this, this::onSubCancelled, null);
            ssTask.setTitle("Subscriptions");
            ssTask.setMessage("Cancelling subscription status...");
            ssTask.execute(ssCall);
        }

        // Purchase Subscription
        else {

            // Creates a new shopping cart
            String currencyCode = "USD";

            Call<String> createCartCall = carts.createCart(user.getId(), currencyCode);

            JsapiCall<String> createCartTask = new JsapiCall<String>(this, this::onCartCreated, null);

            createCartTask.setTitle("TicTacToe");
            createCartTask.setMessage("Creating cart...");
            createCartTask.execute(createCartCall);
        }
    }

    private void onCartCreated(String cartId) {

        this.cartId = cartId;

        // Adds selected item to the cart
        CartItemRequest cartItemRequest = new CartItemRequest();
        cartItemRequest.setCatalogSku(getString(R.string.vipInitialSku));
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

        // Checking if the user already has a payment method for Stripe
        PaymentsApi payments = client.createService(PaymentsApi.class);

        Call<List<PaymentMethodResource>> loadPmsCall = payments.getPaymentMethods(user.getId(), null, null, null, null, null, null, null);

        JsapiCall<List<PaymentMethodResource>> loadPmsTask = new JsapiCall<List<PaymentMethodResource>>(this, this::onPmsLoaded, null);

        loadPmsTask.setTitle("TicTacToe");
        loadPmsTask.setMessage("Loading available payment methods...");
        loadPmsTask.execute(loadPmsCall);
    }

    private void onPmsLoaded(List<PaymentMethodResource> pms) {

        Long paymentMethodId = null;

        for (PaymentMethodResource rsc : pms) {
            if (rsc.getName().equals("Stripe Account")) {
                paymentMethodId = rsc.getId();
                break;
            }
        }

        // prompt for new card if none found
        if (paymentMethodId == null) {

            CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);
            mCardInputWidget.setVisibility(View.VISIBLE);

            Button submitPurchaseButton = (Button) findViewById(R.id.submitPurchaseButton);
            submitPurchaseButton.setVisibility(View.VISIBLE);

            // else just charge the one on file
        } else
            makePayment(paymentMethodId);
    }

    private void onCardSaved(PaymentMethodResource paymentMethod) {
        makePayment(paymentMethod.getId());
    }

    private void makePayment(Long paymentMethodId) {

        // Pays the invoice with the Stripe payment method
        PayBySavedMethodRequest payBySavedMethodRequest = new PayBySavedMethodRequest(); // PayBySavedMethodRequest | Payment info
        payBySavedMethodRequest.setPaymentMethod(paymentMethodId.intValue());

        Call<Void> payInvoiceCall = invoices.payInvoice(invoiceId, payBySavedMethodRequest);

        JsapiCall<Void> payInvoiceTask = new JsapiCall<Void>(this, this::onInvoicePayed, null);

        payInvoiceTask.setTitle("TicTacToe");
        payInvoiceTask.setMessage("Paying invoice...");
        payInvoiceTask.execute(payInvoiceCall);
    }

    private void onInvoicePayed(Void v) {
        subscriptionPurchaseSuccess();
    }

    private void onSubRenewed(Void v) {
        subscriptionRenewSuccess();
    }

    private void onSubCancelled(Void v) {
        subscriptionCancelSuccess();
    }

    public void submitPurchase(View view) {

        CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);
        Card card = mCardInputWidget.getCard();

        final Subscriptions context = this;

        String testPublishableKey = getString(R.string.knetikStripeTestPublishableKey);
        Stripe stripe = new Stripe(getApplicationContext(), testPublishableKey);
        stripe.createToken(
                card,
                new TokenCallback() {

                    public void onSuccess(final Token token) {

                        // record created card
                        PaymentsStripeApi stripe = client.createService(PaymentsStripeApi.class);

                        StripeCreatePaymentMethod request = new StripeCreatePaymentMethod(); // StripeCreatePaymentMethod | The request to create a Stripe customer with payment info
                        request.setUserId(user.getId());
                        request.setToken(token.getId());

                        Call<PaymentMethodResource> saveCardCall = stripe.createStripePaymentMethod(request);

                        JsapiCall<PaymentMethodResource> saveCardTask = new JsapiCall<PaymentMethodResource>(context, context::onCardSaved, null);

                        saveCardTask.setTitle("TicTacToe");
                        saveCardTask.setMessage("Saving payment method...");
                        saveCardTask.execute(saveCardCall);
                    }

                    public void onError(Exception error) {
                        Log.wtf("Subscriptions", error.getMessage());
                    }
                }
        );
    }

    public void cardError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "stripeCardError");
        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionPurchaseSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "subscriptionPurchaseSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionPurchaseError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "subscriptionPurchaseError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionCancelSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "subscriptionCancelSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionCancelError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "subscriptionCancelError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionRenewSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "subscriptionRenewSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionRenewError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "subscriptionRenewError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }
}
