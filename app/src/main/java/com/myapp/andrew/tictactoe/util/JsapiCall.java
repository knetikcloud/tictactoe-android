package com.myapp.andrew.tictactoe.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Response;

public class JsapiCall<T> extends AsyncTask<Call<T>, Void, Response<T>> {

    private Consumer<T> onSuccess;
    private Consumer<Error> onError;

    public static class Error<T> {

        public Exception exception;
        public Response<T> response;
    }

    private Exception exception;

    private Context context;

    private String title = "Working";
    private String message = "Please wait...";

    private ProgressDialog progress;

    public JsapiCall(Context context, Consumer<T> onSuccess, Consumer<Error> onError) {

        this.onSuccess = onSuccess;
        this.onError = onError;
        this.context = context;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    protected void onPreExecute() {

        if (progress == null) {
            progress = new ProgressDialog(context);
            progress.setTitle(title);
            progress.setMessage(message);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        }

        progress.show();
    }

    @Override
    protected Response<T> doInBackground(Call<T>[] calls) {

        try {
            return calls[0].execute();
        } catch (Exception e) {
            exception = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(Response<T> t) {

        progress.dismiss();

        if (t == null || !t.isSuccessful()) {

            if (t == null)
                Log.e("JsapiCall", exception.getMessage());
            else
                Log.e("JsapiCall", t.message());

            Error<T> error = new Error();
            error.exception = exception;
            error.response = t;

            if (onError != null) {

                onError.accept(error);
                return;
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle("Error");
            builder.setMessage(t == null ? exception.getMessage() : t.message());
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setNeutralButton("OK", null);
            builder.create();
            builder.show();

            return;
        }

        if (onSuccess != null)
            onSuccess.accept(t.body());
    }
}