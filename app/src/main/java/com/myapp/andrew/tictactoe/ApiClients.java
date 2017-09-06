package com.myapp.andrew.tictactoe;

import android.content.Context;

import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.client.auth.OAuthFlow;

public abstract class ApiClients {
    private static ApiClient adminClientInstance = null;
    private static ApiClient userClientInstance = null;

    protected ApiClients() {

    }
    public static ApiClient getAdminClientInstance(Context ctx) {
        if(adminClientInstance == null) {
            adminClientInstance = new ApiClient();
            adminClientInstance.getAdapterBuilder().baseUrl("https://andy-tictactoe.sandbox.knetikcloud.com");

            OAuth t = new OAuth(OAuthFlow.password, "", "https://andy-tictactoe.sandbox.knetikcloud.com/oauth/token", "");
            t.getTokenRequestBuilder().setClientId(ctx.getString(R.string.client_id)).setUsername(ctx.getString(R.string.username)).setPassword(ctx.getString(R.string.password));
            adminClientInstance.addAuthorization("oauth", t);
        }
        return adminClientInstance;
    }
    public static ApiClient getUserClientInstance(Context ctx, String username, String password) {
        if(userClientInstance == null) {
            userClientInstance = new ApiClient();
            userClientInstance.getAdapterBuilder().baseUrl("https://andy-tictactoe.sandbox.knetikcloud.com");

            OAuth t = new OAuth(OAuthFlow.password, "", "https://andy-tictactoe.sandbox.knetikcloud.com/oauth/token", "");
            t.getTokenRequestBuilder().setClientId(ctx.getString(R.string.client_id)).setUsername(username).setPassword(password);
            userClientInstance.addAuthorization("oauth", t);
        }
        return userClientInstance;
    }
    public static void resetUserClientInstance() {
        userClientInstance = null;
    }
}
