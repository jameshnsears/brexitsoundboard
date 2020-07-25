package na.brexitsoundboard;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BorisExpressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void goThroughEachImageButton00() {
        onView(withId(R.id.imageButtonBoris00)).perform(click());
        onView(withId(R.id.buttonBoris350MillionPoundsAWeek)).check(matches(withText(R.string.button_boris_350MillionPoundsAWeek)));
        pressBack();

        // make sure 90% of view visible...
        onView(withId(R.id.imageButtonLiam00)).perform(scrollTo(), click());
        onView(withId(R.id.buttonLiamBlamingTheMedia)).check(matches(withText(R.string.button_liam_BlamingTheMedia)));
        pressBack();

        onView(withId(R.id.imageButtonDavid00)).perform(scrollTo(), click());
        onView(withId(R.id.buttonDavidAgreementWillFavourTheEU)).check(matches(withText(R.string.button_david_AgreementWillFavourTheEU)));
        pressBack();

        onView(withId(R.id.imageButtonTheresa00)).perform(scrollTo(), click());
        onView(withId(R.id.buttonTheresAPlan)).check(matches(withText(R.string.button_theresa_APlanForBritain)));
        pressBack();
    }
}
