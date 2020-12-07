package com.example.randomnumber

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //長押しカウンター
    var i = 0

    fun getNumber(view: View) {
        val resultTextView: TextView = findViewById<TextView>(R.id.resultTextView)//画面のテキストビュー
        val button: Button = findViewById<Button>(R.id.button)//画面のボタン

        //0-999のリスト作成,抽選
        val numberList = (1..999).toList()

        //普通のボタン-タップ
        button.setOnClickListener {
            var result = numberList.random().toString()
            resultTextView.text = result
        }

        //普通のボタン-長押し
        button.setOnLongClickListener {
            if (i === 0) {
                resultTextView.text = "1000"
                i++
            } else {
                var result = numberList.random().toString()
                resultTextView.text = result
                i++
            }
            true
        }
    }

    fun resetNum(view: View) {
        val resetBtn: Button = findViewById<Button>(R.id.reset) //リセットボタン
            resetBtn.setOnClickListener {
                i = 0;
            }
    }
}





