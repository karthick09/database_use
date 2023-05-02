package com.example.database_use

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("Range", "SetTextI18n", "Recycle")
    fun onClickShowDetails(view: View?) {
        val resultView = findViewById<View>(R.id.res) as TextView
        val cursor = contentResolver.query(Uri.parse("content://com.demo.user.provider/users"), null, null, null, null)
        if (cursor!!.moveToFirst()) {
            val strBuild = StringBuilder()
            while (!cursor.isAfterLast) {
                strBuild.append("""
	
	${cursor.getString(cursor.getColumnIndex("id"))}-${cursor.getString(cursor.getColumnIndex("name"))}
	""".trimIndent())
                cursor.moveToNext()
            }
            resultView.text = strBuild
        } else {
            resultView.text = "No Records Found"
        }
    }
}
