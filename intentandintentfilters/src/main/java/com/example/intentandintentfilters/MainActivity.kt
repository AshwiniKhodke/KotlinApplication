package com.example.intentandintentfilters

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onOkay(view:View?){
        main()

    }

    private fun dial()
    {
        val int=Intent(Intent.ACTION_DIAL)
    }

   /* private fun call() {

        val int=Intent(Intent.ACTION_CALL)
        int.data=Uri.parse("tel://7721830905")
        startActivity(int)
    }*/
    private fun implicit(){
        val int=Intent()
        int.action="com.example.action.common"
        int.addCategory("com.example.category.Sports")
        int.data=Uri.parse("http://www.google.com")
        startActivity(int)

    }

    private fun main(){
        val int=Intent(Intent.ACTION_MAIN)
        int.addCategory(Intent.CATEGORY_LAUNCHER)
        startActivity(int)

    }
    private fun explicit(){
        startActivity(
                Intent(this@MainActivity,
                        SportsActivity::class.java)
        )

    }
}
