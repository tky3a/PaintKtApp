package com.example.paintktapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 5.Viewを取得
        val myView : MyView = findViewById(R.id.myView)
        val btnClear : Button = findViewById(R.id.btnClear)

        btnClear.setOnClickListener {
            myView.clearCanvas()
        }
    }
}
