package com.myapp.andrew.tictactoe;

import android.content.Context;

import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.client.auth.OAuthFlow;

public class ApiClients {

    private static ApiClient adminClientInstance = null;
    private static ApiClient userClientInstance = null;

    protected ApiClients() {

    }

    public static ApiClient getUserClientInstance(Context ctx) {
        if(userClientInstance == null) {
            //TODO throw an error
        }
        return userClientInstance;
    }

    public static ApiClient getUserClientInstance(Context ctx, String username, String password) {

        if(userClientInstance == null) {

            userClientInstance = new ApiClient();
            userClientInstance.getAdapterBuilder().baseUrl(ctx.getString(R.string.baseurl));

            OAuth t = new OAuth(OAuthFlow.password, "", ctx.getString(R.string.baseurl) + "/oauth/token", "");
            t.getTokenRequestBuilder().setClientId(ctx.getString(R.string.client_id)).setUsername(username).setPassword(password);
            userClientInstance.addAuthorization("oauth", t);
        }
        return userClientInstance;
    }

    public static void resetUserClientInstance() {
        userClientInstance = null;
    }

}
