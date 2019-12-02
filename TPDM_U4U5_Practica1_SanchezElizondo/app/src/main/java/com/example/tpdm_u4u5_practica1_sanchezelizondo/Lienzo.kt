package com.example.tpdm_u4u5_practica1_sanchezelizondo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.util.ArrayList


class Lienzo(p:MainActivity): View(p) {

    var puntero = p

    var icono1 = Imagen(this, 50f, 250f, R.drawable.icono5)
    var icono2 = Imagen(this, 200f, 250f, R.drawable.icono1)
    var icono3 = Imagen(this, 350f, 250f, R.drawable.icono2)
    var icono4 = Imagen(this, 500f, 250f, R.drawable.icono3)
    var icono5 = Imagen(this, 650f, 250f, R.drawable.icono4)

    var icono12 = Imagen(this, 50f, 250f, R.drawable.bn_icono5)
    var icono22 = Imagen(this, 188f, 250f, R.drawable.bn_icono1)
    var icono32 = Imagen(this, 326f, 250f, R.drawable.bn_icono2)
    var icono42 = Imagen(this, 454f, 250f, R.drawable.bn_icono3)
    var icono52 = Imagen(this, 592f, 250f, R.drawable.bn_icono4)

    var icono13 = Imagen(this, 50f, 250f, R.drawable.vicono5)
    var icono23 = Imagen(this, 188f, 250f, R.drawable.vicono1)
    var icono33 = Imagen(this, 326f, 250f, R.drawable.vicono2)
    var icono43 = Imagen(this, 454f, 250f, R.drawable.vicono3)
    var icono53 = Imagen(this, 592f, 250f, R.drawable.vicono4)

    var icono14 = Imagen(this, 50f, 250f, R.drawable.iconfinder)
    var icono24 = Imagen(this, 188f, 250f, R.drawable.iconfinder2)
    var icono34 = Imagen(this, 326f, 250f, R.drawable.iconfinder3)
    var icono44 = Imagen(this, 454f, 250f, R.drawable.iconfinder4)
    var icono54 = Imagen(this, 592f, 250f, R.drawable.iconfinder5)

    var arrayImg = arrayListOf<Imagen>(icono1,icono2,icono3,icono4,icono5)
    var arrayImg2 = arrayListOf<Imagen>(icono12,icono22,icono32,icono42,icono52)
    var arrayImg3 = arrayListOf<Imagen>(icono13,icono23,icono33,icono43,icono53)
    var arrayImg4 = arrayListOf<Imagen>(icono14,icono24,icono34,icono44,icono54)
    var picono: Imagen ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        if(puntero.distancia == 0f){
            Toast.makeText(puntero,"",Toast.LENGTH_SHORT).show()
            c.restore()
        }
        else{
            when (puntero.contador) {
                0 -> {
                    drawImgs(arrayImg, c)
                    moverImagenes(arrayImg, puntero.x)
                }
                1 -> {
                    drawImgs(arrayImg2, c)
                    moverImagenes(arrayImg2, puntero.x)
                }
                2 -> {
                    drawImgs(arrayImg3, c)
                    moverImagenes(arrayImg3, puntero.x)
                }
                3 -> {
                    drawImgs(arrayImg4, c)
                    moverImagenes(arrayImg4, puntero.x)
                }
            }


        }


    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){

            MotionEvent.ACTION_DOWN -> {
                if(icono1.estaEnArea(e.getX(),e.getY())||
                    icono12.estaEnArea(e.getX(),e.getY())||
                    icono13.estaEnArea(e.getX(),e.getY())||
                    icono14.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste Facebook", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono1

                }
                if(icono2.estaEnArea(e.getX(),e.getY())||
                    icono22.estaEnArea(e.getX(),e.getY())||
                    icono23.estaEnArea(e.getX(),e.getY())||
                    icono24.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste Instagram", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono2
                }
                if(icono3.estaEnArea(e.getX(),e.getY())||
                    icono32.estaEnArea(e.getX(),e.getY())||
                    icono33.estaEnArea(e.getX(),e.getY())||
                    icono34.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste Twitter", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono3
                }
                if(icono4.estaEnArea(e.getX(),e.getY())||
                    icono42.estaEnArea(e.getX(),e.getY())||
                    icono43.estaEnArea(e.getX(),e.getY())||
                    icono44.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocast Whatsapp", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono4
                }
                if(icono5.estaEnArea(e.getX(),e.getY())||
                    icono52.estaEnArea(e.getX(),e.getY())||
                    icono53.estaEnArea(e.getX(),e.getY())||
                    icono54.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste youtube", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono5
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }

        }
        return true
    }

    fun moverImagenes(arrayImagenes: ArrayList<Imagen>,x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }



    fun drawImgs(arrayImagenes: ArrayList<Imagen>,c:Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }
}