package com.example.tutorial.ejemplo13handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private EjemploHandler mHandlerThread;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandlerThread=new EjemploHandler();
        mHandlerThread.start();


        mButton = (Button) findViewById(R.id.bMensaje);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, Thread.currentThread().getName());
                mHandlerThread.mHandler.sendMessage(new Message());
            }
        });

    }

}
