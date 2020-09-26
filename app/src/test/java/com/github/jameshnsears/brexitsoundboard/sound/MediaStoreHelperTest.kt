package com.github.jameshnsears.brexitsoundboard.sound

import io.mockk.every
import io.mockk.spyk
import org.junit.Test
import java.io.File

class MediaStoreHelperTest {
    @Test
    fun getContentValues() {
        val mediaStoreHelper = spyk(MediaStoreHelper())

        every { mediaStoreHelper.getFileFolderDestination() } returns File("/")
        assert(mediaStoreHelper.getFileDestination("350 Million Pounds A Week") == File("/350 Million Pounds A Week.mp3"))
    }
}
