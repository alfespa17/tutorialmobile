package com.example.tutorial.ejemplo11sqlcontentprovider;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tutorial.ejemplo11sqlcontentprovider.adapter.ContactoAdapter;
import com.example.tutorial.ejemplo11sqlcontentprovider.contentProvider.contrato.Contacto;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    private ListView lista;
    private Button guardar;
    private EditText contacto;
    private ContactoAdapter  mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista);
        guardar = (Button) findViewById(R.id.guardar);
        contacto = (EditText) findViewById(R.id.contacto);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues mNewValues = new ContentValues();

                mNewValues.put(Contacto.COLUMN_CONTACTO, contacto.getText().toString());

                Uri mAVPContentProviderUri = getApplicationContext().getContentResolver().insert(
                        Contacto.URI,
                        mNewValues
                );

                Log.i(TAG, "id insert: " + mAVPContentProviderUri.getLastPathSegment());

                mListAdapter.changeCursor(getContentResolver().query(Contacto.URI,
                        new String[]{
                                Contacto.COLUMN_ID,
                                Contacto.COLUMN_CONTACTO
                        },
                        null,
                        null,
                        Contacto.COLUMN_CONTACTO));

            }
        });

        if(mListAdapter==null) {
            mListAdapter = new ContactoAdapter(getApplicationContext());
        }
        lista.setAdapter( mListAdapter);

        mListAdapter.changeCursor(getContentResolver().query(Contacto.URI,
                new String[]{
                        Contacto.COLUMN_ID,
                        Contacto.COLUMN_CONTACTO
                },
                null,
                null,
                Contacto.COLUMN_CONTACTO));
    }
}
