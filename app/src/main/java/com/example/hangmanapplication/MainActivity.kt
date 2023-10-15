package com.example.hangmanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val word: Word = Word()

        val firstView = findViewById<TextView>(R.id.textView)
        val secondView = findViewById<TextView>(R.id.textView2)
        val submitButton = findViewById<Button>(R.id.sub)
        val edit = findViewById<EditText>(R.id.edit)

        secondView.text = word.getWord()

        submitButton.setOnClickListener {
            val firstChar = edit.text.get(0)
            word.checkIfContains(firstChar)

            firstView.text = word.getStrikes().toString()
            secondView.text = word.getBlank()
        }
    }

}