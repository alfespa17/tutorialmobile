package com.example.tutorial.ejemplo13handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/**
 * Created by alfredo on 7/12/15.
 */
class EjemploHandler extends HandlerThread implements Handler.Callback{

    private static final String TAG="EjemploHandler";
    public Handler mHandler;

    public EjemploHandler() {
        super("BackgroundThread");
    }

    @Override
    protected void onLooperPrepared(){
        mHandler=new Handler(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        Log.i(TAG, Thread.currentThread().getName());
        return true;
    }
}