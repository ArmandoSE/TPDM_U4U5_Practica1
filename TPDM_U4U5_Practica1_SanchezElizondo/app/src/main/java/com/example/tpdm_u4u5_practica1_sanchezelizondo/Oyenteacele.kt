package com.example.tpdm_u4u5_practica1_sanchezelizondo

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class Oyenteacele (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        puntero.x = event!!.values[0]
    }

}