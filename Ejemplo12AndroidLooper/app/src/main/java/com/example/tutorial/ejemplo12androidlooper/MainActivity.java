package com.example.tutorial.ejemplo12androidlooper;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private Button mButton;
    private LooperExample mLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.bMensaje);
        mLooper=new LooperExample();
        mLooper.start();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, Thread.currentThread().getName());
                mLooper.mHandler.sendMessage(new Message());
            }
        });
    }
}
