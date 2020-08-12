package com.github.jameshnsears.brexitsoundboard.sound

import android.app.Activity
import android.media.MediaPlayer
import timber.log.Timber

class MediaPlayerHelper {
    private var mediaPlayer: MediaPlayer? = null

    fun reset() {
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
        }
    }

    fun play(activity: Activity?, rawSoundId: Int) {
        Timber.d("playMediaFile")
        try {
            mediaPlayer = MediaPlayer.create(activity, rawSoundId)
            mediaPlayer?.start()
        } catch (e: Exception) {
            Timber.d(String.format("%s", e.message))
            reset()
            play(activity, rawSoundId)
        }
    }
}
