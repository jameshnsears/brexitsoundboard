package com.github.jameshnsears.brexitsoundboard.espresso

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.github.jameshnsears.brexitsoundboard.ActivityBrexitSoundboard
import com.github.jameshnsears.brexitsoundboard.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class PersmisionsTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(ActivityBrexitSoundboard::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant(
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"
        )

    @Test
    fun persmisionsTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(1000)

        val switch_ = onView(
            allOf(
                withId(R.id.installSound),
                withText("Enable Media Library integration?"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout),
                        childAtPosition(
                            withId(R.id.scrollView),
                            0
                        )
                    ),
                    0
                )
            )
        )
        switch_.perform(scrollTo(), click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(1000)

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(1000)

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.imageButtonBoris01),
                withContentDescription("Alexander Boris de Pfeffel Johnson"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.linearLayout),
                        1
                    ),
                    1
                )
            )
        )
        appCompatImageButton.perform(scrollTo(), click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(1000)

        val appCompatButton = onView(
            allOf(
                withId(R.id.buttonBoris350MillionPoundsAWeek),
                withText("350 Million Pounds A Week"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    0
                )
            )
        )
        appCompatButton.perform(scrollTo(), longClick())

// not working in CI!
//        Thread.sleep(1000)
//
//        val textView = onView(
//            allOf(
//                withId(android.R.id.title),
//                withText("Alarm"),
//                childAtPosition(
//                    childAtPosition(
//                        withClassName(`is`("com.android.internal.view.menu.ListMenuItemView")),
//                        0
//                    ),
//                    0
//                ),
//                isDisplayed()
//            )
//        )
//        textView.perform(click())
//
//        // Added a sleep statement to match the app's execution delay.
//        // The recommended way to handle such scenarios is to use Espresso idling resources:
//        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
//        Thread.sleep(1000)

        pressBack()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>,
        position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent) &&
                    view == parent.getChildAt(position)
            }
        }
    }
}
