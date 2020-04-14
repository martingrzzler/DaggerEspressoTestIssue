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

        // this doesn't work -> Cast Exception
        // val testMainComponent = (app.appComponent.mainComponent().create() as TestMainComponent)

        launchActivity<MainActivity>()

        onView(withId(R.id.main)).check(matches(isDisplayed()))
        onView(withText("Martin")).check(doesNotExist())
        onView(withText("martingrzzler")).check(doesNotExist())
        onView(withText("martin.gressler@code.berlin")).check(doesNotExist())


        onView(withId(R.id.getUserButton)).perform(click())

        onView(withText("Martin")).check(matches(isDisplayed()))
        onView(withText("martingrzzler")).check(matches(isDisplayed()))
        onView(withText("martin.gressler@code.berlin")).check(matches(isDisplayed()))


    }

}