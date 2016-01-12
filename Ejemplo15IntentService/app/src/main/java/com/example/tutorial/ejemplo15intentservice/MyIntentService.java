package com.example.tutorial.ejemplo15intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG="MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Procesando Servicio");
        Log.i(TAG, Thread.currentThread().getName());
    }


}
