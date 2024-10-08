package com.example.flappybirdclone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

class Pillar(context: Context, private var x: Int, private var gap: Int) {

    private val width: Int = 200
    private val height: Int = 500
    private val paint = Paint()

    init {
        paint.color = Color.GREEN
    }

    fun update() {
        x -= 10
        if (x < -width) {
            x += 1000
        }
    }

    fun draw(canvas: Canvas) {
        canvas.drawRect(Rect(x, 0, x + width, height), paint)
        canvas.drawRect(Rect(x, height + gap, x + width, 2000), paint)
    }

    fun getRects(): List<Rect> {
        val topRect = Rect(x, 0, x + width, height)
        val bottomRect = Rect(x, height + gap, x + width, 2000)
        return listOf(topRect, bottomRect)
    }
}