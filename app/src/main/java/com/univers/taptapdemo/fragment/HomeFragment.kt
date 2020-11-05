package com.univers.taptapdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.univers.taptapdemo.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Jay.Xu
 * @since 2020/10/31
 */
class HomeFragment : Fragment(){

    private var mTitleList: MutableList<String> = ArrayList()
    private var fragmentList: MutableList<Fragment> = ArrayList()
    private lateinit var adapter : FragmentPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTitleList.add("推荐")
        mTitleList.add("全部")

        fragmentList.add(CategoryFragment())
        fragmentList.add(CategoryFragment())

        adapter = object : FragmentPagerAdapter(childFragmentManager) {
            override fun getItem(i: Int): Fragment {
                return fragmentList[i]
            }

            override fun getCount(): Int {
                return fragmentList.size
            }
        }
        viewPager.adapter = adapter
        homeHeadView.setViewPager(viewPager)
    }
}