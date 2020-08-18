package com.test.trafficlight

import android.graphics.drawable.Drawable
import android.os.SystemClock
import android.view.View
import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.core.graphics.drawable.toBitmap
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.test.trafficlight.uicomponents.TrafficLightActivity
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test

class TrafficLightActivityTest {

    @Rule @JvmField val activityTestRule = ActivityTestRule(TrafficLightActivity::class.java, true, true)

    @Test
    fun isRedLightDisplayed() {
//        assertThatDarkBG(R.id.redLight,R.drawable.red_circle_bg_light)
        SystemClock.sleep(3500)
        onView(withId(R.id.redLight))
            .check(matches(isDisplayed()))
        onView(withId(R.id.redLight)).perform(ViewActions.click())

    }

    @Test
    fun isOrangeLightDisplayed() {
        SystemClock.sleep(3500)
        Espresso.onView(withId(R.id.orangeLight))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.orangeLight)).perform(ViewActions.click())

    }

    @Test
    fun isGreenLightDisplayed() {
        SystemClock.sleep(3500)
        Espresso.onView(withId(R.id.greenLight))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.greenLight)).perform(ViewActions.click())

    }

    fun testDrawable(){
        onView(withId(R.id.redLight))
            .check(matches(isDisplayed()))
            .check(matches(hasBackground(R.drawable.round_edge_corner)))
    }

    private fun assertThatDarkBG(@IdRes viewId: Int, @DrawableRes drawable: Int) {
        onView(allOf(withId(viewId), isDisplayed()))
                .check(matches(hasBackground(drawable)))
    }


    fun withDrawable(@DrawableRes id: Int) = object : TypeSafeMatcher<View>() {
        override fun describeTo(description: Description) {
            description.appendText("ImageView with drawable same as drawable with id $id")
        }

        override fun matchesSafely(view: View): Boolean {
            val context = view.context
            val expectedBitmap = context.getDrawable(id)?.toBitmap()

            return view is ImageButton && view.drawable.toBitmap().sameAs(expectedBitmap)
        }
    }

}