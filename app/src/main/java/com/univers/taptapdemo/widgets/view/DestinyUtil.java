package com.univers.taptapdemo.widgets.view;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.TypedValue;

public class DestinyUtil {

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dip2px(Application componentContext, float f) {
        return (int) ((f * componentContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getActionBarSize(Context context) {
        if (!context.getTheme().resolveAttribute(android.R.attr.actionBarSize, new TypedValue(), true)) {
            return 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        int dimension = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        return dimension;
    }

    public static int getDps(Context context,int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int getStatusBarHeight(Context context) {
        int identifier;
        if (Build.VERSION.SDK_INT < 19 || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

}