package com.example.hellonetwork;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by fagner on 10/03/15.
 */
public class GcmController {

    private Context context;
    private final static String NUMERO_REGISTRO = "125394900209";

    public GcmController(Context activity) {
        this.context = activity;
    }

    public void registerID() {
        registerInBackground();
    }


    private void registerInBackground() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String registrationID = null;
                try {
                    GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
                    registrationID = gcm.register(NUMERO_REGISTRO);
                } catch (IOException e) {
                    Log.e(GcmController.class.getName(), e.getMessage(), e);
                }
                return registrationID;
            }

            @Override
            protected void onPostExecute(String msg) {
                Log.i(GcmController.class.getName(), "Implemente a chamada do servidor aqui!");
            }
        }.execute(null, null, null);

    }

}
