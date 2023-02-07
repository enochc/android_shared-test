package com.example.testappdependency


import android.util.Log
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.example.sharedtestcode.SharedTestStringClass

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(
    instrumentedPackages = [
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"
    ]
)
class ExampleUnitTest {
    @Test
    fun ensureCorrectValueFromSharedTestCode() {
        val sharedTestString = SharedTestStringClass.sharedTestStringFromMainActivity
        assertEquals("MainActivity string - added by shared test code", sharedTestString)
    }

    @Test
    fun launchFragmentAndVerifyUI() {

        SharedTestStringClass.doThing()
    }
}
