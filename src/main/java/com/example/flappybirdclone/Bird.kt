package com.example.flappybirdclone

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect

class Bird(context: Context) {

    private val birdBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.bird)
    private var x: Int = 100
    private var y: Int = 500
    private var velocity: Int = 0

    fun update() {
        y += velocity
        velocity += 2
    }

    fun onTouch() {
        velocity = -30
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(birdBitmap, x.toFloat(), y.toFloat(), null)
    }

    fun getRect(): Rect {
        return Rect(x, y, x + birdBitmap.width, y + birdBitmap.height)
    }
}