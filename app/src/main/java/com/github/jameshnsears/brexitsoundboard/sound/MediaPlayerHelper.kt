package com.github.jameshnsears.brexitsoundboard.sound

import android.app.Activity
import android.media.MediaPlayer
import android.util.Log

class MediaPlayerHelper {
    private var mediaPlayer: MediaPlayer? = null

    fun reset() {
        try {
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                mediaPlayer!!.stop()
                mediaPlayer!!.release()
            }
        } catch (exception: IllegalStateException) {
            Log.e("reset", "" + exception.message)
        }
    }

    fun play(activity: Activity?, rawSoundId: Int) {
        Log.i("play", "playMediaFile")
        try {
            mediaPlayer = MediaPlayer.create(activity, rawSoundId)
            mediaPlayer?.start()
        } catch (e: Exception) {
            Log.d("play - Exception:", e.message)
            reset()
            play(activity, rawSoundId)
        }
    }
}
