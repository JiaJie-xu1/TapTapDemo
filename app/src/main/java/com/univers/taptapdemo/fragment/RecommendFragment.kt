package com.univers.taptapdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.univers.taptapdemo.R
import com.univers.taptapdemo.widgets.view.DestinyUtil
import kotlinx.android.synthetic.main.home_recommend_fragment.*

class RecommendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_recommend_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
//        getData()
    }

    private fun initView() {
        rvRecommendList.isFocusableInTouchMode = true
        rvRecommendList.descendantFocusability = ViewGroup.FOCUS_BLOCK_DESCENDANTS

        ((recommendAppBarLayout.layoutParams as CoordinatorLayout.LayoutParams).behavior as AppBarLayout.Behavior).setDragCallback(
            object : AppBarLayout.Behavior.DragCallback() {
                override fun canDrag(appBarLayout: AppBarLayout): Boolean {
                    return true
                }
            })

        setAppBar()
    }

    fun setAppBar(){
        (parentFragment as HomeFragment).setAppBarLayout(recommendAppBarLayout)
    }

    private fun getData() {
        val a2: Int = DestinyUtil.getDps(R.dimen.dp24)
        val a3: Int = DestinyUtil.getDps(R.dimen.dp14) + a2

        if (true) {
            this.recommendAppBarLayout.setExpanded(false, false)
            content_frame.setVisibility(View.GONE)
            val marginLayoutParams3 =
                this.rvRecommendList.layoutParams as MarginLayoutParams
            marginLayoutParams3.topMargin = toolbar_content.getMeasuredHeight()
            this.rvRecommendList.layoutParams = marginLayoutParams3

            View
            toolbar_content.setBackgroundResource(R.drawable.shape_ffffff_10)
            (parentFragment as HomeFragment).getHomeView()
                .setBackgroundColor(context!!.resources.getColor(R.color.tag_blue))
        } else {
            toolbar_content.setBackgroundColor(0)
            if (true) {
                val marginLayoutParams4 =
                    this.rvRecommendList.layoutParams as MarginLayoutParams
                marginLayoutParams4.topMargin = -a2
                this.rvRecommendList.layoutParams = marginLayoutParams4
            }
            this.content_frame.setVisibility(View.VISIBLE)
        }
    }

}