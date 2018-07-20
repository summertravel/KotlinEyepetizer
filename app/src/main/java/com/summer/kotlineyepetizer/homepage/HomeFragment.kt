package com.summer.kotlineyepetizer.homepage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R

import com.summer.kotlineyepetizer.bean.CategoriesBean
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), CateContract.View {
    var rootView: View? = null

    override fun showData(bean: ArrayList<CategoriesBean>) {
        var title = ArrayList<String>()
        var fragmentList = ArrayList<Fragment>()
        for (i in bean.indices) {
            title.add(bean[i].name)
            fragmentList.add(HomeListFragment())
        }
        viewPager.adapter = object : FragmentStatePagerAdapter(childFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getCount(): Int {
                return title.size
            }

        }
        tabLayout.setViewPager(viewPager, title.toTypedArray())
    }

    override fun showLoading(s: String) {
    }

    override fun dismissLoading() {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catePresenter = CatePresenter(this)
        catePresenter.getData()
    }


}