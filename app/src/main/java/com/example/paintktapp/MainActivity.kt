package com.example.paintktapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private val spinnerItems = arrayOf("20", "15", "10", "5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 5.Viewを取得
        val myView : MyView = findViewById(R.id.myView)
        val btnClear : Button = findViewById(R.id.btnClear)
        val spinner: Spinner = findViewById(R.id.spinner)

        // TODO: 色変えボタンと線の太さを変更するボタンを追加する
        btnClear.setOnClickListener {
            myView.clearCanvas()
        }

        // Adapterの生成
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)

        // 選択肢の各項目のレイアウト
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // AdapterをSpinnerのAdapterとして設定
        spinner.adapter = adapter

        // OnItemSelectedListenerの実装
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            // 項目が選択された時に呼ばれる
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // 選択肢を文字列に変換してtextに代入
                val text: String = parent?.selectedItem.toString()
                val float: Float = text.toFloat()
                println(float)
                myView.changeLine(float)
            }

            // 何らかの理由で選択されることなく項目が閉じられたら呼ばれる
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}

