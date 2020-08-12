package com.github.jameshnsears.brexitsoundboard.utils

import android.content.Context
import android.content.SharedPreferences
import com.github.jameshnsears.brexitsoundboard.BuildConfig
import timber.log.Timber

object SharedPreferencesHelper {
    @JvmField
    var SHARED_PREFERENCES_NAME = "BrexitSoundboard"

    @JvmField
    var INSTALL_SOUND = "installSoundIntoMediaLibrary"

    @JvmField
    var SELECTED_BUTTONID_BORIS = "currentBorisButtonId"

    @JvmField
    var SELECTED_BUTTONID_LIAM = "currentLiamButtonId"

    @JvmField
    var SELECTED_BUTTONID_DAVID = "currentDavidButtonId"

    @JvmField
    var SELECTED_BUTTONID_THERESA = "currentTheresaButtonId"

    @JvmStatic
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @JvmStatic
    fun isInstallSoundEnabled(context: Context): Boolean {
        return getSharedPreferences(context).getBoolean(INSTALL_SOUND, false)
    }

    @JvmStatic
    fun removePriorVersionSharedPreferences(context: Context) {
        if (BuildConfig.VERSION_CODE < 20) {
            Timber.d("removing prior shared preferences")

            val sharedPreferences = getSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }
    }
}
