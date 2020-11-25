package com.univers.taptapdemo.fragment

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.appbar.AppBarLayout
import com.univers.taptapdemo.R
import com.univers.taptapdemo.widgets.behavior.RecommendToolBarBehaviorHelper
import com.univers.taptapdemo.widgets.view.DestinyUtil
import com.univers.taptapdemo.widgets.view.HomeHeadView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Jay.Xu
 * @since 2020/10/31
 */
class HomeFragment : Fragment() {

    private var mTitleList: MutableList<String> = ArrayList()
    private var fragmentList: MutableList<Fragment> = ArrayList()
    private lateinit var adapter: FragmentPagerAdapter
    private lateinit var recommendToolBarBehaviorHelper: RecommendToolBarBehaviorHelper
    private lateinit var appBarLayout: AppBarLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarTransParent()

        val layoutParams: CoordinatorLayout.LayoutParams =
            rlToolBarContainer.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.height = DestinyUtil.getStatusBarHeight(context) + DestinyUtil.getDps(
            R.dimen.abc_action_bar_default_height_material
        )
        rlToolBarContainer.layoutParams = layoutParams

        mTitleList.add("推荐")
        mTitleList.add("全部")

        fragmentList.add(RecommendFragment())
        fragmentList.add(CategoryFragment())

        adapter = object : FragmentPagerAdapter(childFragmentManager) {
            override fun getItem(i: Int): Fragment {
                return fragmentList[i]
            }

            override fun getCount(): Int {
                return fragmentList.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return when (position) {
                    0 -> "推荐"
                    1 -> "全部"
                    else -> super.getPageTitle(position)
                }
            }
        }
        viewPager.adapter = adapter
        homeHeadView.setViewPager(viewPager)
        recommendToolBarBehaviorHelper = RecommendToolBarBehaviorHelper()

    }

    public fun setAppBarLayout(appBarLayout: AppBarLayout) {
        this.appBarLayout = appBarLayout
        recommendToolBarBehaviorHelper.setView(
            rlToolBarContainer,
            vShade,
            appBarLayout,
            viewPager,
            homeHeadView.tabLayout
        )
    }

    fun setStatusBarTransParent() {
        //沉浸式导航栏
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = activity!!.window.decorView
            val option = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            decorView.systemUiVisibility = option
            activity!!.window.statusBarColor = Color.TRANSPARENT
        }
    }

    public fun setExpend(isExpend: Boolean) {
        appBarLayoutShade.setExpanded(isExpend)
    }

    fun getHomeView() : HomeHeadView{
        return homeHeadView
    }
}