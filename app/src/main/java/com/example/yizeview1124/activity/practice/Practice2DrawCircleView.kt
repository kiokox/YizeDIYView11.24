package com.example.yizeview1124.activity.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import com.example.yizeview1124.R

class Practice2DrawCircleView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        var radius = 200f

        val paint1 = Paint()
        paint1.color = Color.YELLOW
        var cx1 = left + radius
        var cy1 = top + radius
        canvas.drawCircle(cx1, cy1, radius, paint1)

        val paint2 = Paint()
        paint2.color = Color.WHITE
        var cx2 = right - radius
        var cy2 = top + radius
        canvas.drawCircle(cx2, cy2, radius, paint2)

        val paint2_1 = Paint()
        paint2_1.color = resources.getColor(R.color.carrot)
        canvas.drawCircle(cx2, cy2, 180f, paint2_1)

        val paint3 = Paint()
        paint3.color = Color.BLUE
        paint3.style = Paint.Style.STROKE
        var cx3 = left + radius
        var cy3 = top + radius * 3.2f
        canvas.drawCircle(cx3, cy3, radius, paint3)

        val paint4 = Paint()
        paint4.color = Color.YELLOW
        paint4.style = Paint.Style.STROKE
        paint4.strokeWidth = 20f
        var cx4 = right - radius
        var cy4 = top + radius * 3.2f
        canvas.drawCircle(cx4, cy4, radius, paint4)

    }
}