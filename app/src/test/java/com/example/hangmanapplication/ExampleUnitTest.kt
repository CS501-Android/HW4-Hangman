package com.example.hangmanapplication

import org.junit.Test

import org.junit.Assert.*

import org.junit.Assert.assertEquals
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

class WordUnitTest {

    private lateinit var word: Word

    @Before
    fun setUp() {
        word = Word()
    }

    @Test
    fun testCheckIfContains_CorrectGuess() {
        word.checkIfContains('a')
        assertEquals("_a___", word.getBlank())
    }

    @Test
    fun testCheckIfContains_IncorrectGuess() {
        word.checkIfContains('x')
        assertEquals(1, word.getStrikes())
    }

    class WordUnitTest {

        private lateinit var word: Word

        @Before
        fun setUp() {
            word = Word()
        }

        @Test
        fun testIsGameWon() {
            word.checkIfContains('b')
            word.checkIfContains('o')
            word.checkIfContains('k')
            word.checkIfContains('a')

            assertEquals(true, word.isGameWon())
        }

        @Test
        fun testIsGameLost() {
            word.increaseStrikes()
            word.increaseStrikes()
            word.increaseStrikes()
            word.increaseStrikes()
            word.increaseStrikes()
            word.increaseStrikes()

            assertEquals(true, word.isGameLost())
        }
    }
}


