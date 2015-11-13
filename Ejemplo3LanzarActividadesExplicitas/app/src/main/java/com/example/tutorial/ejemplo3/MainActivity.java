package com.example.tutorial.ejemplo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //Creamos una variable para poder tener una referencia al boton de lanzar
    public Button mLanzarBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Utilizamos la funcion findViewById para obtener la referncia al boton y hacemos un cast al tipo Button
        mLanzarBoton=(Button)findViewById(R.id.lanzarDos);


        //Agregamos un accion a ejecutarse al dar click al boton
        mLanzarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inicializamos un objeto de tipo Intent con la referencia a la actividad que necesitamos lanzar
                Intent intent=new Intent();
                intent.setAction("LANZAR.ACTIVIDAD.DOS");

                //Lanzamos la actividad
                startActivity(intent);

            }
        });
    }
}
