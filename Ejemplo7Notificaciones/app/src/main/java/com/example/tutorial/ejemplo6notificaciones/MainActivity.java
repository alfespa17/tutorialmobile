package com.example.tutorial.ejemplo6notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button lanzarNotificacion;

    private static int NOTIFICATION_ID=10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lanzarNotificacion=(Button)findViewById(R.id.lanzarNotificacion);

        lanzarNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder notificationBuilder = new Notification.Builder(
                        getApplicationContext())
                        .setTicker(getString(R.string.app_name))
                        .setSmallIcon(android.R.drawable.ic_menu_camera)
                        .setAutoCancel(true)
                        .setContentTitle("Titulo Notificacion")
                        .setContentText("Esta es una nueva notificacion");


                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify(NOTIFICATION_ID,
                        notificationBuilder.build());
            }
        });
    }
}
