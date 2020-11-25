package com.univers.taptapdemo.widgets.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;

import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;

import com.univers.taptapdemo.R;

import java.util.Arrays;
import java.util.List;

public class HomeTabLayout extends HorizontalScrollView implements ITabLayout {
    private static final Interpolator a = new FastOutSlowInInterpolator();
    private static final long b = 200;
    /* access modifiers changed from: private */
    public float A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    /* access modifiers changed from: private */
    public boolean E;
    private boolean F;
    private RectF G;
    private Paint H;
    private Paint I;
    private Rect J;
    /* access modifiers changed from: private */
    public ViewPager K;
    private List<String> L;
    private SimpleArrayMap<Integer, String> M;
    /* access modifiers changed from: private */
    public LinearLayout N;
    private ValueAnimator O;
    private PageChangeListener P;
    /* access modifiers changed from: private */
    public OnItemClickListener listener;
    /* access modifiers changed from: private */
    public boolean show;
    /* access modifiers changed from: private */
    public boolean S;
    /* access modifiers changed from: private */
    public int tab_title_color;
    /* access modifiers changed from: private */
    public int tab_sub_title_color;
    /* access modifiers changed from: private */
    public int tab_title2_color;
    /* access modifiers changed from: private */
    public int tab_sub_title2_color;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public int p;
    private int q;
    /* access modifiers changed from: private */
    public int r;
    private int s;
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f212u;
    private float v;
    /* access modifiers changed from: private */
    public float w;
    /* access modifiers changed from: private */
    public float x;
    /* access modifiers changed from: private */
    public float textView1Size;
    /* access modifiers changed from: private */
    public float z;

    public interface OnItemClickListener {
        void a(View view, int i, int i2);
    }

    public HomeTabLayout(Context context) {
        this(context, null);
    }

    public HomeTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint("ResourceType")
    public HomeTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = 0;
        this.p = 0;
        this.F = true;
        this.S = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ForumTabLayout, i2, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(12, DestinyUtil.getDps((int) R.dimen.dp24));
        this.k = obtainStyledAttributes.getDimensionPixelSize(11, DestinyUtil.getDps((int) R.dimen.dp3));
        this.textView1Size = (float) obtainStyledAttributes.getDimensionPixelSize(18, DestinyUtil.getDps((int) R.dimen.sp16));
        this.x = (float) obtainStyledAttributes.getDimensionPixelSize(14, DestinyUtil.getDps((int) R.dimen.sp16));
        this.A = (float) obtainStyledAttributes.getDimensionPixelSize(4, DestinyUtil.getDps((int) R.dimen.sp11));
        this.z = (float) obtainStyledAttributes.getDimensionPixelSize(8, DestinyUtil.getDps((int) R.dimen.sp12));
        this.v = (float) obtainStyledAttributes.getDimensionPixelSize(20, 1);
        this.i = obtainStyledAttributes.getDimensionPixelSize(0, DestinyUtil.dip2px(getContext(), 1.5f));
        this.s = obtainStyledAttributes.getDimensionPixelSize(1, DestinyUtil.getDps((int) R.dimen.dp30));
        this.tab_sub_title_color = obtainStyledAttributes.getColor(17, context.getResources().getColor(R.color.v2_forum_tab_sub_title_color));
        this.tab_title_color = obtainStyledAttributes.getColor(13, context.getResources().getColor(R.color.v2_forum_tab_title_color));
        this.tab_sub_title2_color = obtainStyledAttributes.getColor(7, context.getResources().getColor(R.color.v2_forum_tab_sub_title_color));
        this.tab_title2_color = obtainStyledAttributes.getColor(3, context.getResources().getColor(R.color.v2_forum_tab_title_color));
        this.j = obtainStyledAttributes.getColor(10, context.getResources().getColor(R.color.v2_home_app_bar_tab_indicator));
        this.n = obtainStyledAttributes.getColor(19, context.getResources().getColor(R.color.transparent));
        this.B = obtainStyledAttributes.getBoolean(16, false);
        this.C = obtainStyledAttributes.getBoolean(15, true);
        this.E = obtainStyledAttributes.getBoolean(5, false);
        this.D = obtainStyledAttributes.getBoolean(6, false);
        this.t = obtainStyledAttributes.getDimensionPixelSize(2, DestinyUtil.getDps((int) R.dimen.dp5));
        this.f212u = obtainStyledAttributes.getDimensionPixelSize(9, 0);
        obtainStyledAttributes.recycle();
        b();
    }

    private void b() {
        this.H = new Paint(1);
        this.G = new RectF();
        this.J = new Rect();
        this.I = new Paint();
        setClipChildren(true);
        setClipToPadding(true);
        this.N = new LinearLayout(getContext());
        setFillViewport(true);
        addView(this.N, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setupTabs(ViewPager viewPager) {
        if (viewPager != null) {
            this.K = viewPager;
            if (this.P == null) {
                this.P = new PageChangeListener();
            }
            this.F = true;
            this.P.a();
            this.K.removeOnPageChangeListener(this.P);
            this.K.addOnPageChangeListener(this.P);
            this.N.removeAllViews();
            List<String> list = this.L;
            int i2 = 0;
            if (list != null && !list.isEmpty()) {
                while (i2 < this.L.size()) {
                    String str = this.L.get(i2);
                    SimpleArrayMap<Integer, String> simpleArrayMap = this.M;
                    setTabView(i2, str, simpleArrayMap != null ? simpleArrayMap.get(Integer.valueOf(i2)) : null);
                    i2++;
                }
            } else if (viewPager.getAdapter() != null) {
                while (i2 < viewPager.getAdapter().getCount()) {
                    CharSequence c2 = viewPager.getAdapter().getPageTitle(i2);
                    if (!TextUtils.isEmpty(c2)) {
                        setTabView(i2, c2.toString(), null);
                    }
                    i2++;
                }
            }
            setValueAnimator(this.g);
            p(this.g);
        }
    }

    public void setupTabs() {
        ViewPager viewPager = this.K;
        if (viewPager != null) {
            setupTabs(viewPager);
        }
    }

    public void setupTabs(String[] strArr) {
        a(Arrays.asList(strArr));
        setupTabs();
    }

    public void setupTabs(String[] strArr, boolean z2) {
        this.show = !z2;
        a(Arrays.asList(strArr));
        setupTabs();
    }

    TabView tabView1;
    TabView tabView2;
    private void setTabView(final int i2, String str, String str2) {
        TabView tabView = new TabView(getContext());
        tabView.a(str);
        tabView.b(str2);
        tabView.setMinimumWidth(this.q);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        this.N.addView(tabView, i2, layoutParams);

        if (this.tabView1==null){
            this.tabView1 = tabView;
        }else if (this.tabView2 ==null){
            this.tabView2 = tabView;
        }
        tabView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeTabLayout.this.K != null) {
                    HomeTabLayout.this.K.setCurrentItem(i2, true);
                }
                if (HomeTabLayout.this.listener != null) {
                    HomeTabLayout.this.listener.a(view, i2, HomeTabLayout.this.g);
                }
            }
        });
    }

    public TabView getTabView1(){
        return this.tabView1;
    }

    public TabView getTabView2() {
        return this.tabView2;
    }

    /* access modifiers changed from: private */
    public void p(int i2) {
        for (int i3 = 0; i3 < this.N.getChildCount(); i3++) {
            if (i2 == i3) {
                ((TabView) this.N.getChildAt(i3)).a(true);
            } else {
                ((TabView) this.N.getChildAt(i3)).a(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            post(new Runnable() {

                public void run() {
                    HomeTabLayout HomeTabLayout = HomeTabLayout.this;
                    int unused = HomeTabLayout.g = HomeTabLayout.r;
                    HomeTabLayout HomeTabLayout2 = HomeTabLayout.this;
                    HomeTabLayout2.p(HomeTabLayout2.g);
                    HomeTabLayout HomeTabLayout3 = HomeTabLayout.this;
                    HomeTabLayout3.setValueAnimator(HomeTabLayout3.g);
                    HomeTabLayout HomeTabLayout4 = HomeTabLayout.this;
                    HomeTabLayout4.q(HomeTabLayout4.g);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.K;
        if (viewPager != null) {
            viewPager.setAdapter(null);
            this.K = null;
        }
    }

    /* access modifiers changed from: private */
    public void q(int i2) {
        if (this.N.getChildCount() >= 1) {
            scrollTo(r(i2), i2);
        }
    }

    private int r(int i2) {
        View childAt = this.N.getChildAt(i2);
        int i3 = i2 + 1;
        View childAt2 = i3 < this.N.getChildCount() ? this.N.getChildAt(i3) : null;
        int i4 = 0;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        if (childAt != null) {
            i4 = childAt.getLeft();
        }
        return ((i4 + (width / 2)) - (getWidth() / 2)) + ((int) (((float) (width + width2)) * 0.5f * this.w));
    }

    public int a(int i2, boolean z2) {
        if (this.N.getChildCount() < 1) {
            return 0;
        }
        if (i2 >= this.N.getChildCount()) {
            i2 = this.N.getChildCount() - 1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += this.N.getChildAt(i4).getWidth();
        }
        if (i2 < 0 || i2 >= this.N.getChildCount()) {
            return i3;
        }
        if (z2) {
            return i3 + ((this.N.getChildAt(i2).getWidth() + this.h) / 2);
        }
        return i3 + ((this.N.getChildAt(i2).getWidth() - this.h) / 2);
    }

    public int b(int i2, boolean z2) {
        return a(i2, !z2);
    }

    /* access modifiers changed from: private */
    public void setIndicatorStart(int i2) {
        this.l = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void setIndicatorEnd(int i2) {
        this.m = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        }
    }

    public void setValueAnimator(int i2) {
        setValueAnimator(i2, 200L);
    }

    private void setValueAnimator(int i2, long j2) {
        if (this.O == null) {
            this.O = new ValueAnimator();
        }
        if (this.O.isRunning()) {
            this.O.cancel();
        }
        this.O.setInterpolator(a);
        this.O.setDuration(j2);
        this.O.setIntValues(a(this.g, false), a(i2, false));
        this.O.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.play.taptap.ui.home.v3.HomeTabLayout.AnonymousClass3 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeTabLayout.this.setIndicatorStart(((Integer) valueAnimator.getAnimatedValue()).intValue());
                HomeTabLayout.this.setIndicatorEnd(((Integer) valueAnimator.getAnimatedValue()).intValue() + HomeTabLayout.this.h);
            }
        });
        this.O.start();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        if (this.F) {
            this.F = false;
            for (int i5 = 0; i5 < this.N.getChildCount(); i5++) {
                TabView tabView = (TabView) this.N.getChildAt(i5);
                int measuredWidth = tabView.getMeasuredWidth();
                String a2 = tabView.getText1String();
                if (!TextUtils.isEmpty(a2)) {
                    this.I.setTextSize(this.x);
                    if (this.C) {
                        this.I.setFakeBoldText(true);
                    }
                    this.I.getTextBounds(a2, 0, a2.length(), this.J);
                    i4 = this.J.width();
                } else {
                    i4 = 0;
                }
                String b2 = tabView.getText2String();
                if (!TextUtils.isEmpty(b2)) {
                    this.I.setTextSize(this.z);
                    if (this.E) {
                        this.I.setFakeBoldText(true);
                    }
                    this.I.getTextBounds(b2, 0, b2.length(), this.J);
                    i4 += this.J.width() + this.t;
                }
                int i6 = measuredWidth - i4;
                int i7 = this.s;
                if (i6 < i7) {
                    ViewGroup.LayoutParams layoutParams = tabView.getLayoutParams();
                    layoutParams.width = i4 + i7;
                    tabView.setLayoutParams(layoutParams);
                }
            }
            super.onMeasure(i2, i3);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.N.getChildCount() >= 1 && this.K != null) {
            if (this.l <= 0 || this.m <= 0) {
                int currentItem = this.K.getCurrentItem();
                this.r = currentItem;
                this.g = currentItem;
                this.l = a(this.K.getCurrentItem(), false);
                setIndicatorEnd(this.l + this.h);
            }
            this.H.setColor(this.n);
            this.H.setStrokeWidth(this.v);
            canvas.drawLine(0.0f, (float) (getHeight() - this.f212u), (float) (getWidth() + getScrollX()), (float) (getHeight() - this.f212u), this.H);
            int i2 = this.l;
            int i3 = this.m;
            if (i2 > i3) {
                this.G.set((float) i3, (float) ((getHeight() - this.k) - this.f212u), (float) this.l, (float) (getHeight() - this.f212u));
            } else {
                this.G.set((float) i2, (float) ((getHeight() - this.k) - this.f212u), (float) this.m, (float) (getHeight() - this.f212u));
            }
            this.H.setColor(this.j);
            this.H.setStrokeWidth((float) this.k);
            RectF rectF = this.G;
            int i4 = this.i;
            canvas.drawRoundRect(rectF, (float) i4, (float) i4, this.H);
        }
    }

    class PageChangeListener implements ViewPager.OnPageChangeListener {
        PageChangeListener() {
        }
        public void onPageScrolled(int i, float f, int i2) {
            int round;
            int i3 = i;
            float f2 = f;
            if (!(i3 == 0 && f2 == 0.0f && HomeTabLayout.this.p == 0) && (round = Math.round(((float) i3) + f2)) >= 0 && round < HomeTabLayout.this.N.getChildCount()) {
                float unused = HomeTabLayout.this.w = f2;
                HomeTabLayout.this.q(i3);
                boolean z = HomeTabLayout.this.p != 2 || HomeTabLayout.this.o == 1;
                if ((HomeTabLayout.this.p == 2 && HomeTabLayout.this.o == 0) ? false : true) {
                    HomeTabLayout HomeTabLayout = HomeTabLayout.this;
                    int a2 = HomeTabLayout.a(i3, i3 < HomeTabLayout.g);
                    HomeTabLayout HomeTabLayout2 = HomeTabLayout.this;
                    int b = HomeTabLayout2.b(i3, i3 < HomeTabLayout2.g);
                    if (!HomeTabLayout.this.S) {
                        int a3 = HomeTabLayout.this.a(i3, false);
                        int a4 = a3 + ((int) (((float) (HomeTabLayout.this.a(i3 + 1, false) - a3)) * HomeTabLayout.this.w));
                        HomeTabLayout.this.setIndicatorStart(a4);
                        HomeTabLayout HomeTabLayout3 = HomeTabLayout.this;
                        HomeTabLayout3.setIndicatorEnd(a4 + HomeTabLayout3.h);
                    } else if (i3 >= HomeTabLayout.this.g) {
                        int i4 = b;
                        if (((double) HomeTabLayout.this.w) == 0.0d) {
                            HomeTabLayout HomeTabLayout4 = HomeTabLayout.this;
                            HomeTabLayout4.setIndicatorStart(HomeTabLayout4.a(i3, false));
                            HomeTabLayout HomeTabLayout5 = HomeTabLayout.this;
                            HomeTabLayout5.setIndicatorEnd(HomeTabLayout5.b(i3, false));
                        } else if (HomeTabLayout.this.w <= 0.0f || ((double) HomeTabLayout.this.w) > 0.5d) {
                            HomeTabLayout HomeTabLayout6 = HomeTabLayout.this;
                            int i5 = i3 + 1;
                            HomeTabLayout6.setIndicatorStart(a2 + ((int) (((float) (HomeTabLayout6.a(i5, false) - a2)) * ((HomeTabLayout.this.w * 2.0f) - 1.0f))));
                            HomeTabLayout HomeTabLayout7 = HomeTabLayout.this;
                            HomeTabLayout7.setIndicatorEnd(HomeTabLayout7.b(i5, false));
                        } else {
                            HomeTabLayout.this.setIndicatorStart(a2);
                            HomeTabLayout HomeTabLayout8 = HomeTabLayout.this;
                            HomeTabLayout8.setIndicatorEnd(i4 + ((int) (((float) (HomeTabLayout8.b(i3 + 1, false) - i4)) * HomeTabLayout.this.w * 2.0f)));
                        }
                    } else {
                        int i6 = b;
                        if (((double) HomeTabLayout.this.w) == 0.0d) {
                            HomeTabLayout HomeTabLayout9 = HomeTabLayout.this;
                            HomeTabLayout9.setIndicatorStart(HomeTabLayout9.a(i3, true));
                            HomeTabLayout HomeTabLayout10 = HomeTabLayout.this;
                            HomeTabLayout10.setIndicatorEnd(HomeTabLayout10.b(i3, true));
                        } else if (HomeTabLayout.this.w <= 0.0f || ((double) HomeTabLayout.this.w) > 0.5d) {
                            int i7 = i6;
                            HomeTabLayout HomeTabLayout11 = HomeTabLayout.this;
                            int i8 = i3 + 1;
                            HomeTabLayout11.setIndicatorStart(HomeTabLayout11.a(i8, true));
                            HomeTabLayout HomeTabLayout12 = HomeTabLayout.this;
                            HomeTabLayout12.setIndicatorEnd(i7 + ((int) (((float) (HomeTabLayout12.b(i8, true) - i7)) * ((HomeTabLayout.this.w * 2.0f) - 1.0f))));
                        } else {
                            HomeTabLayout HomeTabLayout13 = HomeTabLayout.this;
                            HomeTabLayout13.setIndicatorStart(a2 + ((int) (((float) (HomeTabLayout13.a(i3 + 1, true) - a2)) * HomeTabLayout.this.w * 2.0f)));
                            HomeTabLayout.this.setIndicatorEnd(i6);
                        }
                    }
                }
                if (z) {
                    HomeTabLayout.this.p(round);
                }
            }
        }

        public void onPageSelected(int i) {
            if (HomeTabLayout.this.p == 0 || (HomeTabLayout.this.p == 2 && HomeTabLayout.this.o == 0 && HomeTabLayout.this.K != null)) {
                HomeTabLayout.this.p(i);
                HomeTabLayout.this.setValueAnimator(i);
            }
            int unused = HomeTabLayout.this.r = i;
        }

        public void onPageScrollStateChanged(int i) {
            HomeTabLayout HomeTabLayout = HomeTabLayout.this;
            int unused = HomeTabLayout.o = HomeTabLayout.p;
            int unused2 = HomeTabLayout.this.p = i;
            if (i == 0 && HomeTabLayout.this.g != HomeTabLayout.this.r) {
                HomeTabLayout HomeTabLayout2 = HomeTabLayout.this;
                int unused3 = HomeTabLayout2.g = HomeTabLayout2.r;
            }
        }

        public void a() {
            HomeTabLayout HomeTabLayout = HomeTabLayout.this;
            int unused = HomeTabLayout.o = HomeTabLayout.p = 0;
        }
    }

    public class TabView extends LinearLayout {
        public TextView textView1;
        public TextView textView2;

        public TabView(Context context) {
            super(context);
            setGravity(Gravity.CENTER);
            if (HomeTabLayout.this.f212u != 0) {
                ViewCompat.postInvalidateOnAnimation(this, 0, 0, 0, HomeTabLayout.this.f212u);
            }
            setClickable(true);
        }

        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (this.textView1 == null) {
                    this.textView1 = new TextView(getContext());
                    this.textView1.setSingleLine(true);
                    addView(this.textView1);
                }
                this.textView1.setText(str);
                a(isSelected());
            }
        }

        public void b(String str) {
            if (str != null) {
                if (this.textView2 == null) {
                    this.textView2 = new TextView(getContext());
                    this.textView2.setSingleLine(true);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                    layoutParams.leftMargin = HomeTabLayout.this.t;
                    addView(this.textView2, layoutParams);
                }
                if (HomeTabLayout.this.show && this.textView2.getVisibility() != GONE) {
                    this.textView2.setVisibility(GONE);
                } else if (!HomeTabLayout.this.show && this.textView2.getVisibility() != VISIBLE) {
                    this.textView2.setVisibility(VISIBLE);
                }
                this.textView2.setText(str);
                if (TextUtils.isEmpty(str) && this.textView2.getVisibility() != GONE) {
                    this.textView2.setVisibility(GONE);
                } else if (!TextUtils.isEmpty(str) && this.textView2.getVisibility() != VISIBLE) {
                    this.textView2.setVisibility(VISIBLE);
                }
                b(isSelected());
            }
        }

        public void a(boolean z) {
            setSelected(z);
            if (z) {
                this.textView1.setTextColor(HomeTabLayout.this.tab_title_color);
                this.textView1.setTextSize(0, HomeTabLayout.this.x);
                if (HomeTabLayout.this.C) {
                    this.textView1.getPaint().setFakeBoldText(true);
                } else {
                    this.textView1.getPaint().setFakeBoldText(false);
                }
                b(true);
                return;
            }
            this.textView1.setTextColor(HomeTabLayout.this.tab_sub_title_color);
            this.textView1.setTextSize(0, HomeTabLayout.this.textView1Size);
            if (HomeTabLayout.this.B) {
                this.textView1.getPaint().setFakeBoldText(true);
            } else {
                this.textView1.getPaint().setFakeBoldText(false);
            }
            b(false);
        }

        public void b(boolean z) {
            setSelected(z);
            TextView textView = this.textView2;
            if (textView == null) {
                return;
            }
            if (z) {
                textView.setTextColor(HomeTabLayout.this.tab_title2_color);
                this.textView2.setTextSize(0, HomeTabLayout.this.z);
                if (HomeTabLayout.this.E) {
                    this.textView2.getPaint().setFakeBoldText(true);
                } else {
                    this.textView2.getPaint().setFakeBoldText(false);
                }
            } else {
                textView.setTextColor(HomeTabLayout.this.tab_sub_title2_color);
                this.textView2.setTextSize(0, HomeTabLayout.this.A);
                if (HomeTabLayout.this.D) {
                    this.textView2.getPaint().setFakeBoldText(true);
                } else {
                    this.textView2.getPaint().setFakeBoldText(false);
                }
            }
        }

        public String getText1String() {
            return this.textView1.getText().toString();
        }

        public TextView getTextView1(){
            return this.textView1;
        }

        public TextView getTextView2(){
            return this.textView2;
        }

        public String getText2String() {
            TextView textView = this.textView2;
            if (textView == null) {
                return null;
            }
            return textView.getText().toString();
        }
    }

    public HomeTabLayout a(List<String> list) {
        this.L = list;
        return this;
    }

    public int getItemCount() {
        return this.N.getChildCount();
    }

    public HomeTabLayout b(List<String> list) {
        if (this.M == null) {
            this.M = new SimpleArrayMap<>();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.M.put(Integer.valueOf(i2), list.get(i2));
        }
        if (!this.F && !list.isEmpty()) {
            for (int i3 = 0; i3 < this.N.getChildCount(); i3++) {
                ((TabView) this.N.getChildAt(i3)).b(list.get(i3));
            }
        }
        this.F = true;
        return this;
    }

    public HomeTabLayout a(int i2) {
        this.q = i2;
        return this;
    }

    public HomeTabLayout b(int i2) {
        this.h = i2;
        return this;
    }

    public HomeTabLayout c(int i2) {
        this.k = i2;
        return this;
    }

    public HomeTabLayout setAppBarTabIndicatorColor(int i2) {
        this.j = i2;
        return this;
    }

    public HomeTabLayout setTabTitleColor(int i2) {
        this.tab_title_color = i2;
        return this;
    }

    public HomeTabLayout setTabSubTitleColor(int i2) {
        this.tab_sub_title_color = i2;
        return this;
    }

    public HomeTabLayout g(int i2) {
        this.x = (float) i2;
        return this;
    }

    public HomeTabLayout h(int i2) {
        this.textView1Size = (float) i2;
        return this;
    }

    public HomeTabLayout setTabTitle2Color(int i2) {
        this.tab_title2_color = i2;
        return this;
    }

    public HomeTabLayout setTabSubTitle2Color(int i2) {
        this.tab_sub_title2_color = i2;
        return this;
    }

    public HomeTabLayout k(int i2) {
        this.z = (float) i2;
        return this;
    }

    public HomeTabLayout l(int i2) {
        this.A = (float) i2;
        return this;
    }

    public HomeTabLayout m(int i2) {
        this.n = i2;
        return this;
    }

    public HomeTabLayout n(int i2) {
        this.t = i2;
        return this;
    }

    public HomeTabLayout o(int i2) {
        this.f212u = i2;
        return this;
    }

    public HomeTabLayout a(boolean z2) {
        this.E = z2;
        return this;
    }

    public HomeTabLayout b(boolean z2) {
        this.D = z2;
        return this;
    }

    public void setOpenFollowScroll(boolean z2) {
        this.S = z2;
    }

    public HomeTabLayout a(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
        return this;
    }
}