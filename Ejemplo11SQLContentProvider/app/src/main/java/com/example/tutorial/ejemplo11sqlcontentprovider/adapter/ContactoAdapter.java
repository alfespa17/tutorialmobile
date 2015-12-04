package com.example.tutorial.ejemplo11sqlcontentprovider.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.tutorial.ejemplo11sqlcontentprovider.R;
import com.example.tutorial.ejemplo11sqlcontentprovider.contentProvider.contrato.Contacto;

/**
 * Created by alfredo on 3/12/15.
 */
public class ContactoAdapter extends CursorAdapter{

    public ContactoAdapter(Context context){
        super(context,null,CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item,null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tContacto=(TextView)view.findViewById(R.id.contacto);

        String mContacto=cursor.getString(cursor.getColumnIndexOrThrow(Contacto.COLUMN_CONTACTO));

        tContacto.setText(mContacto);

    }
}
