package com.tutorials180.fadp41app.CustomListAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tutorials180.fadp41app.R

class CustomListAdapter (var myContext:Context,
                        var titleList:List<String>,
                        var desList:List<String>,
                        var imageList:List<Int>):
ArrayAdapter<String>(myContext, R.layout.single_row,titleList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        var singleRow=LayoutInflater.from(myContext).inflate(R.layout.single_row,
                                    null,false)

        var titleTV:TextView = singleRow.findViewById(R.id.sr_title_tv)
        var desTV:TextView = singleRow.findViewById(R.id.sr_des_tv)

        var imageView: ImageView = singleRow.findViewById(R.id.sr_iv)
        titleTV.text = titleList.get(position)

        desTV.text = desList.get(position)
        imageView.setImageResource(imageList.get(position))

        return singleRow
    }

}