package com.summer.kotlineyepetizer.homepage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.base.BaseActivity
import com.summer.kotlineyepetizer.gaunzhu.GuanzhuFragment
import com.summer.kotlineyepetizer.message.MessageFragment
import com.summer.kotlineyepetizer.my.MyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    val bottom = arrayOf("首页", "关注", "通知", "我的")
    val select = arrayOf(R.drawable.ic_home_selected, R.drawable.ic_discovery_selected, R.drawable.ic_hot_selected, R.drawable.ic_mine_selected)
    val normal = arrayOf(R.drawable.ic_home_normal, R.drawable.ic_discovery_normal, R.drawable.ic_hot_normal, R.drawable.ic_mine_normal)


    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arrayList = ArrayList<CustomTabEntity>()
        for (i in bottom.indices) {
            val tab = object : CustomTabEntity {
                override fun getTabSelectedIcon(): Int {
                    return select[i]
                }

                override fun getTabTitle(): String {
                    return bottom[i]
                }

                override fun getTabUnselectedIcon(): Int {
                    return normal[i]
                }

            }
            arrayList.add(tab)
        }
        bottomLayout!!.setTabData(arrayList)
        bottomLayout.currentTab = 0
        bottomLayout.iconWidth = 25f
        bottomLayout.iconHeight = 25f
        bottomLayout.textSelectColor = R.color.black
        bottomLayout.textUnselectColor = R.color.gray
        bottomLayout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                viewPager.setCurrentItem(position,false)
            }

            override fun onTabReselect(position: Int) {
            }

        })

        var fragmentList = ArrayList<Fragment>()
        fragmentList.add(HomeFragment())
        fragmentList.add(GuanzhuFragment())
        fragmentList.add(MessageFragment())
        fragmentList.add(MyFragment())

        viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getCount(): Int {
                return fragmentList.size
            }

        }
    }


}



