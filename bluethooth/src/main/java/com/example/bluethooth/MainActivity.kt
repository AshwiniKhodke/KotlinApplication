package com.example.bluethooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {

    private  val btmgr by lazy {
        BluetoothAdapter.getDefaultAdapter()

    }
    private val scndRcvr=object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            val rmtDvc=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)as BluetoothDevice
            Log.i("@intel","")

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (btmgr === null) {
            Log.i("@intel", "Bluetooth is not supported to this device")
            return
        }
        if (!btmgr.isEnabled) {
            val enableBtIntent=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, 1234)

        } else {
            paired()
            registerReceiver(scndRcvr, IntentFilter(BluetoothDevice.ACTION_FOUND))
        }
    }
        private fun paired(){
            btmgr.bondedDevices.forEach{
                Log.i("@intel","Name ${it.name}")
            }
        }
    fun scan(vw:View)=btmgr.startDiscovery()
}


