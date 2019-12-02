package com.example.tpdm_u4u5_practica1_sanchezelizondo

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.Toast

class Oyenteshake (p:MainActivity): SensorEventListener {
    var puntero = p
    var cambio: Long = 0

    var x = 0f
    var y = 0f
    var z = 0f
    var nx = 0f
    var ny = 0f
    var nz = 0f

    var cont = 0
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var curTime: Long = System.currentTimeMillis()
        // only allow one update every 100ms.
        if ((curTime - cambio) > 100) {
            var diffTime = (curTime - cambio)
            cambio = curTime;

            x = event!!.values[0]
            y = event!!.values[1]
            z = event!!.values[2]

            var speed: Float = Math.abs(x + y + z - nx - ny - nz) / diffTime * 10000;

            if (speed > 800) {
                puntero.contador++
                if (puntero.contador == 4) puntero.contador = 0
            }
            nx = x
            ny = y
            nz = z
        }
    }
}

