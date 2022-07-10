package com.tutorials180.fadp41app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.fadp41app.Adapters.AdapterActivity
import com.tutorials180.fadp41app.BroadCastReceiver.BRActivity
import com.tutorials180.fadp41app.CustomListAdapter.CustomListActivity
import com.tutorials180.fadp41app.FbWorking.FbWorkingActivity
import com.tutorials180.fadp41app.GeoLocation.GeoLocationActivity
import com.tutorials180.fadp41app.RoomLib.RoomLibWorkingActivity
import com.tutorials180.fadp41app.SMSPackageManager.SMSManagerActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstValueET:EditText = findViewById(R.id.firstValueET)
        var secondValueET:EditText = findViewById(R.id.secondValueET)

        var resultTV:TextView = findViewById(R.id.resultTV)
        var resultBtn:Button = findViewById(R.id.resultBtn)

        var moveToAdapterActivityBtn = findViewById<Button>(R.id.moveToAdapterBtn)

        var moveToCustomAdapterActivityBtn = findViewById<Button>(R.id.moveToCustomAdapterBtn)
        resultBtn.setOnClickListener {

            var val1 = firstValueET.text.toString().toInt()
            var val2 = secondValueET.text.toString().toInt()

            var result = val1 + val2
            resultTV.text = result.toString()
        }

        val moveBtn:Button = findViewById(R.id.moveBtn)
        val userName = "Ali Raza"

        val userAge = 25
        moveBtn.setOnClickListener {
            var objIntent = Intent(MainActivity@this,SecondActivity::class.java)
            objIntent.putExtra("n",userName)

            objIntent.putExtra("a",userAge)
            startActivity(objIntent)
        }

        moveToAdapterActivityBtn.setOnClickListener {
            startActivity(Intent(MainActivity@this,AdapterActivity::class.java))
        }

//        moveToCustomAdapterActivityBtn.setOnClickListener {
//            startActivity(Intent(MainActivity@this,CustomListActivity::class.java))
//        }

//        moveToCustomAdapterActivityBtn.setOnClickListener {
//            startActivity(Intent(MainActivity@this,SMSManagerActivity::class.java))
//        }

//        moveToCustomAdapterActivityBtn.setOnClickListener {
//            startActivity(Intent(MainActivity@this,GeoLocationActivity::class.java))
//        }

//        moveToCustomAdapterActivityBtn.setOnClickListener {
//            startActivity(Intent(MainActivity@this,RoomLibWorkingActivity::class.java))
//        }

//        moveToCustomAdapterActivityBtn.setOnClickListener {
//            startActivity(Intent(MainActivity@this,FbWorkingActivity::class.java))
//        }

        moveToCustomAdapterActivityBtn.setOnClickListener {
            startActivity(Intent(MainActivity@this,BRActivity::class.java))
        }





 }

}