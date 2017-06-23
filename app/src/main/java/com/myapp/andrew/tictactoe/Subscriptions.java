package com.myapp.andrew.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.knetikcloud.api.InvoicesApi;
import com.knetikcloud.api.PaymentsApi;
import com.knetikcloud.api.PaymentsStripeApi;
import com.knetikcloud.api.StoreShoppingCartsApi;
import com.knetikcloud.api.UsersSubscriptionsApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.CartItemRequest;
import com.knetikcloud.model.InventorySubscriptionResource;
import com.knetikcloud.model.InvoiceCreateRequest;
import com.knetikcloud.model.InvoiceResource;
import com.knetikcloud.model.PayBySavedMethodRequest;
import com.knetikcloud.model.PaymentMethodResource;
import com.knetikcloud.model.StripeCreatePaymentMethod;

import com.knetikcloud.model.StripePaymentRequest;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import java.util.List;

import static android.R.attr.id;
import static android.os.Build.VERSION_CODES.N;
import static com.myapp.andrew.tictactoe.R.id.progressBar;

public class Subscriptions extends AppCompatActivity {
    String adminToken;
    int inventoryId;
    int invoiceId;
    Boolean paymentMethodExists = false;
    int paymentMethodId;
    int userId;
    String username;
    Boolean vipPurchased = false; // True if VIPMembership is already purchased
    Boolean vipRenew = false; // True if VIPMembership status is 'canceled'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriptions);

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

                // Retrieving the user's subscriptions
                UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
                try {
                    List<InventorySubscriptionResource> result = apiInstance.getUsersSubscriptionDetails(userId);
                    System.out.println(result);

                    // Checking if the user currently has the "VIP Member" subscription
                    for(InventorySubscriptionResource rsc : result) {
                        if(rsc.getSku().equals(getString(R.string.vipRecurringSku))) {
                            if(rsc.getSubscriptionStatus() == 14) { // 14 = "current"
                                Subscriptions.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Button purchaseSubscriptionButton = (Button) findViewById(R.id.purchaseSubscriptionButton);
                                        purchaseSubscriptionButton.setText("Cancel Subscription");
                                    }
                                });
                                inventoryId = rsc.getInventoryId();
                                vipPurchased = true;
                                break;
                            }
                            else if (rsc.getSubscriptionStatus() == 15) { // 15 = "canceled"
                                Subscriptions.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Button purchaseSubscriptionButton = (Button) findViewById(R.id.purchaseSubscriptionButton);
                                        purchaseSubscriptionButton.setText("Renew Subscription");
                                    }
                                });
                                inventoryId = rsc.getInventoryId();
                                vipPurchased = true;
                                vipRenew = true;
                                break;
                            }
                        }
                    }
                } catch (ApiException e) {
                    System.err.println("Exception when calling UsersSubscriptionsApi#getUsersSubscriptionDetails");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Called when the "Purchase Subscription", "Cancel Subscription", or "Renew Subscription" button is pressed
    public void purchaseSubscription(View view) {

        if(vipRenew) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ApiClient defaultClient = Configuration.getDefaultApiClient();
                    defaultClient.setBasePath(getString(R.string.baseurl));

                    // Configure OAuth2 access token for authorization: OAuth2
                    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                    OAuth2.setAccessToken(adminToken);

                    //Changing the status of the subscription to "current"
                    UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
                    String status = "current"; // String | The new status for the subscription. Allowable values: ('current', 'canceled', 'stopped', 'payment_failed', 'suspended')
                    try {
                        apiInstance.setSubscriptionStatus(userId, inventoryId, status);
                        Subscriptions.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                subscriptionRenewSuccess();
                            }
                        });
                    } catch (ApiException e) {
                        System.err.println("Exception when calling UsersSubscriptionsApi#setSubscriptionStatus");
                        e.printStackTrace();
                        Subscriptions.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                subscriptionRenewError();
                                System.out.println(inventoryId);
                            }
                        });
                    }
                }
            }).start();
        }
        // Cancel subscription
        else if(vipPurchased) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ApiClient defaultClient = Configuration.getDefaultApiClient();
                    defaultClient.setBasePath(getString(R.string.baseurl));

                    // Configure OAuth2 access token for authorization: OAuth2
                    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                    OAuth2.setAccessToken(adminToken);

                    //Changing the status of the subscription to "canceled"
                    UsersSubscriptionsApi apiInstance = new UsersSubscriptionsApi();
                    String status = "canceled"; // String | The new status for the subscription. Allowable values: ('current', 'canceled', 'stopped', 'payment_failed', 'suspended')
                    try {
                        apiInstance.setSubscriptionStatus(userId, inventoryId, status);
                        Subscriptions.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                subscriptionCancelSuccess();
                            }
                        });
                    } catch (ApiException e) {
                        System.err.println("Exception when calling UsersSubscriptionsApi#setSubscriptionStatus");
                        e.printStackTrace();
                        Subscriptions.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                subscriptionCancelError();
                            }
                        });
                    }
                }
            }).start();
        }
        // Purchase Subscription
        else {
            CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);
            mCardInputWidget.setVisibility(View.VISIBLE);

            Button submitPurchaseButton = (Button) findViewById(R.id.submitPurchaseButton);
            submitPurchaseButton.setVisibility(View.VISIBLE);

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
                    String currencyCode = "USD";
                    try {
                        String cartId = apiInstance.createCart(userId, currencyCode);
                        System.out.println("Cart ID: " + cartId);

                        // Adds selected item to the cart
                        StoreShoppingCartsApi apiInstance2 = new StoreShoppingCartsApi();
                        CartItemRequest cartItemRequest = new CartItemRequest();
                        cartItemRequest.setCatalogSku(getString(R.string.vipInitialSku));
                        cartItemRequest.setQuantity(1);
                        try {
                            apiInstance.addItemToCart(cartId, cartItemRequest);

                            // Creates an invoice for the cart
                            InvoicesApi apiInstance3 = new InvoicesApi();
                            InvoiceCreateRequest req = new InvoiceCreateRequest();
                            req.setCartGuid(cartId);
                            try {
                                List<InvoiceResource> invoiceResource = apiInstance3.createInvoice(req);
                                System.out.println(invoiceResource);
                                invoiceId = invoiceResource.get(0).getId();
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
        }
    }

    public void submitPurchase(View view) {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);
                Card card = mCardInputWidget.getCard();
                if(card == null) {
                    Subscriptions.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            cardError();
                        }
                    });
                }
                else {
                    String testPublishableKey = getString(R.string.knetikStripeTestPublishableKey);
                    Stripe stripe = new Stripe(getApplicationContext(), testPublishableKey);
                    stripe.createToken(
                            card,
                            new TokenCallback() {
                                public void onSuccess(final Token token) {
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Checking if the user already has a payment method for Stripe
                                            PaymentsApi apiInstance = new PaymentsApi();
                                            try {
                                                List<PaymentMethodResource> result = apiInstance.getPaymentMethods(userId, null, null, null, null, null, null, null);
                                                System.out.println(result);

                                                for(PaymentMethodResource rsc : result) {
                                                    if(rsc.getName().equals("Stripe Account")) {
                                                        paymentMethodId = rsc.getId().intValue();
                                                        paymentMethodExists = true;
                                                        break;
                                                    }
                                                }
                                                // Creates a Stripe payment method for the user if they do not have one
                                                if(!paymentMethodExists) {
                                                    PaymentsStripeApi apiInstance2 = new PaymentsStripeApi();
                                                    StripeCreatePaymentMethod request = new StripeCreatePaymentMethod(); // StripeCreatePaymentMethod | The request to create a Stripe customer with payment info
                                                    request.setUserId(userId);
                                                    request.setToken(token.getId());
                                                    try {
                                                        PaymentMethodResource paymentMethodResource = apiInstance2.createStripePaymentMethod(request);
                                                        System.out.println(paymentMethodResource);
                                                        paymentMethodId = paymentMethodResource.getId().intValue();

                                                    } catch (ApiException e) {
                                                        System.err.println("Exception when calling PaymentsStripeApi#createStripePaymentMethod");
                                                        e.printStackTrace();
                                                        Subscriptions.this.runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                progressBar.setVisibility(View.GONE);
                                                                subscriptionPurchaseError();
                                                            }
                                                        });
                                                    }
                                                }
                                            } catch (ApiException e) {
                                                progressBar.setVisibility(View.GONE);
                                                System.err.println("Exception when calling PaymentsApi#getPaymentMethods");
                                                e.printStackTrace();
                                            }
                                            // Pays the invoice with the Stripe payment method
                                            InvoicesApi apiInstance3 = new InvoicesApi();
                                            PayBySavedMethodRequest payBySavedMethodRequest = new PayBySavedMethodRequest(); // PayBySavedMethodRequest | Payment info
                                            payBySavedMethodRequest.setPaymentMethod(paymentMethodId);
                                            try {
                                                apiInstance3.payInvoice(invoiceId, payBySavedMethodRequest);
                                                Subscriptions.this.runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        progressBar.setVisibility(View.GONE);
                                                        subscriptionPurchaseSuccess();
                                                    }
                                                });
                                            } catch (ApiException e) {
                                                System.err.println("Exception when calling InvoicesApi#payInvoice");
                                                e.printStackTrace();
                                                Subscriptions.this.runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        progressBar.setVisibility(View.GONE);
                                                        subscriptionPurchaseError();
                                                    }
                                                });
                                            }
                                        }
                                    }).start();
                                }
                                public void onError(Exception error) {
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Subscriptions.this.runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    progressBar.setVisibility(View.GONE);
                                                    subscriptionPurchaseError();
                                                }
                                            });
                                        }
                                    }).start();

                                }
                            }
                    );
                }
            }
        }).start();
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
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);
        bundle.putString("argument", "subscriptionPurchaseSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionPurchaseError() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);
        bundle.putString("argument", "subscriptionPurchaseError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionCancelSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);
        bundle.putString("argument", "subscriptionCancelSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionCancelError() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);
        bundle.putString("argument", "subscriptionCancelError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionRenewSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);
        bundle.putString("argument", "subscriptionRenewSuccess");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void subscriptionRenewError() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);
        bundle.putString("argument", "subscriptionRenewError");

        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }
}
