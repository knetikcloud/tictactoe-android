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
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;
import com.knetikcloud.model.PageResourceUserInventoryResource;
import com.knetikcloud.model.PayBySavedMethodRequest;
import com.knetikcloud.model.PaymentMethodResource;
import com.knetikcloud.model.SimpleWallet;
import com.knetikcloud.model.UserInventoryResource;

import java.util.List;

public class Store extends AppCompatActivity {
    String adminToken;
    Double currentBalance;
    int paymentMethodId;
    int userId;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                // Configure OAuth2 access token for authorization: OAuth2
                OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                OAuth2.setAccessToken(adminToken);

                // Attempts to retrieve balance of TTD in user's wallet
                PaymentsWalletsApi apiInstance = new PaymentsWalletsApi();
                String currencyCode = "TTD"; // TicTacDollars
                try {
                    SimpleWallet result = apiInstance.getUserWallet(userId, currencyCode);
                    System.out.println(result);
                    currentBalance = result.getBalance();
                } catch (ApiException e) {
                    System.err.println("Exception when calling PaymentsWalletsApi#getUserWallet");
                    e.printStackTrace();
                }

                // Attempts to retrieve ID of user's payment method
                PaymentsApi apiInstance2 = new PaymentsApi();
                try {
                    List<PaymentMethodResource> result = apiInstance2.getPaymentMethods(userId, null, null, null);
                    System.out.println(result);
                    paymentMethodId = result.get(0).getPaymentMethodType().getId();
                } catch (ApiException e) {
                    System.err.println("Exception when calling PaymentsApi#getPaymentMethods");
                    e.printStackTrace();
                }

                // Attempts to retrieve user's inventories
                UsersInventoryApi apiInstance3 = new UsersInventoryApi();
                Boolean inactive = false; // If true, accepts inactive user inventories
                try {
                    final PageResourceUserInventoryResource result = apiInstance3.getUserInventories(userId, inactive, null, null, null, null, null, null, null);
                    System.out.println(result);

                    Store.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initializeStore(currentBalance, result);
                        }
                    });
                } catch (ApiException e) {
                    System.err.println("Exception when calling UsersInventoryApi#getUserInventories");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Sets current balance and which items have already been purchased
    public void initializeStore(Double currentBalance, PageResourceUserInventoryResource result) {
        TextView currentBalanceLabel = (TextView) findViewById(R.id.currentBalanceLabel);
        if(currentBalance != null)
            currentBalanceLabel.setText("Current Balance: $" + String.format("%.2f", currentBalance) + " TTD");

        Button redButton = (Button) findViewById(R.id.gamePieceRed);
        Button blueButton = (Button) findViewById(R.id.gamePieceBlue);
        Button yellowButton = (Button) findViewById(R.id.gamePieceYellow);
        Button greenButton = (Button) findViewById(R.id.gamePieceGreen);
        Button bundleButton = (Button) findViewById(R.id.gamePieceColorsBundle);

        List<UserInventoryResource> inventoryResources = result.getContent();

        for(UserInventoryResource rsc : inventoryResources) {
            String itemName = rsc.getItemName();

            if(itemName.equals("gamePieceRed")) {
                redButton.setText("Purchased");
                redButton.setClickable(false);
            }
            else if(itemName.equals("gamePieceBlue")) {
                blueButton.setText("Purchased");
                blueButton.setClickable(false);
            }
            else if(itemName.equals("gamePieceYellow")) {
                yellowButton.setText("Purchased");
                yellowButton.setClickable(false);
            }
            else if(itemName.equals("gamePieceGreen")) {
                greenButton.setText("Purchased");
                greenButton.setClickable(false);
            }
        }
    }

    // Called when a user clicks on a purchasable item
    public void purchaseItem(View view) {
        final Button button = (Button) view;
        if(button.getTag().toString().equals("gamePieceRed")) {
            if (currentBalance < 100) {
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
            if (currentBalance < 200) {
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
            if (currentBalance < 300) {
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
            if (currentBalance < 400) {
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
            if (currentBalance < 850) {
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
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                // Configure OAuth2 access token for authorization: OAuth2
                OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                OAuth2.setAccessToken(adminToken);

                // Creates a new shopping cart
                StoreShoppingCartsApi apiInstance = new StoreShoppingCartsApi();
                String currencyCode = "TTD"; // TicTacDollars
                try {
                    String cartId = apiInstance.createCart(userId, currencyCode);
                    System.out.println("Cart ID: " + cartId);

                    // Adds selected item to the cart
                    StoreShoppingCartsApi apiInstance2 = new StoreShoppingCartsApi();
                    CartItemRequest cartItemRequest = new CartItemRequest();
                    cartItemRequest.setCatalogSku(button.getTag().toString());
                    cartItemRequest.setQuantity(1);
                    try {
                        apiInstance.addItemToCart(cartId, cartItemRequest);

                        // Creates an invoice for the cart
                        InvoicesApi apiInstance3 = new InvoicesApi();
                        InvoiceCreateRequest req = new InvoiceCreateRequest();
                        req.setCartGuid(cartId);
                        try {
                            List<InvoiceResource> result = apiInstance3.createInvoice(req);
                            System.out.println(result);
                            int invoiceId = result.get(0).getId();

                            // Paying for the invoice
                            InvoicesApi apiInstance4 = new InvoicesApi();
                            PayBySavedMethodRequest request = new PayBySavedMethodRequest();
                            request.setPaymentMethod(paymentMethodId);
                            try {
                                apiInstance4.payInvoice(invoiceId, request);
                            } catch (ApiException e) {
                                System.err.println("Exception when calling InvoicesApi#payInvoice");
                                e.printStackTrace();
                            }
                        } catch (ApiException e) {
                            System.err.println("Exception when calling InvoicesApi#createInvoice");
                            e.printStackTrace();
                        }
                    } catch (ApiException e) {
                        System.err.println("Exception when calling StoreShoppingCartsApi#addItemToCart");
                        e.printStackTrace();
                    }
                } catch (ApiException e) {
                    System.err.println("Exception when calling StoreShoppingCartsApi#createCart");
                    e.printStackTrace();
                }
            }
        }).start();

        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Profile.class);
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
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Currency.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
