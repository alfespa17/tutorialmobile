package com.example.tutorial.ejemplo11sqlcontentprovider.contentProvider.contrato;

import android.net.Uri;
/**
 * Created by alfredo on 3/12/15.
 */
public class Contacto {

    public static final String TABLE_NAME="contacto";

    public static final Uri URI=Uri.parse("content://com.ejemplo11/"+TABLE_NAME);

    public static final String COLUMN_ID="_id";
    public static final String COLUMN_CONTACTO="CONTACTO";
}
