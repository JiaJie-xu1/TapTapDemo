package com.univers.taptapdemo.widgets.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.univers.taptapdemo.R;


public class HomeHeadView extends FrameLayout {

    public HomeHeadView(@NonNull Context context) {
        super(context);
        init();
    }

    public HomeHeadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HomeHeadView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.recommend_rec_head, this);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setViewPager(ViewPager viewPager) {
        this.tabLayout.setupTabs(viewPager);
    }

    public HomeTabLayout getTabLayout(){
        if (tabLayout!=null){
            return tabLayout;
        }
        return null;
    }
}
