package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.knetikcloud.api.InvoicesApi;
import com.knetikcloud.api.PaymentsApi;
import com.knetikcloud.api.PaymentsWalletsApi;
import com.knetikcloud.api.StoreShoppingCartsApi;
import com.knetikcloud.api.UsersInventoryApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;
import com.knetikcloud.model.PageResourceUserInventoryResource;
import com.knetikcloud.model.PayBySavedMethodRequest;
import com.knetikcloud.model.PaymentMethodResource;
import com.knetikcloud.model.SimpleWallet;
import com.knetikcloud.model.UserInventoryResource;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.Response;

public class Store extends AppCompatActivity {
    BigDecimal currentBalance;
    int paymentMethodId;
    int userId;
    String username;

    // Setting the back button to always open the main menu
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                // Attempts to retrieve balance of TTD in user's wallet
                PaymentsWalletsApi apiInstance = client.createService(PaymentsWalletsApi.class);
                String currencyCode = "TTD"; // TicTacDollars
                try {
                    Call<SimpleWallet> call = apiInstance.getUserWallet(userId, currencyCode);
                    Response<SimpleWallet> result = call.execute();
                    System.out.println(result.body());
                    currentBalance = result.body().getBalance();
                } catch (IOException e) {
                    System.err.println("Exception when calling PaymentsWalletsApi#getUserWallet");
                    e.printStackTrace();
                }

                // Attempts to retrieve ID of user's payment method
                PaymentsApi apiInstance2 = client.createService(PaymentsApi.class);
                try {
                    Call<List<PaymentMethodResource>> call = apiInstance2.getPaymentMethods(userId, null, null, null, null, null, null, null);
                    Response<List<PaymentMethodResource>> result = call.execute();
                    System.out.println(result.body());

                    for(PaymentMethodResource rsc : result.body()) {
                        if(rsc.getPaymentMethodType().getName().equalsIgnoreCase("Wallet")) {
                            paymentMethodId = rsc.getPaymentMethodType().getId();
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Exception when calling PaymentsApi#getPaymentMethods");
                    e.printStackTrace();
                }

                // Attempts to retrieve user's inventories
                UsersInventoryApi apiInstance3 = client.createService(UsersInventoryApi.class);
                Boolean inactive = false; // If true, accepts inactive user inventories
                try {
                    Call<PageResourceUserInventoryResource> call = apiInstance3.getUserInventories(userId, inactive, null, null, null, null, null, null, null);
                    final Response<PageResourceUserInventoryResource> result = call.execute();
                    System.out.println(result.body());

                    Store.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initializeStore(currentBalance, result.body());
                        }
                    });
                } catch (IOException e) {
                    System.err.println("Exception when calling UsersInventoryApi#getUserInventories");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Sets current balance and which items have already been purchased
    public void initializeStore(BigDecimal currentBalance, PageResourceUserInventoryResource result) {
        TextView currentBalanceLabel = (TextView) findViewById(R.id.currentBalanceLabel);
        if(currentBalance != null)
            currentBalanceLabel.setText("Current Balance: $" + String.format("%.2f", currentBalance) + " TTD");

        Button redButton = (Button) findViewById(R.id.gamePieceRed);
        Button blueButton = (Button) findViewById(R.id.gamePieceBlue);
        Button yellowButton = (Button) findViewById(R.id.gamePieceYellow);
        Button greenButton = (Button) findViewById(R.id.gamePieceGreen);
        Button bundleButton = (Button) findViewById(R.id.gamePieceColorsBundle);
        boolean redPurchased = false;
        boolean bluePurchased = false;
        boolean yellowPurchased = false;
        boolean greenPurchased = false;

        List<UserInventoryResource> inventoryResources = result.getContent();

        for(UserInventoryResource rsc : inventoryResources) {
            String itemName = rsc.getItemName();

            if(itemName.equals("gamePieceRed")) {
                redButton.setText("Purchased");
                redButton.setClickable(false);
                redPurchased = true;
            }
            else if(itemName.equals("gamePieceBlue")) {
                blueButton.setText("Purchased");
                blueButton.setClickable(false);
                bluePurchased = true;
            }
            else if(itemName.equals("gamePieceYellow")) {
                yellowButton.setText("Purchased");
                yellowButton.setClickable(false);
                yellowPurchased = true;
            }
            else if(itemName.equals("gamePieceGreen")) {
                greenButton.setText("Purchased");
                greenButton.setClickable(false);
                greenPurchased = true;
            }

            if(redPurchased && bluePurchased && yellowPurchased && greenPurchased) {
                bundleButton.setText("Purchased");
                bundleButton.setClickable(false);
            }
        }
    }

    // Called when a user clicks on a purchasable item
    public void purchaseItem(View view) {
        final Button button = (Button) view;
        if(button.getTag().toString().equals("gamePieceRed")) {
            if (currentBalance.compareTo(BigDecimal.valueOf(100)) == -1) {
                Store.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        insufficientFunds();
                    }
                });
                return;
            }
        }
        else if(button.getTag().toString().equals("gamePieceBlue")) {
            if (currentBalance.compareTo(BigDecimal.valueOf(200)) == -1) {
                Store.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        insufficientFunds();
                    }
                });
                return;
            }
        }
        else if(button.getTag().toString().equals("gamePieceYellow")) {
            if (currentBalance.compareTo(BigDecimal.valueOf(300)) == -1) {
                Store.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        insufficientFunds();
                    }
                });
                return;
            }
        }
        else if(button.getTag().toString().equals("gamePieceGreen")) {
            if (currentBalance.compareTo(BigDecimal.valueOf(400)) == -1) {
                Store.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        insufficientFunds();
                    }
                });
                return;
            }
        }
        else if(button.getTag().toString().equals("gamePieceColorsBundle")) {
            if (currentBalance.compareTo(BigDecimal.valueOf(850)) == -1) {
                Store.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        insufficientFunds();
                    }
                });
                return;
            }
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                // Creates a new shopping cart
                StoreShoppingCartsApi apiInstance = client.createService(StoreShoppingCartsApi.class);
                String currencyCode = "TTD"; // TicTacDollars
                try {
                    Call<String> call = apiInstance.createCart(userId, currencyCode);
                    Response<String> result = call.execute();
                    String cartId = result.body();
                    System.out.println("Cart ID: " + cartId);

                    // Adds selected item to the cart
                    CartItemRequest cartItemRequest = new CartItemRequest();
                    cartItemRequest.setCatalogSku(button.getTag().toString());
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
                            System.out.println(result3.body());
                            int invoiceId = result3.body().get(0).getId();

                            // Paying for the invoice
                            PayBySavedMethodRequest request = new PayBySavedMethodRequest();
                            request.setPaymentMethod(paymentMethodId);
                            try {
                                Call call4 = invoicesApi.payInvoice(invoiceId, request);
                                Response result4 = call4.execute();

                                Store.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        reloadStore();
                                    }
                                });
                            } catch (IOException e) {
                                System.err.println("Exception when calling InvoicesApi#payInvoice");
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

    public void reloadStore() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, Store.class);
        intent.putExtras(bundle);
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
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, Currency.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
