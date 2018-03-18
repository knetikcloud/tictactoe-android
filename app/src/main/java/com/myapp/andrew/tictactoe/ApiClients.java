package com.myapp.andrew.tictactoe;

import android.content.Context;
import android.content.Intent;

import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.client.auth.OAuthFlow;

public abstract class ApiClients {
    private static ApiClient adminClientInstance = null;
    private static ApiClient userClientInstance = null;

    protected ApiClients() {

    }

    /*
    public static ApiClient getAdminClientInstance(Context ctx) {
        System.out.println("HERE!!!");
        if(adminClientInstance == null) {
            System.out.println("HERE TOO!!!");

            adminClientInstance = new ApiClient();
            adminClientInstance.getAdapterBuilder().baseUrl("https://andy-tictactoe.sandbox.knetikcloud.com");

            OAuth t = new OAuth(OAuthFlow.password, "", "https://andy-tictactoe.sandbox.knetikcloud.com/oauth/token", "");
            t.getTokenRequestBuilder().setClientId(ctx.getString(R.string.client_id)).setUsername(ctx.getString(R.string.username)).setPassword(ctx.getString(R.string.password));
            adminClientInstance.addAuthorization("oauth", t);

        }
        return adminClientInstance;
    }
    */

    public static ApiClient getUserClientInstance(Context ctx) {
        if(userClientInstance == null) {
            //TODO logout user
        }
        return userClientInstance;
    }

    public static ApiClient getUserClientInstance(Context ctx, String username, String password) {
        //System.out.println("HERE 2!!!");
        if(userClientInstance == null) {
            //System.out.println("HERE 2 TOO!!!");
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
