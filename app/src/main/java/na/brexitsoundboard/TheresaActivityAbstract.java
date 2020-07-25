package na.brexitsoundboard;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class TheresaActivityAbstract extends AbstractBrexitSoundboardActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theresa);

        firebaseWrapper.setFirebaseAnalytics(FirebaseAnalytics.getInstance(this));

        registerClickListener(R.id.buttonTheresAPlan);
        registerClickListener(R.id.buttonTheresaBrexitMeansBrexit);
        registerClickListener(R.id.buttonTheresaCertainityAndClarity);
        registerClickListener(R.id.buttonTheresaEveryVoteForMe);
        registerClickListener(R.id.buttonTheresaNoDealBetterThanABadDeal);
        registerClickListener(R.id.buttonTheresaNoNeedForAnElection);
        registerClickListener(R.id.buttonTheresaRedWhiteAndBlueBrexit);
        registerClickListener(R.id.buttonTheresaStrongAndStableLeadership);
        registerClickListener(R.id.buttonTheresaWeShouldStayInTheEu);
    }
}
