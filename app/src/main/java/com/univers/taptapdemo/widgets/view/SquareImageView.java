package com.univers.taptapdemo.widgets.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * Created by Jay.Xu
 *
 * @since 2020/11/11
 */
public class SquareImageView extends AppCompatImageView {
    public SquareImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();

        int size = Math.max(measuredHeight, measuredWidth);
        setMeasuredDimension(size, size);//保存测得的尺寸
    }

}
