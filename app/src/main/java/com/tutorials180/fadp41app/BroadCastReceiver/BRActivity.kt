package com.tutorials180.fadp41app.BroadCastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tutorials180.fadp41app.R

class BRActivity : AppCompatActivity() {
    private lateinit var mWIFIManager:WifiManager
    private lateinit var brTV:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bractivity)

        mWIFIManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        brTV= findViewById(R.id.brTV)
    }

    override fun onStart() {
        super.onStart()
        val ourBrIntentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)

        registerReceiver(wifiBR,ourBrIntentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiBR)
    }

    private val wifiBR = object : BroadcastReceiver()
    {
        override fun onReceive(p0: Context?, p1: Intent?) {
            when(p1?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN))
            {
                WifiManager.WIFI_STATE_ENABLED ->
                {
                    brTV.text = "WIFI is Enabled"
                }

                WifiManager.WIFI_STATE_DISABLED ->
                {
                    brTV.text = "WIFI is disabled"
                }
            }
        }

    }
}