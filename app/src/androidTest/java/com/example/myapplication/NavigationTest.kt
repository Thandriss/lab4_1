package com.example.myapplication

import android.content.pm.ActivityInfo
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBackUnconditionally
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun FirstTest1() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()
        Assert.assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun FirstTest2() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun FirstTest3() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        pressBack()
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun FirstTest4() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        pressBack()
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest1() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_host_fragment_activity_main)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest2() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest3() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest4() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest5() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest6() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_view)).perform(click())
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest7() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest8() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun SecondTest9() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withContentDescription("Navigate up")).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun ThirdTest1() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        rotLand()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(doesNotExist())
        onView(withId(R.id.fragment2)).check(doesNotExist())
    }

    @Test
    fun ThirdTest2() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        rotLand()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        rotPort()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun ThirdTest3() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        rotLand()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        rotPort()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        rotLand()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun ThirdTest4() {
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        rotLand()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        rotPort()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        rotLand()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        rotPort()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        rotLand()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }

    fun checkFr1() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
    }

    fun checkFr2() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun ThirdTest5() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        rotPort()
        rotLand()
        checkFr2()
        pressBack()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        rotPort()
        pressBack()
        checkFr2()
        rotLand()
        pressBack()
        checkFr1()
    }

    @Test
    fun ThirdTest6() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        rotPort()
        rotLand()
        checkFr2()
        pressBack()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        rotPort()
        pressBack()
        checkFr2()
        rotLand()
        rotPort()
        pressBack()
        checkFr1()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testAbout() {
        launchActivity<MainActivity>()
        openAbout()
        onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }

    private fun rotLand() {
        activityRule.scenario.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        Thread.sleep(1000)
    }
    private fun rotPort() {
        activityRule.scenario.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            )
        }
        Thread.sleep(1000)
    }
}