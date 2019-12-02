package com.example.tpdm_u4u5_practica1_sanchezelizondo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(){

    var sensorManager: SensorManager ?= null
    var oyenteProximidad : OyenteProxi ?= null
    var oyenteAcelerometro : Oyenteacele ?= null
    var oyenteShake : Oyenteshake?= null

    var x = 0f

    var contador = 0

    var distancia = 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager


        oyenteShake = Oyenteshake(this)
        oyenteProximidad = OyenteProxi(this)
        oyenteAcelerometro = Oyenteacele(this)

        sensorManager?.registerListener(oyenteProximidad,sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_UI)
        sensorManager?.registerListener(oyenteShake,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)
        sensorManager?.registerListener(oyenteAcelerometro,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)





    }

}
