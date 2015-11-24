package com.example.tutorial.ejemplo3resultadoactividad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActividadSecundaria extends AppCompatActivity {

    private static final String TAG="MainActivity";

    private static final int REQUEST_CODE=1000;
    Button mCerrar;
    EditText mNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_secundaria);

        mCerrar = (Button) findViewById(R.id.bCerrar);
        mNombre = (EditText) findViewById(R.id.etNombre);

        mCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("nombre",mNombre.getText().toString());
                setResult(Activity.RESULT_OK,data);

                //setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
