package com.example.sharedtestcode

import android.util.Log
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import com.example.testappdependency.MainActivity
import com.example.testappdependency.R
import androidx.test.uiautomator.UiDevice


object SharedTestStringClass {
    val sharedTestStringFromMainActivity: String
        get() = MainActivity.mainAppString + " - added by shared test code"

    fun doThing(){

        ActivityScenario.launch(MainActivity::class.java)

        var device: UiDevice? = null
        try {
            device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        } catch (e: NullPointerException) {
            Log.e("ERROR", "null device")
        }

        onView(withId(R.id.textview_first)).check(matches(withText("Hello first fragment")))

        onView(withId(R.id.button_first)).perform(ViewActions.click())


        device?.waitForIdle()

        onView(withId(R.id.textview_second)).check(matches(withText("second")))

    }
}
