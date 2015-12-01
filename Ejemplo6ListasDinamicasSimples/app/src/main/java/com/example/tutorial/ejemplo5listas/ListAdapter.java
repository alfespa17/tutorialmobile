package com.example.tutorial.ejemplo5listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfredo on 30/11/15.
 */
public class ListAdapter extends BaseAdapter {

    ArrayList<String> datosLista=new ArrayList<>();
    private Context mContext;

    public ListAdapter(Context mContext){
        this.mContext=mContext;
    }

    public void changeContext(Context mContext){
        this.mContext=mContext;
    }

    public void add(String elemento){
        datosLista.add(elemento);
    }

    @Override
    public int getCount() {
        return datosLista.size();
    }

    @Override
    public Object getItem(int position) {
        return datosLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout itemLayout = (LinearLayout)inflater.inflate(R.layout.elemento_lista, null);

        TextView elemento=(TextView)itemLayout.findViewById(R.id.textoElemento);

        elemento.setText(datosLista.get(position));

        return itemLayout;
    }
}
