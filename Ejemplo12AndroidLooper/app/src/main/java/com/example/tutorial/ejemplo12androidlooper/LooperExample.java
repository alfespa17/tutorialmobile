package com.example.tutorial.ejemplo12androidlooper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


/**
 * Created by alfredo on 7/12/15.
 */
public class LooperExample extends Thread {

    private static final String TAG="LooperExample";
    public Handler mHandler;

    public void run() {
        Looper.prepare();

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.i(TAG,Thread.currentThread().getName());
            }
        };

        Looper.loop();
    }
}
