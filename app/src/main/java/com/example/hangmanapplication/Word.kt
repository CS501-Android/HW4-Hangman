package com.example.hangmanapplication

import android.util.Log
import kotlin.properties.Delegates

val words = listOf("book", "chair", "apple", "ocean", "music", "dream", "pizza", "cloud", "heart", "phone",
    "run", "jump", "sing", "write", "laugh", "sleep", "play", "learn", "cook", "draw",
    "happy", "blue", "smart", "fast", "cold", "big", "small", "cute", "funny", "brave")

class Word {
    private var current = words.random()
    private var strikes: Int = 0
    private var blanks = "_".repeat(this.current.length)


    private fun chooseWord() {
        this.current = words.random()
    }

    private fun resetStrikes() {
        this.strikes = 0
    }

    fun checkIfContains(c: Char) {
        var hasContained = false

        Log.e("Hmm", "Something has gotten here")
        for (i in 0..<this.current.length) {
            if (this.current[i] == c) { // replace the ith blank with the letter if it exists in the word
                hasContained = true
                updateBlank(i, c)
            }
        }

        // if the user did not type a letter in the word, increase the number of strikes!
        if (!hasContained) increaseStrikes()
    }


    // check if the user has completed the puzzle
    private fun checkIfDone(): Boolean {
        return current == this.blanks
    }

    // check if the user has maxed out their strikes
    private fun checkIfStruckOut(): Boolean {
        return this.strikes >= 6
    }

    // increase the strikes when user gets no letters
    private fun increaseStrikes() {
        this.strikes += 1
    }

    private fun setBlank(s: String) {
        this.blanks = s
    }

    private fun updateBlank(i: Int, c: Char) {
        setBlank(getBlank().replaceRange(i..i, c.toString()))
    }

    /* Public getter methods:
        get word - gets the current randomly chosen word
        get strikes - gets the current number of strikes
        get blank - gets the blank with embedded correct letters
     */
    fun getWord(): String {
        return this.current
    }

    fun getStrikes(): Int {
        return this.strikes
    }

    fun getBlank(): String {
        return this.blanks
    }

}
