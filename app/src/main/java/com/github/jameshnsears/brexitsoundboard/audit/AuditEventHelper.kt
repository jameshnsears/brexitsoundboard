package com.github.jameshnsears.brexitsoundboard.audit

import android.app.Application
import com.github.jameshnsears.brexitsoundboard.BuildConfig
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import java.util.concurrent.ConcurrentHashMap

class AuditEventHelper private constructor(application: Application) {
    enum class Event {
        PERSON, SOUND, MEDIA_LIBRARY
    }

    companion object {
        private var auditEventHelperSingleton: AuditEventHelper? = null

        @Synchronized
        fun createInstance(application: Application) {
            if (auditEventHelperSingleton == null) {
                auditEventHelperSingleton = AuditEventHelper(application)
            }
        }

        fun auditEvent(event: Event?, value: String) {
            val auditProperties = ConcurrentHashMap<String, String>()
            var keyName = ""
            when (event) {
                Event.PERSON -> keyName = "PERSON"
                Event.SOUND -> keyName = "SOUND"
                Event.MEDIA_LIBRARY -> keyName = "MEDIA_LIBRARY"
            }
            auditProperties[keyName] = value
            trackEvent(keyName, auditProperties)
        }

        fun trackEvent(keyName: String, auditProperties: ConcurrentHashMap<String, String>) {
            Analytics.trackEvent(keyName, auditProperties)
        }
    }

    init {
        AppCenter.start(
            application,
            BuildConfig.APPCENTER_KEY,
            Analytics::class.java,
            Crashes::class.java
        )
    }
}
