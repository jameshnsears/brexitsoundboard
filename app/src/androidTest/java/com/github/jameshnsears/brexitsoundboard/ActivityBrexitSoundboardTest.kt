package com.github.jameshnsears.brexitsoundboard

import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.activity_home.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityBrexitSoundboardTest {
    @get:Rule
    var activityBrexitSoundboard: ActivityTestRule<ActivityBrexitSoundboard> = ActivityTestRule(ActivityBrexitSoundboard::class.java)

    @Test
    @UiThreadTest
    fun checkOrderOfButtonImages() {
        var activeImageId = activityBrexitSoundboard.activity!!.setNextButtonImage(
            activityBrexitSoundboard.activity?.activityHomeBinding!!.imageButtonBoris00,
            activityBrexitSoundboard.activity.buttonIdsBoris
        )
        Assert.assertEquals(R.id.imageButtonBoris01.toLong(), activeImageId.toLong())

        activeImageId = activityBrexitSoundboard.activity!!.setNextButtonImage(
            activityBrexitSoundboard.activity?.activityHomeBinding!!.imageButtonBoris08,
            activityBrexitSoundboard.activity.buttonIdsBoris
        )
        Assert.assertEquals(R.id.imageButtonBoris00.toLong(), activeImageId.toLong())

        activeImageId = activityBrexitSoundboard.activity!!.setNextButtonImage(
            activityBrexitSoundboard.activity?.activityHomeBinding!!.imageButtonTheresa00,
            activityBrexitSoundboard.activity.buttonIdsTheresa
        )
        Assert.assertEquals(R.id.imageButtonTheresa01.toLong(), activeImageId.toLong())
    }
}
