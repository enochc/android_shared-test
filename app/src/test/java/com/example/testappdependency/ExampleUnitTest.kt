package com.example.testappdependency


import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sharedtestcode.SharedTestStringClass

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
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
