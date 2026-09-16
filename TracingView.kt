package com.example.tracingalphabet

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class EraseView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private lateinit var eraseBitmap: Bitmap
    private lateinit var eraseCanvas: Canvas
    private var letterRes: Int = R.drawable.a

    private val erasePaint = Paint().apply {
        isAntiAlias = true
        strokeWidth = 100f
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    fun setLetter(resId: Int) {
        letterRes = resId
        recreateBitmap()
        invalidate()
    }

    private fun recreateBitmap() {
        if (width == 0 || height == 0) return

        eraseBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        eraseCanvas = Canvas(eraseBitmap)

        val whiteLetter = BitmapFactory.decodeResource(resources, letterRes)
        val scaled = Bitmap.createScaledBitmap(whiteLetter, width, height, true)

        eraseCanvas.drawBitmap(scaled, 0f, 0f, null)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        recreateBitmap()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(eraseBitmap, 0f, 0f, null)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_MOVE) {
            eraseCanvas.drawPoint(event.x, event.y, erasePaint)
            invalidate()
        }
        return true
    }
}
