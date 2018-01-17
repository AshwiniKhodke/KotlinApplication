package com.example.ankomodule

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        verticalLayout {
            button("Alert") {
                onClick {
                    alert {
                        title = "title"
                        message = "message"
                        yesButton {

                        }
                        noButton {

                        }

                    }.show()
                }
            }


            button("Date Picker") {
                onClick {
                    DatePickerDialog(this@MainActivity,
                            DatePickerDialog.OnDateSetListener { _, yr, mnth, dt ->
                                toast("""Sdt, - {$mnth + 1}, $yr""")
                            },
                            2018,
                            0,
                            16
                    ).show()


                }
            }



            button("Time Picker") {
                onClick {
                    TimePickerDialog(this@MainActivity, { _, hh, mm ->
                        toast(""" $hh:$mm""")

                    },
                            1,
                            12,
                            false

                    ).show()
                }
            }
            button("Custom Dialog"){
                onClick{
                    alert{
                        /*customView {
                            verticalLayout {
                                editText()
                                val nm = editText()
                                button("Go") {
                                    onClick{
                                        toast(""" Go Clicked ${nm.text}""")
                                    }
                                }
                            }
                        }*/
                        customView= View.inflate(this@MainActivity,R.layout.lgn,null)

                    }.show()
                        }

                    }

                }
            }


        }



