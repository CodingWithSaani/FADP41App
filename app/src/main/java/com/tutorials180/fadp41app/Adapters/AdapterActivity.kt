package com.tutorials180.fadp41app.Adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.tutorials180.fadp41app.R

class AdapterActivity : AppCompatActivity() {

    val weekDays = arrayOf("Monday","Tuesday","Wednesday",
        "Thursday","Friday","Saturday","Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)

        var myArrayAdapter = ArrayAdapter(this,
                               android.R.layout.simple_list_item_1,weekDays )

        var listView:ListView = findViewById(R.id.listView)
        listView.adapter = myArrayAdapter
    }
}


/*
    Step 1: Define the adapter view
        List View

    Step 2: Define the data source
        Array

    Step 3: Create and initialize the adapter
        ArrayAdapter

    Step 4:Connect Adapter with AdapterView
        myArrayAdapter with ListView
 */












