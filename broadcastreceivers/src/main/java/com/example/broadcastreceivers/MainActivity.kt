package com.example.broadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    private val br=MyReceiver()
    private val fltr=IntentFilter()
    private var lbrMgr:LocalBroadcastManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fltr.addAction("com.example.my.action")
        fltr.addAction("android.intent.action.ACTION_POWER_CONNECTED")
        fltr.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")

        lbrMgr = LocalBroadcastManager.getInstance(this@MainActivity)

    }
    fun onOkay(view: View){
        sendBroadcast(Intent("com.example.my.action"))

    }

    override fun onStart() {
        super.onStart()
        registerReceiver(br,fltr)
        lbrMgr?.registerReceiver(br, fltr)
    }

    override fun onStop() {

        unregisterReceiver(br)
        lbrMgr?.unregisterReceiver(br)
        super.onStop()
    }
}
