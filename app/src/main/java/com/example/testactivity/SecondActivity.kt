package com.example.testactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    val TAG="SecondActivity"
    var returnValue: Double =0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title=TAG

        val data=intent.getDoubleExtra("main_activity_data",0.0)

        returnValue=data*data

        textView.text="$data -> $returnValue"

        Log.v(TAG,"onCreate")
    }


    fun closeActivity(v: View){
        var resultIntent= Intent();
        resultIntent.putExtra("result", returnValue)
        println("$returnValue")
        setResult(Activity.RESULT_OK,resultIntent)
        finish()
    }
}