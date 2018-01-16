package com.example.intel.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nm: String = "android"

        var mulLn =
                """
                    ashwini
                    veena
                    sonu
                    Kanchan
                    sonali
                    sangita
                    """.trimIndent()

        var dt = 10

        val dn = 10

        var cnNl: String? = "java"

        fun objects() {
            val fn = String()
        }

        fun loops() {
            println(""" value of nm is $nm""")
            val arr = arrayOf("android", "java", "kotlin")
            arr.forEach {
                println(it)
            }
        }

        for (i in 1..100) {
            println(i)
        }

        when (nm) {
            "android" -> print("android")
            "java" -> print("hello")

        }
    }
}
