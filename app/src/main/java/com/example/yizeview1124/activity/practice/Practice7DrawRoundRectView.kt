package com.example.yizeview1124.activity.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class Practice7DrawRoundRectView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        val left = left + 100f
        val top = top + 100f
        val right = right - 100f
        val bottom = top + 500f
        val paint = Paint()
        canvas.drawRoundRect(left, top, right, bottom, 40f, 40f, paint)
    }
}