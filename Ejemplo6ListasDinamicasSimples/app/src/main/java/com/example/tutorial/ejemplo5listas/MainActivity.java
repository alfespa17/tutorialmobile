package com.example.tutorial.ejemplo5listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static String TAG="MainActivity";

    private Button agregarLista;
    private ListView lista;
    private EditText textoAgregar;

    private ListAdapter listAdapter=null;//new ListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=(ListView)findViewById(R.id.lista);
        if(listAdapter==null){
            listAdapter=new ListAdapter(getApplicationContext());
        }

        lista.setAdapter(listAdapter);

        agregarLista=(Button)findViewById(R.id.agregarLista);
        textoAgregar=(EditText)findViewById(R.id.textoAgregar);

        agregarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto=textoAgregar.getText().toString();
                listAdapter.add(texto);
                listAdapter.notifyDataSetChanged();
            }
        });
    }
}
