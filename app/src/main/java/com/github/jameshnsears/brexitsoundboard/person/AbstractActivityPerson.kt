package com.github.jameshnsears.brexitsoundboard.person

import android.provider.MediaStore
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.jameshnsears.brexitsoundboard.R
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper.Companion.auditEvent
import com.github.jameshnsears.brexitsoundboard.sound.MapButtonToSound
import com.github.jameshnsears.brexitsoundboard.sound.MediaPlayerHelper
import com.github.jameshnsears.brexitsoundboard.sound.MediaStoreHelper
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper.isInstallSoundEnabled
import com.github.jameshnsears.brexitsoundboard.utils.ToastHelper
import timber.log.Timber

abstract class AbstractActivityPerson : AppCompatActivity(), View.OnClickListener {
    private val mapButtonToSound = MapButtonToSound()

    private val mediaPlayerHelper = MediaPlayerHelper()
    private val mediaStoreHelper = MediaStoreHelper()

    private var viewContextMenuAppliesTo: View? = null

    fun registerClickListener(buttonId: Int) {
        findViewById<Button>(buttonId).setOnClickListener(this)
        if (isInstallSoundEnabled(this)) {
            registerForContextMenu(findViewById(buttonId))
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu, view: View, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, view, menuInfo)
        viewContextMenuAppliesTo = view
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_media_store, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val selectedSoundTitle = findViewById<Button>(viewContextMenuAppliesTo!!.id).text.toString()
        val selectedSoundId = mapButtonToSound.buttonIdToSoundIdMap[viewContextMenuAppliesTo!!.id]!!

        return when (item.itemId) {
            R.id.menu_item_alarm -> {
                soundInstall(selectedSoundId, selectedSoundTitle, MediaStore.Audio.Media.IS_ALARM)
                true
            }
            R.id.menu_item_notification -> {
                soundInstall(selectedSoundId, selectedSoundTitle, MediaStore.Audio.Media.IS_NOTIFICATION)
                true
            }
            R.id.menu_item_ringtone -> {
                soundInstall(selectedSoundId, selectedSoundTitle, MediaStore.Audio.Media.IS_RINGTONE)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onClick(view: View) {
        soundPlay(
            mapButtonToSound.buttonIdToSoundIdMap[view.id]!!,
            findViewById<Button>(view.id).text.toString()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        ToastHelper.cancelToast()
    }

    private fun soundPlay(rawSoundId: Int, nameOfSound: String) {
        Timber.d(String.format("soundPlay: %s", nameOfSound))

        auditEvent(AuditEventHelper.Event.SOUND, nameOfSound)

        mediaPlayerHelper.reset()
        mediaPlayerHelper.play(this, rawSoundId)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mediaPlayerHelper.reset()
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun soundInstall(resourceId: Int, nameOfSound: String, mediaType: String) {
        Timber.d(SharedPreferencesHelper.INSTALL_SOUND, mediaType)

        auditEvent(AuditEventHelper.Event.MEDIA_LIBRARY, "$mediaType:$nameOfSound")

        mediaStoreHelper.installSound(
            resources,
            baseContext,
            contentResolver,
            resourceId,
            nameOfSound,
            mediaType
        )
    }
}
