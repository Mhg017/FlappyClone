package com.example.flappybirdclone

import android.content.Context
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.graphics.Rect


class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private val thread: GameThread
    private val bird: Bird
    private val pillars: MutableList<Pillar> = mutableListOf()

    init {
        holder.addCallback(this)
        thread = GameThread(holder, this)
        bird = Bird(context)  // Initialize bird here
        for (i in 1..3) {
            pillars.add(Pillar(context, 600 * i, 300))
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        var retry = true
        thread.setRunning(false)
        while (retry) {
            try {
                thread.join()
                retry = false
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        bird.update()
        bird.draw(canvas)

        for (pillar in pillars) {
            pillar.update()
            pillar.draw(canvas)

            // Collision detection
            for (rect in pillar.getRects()) {
                if (Rect.intersects(bird.getRect(), rect)) {
                    // Handle collision (e.g., end game)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        bird.onTouch()
        return super.onTouchEvent(event)
    }
}
