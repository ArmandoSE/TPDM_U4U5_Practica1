package com.example.tpdm_u4u5_practica1_sanchezelizondo

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.Toast

class OyenteProxi (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        puntero.distancia = event!!.values[0]
        if (event!!.values[0]==0f)
            Toast.makeText(puntero,"distancia = "+event!!.values[0],Toast.LENGTH_SHORT).show()

    }

}