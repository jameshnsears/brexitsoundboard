package na.brexitsoundboard;

import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import na.brexitsoundboard.analytics.FirebaseWrapper;
import na.brexitsoundboard.buttontosound.MapButtonToSound;
import na.brexitsoundboard.buttontosound.MediaPlayerWrapper;

public abstract class AbstractBrexitSoundboardActivity extends Activity implements View.OnClickListener {
    private final MapButtonToSound mapButtonToSound = new MapButtonToSound();

    final FirebaseWrapper firebaseWrapper = new FirebaseWrapper();

    private final MediaPlayerWrapper mediaPlayerWrapper = new MediaPlayerWrapper();

    private void playMediaFile(final int raw_sound) {
        mediaPlayerWrapper.playMediaFile(this, raw_sound);
    }

    void registerClickListener(final int buttonId) {
        final Button button = findViewById(buttonId);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        Log.i(this.getClass().getSimpleName(), "onClick");
        firebaseWrapper.logAnalyticsEvent(
                this.getClass().getName(),
                getResources().getResourceName(view.getId()),
                "onClick");
        mediaPlayerWrapper.resetMediaPlayer();
        try {
            playMediaFile(mapButtonToSound.buttonIdToSoundIdMap.get(view.getId()));
        } catch (NullPointerException exception) {
            Log.e("NullPointerException", exception.getMessage());
        }
    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mediaPlayerWrapper.resetMediaPlayer();
        }
        return super.onKeyDown(keyCode, event);
    }
}
