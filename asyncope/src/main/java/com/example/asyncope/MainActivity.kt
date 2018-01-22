package com.example.asyncope

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOkay.setOnClickListener {
            val dlg = indeterminateProgressDialog(
                    message = "wait a bit",
                    title = " Counting"

            )
            doAsync {
                for (i in 1..100) {
                    Thread.sleep(100)
                    runOnUiThread {

                        txtInfo.text = """$i"""
                    }
                }
            }
            runOnUiThread { dlg.dismiss() }
        }
    }


    private fun hndlrs() {
        val hndl = Handler(Looper.getMainLooper())
        btnOkay.setOnClickListener {
            Thread {
                for (i in 1..100) {
                    Thread.sleep(1000)
                    hndl.post {
                        txtInfo.text = """$i"""
                    }
                }

            }.start()
        }
    }
        private fun normal() {
            Thread {
                for (i in 1..100) {
                    Thread.sleep(1000)
                    //txtInfo.text = """$i"""
                }
            }.start()
        }
}

