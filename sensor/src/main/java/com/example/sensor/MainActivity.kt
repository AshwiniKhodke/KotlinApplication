package com.example.sensor


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val lnsr=object:SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

        }

        override fun onSensorChanged(event: SensorEvent) {
            val dtx=event.values[0]
            val dty=event.values[1]
            val dtz=event.values[2]

            txtDt.text="""
                x $dtx
                y $dty
                z $dtz
            """.trimMargin()

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mgr = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lst = mgr.getSensorList(Sensor.TYPE_ALL)

        lst.forEach {
            txtDt.append(it.name)
            txtDt.append("\n")
            txtDt.append("\n-------")
        }

    }
}
