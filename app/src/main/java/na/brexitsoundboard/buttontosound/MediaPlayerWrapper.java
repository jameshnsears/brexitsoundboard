package na.brexitsoundboard.buttontosound;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;

public class MediaPlayerWrapper {
    private MediaPlayer mediaPlayer;

    public void resetMediaPlayer() {
        try {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        } catch (IllegalStateException exception) {
            // fix for: Fatal Exception: java.lang.NullPointerException: println needs a message
            Log.e("resetMediaPlayer=", "" + exception.getMessage());
        }
    }

    public void playMediaFile(final Activity activity, final int raw_sound) {
        Log.i(this.getClass().getSimpleName(), "playMediaFile");
        mediaPlayer = MediaPlayer.create(activity, raw_sound);
        mediaPlayer.start();
    }
}
