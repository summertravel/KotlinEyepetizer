package com.summer.kotlineyepetizer.gaunzhu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.bean.Guanzhu
import kotlinx.android.synthetic.main.fragment_guznhu.*

class GuanzhuFragment : Fragment(), GuanzhuContract.View {
    override fun showData(tab: ArrayList<Guanzhu.TabInfo.Tab>) {
        var title = ArrayList<String>()
        var fragmentList = ArrayList<Fragment>()
        for (i in tab.indices) {
            title.add(tab[i].name)
            fragmentList.add(GuanzhuListFragment(i,tab[i].apiUrl))
        }
        viewPager.adapter = object : FragmentStatePagerAdapter(childFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getCount(): Int {
                return fragmentList.size
            }

        }
        tabLayout.setViewPager(viewPager, title.toTypedArray())
    }

    override fun showLoading(s: String) {
    }

    override fun dismissLoading() {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_guznhu, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter = GuanZhuPresenter(this)
        presenter.getData()
    }
}