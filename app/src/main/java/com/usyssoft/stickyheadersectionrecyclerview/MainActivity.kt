package com.usyssoft.stickyheadersectionrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.MainAdapter
import com.model.ChildModel
import com.model.ListModel
import com.usyssoft.stickyheadersectionrecyclerview.databinding.ActivityMainBinding
import com.util.RecyclerItemDecoration


class MainActivity : AppCompatActivity() {
    private lateinit var b : ActivityMainBinding
    private var list : ArrayList<ListModel> = ArrayList()
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.apply {

            rv.setHasFixedSize(true)
            val lm = LinearLayoutManager(this@MainActivity)
            rv.layoutManager = lm
            adapter = MainAdapter(this@MainActivity,list)
            rv.adapter = adapter

            getData()





        }
    }
    private fun getSectionCallback(list: ArrayList<ListModel>): RecyclerItemDecoration.SectionCallback {
        return object : RecyclerItemDecoration.SectionCallback {
            override fun isSection(pos: Int): Boolean {
                return pos == 0 || list[pos].name != list[pos - 1].name
            }

            override fun getSectionHeaderName(pos: Int): String {
                return list[pos].name
            }
        }
    }


    private fun getData() {
        for (i in 0..50) {
            val section = ListModel("Section 1",ChildModel("Child $i"))
            list.add(section)
        }
        for (i in 0..100) {
            val section = ListModel("Section 2",ChildModel("Child $i"))
            list.add(section)
        }
        for (i in 0..250) {
            val section = ListModel("Section 3",ChildModel("Child $i"))
            list.add(section)
        }
        for (i in 0..450) {
            val section = ListModel("Section 4",ChildModel("Child $i"))
            list.add(section)
        }
        for (i in 0..750) {
            val section = ListModel("Section 5",ChildModel("Child $i"))
            list.add(section)
        }
        for (i in 0..1000) {
            val section = ListModel("Section 6",ChildModel("Child $i"))
            list.add(section)
        }

        //Sticky true false
        val recyclerItemDecoration = RecyclerItemDecoration(
            this@MainActivity,
            resources.getDimensionPixelSize(R.dimen.header_height),
            false,
            getSectionCallback(list)
        )
        b.rv.addItemDecoration(recyclerItemDecoration)

    }
}