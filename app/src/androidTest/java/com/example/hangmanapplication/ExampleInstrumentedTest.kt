package com.example.hangmanapplication

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.regex.Pattern.matches
import androidx.test.filters.LargeTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.hangmanapplication", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityInstrumentedTest {

    @Before
    fun setUp() {
        // You can perform any setup here if needed
    }
    @Test
    fun testButtonClick() {
        onView(withId(R.id.edit)).perform(typeText("a"))
        onView(withId(R.id.sub)).perform(click())
    }

    @Test
    fun testGameLost() {
        onView(withId(R.id.edit)).perform(typeText("x"))
        onView(withId(R.id.sub)).perform(click())
        onView(withId(R.id.edit)).perform(typeText("y"))
        onView(withId(R.id.sub)).perform(click())
        onView(withId(R.id.edit)).perform(typeText("z"))
        onView(withId(R.id.sub)).perform(click())
        onView(withId(R.id.edit)).perform(typeText("w"))
        onView(withId(R.id.sub)).perform(click())
        onView(withId(R.id.edit)).perform(typeText("u"))
        onView(withId(R.id.sub)).perform(click())
        onView(withId(R.id.edit)).perform(typeText("v"))
        onView(withId(R.id.sub)).perform(click())
    }

}