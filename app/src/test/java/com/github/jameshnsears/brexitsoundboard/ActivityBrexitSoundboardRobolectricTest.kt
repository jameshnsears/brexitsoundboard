package com.github.jameshnsears.brexitsoundboard

import com.github.jameshnsears.brexitsoundboard.person.ActivityDavid
import com.github.jameshnsears.brexitsoundboard.person.ActivityLiam
import com.github.jameshnsears.brexitsoundboard.person.ActivityTheresa
import kotlinx.android.synthetic.main.activity_david.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_liam.*
import kotlinx.android.synthetic.main.activity_theresa.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ActivityBrexitSoundboardRobolectricTest {
    // see - https://github.com/android/testing-samples - for testing ideas

    @Test
    fun checkOrderOfButtonImages() {
        val controller = Robolectric.buildActivity(ActivityBrexitSoundboard::class.java).create()
        controller.start()

        val activeImageId = controller.get().setNextButtonImage(
            controller.get().activityHomeBinding!!.imageButtonBoris00,
            controller.get().buttonIdsBoris
        )

        Assert.assertEquals(R.id.imageButtonBoris01.toLong(), activeImageId.toLong())
    }

    @Test
    fun playLiamSound() {
        val controller = Robolectric.buildActivity(ActivityLiam::class.java).create()
        controller.start()

        controller.get().onClick(controller.get().buttonLiamChickenObsessedMedia)
    }

    @Test
    fun playDavidSound() {
        val controller = Robolectric.buildActivity(ActivityDavid::class.java).create()
        controller.start()

        controller.get().onClick(controller.get().buttonDavidDoNotBlameMe)
    }

    @Test
    fun playTheresaSound() {
        val controller = Robolectric.buildActivity(ActivityTheresa::class.java).create()
        controller.start()

        controller.get().onClick(controller.get().buttonTheresAPlan)
    }

    @Test
    fun clickOnLinks() {
        val controller = Robolectric.buildActivity(ActivityBrexitSoundboard::class.java).create()
        controller.start()

        controller.get().activityHomeBinding!!.textViewNameBoris.performClick()
        controller.get().activityHomeBinding!!.textViewNameLiam.performClick()
        controller.get().activityHomeBinding!!.textViewNameDavid.performClick()
        controller.get().activityHomeBinding!!.textViewNameTheresa.performClick()

        controller.get().activityHomeBinding!!.imageButtonSuggestionBox.performClick()

        controller.get().activityHomeBinding!!.textViewVersion.performClick()
    }
}
