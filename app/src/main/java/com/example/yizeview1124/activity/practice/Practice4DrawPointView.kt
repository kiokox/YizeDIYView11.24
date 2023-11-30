package com.example.yizeview1124.activity.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class Practice4DrawPointView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        val x = left + 100f
        val y = top + 100f
        val paint = Paint()
        paint.strokeWidth = 100f
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawPoint(x, y, paint)

        val x2 = right - 200f
        val y2 = top + 100f
        val paint2 = Paint()
        paint2.strokeWidth = 100f
        // 笔触方还是圆
        paint2.strokeCap = Paint.Cap.BUTT
        canvas.drawPoint(x2, y2, paint2)

        val points = floatArrayOf(200f, 400f, 500f, 600f, 800f, 800f)
        canvas.drawPoints(points, paint2)
    }
}