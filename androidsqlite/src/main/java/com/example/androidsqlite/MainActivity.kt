package com.example.androidsqlite

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext,
                AppDb::class.java,
                "Mobile")
                .build()

        Thread{
            val mob=Mobile()
            mob.isQw=true
            mob.mbId=1234
            mob.mnFr="MI"
            mob.typ="TAB"

            db.mobDao().savedMobile(mob)

            db.mobDao().mobiles().forEach{
                Log.i("@example","""Type - ${it.typ}""")
                Log.i("@example","""MnFr - ${it.mnFr}""")
                Log.i("@example","""Id - ${it.mbId}""")
                Log.i("@example","""QWERTY - ${it.isQw}""")


            }

        }.start()

    }
}
