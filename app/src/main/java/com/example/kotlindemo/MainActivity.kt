package com.example.kotlindemo

import android.app.ActivityManager
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.add_project.*

class MainActivity : AppCompatActivity(), SensorEventListener {


    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_project)

        clickMe.setOnClickListener {

        }
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)

        val activityManager: ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val configurationInfo = activityManager.deviceConfigurationInfo
        if (configurationInfo.reqGlEsVersion >= 0x20000) {
            Log.i("aaaa", "支持2.0")
        }else{
            Log.i("aaaa", "不支持2.0")
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        val values = event.values
        val builder = StringBuilder()
        builder.append("x方向旋转")
        builder.append(values[0])
        builder.append("\ny方向旋转")
        builder.append(values[1])
        builder.append("\nz方向旋转")
        builder.append(values[2])
        sensorTv.text = builder.toString()
    }


    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(this)
    }
}

