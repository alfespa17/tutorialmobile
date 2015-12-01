package com.example.tutorial.ejemplo4fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tutorial.ejemplo4fragment.EjemploFragment;

public class MainActivity extends AppCompatActivity implements com.example.tutorial.ejemplo4fragment.EjemploFragment.OnFragmentInteractionListener{

    private static String TAG="MainActivity";
    private Button frameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameButton=(Button)findViewById(R.id.frameButton);

        frameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                EjemploFragment mEjemplo = new com.example.tutorial.ejemplo4fragment.EjemploFragment();
                fragmentTransaction.replace(R.id.frameContainer, mEjemplo);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);

        Log.i(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onFragmentInteraction() {

    }
}
