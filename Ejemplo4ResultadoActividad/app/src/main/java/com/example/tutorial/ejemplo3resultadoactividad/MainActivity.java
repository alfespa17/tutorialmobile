package com.example.tutorial.ejemplo3resultadoactividad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    private static final int REQUEST_CODE=1000;
    Button mAbrir;
    TextView mNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAbrir = (Button) findViewById(R.id.bAbrir);
        mNombre = (TextView) findViewById(R.id.tvNombre);

        mAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mActividadDos = new Intent();
                mActividadDos.setClass(getApplicationContext(),ActividadSecundaria.class);
                startActivityForResult(mActividadDos,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if( resultCode== Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            String nombre=data.getStringExtra("nombre");
            mNombre.setText(nombre);
            Log.i(TAG, "Seteando Nombre");
        }
    }
}
