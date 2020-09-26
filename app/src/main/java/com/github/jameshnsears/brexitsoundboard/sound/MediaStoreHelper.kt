package com.github.jameshnsears.brexitsoundboard.sound

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.content.res.Resources
import android.os.Environment
import android.provider.MediaStore
import android.util.TypedValue
import com.github.jameshnsears.brexitsoundboard.R
import com.github.jameshnsears.brexitsoundboard.utils.ToastHelper.makeToast
import org.apache.commons.io.IOUtils
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream

class MediaStoreHelper {
    fun installSound(
        resources: Resources,
        context: Context,
        contentResolver: ContentResolver,
        resourceId: Int,
        soundName: String,
        mediaType: String
    ) {
        try {
            val resPathToFilename = TypedValue()
            resources.getValue(resourceId, resPathToFilename, true)

            val inputStream = context.resources.openRawResource(resourceId)
            val fileDestination = getFileDestination(soundName)
            val fileOutputStream = FileOutputStream(fileDestination)

            IOUtils.copy(inputStream, fileOutputStream)
            fileOutputStream.close()
            inputStream.close()

            contentResolver.insert(
                MediaStore.Audio.Media.getContentUriForPath(fileDestination.absolutePath)!!,
                getContentValues(soundName, mediaType, fileDestination)
            )

            makeToast(context, context.getString(R.string.install_menu_confirmation, soundName))
        } catch (e: Exception) {
            Timber.e(String.format("", e.message))
        }
    }

    fun getFileDestination(soundName: String): File {
        val fileFolderDestination = getFileFolderDestination()
        if (!fileFolderDestination.exists()) {
            fileFolderDestination.mkdirs()
        }
        val fileDestination = File(fileFolderDestination.absolutePath + "/" + soundName + ".mp3")
        Timber.d(fileFolderDestination.absolutePath)
        return fileDestination
    }

    fun getFileFolderDestination(): File {
        return File(Environment.getExternalStorageDirectory().absolutePath + "/Music")
    }

    private fun getContentValues(soundName: String, mediaType: String, fileDestination: File): ContentValues {
        val contentValues = ContentValues()

        contentValues.put(MediaStore.MediaColumns.TITLE, soundName)
        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3")

        contentValues.put(MediaStore.Audio.Media.IS_RINGTONE, false)
        contentValues.put(MediaStore.Audio.Media.IS_NOTIFICATION, false)
        contentValues.put(MediaStore.Audio.Media.IS_ALARM, false)
        contentValues.put(mediaType, true)

        contentValues.put(MediaStore.MediaColumns.DATA, fileDestination.absolutePath)
        return contentValues
    }
}
