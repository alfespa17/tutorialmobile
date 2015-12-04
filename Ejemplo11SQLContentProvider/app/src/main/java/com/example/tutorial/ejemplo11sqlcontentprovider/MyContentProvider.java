package com.example.tutorial.ejemplo11sqlcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import com.example.tutorial.ejemplo11sqlcontentprovider.contentProvider.contrato.Contacto;
import com.example.tutorial.ejemplo11sqlcontentprovider.contentProvider.databasehelper.ContactosDatabaseHelper;

public class MyContentProvider extends ContentProvider {

    private static final String TAG="ContentProvider";

    private SQLiteOpenHelper mDbHelper;


    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.i(TAG, "delete " + TAG);
        SQLiteDatabase db=mDbHelper.getWritableDatabase();
        return db.delete(Contacto.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.i(TAG, "insert " + TAG);
        SQLiteDatabase db=mDbHelper.getWritableDatabase();
        Long id=db.insert(Contacto.TABLE_NAME, null, values);
        return Uri.parse(Contacto.URI+"/"+id.toString());
    }

    @Override
    public boolean onCreate() {
        Log.i(TAG,"onCreate " + TAG);
        mDbHelper=new ContactosDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.i(TAG, "query " + TAG);
        SQLiteDatabase db=mDbHelper.getReadableDatabase();
        Cursor cursor=db.query(Contacto.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder+" ASC");
        Log.i(TAG, "query size" + cursor.getCount());
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Log.i(TAG, "update " + TAG);
        SQLiteDatabase db=mDbHelper.getWritableDatabase();
        return db.update(Contacto.TABLE_NAME, values, selection,selectionArgs);
    }
}
