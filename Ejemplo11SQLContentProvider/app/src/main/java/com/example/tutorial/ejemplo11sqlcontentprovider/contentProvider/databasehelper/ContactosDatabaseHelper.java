package com.example.tutorial.ejemplo11sqlcontentprovider.contentProvider.databasehelper;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tutorial.ejemplo11sqlcontentprovider.contentProvider.contrato.Contacto;

/**
 * Created by alfredo on 3/12/15.
 */
public class ContactosDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG="ContactosDatabaseHelper";

    private Context mContext;

    private static final String DATABASE_NAME="Contactos.db";
    private static final int DATABASE_VERSION=1;

    public static String TABLE_NAME="SELFIES";

    final private static String CREATE_SELFIES_V1 =

            "CREATE TABLE contacto (" +
                    Contacto.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Contacto.COLUMN_CONTACTO + " TEXT NOT NULL" +
                    ")";

    public ContactosDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate(" + TAG + ")");
        db.execSQL(CREATE_SELFIES_V1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade(" + TAG + ")");
    }
}
