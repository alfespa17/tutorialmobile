package com.example.tutorial.ejemplo8sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText leer;
    private EditText guardar;
    private Button botonGuardar;
    private Button botonLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leer=(EditText)findViewById(R.id.textoLeer);
        guardar=(EditText)findViewById(R.id.textoGuardar);

        botonGuardar=(Button)findViewById(R.id.botonGuardar);
        botonLeer=(Button)findViewById(R.id.botonLeer);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("Ejemplo8", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("textoguardado", guardar.getText().toString());
                editor.commit();
            }
        });

        botonLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("Ejemplo8", Context.MODE_PRIVATE);
                String defaultValue = sharedPref.getString("textoguardado","0");

                Log.i("Valor", defaultValue);

                leer.setText(defaultValue);
            }
        });
    }
}
