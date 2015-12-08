package com.example.tutorial.ejemplo14asynctask;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by alfredo on 7/12/15.
 */

/**
 * An asynchronous task is defined by a computation that runs on a background thread and whose result is published on the UI thread.
 * An asynchronous task is defined by 3 generic types, called
 *          Params,
 *          Progress
 *      and Result, and 4 steps,
 * called onPreExecute,
 *        doInBackground,
 *        onProgressUpdate
 *    and onPostExecute.
 */
public class BackgroundTask extends AsyncTask<Integer,Void,String>{

    private static final String TAG="BackgroundTask";

    @Override
    protected String doInBackground(Integer... params) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName();
    }

    @Override
    protected void onPostExecute(String resultado){
        Log.i(TAG, resultado);
        Log.i(TAG,Thread.currentThread().getName());
    }
}
