package com.example.yizeview1124.activity.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class Practice8DrawArcView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        val mPaint = Paint()
        mPaint.color = Color.YELLOW
        val rectF = RectF(100f, 100f, 500f, 500f)
        canvas.drawRect(rectF, mPaint)

        val mPaint2 = Paint()
        mPaint2.color = Color.BLUE

        val mPaint3 = Paint()
        mPaint3.color = Color.BLUE
        // 空心
        mPaint3.style = Paint.Style.STROKE
        // 线条粗细
        mPaint3.strokeWidth = 10f
        canvas.drawArc(rectF, 180f, 90f, false, mPaint2)
        canvas.drawArc(rectF, 270f, 90f, true, mPaint2)
        canvas.drawArc(rectF, 0f, 90f, false, mPaint3)

    }
}