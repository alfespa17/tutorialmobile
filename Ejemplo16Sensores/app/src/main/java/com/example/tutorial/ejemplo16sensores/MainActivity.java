package com.example.tutorial.ejemplo16sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG="MainActivity";
    private SensorManager mSensorManager;

    private Sensor mProximidad;
    private Sensor mAcelerometro;
    private Sensor mGiroscopio;
    private Sensor mPasos;
    private Sensor mContadorPasos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor mDevice: deviceSensors){
            Log.i(TAG, "***********");
            Log.i(TAG, mDevice.getName());
            Log.i(TAG, mDevice.getVendor());
            Log.i(TAG, "Version="+String.valueOf(mDevice.getVersion()));
            Log.i(TAG, "Energica="+String.valueOf(mDevice.getPower()));
            Log.i(TAG, "Resolucion="+String.valueOf(mDevice.getResolution()));
            Log.i(TAG, "RangoMaximo="+ String.valueOf(mDevice.getMaximumRange()));
            Log.i(TAG, "MinDelay="+ String.valueOf(mDevice.getMinDelay()));
            //Log.i(TAG, "MaxDelay="+ String.valueOf(mDevice.getMaxDelay()));
        }

        mProximidad = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mAcelerometro = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mGiroscopio = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mPasos = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        mContadorPasos = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mSensorManager.registerListener(this, mProximidad, SensorManager.SENSOR_DELAY_NORMAL);
        //mSensorManager.registerListener(this, mAcelerometro, SensorManager.SENSOR_DELAY_NORMAL);
        //mSensorManager.registerListener(this, mGiroscopio, SensorManager.SENSOR_DELAY_NORMAL);
        //mSensorManager.registerListener(this, mPasos, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mContadorPasos, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
            float[] value= event.values;
            Log.i(TAG,"-----------");
            Log.i(TAG,event.sensor.getName());
            Log.i(TAG,String.valueOf(value.length));
            Log.i(TAG,String.valueOf(value[0]));
            //Log.i(TAG,String.valueOf(value[1]));
            //Log.i(TAG,String.valueOf(value[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
