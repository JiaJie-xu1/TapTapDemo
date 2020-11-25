package com.univers.taptapdemo.widgets.view

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup

/**
 * Created by Jay.Xu
 * @since 2020/11/11
 */
class TagLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    val childBounds: MutableList<Rect> = ArrayList<Rect>()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var widthUsed = 0;
        var heightUsed = 0
        var lineMaxHeight = 0
        var lineWidthUsed = 0;
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            measureChildWithMargins(
                childView,
                widthMeasureSpec,
                0,
                heightMeasureSpec,
                heightUsed
            )

            if ((MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED)
                && (lineWidthUsed + childView.measuredWidth > MeasureSpec.getSize(widthMeasureSpec))
            ) {
                lineWidthUsed = 0;
                heightUsed += lineMaxHeight
                lineMaxHeight = 0
                measureChildWithMargins(
                    childView,
                    widthMeasureSpec,
                    0,
                    heightMeasureSpec,
                    heightUsed
                )
            }

            var childBound: Rect

            if (childBounds.size <= i) {
                childBound = Rect()
                childBounds.add(childBound)
            } else {
                childBound = childBounds[i]
            }
            childBound.set(
                lineWidthUsed,
                heightUsed,
                lineWidthUsed + childView.measuredWidth,
                heightUsed + childView.measuredHeight
            )
            lineWidthUsed += childView.measuredWidth
            widthUsed = Math.max(widthUsed, lineWidthUsed)

            lineMaxHeight = Math.max(lineMaxHeight, childView.measuredHeight)
        }

        var width = widthUsed
        var height = heightUsed + lineMaxHeight

        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        Log.e("xujj", "childCount:$childCount")
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            var childBound = childBounds[i]
            childView.layout(childBound.left, childBound.top, childBound.right, childBound.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}