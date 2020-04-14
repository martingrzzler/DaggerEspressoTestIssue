package com.martingrzzler.testdaggerapp

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.martingrzzler.testdaggerapp.di.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @Test
    fun test_clicking_btn_displays_user_data() {

        val app = InstrumentationRegistry.getInstrumentation()
            .targetContext.applicationContext as TestBaseApplication

        (app.appComponent as TestAppComponent).inject(this)


        launchActivity<MainActivity>()

        onView(withId(R.id.main)).check(matches(isDisplayed()))
        onView(withText("Max")).check(doesNotExist())
        onView(withText("maximus")).check(doesNotExist())
        onView(withText("maximus@maximal.com")).check(doesNotExist())


        onView(withId(R.id.getUserButton)).perform(click())

        onView(withText("Max")).check(matches(isDisplayed()))
        onView(withText("maximus")).check(matches(isDisplayed()))
        onView(withText("maximus@maximal.com")).check(matches(isDisplayed()))


    }

}