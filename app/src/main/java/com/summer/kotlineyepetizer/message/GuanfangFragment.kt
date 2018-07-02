package com.summer.kotlineyepetizer.message

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.summer.kotlineyepetizer.R
import com.summer.kotlineyepetizer.adapter.GuanfangAdapter
import com.summer.kotlineyepetizer.bean.Message
import kotlinx.android.synthetic.main.fragment_guanfang.*

class GuanfangFragment : Fragment(), MessageContract.View {
    private var dataList: ArrayList<Message>? = ArrayList()
    var adapter: GuanfangAdapter? = null
    override fun showData(dataList: ArrayList<Message>) {
        this.dataList?.addAll(dataList)
        adapter?.notifyDataSetChanged()
    }

    override fun showLoading(s: String) {
    }

    override fun dismissLoading() {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_guanfang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = GuanfangAdapter(context!!, dataList!!)
        recyclerView.adapter = adapter
        MessagePresenter(this).getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dataList?.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("log", "GuanfangFragment+ onDestroy")
    }
}