package na.brexitsoundboard;

import android.widget.ImageButton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ButtonImageTest {
    private MainActivity mainActivitySpy;

    @Before
    public void before() {
        final MainActivity mainActivity = new MainActivity();

        mainActivitySpy = Mockito.spy(mainActivity);
        // spy invokes all real methods, except for...
        Mockito.doNothing().when(mainActivitySpy).registerClickListenerForButtonId(
                ArgumentMatchers.anyInt(), ArgumentMatchers.isA(Class.class));
        Mockito.doNothing().when(mainActivitySpy).registerButtonSuggestionBox();
        mainActivitySpy.registerButtons();
    }

    @Test
    public void determineButtonTypes() {
        final ImageButton imageButton = Mockito.mock(ImageButton.class);
        // mock stubs out everything except for...
        Mockito.when(imageButton.getId()).thenReturn(R.id.imageButtonBoris00);
        Assert.assertEquals(MainActivity.ButtonType.BORIS, mainActivitySpy.determineButtonType(imageButton));

        Mockito.when(imageButton.getId()).thenReturn(R.id.imageButtonLiam01);
        Assert.assertEquals(MainActivity.ButtonType.LIAM, mainActivitySpy.determineButtonType(imageButton));

        Mockito.when(imageButton.getId()).thenReturn(R.id.imageButtonDavid02);
        Assert.assertEquals(MainActivity.ButtonType.DAVID, mainActivitySpy.determineButtonType(imageButton));

        Mockito.when(imageButton.getId()).thenReturn(R.id.imageButtonTheresa03);
        Assert.assertEquals(MainActivity.ButtonType.THERESA, mainActivitySpy.determineButtonType(imageButton));
    }

    @Test
    public void setButtonImage() {
        final List<Integer> borrisButtonIds = new ArrayList<>();
        borrisButtonIds.add(R.id.imageButtonBoris00);
        borrisButtonIds.add(R.id.imageButtonBoris01);
        borrisButtonIds.add(R.id.imageButtonBoris02);
        borrisButtonIds.add(R.id.imageButtonBoris03);
        borrisButtonIds.add(R.id.imageButtonBoris04);

        final List<Integer> randomButtonIds = mainActivitySpy.getRandomButtonIds(
                R.id.imageButtonBoris00, borrisButtonIds);
        Assert.assertEquals(4, randomButtonIds.size());
        Assert.assertFalse(randomButtonIds.contains(R.id.imageButtonBoris00));
    }
}
