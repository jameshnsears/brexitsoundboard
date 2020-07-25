package na.brexitsoundboard;

import android.annotation.SuppressLint;
import android.view.View;

import org.junit.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import na.brexitsoundboard.buttontosound.MapButtonToSound;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AssertMap {
    @SuppressLint("UseSparseArrays")
    final Map<Integer, Integer> keyValueMap = new ConcurrentHashMap<>();

    void assertKeyValueMatch() {
        final MapButtonToSound mapButtonToSound = new MapButtonToSound();

        final View view = mock(View.class);
        for (final Map.Entry<Integer, Integer> entry : keyValueMap.entrySet()) {
            when(view.getId()).thenReturn(entry.getKey());
            Assert.assertEquals(entry.getValue(), mapButtonToSound.buttonIdToSoundIdMap.get(view.getId()));
        }
    }
}
