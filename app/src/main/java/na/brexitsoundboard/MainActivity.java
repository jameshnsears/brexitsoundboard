package na.brexitsoundboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import na.brexitsoundboard.analytics.FirebaseWrapper;
import na.brexitsoundboard.buttontosound.MediaPlayerWrapper;

public class MainActivity extends AppCompatActivity {
    private final FirebaseWrapper firebaseWrapper = new FirebaseWrapper();
    private final List<Integer> borrisButtonIds = new ArrayList<>();
    private final List<Integer> liamButtonIds = new ArrayList<>();
    private final List<Integer> davidButtonIds = new ArrayList<>();
    private final List<Integer> theresaButtonIds = new ArrayList<>();
    private ImageButton imageButtonClickedOn;

    private int selectedBorrisButtonId;
    private int selectedLiamButtonId;
    private int selectedDavidButtonId;
    private int selectedTheresaButtonId;

    private final MediaPlayerWrapper mediaPlayerWrapper = new MediaPlayerWrapper();

    public enum ButtonType {
        BORIS,
        LIAM,
        DAVID,
        THERESA
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseWrapper.setFirebaseAnalytics(FirebaseAnalytics.getInstance(this));
        registerButtons();

        restoreButtonIds();
    }

    @Override
    protected void onResume() {
        mediaPlayerWrapper.resetMediaPlayer();

        if (imageButtonClickedOn != null) {
            setRandomButtonImage(imageButtonClickedOn);
        }

        restoreButtonIds();

        super.onResume();
    }

    public void registerButtons() {
        registerButtonsBoris();
        registerButtonsDavid();
        registerButtonsLiam();
        registerButtonsTheresa();
        registerButtonSuggestionBox();
    }

    private void registerButtonsBoris() {
        borrisButtonIds.add(R.id.imageButtonBoris00);
        borrisButtonIds.add(R.id.imageButtonBoris01);
        borrisButtonIds.add(R.id.imageButtonBoris02);
        borrisButtonIds.add(R.id.imageButtonBoris03);
        borrisButtonIds.add(R.id.imageButtonBoris04);
        registerClickListenersForButtonIds(borrisButtonIds, BorisActivityAbstract.class);
        selectedBorrisButtonId = R.id.imageButtonBoris00;
    }

    private void registerButtonsLiam() {
        liamButtonIds.add(R.id.imageButtonLiam00);
        liamButtonIds.add(R.id.imageButtonLiam01);
        liamButtonIds.add(R.id.imageButtonLiam02);
        liamButtonIds.add(R.id.imageButtonLiam03);
        registerClickListenersForButtonIds(liamButtonIds, LiamActivityAbstract.class);
        selectedLiamButtonId = R.id.imageButtonLiam00;
    }

    private void registerButtonsDavid() {
        davidButtonIds.add(R.id.imageButtonDavid00);
        davidButtonIds.add(R.id.imageButtonDavid01);
        davidButtonIds.add(R.id.imageButtonDavid02);
        davidButtonIds.add(R.id.imageButtonDavid03);
        registerClickListenersForButtonIds(davidButtonIds, DavidActivityAbstract.class);
        selectedDavidButtonId = R.id.imageButtonDavid00;
    }

    private void registerButtonsTheresa() {
        theresaButtonIds.add(R.id.imageButtonTheresa00);
        theresaButtonIds.add(R.id.imageButtonTheresa01);
        theresaButtonIds.add(R.id.imageButtonTheresa02);
        theresaButtonIds.add(R.id.imageButtonTheresa03);
        theresaButtonIds.add(R.id.imageButtonTheresa04);
        registerClickListenersForButtonIds(theresaButtonIds, TheresaActivityAbstract.class);
        selectedTheresaButtonId = R.id.imageButtonTheresa00;
    }

    public void registerButtonSuggestionBox() {
        final ImageButton buttonSuggestionBox = findViewById(R.id.imageButtonSuggestionBox);
        buttonSuggestionBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                startActivity(new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfHLj5AkDLyb8fFAHtAl5AdJ1FrKE9gK5uxEnTt0J9sIOa2qQ/viewform?c=0&w=1"))
                );
            }
        });
    }

    private void registerClickListenersForButtonIds(final List<Integer> buttonIds, final Class activity) {
        for (final Integer buttonId : buttonIds) {
            registerClickListenerForButtonId(buttonId, activity);
        }
    }

    public void registerClickListenerForButtonId(final int imageButtonViewId, final Class<?> activityClass) {
        findViewById(imageButtonViewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                firebaseWrapper.logAnalyticsEvent(
                        this.getClass().getName(),
                        getResources().getResourceName(view.getId()), "onClick");

                imageButtonClickedOn = findViewById(imageButtonViewId);
                final Intent intent = new Intent(view.getContext(), activityClass);
                view.getContext().startActivity(intent);
            }
        });
    }

    private void setRandomButtonImage(final ImageButton selectedImageButton) {
        switch (determineButtonType(selectedImageButton)) {
            case BORIS:
                selectedBorrisButtonId = setImageOnButton(selectedImageButton, borrisButtonIds);
                break;
            case LIAM:
                selectedLiamButtonId = setImageOnButton(selectedImageButton, liamButtonIds);
                break;
            case DAVID:
                selectedDavidButtonId = setImageOnButton(selectedImageButton, davidButtonIds);
                break;
            case THERESA:
                selectedTheresaButtonId = setImageOnButton(selectedImageButton, theresaButtonIds);
                break;
            default:
                Log.e("setRandomButtonImage", "unable to determine");
                break;
        }

        saveButtonIds();
    }

    public ButtonType determineButtonType(final ImageButton imageButton) {
        ButtonType buttonType;

        if (borrisButtonIds.contains(imageButton.getId())) {
            buttonType = ButtonType.BORIS;
        } else if (liamButtonIds.contains(imageButton.getId())) {
            buttonType = ButtonType.LIAM;
        } else if (davidButtonIds.contains(imageButton.getId())) {
            buttonType = ButtonType.DAVID;
        } else {
            buttonType = ButtonType.THERESA;
        }

        Log.i("buttonType", buttonType.toString());

        return buttonType;
    }

    private int setImageOnButton(final ImageButton selectedImageButton, final List<Integer> buttonIds) {
        List<Integer> randomButtonIds = getRandomButtonIds( selectedImageButton.getId(), buttonIds);

        for (int buttonId : buttonIds) {
            findViewById(buttonId).setVisibility(View.GONE);
        }

        View view = findViewById(buttonIds.get(randomButtonIds.get(0)));
        view.setVisibility(View.VISIBLE);
        return view.getId();
    }

    public List<Integer> getRandomButtonIds(final int selectedButtonId, final List<Integer> buttonIds) {
        final List<Integer> availableButtomImageIds = new ArrayList<>();
        for (int buttonId = 0; buttonId < buttonIds.size(); buttonId++) {
            if (buttonIds.get(buttonId) != selectedButtonId) {
                availableButtomImageIds.add(buttonId);
            }
        }

        Collections.shuffle(availableButtomImageIds);
        return availableButtomImageIds;
    }

    private void saveButtonIds() {
        // /data/user/0/na.brexitsoundboard/shared_prefs/brexitsoundboard.xml
        SharedPreferences.Editor preferences = getSharedPreferences(
                "brexitsoundboard", MODE_PRIVATE).edit();

        preferences.putInt("selectedBorrisButtonId", selectedBorrisButtonId);
        Log.i("save.borrisButtonId", Integer.toString(selectedBorrisButtonId));

        preferences.putInt("selectedLiamButtonId", selectedLiamButtonId);
        Log.i("save.liamButtonId", Integer.toString(selectedLiamButtonId));

        preferences.putInt("selectedDavidButtonId", selectedDavidButtonId);
        Log.i("save.davidButtonId", Integer.toString(selectedDavidButtonId));

        preferences.putInt("selectedTheresaButtonId", selectedTheresaButtonId);
        Log.i("save.theresaButtonId", Integer.toString(selectedTheresaButtonId));
        preferences.apply();
    }

    private void restoreButtonImage(
            final SharedPreferences sharedPreferences,
            final List<Integer> buttonList,
            final String key,
            final int defaultButtonId) {

        for (Integer buttonId : buttonList) {
            if (buttonId == sharedPreferences.getInt(key, defaultButtonId)) {
                Log.i(String.format("restore.%s", key), buttonId.toString());
                findViewById(buttonId).setVisibility(View.VISIBLE);
            } else {
                findViewById(buttonId).setVisibility(View.GONE);
            }
        }
    }

    private void restoreButtonIds() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                "brexitsoundboard", MODE_PRIVATE);

        restoreButtonImage(sharedPreferences, borrisButtonIds, "selectedBorrisButtonId", R.id.imageButtonBoris00);
        selectedBorrisButtonId = sharedPreferences.getInt("selectedBorrisButtonId", R.id.imageButtonBoris00);

        restoreButtonImage(sharedPreferences, liamButtonIds, "selectedLiamButtonId", R.id.imageButtonLiam00);
        selectedLiamButtonId = sharedPreferences.getInt("selectedLiamButtonId", R.id.imageButtonLiam00);

        restoreButtonImage(sharedPreferences, davidButtonIds, "selectedDavidButtonId", R.id.imageButtonDavid00);
        selectedDavidButtonId = sharedPreferences.getInt("selectedDavidButtonId", R.id.imageButtonDavid00);

        restoreButtonImage(sharedPreferences, theresaButtonIds, "selectedTheresaButtonId", R.id.imageButtonTheresa00);
        selectedTheresaButtonId = sharedPreferences.getInt("selectedTheresaButtonId", R.id.imageButtonTheresa00);
    }
}
