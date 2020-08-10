package com.github.jameshnsears.brexitsoundboard

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper.Companion.auditEvent
import com.github.jameshnsears.brexitsoundboard.audit.AuditEventHelper.Companion.createInstance
import com.github.jameshnsears.brexitsoundboard.databinding.ActivityHomeBinding
import com.github.jameshnsears.brexitsoundboard.person.ActivityBoris
import com.github.jameshnsears.brexitsoundboard.person.ActivityDavid
import com.github.jameshnsears.brexitsoundboard.person.ActivityLiam
import com.github.jameshnsears.brexitsoundboard.person.ActivityTheresa
import com.github.jameshnsears.brexitsoundboard.sound.MediaPlayerHelper
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper.getSharedPreferences
import com.github.jameshnsears.brexitsoundboard.utils.SharedPreferencesHelper.removePriorVersionSharedPreferences
import java.util.*

class ActivityBrexitSoundboard : AppCompatActivity() {
    val buttonIdsBoris: MutableList<Int> = ArrayList()
    private val buttonIdsLiam: MutableList<Int> = ArrayList()
    private val buttonIdsDavid: MutableList<Int> = ArrayList()
    private val buttonIdsTheresa: MutableList<Int> = ArrayList()
    private var imageButtonClickedOn: ImageButton? = null
    private var selectedButtonIdBoris = 0
    private var selectedButtonIdLiam = 0
    private var selectedButtonIdDavid = 0
    private var selectedButtonIdTheresa = 0
    private val mediaPlayerHelper = MediaPlayerHelper()

    enum class ButtonType {
        BORIS, LIAM, DAVID, THERESA
    }

    var activityHomeBinding: ActivityHomeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferencesRemovePriorAppVersion()
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        val view: View = activityHomeBinding!!.root
        setContentView(view)
        initAuditing()
        setFooterVersion()
        registerClickListenerForInstallSound()
        registerClickListenersForImageButtons()
        registerClickListenerWikipedia()
        registerClickListenerFooter()
        sharedPreferencesRestore()
    }

    private fun sharedPreferencesRemovePriorAppVersion() {
        removePriorVersionSharedPreferences(this)
    }

    private fun initAuditing() {
        createInstance(application)
    }

    private fun setFooterVersion() {
        activityHomeBinding!!.textViewVersion.text = resources.getString(R.string.footer_version,
                BuildConfig.VERSION_NAME, BuildConfig.GIT_HASH)
    }

    override fun onResume() {
        super.onResume()
        mediaPlayerHelper.reset()
        if (imageButtonClickedOn != null) {
            setButtonImage(imageButtonClickedOn!!)
        }
        sharedPreferencesRestore()
    }

    fun registerClickListenersForImageButtons() {
        registerButtonBoris()
        registerButtonDavid()
        registerButtonLiam()
        registerButtonTheresa()
        registerButtonSuggestionBox()
    }

    private fun registerButtonBoris() {
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris00.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris01.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris02.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris03.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris04.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris05.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris06.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris07.id)
        buttonIdsBoris.add(activityHomeBinding!!.imageButtonBoris08.id)
        registerClickListenersForButtonIds(buttonIdsBoris, ActivityBoris::class.java)
        selectedButtonIdBoris = activityHomeBinding!!.imageButtonBoris00.id
    }

    private fun registerButtonLiam() {
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam00.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam01.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam02.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam03.id)
        buttonIdsLiam.add(activityHomeBinding!!.imageButtonLiam04.id)
        registerClickListenersForButtonIds(buttonIdsLiam, ActivityLiam::class.java)
        selectedButtonIdLiam = activityHomeBinding!!.imageButtonLiam00.id
    }

    private fun registerButtonDavid() {
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid00.id)
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid01.id)
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid02.id)
        buttonIdsDavid.add(activityHomeBinding!!.imageButtonDavid03.id)
        registerClickListenersForButtonIds(buttonIdsDavid, ActivityDavid::class.java)
        selectedButtonIdDavid = activityHomeBinding!!.imageButtonDavid00.id
    }

    private fun registerButtonTheresa() {
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa00.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa01.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa02.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa03.id)
        buttonIdsTheresa.add(activityHomeBinding!!.imageButtonTheresa04.id)
        registerClickListenersForButtonIds(buttonIdsTheresa, ActivityTheresa::class.java)
        selectedButtonIdTheresa = activityHomeBinding!!.imageButtonTheresa00.id
    }

    fun registerClickListenerForInstallSound() {
        activityHomeBinding!!.installSound.setOnCheckedChangeListener { _: CompoundButton?, _: Boolean ->
            if (activityHomeBinding!!.installSound.isChecked) {
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
                            BREXIT_SOUNDBOARD_EXTERNAL_STORAGE)
                }
            }
            sharedPreferencesSave()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == BREXIT_SOUNDBOARD_EXTERNAL_STORAGE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission given
                activityHomeBinding!!.installSound.isChecked = true
            } else {
                // permission not given
                activityHomeBinding!!.installSound.isChecked = false
            }
            sharedPreferencesSave()
        }
    }

    fun registerButtonSuggestionBox() {
        activityHomeBinding!!.imageButtonSuggestionBox.setOnClickListener { _: View? ->
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfHLj5AkDLyb8fFAHtAl5AdJ1FrKE9gK5uxEnTt0J9sIOa2qQ/viewform?c=0&w=1"))
            )
        }
    }

    private fun registerClickListenerWikipedia() {
        activityHomeBinding!!.textViewNameBoris.setOnClickListener { _: View? ->
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Boris_Johnson"))
            )
        }
        activityHomeBinding!!.textViewNameLiam.setOnClickListener { _: View? ->
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Liam_Fox"))
            )
        }
        activityHomeBinding!!.textViewNameDavid.setOnClickListener { _: View? ->
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/David_Davis_(British_politician)"))
            )
        }
        activityHomeBinding!!.textViewNameTheresa.setOnClickListener { _: View? ->
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Theresa_May"))
            )
        }
    }

    private fun registerClickListenerFooter() {
        val githubUrl = "https://github.com/jameshnsears/brexitsoundboard"
        activityHomeBinding!!.textViewVersion.setOnClickListener { _: View? ->
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(githubUrl))
            )
        }
        activityHomeBinding!!.githubLogo.setOnClickListener { _: View? ->
            startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(githubUrl))
            )
        }
    }

    private fun registerClickListenersForButtonIds(buttonIds: List<Int>, activity: Class<*>) {
        for (buttonId in buttonIds) {
            registerClickListenerForButtonId(buttonId, activity)
        }
    }

    fun registerClickListenerForButtonId(imageButtonViewId: Int, activityClass: Class<*>?) {
        findViewById<View>(imageButtonViewId).setOnClickListener { view: View ->
            imageButtonClickedOn = findViewById(imageButtonViewId)
            val imageButton = imageButtonClickedOn
            if (imageButton != null) {
                auditEvent(AuditEventHelper.Event.PERSON, imageButton.getContentDescription().toString())
            }
            view.context.startActivity(Intent(view.context, activityClass))
        }
    }

    private fun setButtonImage(selectedImageButton: ImageButton) {
        when (determineButtonType(selectedImageButton)) {
            ButtonType.BORIS -> selectedButtonIdBoris = setButtonImage(selectedImageButton, buttonIdsBoris)
            ButtonType.LIAM -> selectedButtonIdLiam = setButtonImage(selectedImageButton, buttonIdsLiam)
            ButtonType.DAVID -> selectedButtonIdDavid = setButtonImage(selectedImageButton, buttonIdsDavid)
            ButtonType.THERESA -> selectedButtonIdTheresa = setButtonImage(selectedImageButton, buttonIdsTheresa)
        }
        sharedPreferencesSave()
    }

    fun determineButtonType(imageButton: ImageButton): ButtonType {
        val buttonType: ButtonType
        buttonType = if (buttonIdsBoris.contains(imageButton.id)) {
            ButtonType.BORIS
        } else if (buttonIdsLiam.contains(imageButton.id)) {
            ButtonType.LIAM
        } else if (buttonIdsDavid.contains(imageButton.id)) {
            ButtonType.DAVID
        } else {
            ButtonType.THERESA
        }
        Log.i("determineButtonType", buttonType.toString())
        return buttonType
    }

    fun setButtonImage(selectedImageButton: ImageButton, buttonIds: List<Int>): Int {
        for (buttonId in buttonIds) {
            findViewById<View>(buttonId).visibility = View.GONE
        }
        var nextActiveImageButtonIdIndex = 0
        if (buttonIds.indexOf(selectedImageButton.id) < buttonIds.size - 1) {
            nextActiveImageButtonIdIndex = 1 + buttonIds.indexOf(selectedImageButton.id)
        }
        val view = findViewById<View>(buttonIds[nextActiveImageButtonIdIndex])
        view.visibility = View.VISIBLE
        return view.id
    }

    private fun sharedPreferencesSave() {
        val preferences = getSharedPreferences(this).edit()
        preferences.putBoolean(SharedPreferencesHelper.INSTALL_SOUND, activityHomeBinding!!.installSound.isChecked)
        preferences.putInt(SharedPreferencesHelper.SELECTED_BUTTONID_BORIS, selectedButtonIdBoris)
        preferences.putInt(SharedPreferencesHelper.SELECTED_BUTTONID_LIAM, selectedButtonIdLiam)
        preferences.putInt(SharedPreferencesHelper.SELECTED_BUTTONID_DAVID, selectedButtonIdDavid)
        preferences.putInt(SharedPreferencesHelper.SELECTED_BUTTONID_THERESA, selectedButtonIdTheresa)
        preferences.apply()
    }

    private fun restoreButtonImage(
        sharedPreferences: SharedPreferences,
        buttonList: List<Int>,
        key: String,
        defaultButtonId: Int
    ) {
        for (buttonId in buttonList) {
            if (buttonId == sharedPreferences.getInt(key, defaultButtonId)) {
                Log.i(String.format("restoreButtonImage.%s", key), buttonId.toString())
                findViewById<View>(buttonId).visibility = View.VISIBLE
            } else {
                findViewById<View>(buttonId).visibility = View.GONE
            }
        }
    }

    private fun sharedPreferencesRestore() {
        val sharedPreferences = getSharedPreferences(this)
        activityHomeBinding!!.installSound.isChecked = sharedPreferences.getBoolean(SharedPreferencesHelper.INSTALL_SOUND, activityHomeBinding!!.installSound.isChecked)
        restoreButtonImage(sharedPreferences, buttonIdsBoris, SharedPreferencesHelper.SELECTED_BUTTONID_BORIS, activityHomeBinding!!.imageButtonBoris00.id)
        selectedButtonIdBoris = sharedPreferences.getInt(SharedPreferencesHelper.SELECTED_BUTTONID_BORIS, activityHomeBinding!!.imageButtonBoris00.id)
        restoreButtonImage(sharedPreferences, buttonIdsLiam, SharedPreferencesHelper.SELECTED_BUTTONID_LIAM, activityHomeBinding!!.imageButtonLiam00.id)
        selectedButtonIdLiam = sharedPreferences.getInt(SharedPreferencesHelper.SELECTED_BUTTONID_LIAM, activityHomeBinding!!.imageButtonLiam00.id)
        restoreButtonImage(sharedPreferences, buttonIdsDavid, SharedPreferencesHelper.SELECTED_BUTTONID_DAVID, activityHomeBinding!!.imageButtonDavid00.id)
        selectedButtonIdDavid = sharedPreferences.getInt(SharedPreferencesHelper.SELECTED_BUTTONID_DAVID, activityHomeBinding!!.imageButtonDavid00.id)
        restoreButtonImage(sharedPreferences, buttonIdsTheresa, SharedPreferencesHelper.SELECTED_BUTTONID_THERESA, activityHomeBinding!!.imageButtonTheresa00.id)
        selectedButtonIdTheresa = sharedPreferences.getInt(SharedPreferencesHelper.SELECTED_BUTTONID_THERESA, activityHomeBinding!!.imageButtonTheresa00.id)
    }

    public override fun onDestroy() {
        mediaPlayerHelper.reset()
        super.onDestroy()
    }

    companion object {
        private const val BREXIT_SOUNDBOARD_EXTERNAL_STORAGE = 10101010
    }
}
