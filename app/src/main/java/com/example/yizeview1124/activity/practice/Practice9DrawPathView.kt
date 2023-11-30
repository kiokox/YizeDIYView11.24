package com.example.yizeview1124.activity.practice

import android.R.attr
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable


class Practice9DrawPathView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawPath() 方法画心形
        val path = Path()
        val mPaint = Paint()
        mPaint.color = Color.YELLOW
        mPaint.isAntiAlias = true;
        mPaint.strokeWidth = 10f

        path.moveTo((attr.width / 2).toFloat(), (attr.height / 4).toFloat())

        path.cubicTo(
            (attr.width * 6 / 7).toFloat(),
            (attr.height / 9).toFloat(),
            (attr.width * 12 / 13).toFloat(),
            (attr.height * 2 / 5).toFloat(),
            (attr.width / 2).toFloat(),
            (attr.height * 7 / 12).toFloat()
        )

        canvas.drawPath(path,  mPaint)

        val path2 = Path()

        path2.moveTo((attr.width / 2).toFloat(), (attr.height / 4).toFloat())

        path2.cubicTo(
            (attr.width / 7).toFloat(),
            (attr.height / 9).toFloat(),
            (attr.width / 13).toFloat(),
            (attr.height * 2 / 5).toFloat(),
            (attr.width / 2).toFloat(),
            (attr.height * 7 / 12).toFloat()
        )

        canvas.drawPath(path2, mPaint)

    }
}