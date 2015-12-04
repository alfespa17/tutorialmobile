package com.example.tutorial.ejemplo10notificacionestoastalertas;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String TAG="MainActivity";

    private Button bToast;
    private Button bDialog;
    private Button bProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bToast = (Button) findViewById(R.id.bToast);
        bDialog = (Button) findViewById(R.id.bDialog);
        bProgreso = (Button) findViewById(R.id.bProgreso);

        bToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hola Mensaje Toast",Toast.LENGTH_LONG).show();
            }
        });

        bDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


                builder.setMessage("Mensaje Notificacion")
                        .setTitle("Titulo Notificacion");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "Click OK");
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "Click Cancel");
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        bProgreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mProgress=new ProgressDialog(MainActivity.this);
                mProgress.setMessage("Mostrando Mensaje....");
                mProgress.show();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000L);
                            mProgress.dismiss();
                        }catch(Exception ex){

                        }

                    }
                }).start();
            }
        });

    }
}
