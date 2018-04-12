package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.knetikcloud.api.InvoicesApi;
import com.knetikcloud.api.PaymentsApi;
import com.knetikcloud.api.PaymentsWalletsApi;
import com.knetikcloud.api.StoreShoppingCartsApi;
import com.knetikcloud.api.UsersInventoryApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;
import com.knetikcloud.model.PageResourceUserInventoryResource;
import com.knetikcloud.model.PayBySavedMethodRequest;
import com.knetikcloud.model.PaymentMethodResource;
import com.knetikcloud.model.SimpleWallet;
import com.knetikcloud.model.UserInventoryResource;
import com.myapp.andrew.tictactoe.util.JsapiCall;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class Store extends AbstractActivity {

    ApiClient client;
    StoreShoppingCartsApi carts;
    InvoicesApi invoices;

    BigDecimal currentBalance;
    int paymentMethodId;

    private static final String VIRTUAL_CURRENCY_CODE = "TTD";

    // Setting the back button to always open the main menu
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void _onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_store);

        client = ApiClients.getUserClientInstance(getApplicationContext());
        carts = client.createService(StoreShoppingCartsApi.class);
        invoices = client.createService(InvoicesApi.class);

        // Attempts to retrieve balance of TTD in user's wallet
        PaymentsWalletsApi wallets = client.createService(PaymentsWalletsApi.class);

        Call<SimpleWallet> loadWalletCall = wallets.getUserWallet(user.getId(), VIRTUAL_CURRENCY_CODE);
        JsapiCall<SimpleWallet> loadWalletTask = new JsapiCall<SimpleWallet>(this, this::onWalletLoaded, null);
        loadWalletTask.execute(loadWalletCall);

        // Attempts to retrieve ID of user's payment method
        PaymentsApi payments = client.createService(PaymentsApi.class);

        Call<List<PaymentMethodResource>> loadPmCall = payments.getPaymentMethods(user.getId(), null, null, null, null, null, null, null);
        JsapiCall<List<PaymentMethodResource>> loadPmTask = new JsapiCall<List<PaymentMethodResource>>(this, this::onPmLoaded, null);
        loadPmTask.execute(loadPmCall);

        // Attempts to retrieve user's inventories
        UsersInventoryApi inventory = client.createService(UsersInventoryApi.class);
        Boolean inactive = false; // If true, accepts inactive user inventories

        Call<PageResourceUserInventoryResource> inventoryCall = inventory.getUserInventories(user.getId(), inactive, null, null, null, null, null, null, null);

        JsapiCall<PageResourceUserInventoryResource> inventoryTask = new JsapiCall<PageResourceUserInventoryResource>(this, this::initializeStore, t -> {
            Log.wtf("Store", "unable to load user inventory");
        });
        inventoryTask.setTitle("Store");
        inventoryTask.setMessage("Loading inventory...");
        inventoryTask.execute(inventoryCall);
    }

    public void onWalletLoaded(SimpleWallet wallet) {
        currentBalance = wallet.getBalance();
    }

    public void onPmLoaded(List<PaymentMethodResource> pms) {
        for (PaymentMethodResource rsc : pms) {
            if (rsc.getPaymentMethodType().getName().equalsIgnoreCase("Wallet")) {
                paymentMethodId = rsc.getPaymentMethodType().getId();
                break;
            }
        }
    }

    // Sets current balance and which items have already been purchased
    public void initializeStore(PageResourceUserInventoryResource result) {

        TextView currentBalanceLabel = (TextView) findViewById(R.id.currentBalanceLabel);

        // show balance
        if (currentBalance != null)
            currentBalanceLabel.setText("Current Balance: " + String.format("%.2f", currentBalance) + " " + VIRTUAL_CURRENCY_CODE);

        // manage button states
        Button redButton = (Button) findViewById(R.id.gamePieceRed);
        Button blueButton = (Button) findViewById(R.id.gamePieceBlue);
        Button yellowButton = (Button) findViewById(R.id.gamePieceYellow);
        Button greenButton = (Button) findViewById(R.id.gamePieceGreen);
        Button bundleButton = (Button) findViewById(R.id.gamePieceColorsBundle);

        Map<String, Button> buttons = new HashMap<>();

        Arrays.asList(redButton, blueButton, yellowButton, greenButton).forEach(button -> {
            buttons.put(button.getTag().toString(), button);
        });

        List<UserInventoryResource> inventoryResources = result.getContent();

        int purchased = 0;

        for (UserInventoryResource rsc : inventoryResources) {

            String itemName = rsc.getItemName();

            Button button = buttons.get(itemName);

            if (button == null)
                continue;

            purchased++;

            button.setText("Purchased");
            button.setClickable(false);
        }

        if (purchased == 4) {
            bundleButton.setText("Purchased");
            bundleButton.setClickable(false);
        }
    }

    // Called when a user clicks on a purchasable item
    public void purchaseItem(View view) {

        final Button button = (Button) view;

        if (button.getTag().toString().equals("gamePieceRed") && currentBalance.compareTo(BigDecimal.valueOf(100)) == -1
                || button.getTag().toString().equals("gamePieceBlue") && currentBalance.compareTo(BigDecimal.valueOf(200)) == -1
                || button.getTag().toString().equals("gamePieceYellow") && currentBalance.compareTo(BigDecimal.valueOf(300)) == -1
                || button.getTag().toString().equals("gamePieceGreen") && currentBalance.compareTo(BigDecimal.valueOf(400)) == -1
                || button.getTag().toString().equals("gamePieceColorsBundle") && currentBalance.compareTo(BigDecimal.valueOf(850)) == -1) {

            insufficientFunds();
        }

        Call<String> createCartCall = carts.createCart(user.getId(), VIRTUAL_CURRENCY_CODE);
        JsapiCall<String> createCartTask = new JsapiCall<String>(this, cardId -> {
            addItem(cardId, button);
        }, null);

        createCartTask.setTitle("Store");
        createCartTask.setMessage("Creating cart...");
        createCartTask.execute(createCartCall);
    }

    private void addItem(String cartId, Button button) {

        // Adds selected item to the cart
        CartItemRequest cartItemRequest = new CartItemRequest();
        cartItemRequest.setCatalogSku(button.getTag().toString());
        cartItemRequest.setQuantity(1);

        Call<Void> addItemCall = carts.addItemToCart(cartId, cartItemRequest);
        JsapiCall<Void> addItemTask = new JsapiCall<Void>(this, v -> {
            createInvoice(cartId);
        }, null);

        addItemTask.setTitle("Store");
        addItemTask.setMessage("Adding item to cart...");
        addItemTask.execute(addItemCall);
    }

    private void createInvoice(String cartId) {

        // Creates an invoice for the cart
        InvoiceCreateRequest req = new InvoiceCreateRequest();
        req.setCartGuid(cartId);

        Call<List<InvoiceResource>> createInvoiceCall = invoices.createInvoice(req);
        JsapiCall<List<InvoiceResource>> createInvoiceTask = new JsapiCall<List<InvoiceResource>>(this, this::onInvoiceCreated, null);

        createInvoiceTask.setTitle("Store");
        createInvoiceTask.setMessage("Creating invoice...");
        createInvoiceTask.execute(createInvoiceCall);
    }

    private void onInvoiceCreated(List<InvoiceResource> invoiceList) {

        int invoiceId = invoiceList.get(0).getId();

        // Paying for the invoice
        PayBySavedMethodRequest request = new PayBySavedMethodRequest();
        request.setPaymentMethod(paymentMethodId);

        Call<Void> payInvoiceCall = invoices.payInvoice(invoiceId, request);
        JsapiCall<Void> payInvoiceTask = new JsapiCall<Void>(this, this::onPaymentCompleted, null);

        payInvoiceTask.setTitle("Store");
        payInvoiceTask.setMessage("Paying invoice...");
        payInvoiceTask.execute(payInvoiceCall);
    }

    public void onPaymentCompleted(Void v) {

        Intent intent = new Intent(this, Store.class);
        startActivity(intent);
    }

    // Called when a user attempts to purchase an item they cannot afford
    public void insufficientFunds() {

        Bundle bundle = new Bundle();
        bundle.putString("argument", "insufficientFunds");
        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
        return;
    }

    public void purchaseCurrency(View view) {

        Intent intent = new Intent(this, Currency.class);
        startActivity(intent);
    }

    public void manageSubscriptions(View view) {

        Intent intent = new Intent(this, Subscriptions.class);
        startActivity(intent);
    }
}
