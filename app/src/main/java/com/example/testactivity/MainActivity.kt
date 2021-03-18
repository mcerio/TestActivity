package com.example.testactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    val TAG="MainActivity"
    val SECOND_ACTIVITY=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title=TAG
        Log.v(TAG,"onCreate")
    }


    fun openSecondActivity(v: View){
        Log.v(TAG,"onClick")
        val intent= Intent(this@MainActivity, SecondActivity::class.java)
        val msg= editText.text.toString()
        try {
            val num=msg.toDouble()
            intent.putExtra("main_activity_data",num)
            startActivityForResult(intent,SECOND_ACTIVITY)
        }catch (e: NumberFormatException){
            Toast.makeText(applicationContext,"$msg is mot a number",Toast.LENGTH_SHORT).show()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode==SECOND_ACTIVITY) and (resultCode== Activity.RESULT_OK)){
            val returnValue=data?.getDoubleExtra("result", 0.0)
            textView.setText("$returnValue")
        }
    }
}