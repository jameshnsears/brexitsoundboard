package com.github.jameshnsears.brexitsoundboard

import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityBrexitSoundboardTest {
    @get:Rule
    var brexitSoundboardActivity: ActivityTestRule<ActivityBrexitSoundboard> = ActivityTestRule(ActivityBrexitSoundboard::class.java)

    @Test
    @UiThreadTest
    fun checkOrderOfButtonImages() {
        var activeImageId = brexitSoundboardActivity.activity!!.setNextButtonImage(
            brexitSoundboardActivity.activity?.activityHomeBinding!!.imageButtonBoris00,
            brexitSoundboardActivity.activity.buttonIdsBoris
        )
        Assert.assertEquals(R.id.imageButtonBoris01.toLong(), activeImageId.toLong())

        activeImageId = brexitSoundboardActivity.activity!!.setNextButtonImage(
            brexitSoundboardActivity.activity?.activityHomeBinding!!.imageButtonBoris08,
            brexitSoundboardActivity.activity.buttonIdsBoris
        )
        Assert.assertEquals(R.id.imageButtonBoris00.toLong(), activeImageId.toLong())
    }
}
