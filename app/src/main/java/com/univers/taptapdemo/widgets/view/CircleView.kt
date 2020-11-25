package com.univers.taptapdemo.widgets.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View

/**
 * Created by Jay.Xu
 * @since 2020/11/11
 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val RADIUS = DestinyUtil.dip2px(context, 80f)
    val PADDING = DestinyUtil.dip2px(context, 8f)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var width = (PADDING + RADIUS) * 2
        var height = (PADDING + RADIUS) * 2

        /*var widthMode = MeasureSpec.getMode(widthMeasureSpec)
        var size = MeasureSpec.getSize(widthMeasureSpec)

        when(widthMode){
            MeasureSpec.EXACTLY ->
                width = size
            MeasureSpec.AT_MOST ->
                if (width > size){
                    width = size
                }
        }*/

        width = resolveSize(width,widthMeasureSpec)
        height = resolveSize(height,heightMeasureSpec)

        resolveSizeAndState(width,widthMeasureSpec,0)
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.RED)
        canvas?.drawCircle(
            (PADDING + RADIUS).toFloat(), (PADDING + RADIUS).toFloat(),
            RADIUS.toFloat(), paint
        )
    }
}