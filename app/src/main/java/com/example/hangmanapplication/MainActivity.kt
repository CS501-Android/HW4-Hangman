package com.example.hangmanapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var word: Word
    private lateinit var firstView: TextView
    private lateinit var secondView: TextView
    private lateinit var submitButton: Button
    private lateinit var edit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        word = Word()

        firstView = findViewById(R.id.textView)
        secondView = findViewById(R.id.textView2)
        submitButton = findViewById(R.id.sub)
        edit = findViewById(R.id.edit)

        secondView.text = word.getWord()

        submitButton.setOnClickListener {
            val inputText = edit.text.toString().trim()
            if (inputText.isNotEmpty() && inputText.length == 1) {
                val guessedLetter = inputText[0]

                word.checkIfContains(guessedLetter)

                firstView.text = "Strikes: ${word.getStrikes()}"
                secondView.text = word.getBlank()

                if (word.isGameWon()) {
                    displayMessage("You've won!")
                    startNewGame()
                } else if (word.isGameLost()) {
                    displayMessage("You've lost! The word was: ${word.getWord()}")
                    startNewGame()
                }
            }
        }
    }

    private fun startNewGame() {
        word = Word()
        secondView.text = word.getWord()
        firstView.text = "Strikes: 0"
        edit.text.clear()
    }

    private fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}