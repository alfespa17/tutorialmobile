package com.example.tutorial.ejemplo15intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private Button mServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mServicio = (Button) findViewById(R.id.mServicio);

        mServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Procesando Servicio");
                Log.i(TAG, Thread.currentThread().getName());

                Intent service=new Intent(getApplicationContext(),MyIntentService.class);
                startService(service);
            }
        });
    }
}
