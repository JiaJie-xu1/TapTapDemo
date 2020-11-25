package com.univers.taptapdemo.widgets.behavior;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.univers.taptapdemo.MyApplication;
import com.univers.taptapdemo.R;
import com.univers.taptapdemo.widgets.view.DestinyUtil;
import com.univers.taptapdemo.widgets.view.HomeTabLayout;


public class RecommendToolBarBehaviorHelper {
    private AppBarLayout appBarLayout;
    public View shadeView;
    public View view;
    public View toolBarContainer;
    private ViewPager mPager;
    public float f;
    public int g;
    public boolean h;

    public HomeTabLayout tabLayout;

    public void setView(View view, View view2, AppBarLayout appBarLayout, ViewPager viewPager, HomeTabLayout tabLayout) {
        if (appBarLayout != null) {
            this.toolBarContainer = view;
            this.shadeView = view2;
            this.mPager = viewPager;
            this.tabLayout = tabLayout;
            ViewPager viewPager2 = this.mPager;
            if (viewPager2 != null) {
                viewPager2.addOnPageChangeListener(new RecommendOnPageChangeListener());
            }
            if (this.appBarLayout != appBarLayout) {
                this.appBarLayout = appBarLayout;
                this.appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new UpShowOffsetChangeListener(view, tabLayout));
            }
        }
    }

    public void setView(View view) {
        this.view = view;
    }

    class RecommendOnPageChangeListener implements ViewPager.OnPageChangeListener {
        RecommendOnPageChangeListener() {
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (RecommendToolBarBehaviorHelper.this.f < ((float) RecommendToolBarBehaviorHelper.this.getActionBarSize())) {
                if (i == 1) {
                    RecommendToolBarBehaviorHelper.this.shadeView.setAlpha(1.0f);
                } else {
                    RecommendToolBarBehaviorHelper.this.shadeView.setAlpha(f);
                }
            } else {
                RecommendToolBarBehaviorHelper.this.shadeView.setAlpha(0.0f);
            }
        }

        public void onPageSelected(int i) {
            int unused = RecommendToolBarBehaviorHelper.this.g = i;
        }

        public void onPageScrollStateChanged(int i) {

            if (i == 0 && RecommendToolBarBehaviorHelper.this.g == 1) {
                boolean unused = RecommendToolBarBehaviorHelper.this.h = true;
                if (RecommendToolBarBehaviorHelper.this.toolBarContainer.getTranslationY() != 0.0f) {
                    RecommendToolBarBehaviorHelper.this.toolBarContainer.animate().translationY(0.0f).setDuration(100).start();
                }
                if (RecommendToolBarBehaviorHelper.this.view != null && RecommendToolBarBehaviorHelper.this.view.getTranslationY() != 0.0f) {
                    RecommendToolBarBehaviorHelper.this.view.animate().translationY(0.0f).setDuration(100).start();
                }
            }
        }
    }

    class UpShowOffsetChangeListener implements AppBarLayout.OnOffsetChangedListener {
        public View appBarLayout;
        public int height = 0;

        public HomeTabLayout homeTabLayout;

        public UpShowOffsetChangeListener(View view, HomeTabLayout homeTabLayout) {
            this.appBarLayout = view;
            this.homeTabLayout = homeTabLayout;
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            boolean z = true;
            if (RecommendToolBarBehaviorHelper.this.g != 1) {
                if (this.height == 0) {
                    this.height = this.appBarLayout.getHeight();
                }
                int width = appBarLayout.getWidth() - this.height;
                if (RecommendToolBarBehaviorHelper.this.h) {
                    double d = (double) (-width);
                    double d2 = (double) this.height;
                    Double.isNaN(d2);
                    Double.isNaN(d);
                    if (((double) i) <= d + (d2 * 1.5d)) {
                        z = false;
                    }
                    if (z) {
                        this.appBarLayout.setBackgroundColor(0);
                        if (i + 200 > 0) {
                            boolean unused = RecommendToolBarBehaviorHelper.this.h = false;
                        }
                        if (homeTabLayout.getTabView1() != null && homeTabLayout.getTabView1().getTextView1() != null) {
                            homeTabLayout.getTabView1().getTextView1().setTextColor(0xffffffff);
                        }
                        if (homeTabLayout.getTabView2() != null && homeTabLayout.getTabView2().getTextView1() != null) {
                            homeTabLayout.getTabView2().getTextView1().setTextColor(0xffffffff);
                        }
                    } else {
                        this.appBarLayout.setBackgroundResource(R.color.c_f9f9f9);
                        if (((float) ((-(i - 200)) - width)) > ((float) this.height)) {
                            boolean unused2 = RecommendToolBarBehaviorHelper.this.h = false;
                        }
                        if (homeTabLayout != null) {
                            if (homeTabLayout.getTabView1() != null && homeTabLayout.getTabView1().getTextView1() != null) {
                                homeTabLayout.getTabView1().getTextView1().setTextColor(0xff63b4ff);
                            }
                            if (homeTabLayout.getTabView2() != null && homeTabLayout.getTabView2().getTextView1() != null) {
                                homeTabLayout.getTabView2().getTextView1().setTextColor(0xffaeaeae);
                            }
                        }
                    }
                } else {
                    if (i > (-width) + this.height) {
                        int i2 = i + 200;
                        if (i2 > 0) {
                            i2 = 0;
                        }
                        int i3 = this.height;
                        if (i2 < (-i3)) {
                            i2 = -i3;
                        }
                        float f = (float) i2;
                        this.appBarLayout.setTranslationY(f);
                        this.appBarLayout.setBackgroundColor(0);
                        this.appBarLayout.setClickable(false);

                        if (homeTabLayout != null) {
                            if (homeTabLayout.getTabView1() != null && homeTabLayout.getTabView1().getTextView1() != null) {
                                homeTabLayout.getTabView1().getTextView1().setTextColor(0xffffffff);
                            }
                            if (homeTabLayout.getTabView2() != null && homeTabLayout.getTabView2().getTextView1() != null) {
                                homeTabLayout.getTabView2().getTextView1().setTextColor(0xffffffff);
                            }
                        }
                        if (RecommendToolBarBehaviorHelper.this.view != null) {
                            RecommendToolBarBehaviorHelper.this.view.setTranslationY(f);
                        }
                    } else {
                        this.appBarLayout.setClickable(true);
                        this.appBarLayout.setBackgroundResource(R.color.c_f9f9f9);
                        if (homeTabLayout != null) {
                            if (homeTabLayout.getTabView1() != null && homeTabLayout.getTabView1().getTextView1() != null) {
                                homeTabLayout.getTabView1().getTextView1().setTextColor(0xff63b4ff);
                            }
                            if (homeTabLayout.getTabView2() != null && homeTabLayout.getTabView2().getTextView1() != null) {
                                homeTabLayout.getTabView2().getTextView1().setTextColor(0xffaeaeae);
                            }
                        }
                        float f2 = ((float) ((-(i - 200)) - width)) / ((float) this.height);
                        if (f2 > 1.0f) {
                            f2 = 1.0f;
                        } else if (f2 < 0.0f) {
                            f2 = 0.0f;
                        }
                        float f3 = (f2 - 1.0f) * ((float) this.height);
                        this.appBarLayout.setTranslationY(f3);
                        if (RecommendToolBarBehaviorHelper.this.view != null) {
                            RecommendToolBarBehaviorHelper.this.view.setTranslationY(f3);
                        }
                    }
                }
                float unused3 = RecommendToolBarBehaviorHelper.this.f = (float) i;
            }
        }
    }

    public int getActionBarSize() {
        return DestinyUtil.getStatusBarHeight(MyApplication.context) + DestinyUtil.getDps((int) R.dimen.abc_action_bar_default_height_material);
    }
}