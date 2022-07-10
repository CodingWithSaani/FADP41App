package com.tutorials180.fadp41app.CustomListAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.tutorials180.fadp41app.MainActivity
import com.tutorials180.fadp41app.R

class CustomListActivity : AppCompatActivity()
{
    private var titleList = listOf("News 1","News 2", "News 3","News 4","News 5"
                            ,"News 1","News 2", "News 3","News 4","News 5",
                            "News 1","News 2", "News 3","News 4","News 5")

    private var desList = listOf("News 1 Des","News 2 Des", "News 3 Des","News 4 Des","News 5"
        ,"News 1","News 2", "News 3","News 4","News 5",
        "News 1","News 2", "News 3","News 4","News 5")

    private var imageList = listOf(R.drawable.ba,R.drawable.ba, R.drawable.ba,R.drawable.ba,R.drawable.ba
        ,R.drawable.ba,R.drawable.aa, R.drawable.sm,R.drawable.ha,R.drawable.ba,
        R.drawable.ba,R.drawable.ba, R.drawable.iuh,R.drawable.ba,R.drawable.ba)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        var listView = findViewById<ListView>(R.id.ourCustomListView)
        listView.adapter = CustomListAdapter(MainActivity@this,titleList,desList,
        imageList)
    }
}