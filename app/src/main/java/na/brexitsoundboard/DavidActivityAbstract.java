package na.brexitsoundboard;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class DavidActivityAbstract extends AbstractBrexitSoundboardActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_david);

        firebaseWrapper.setFirebaseAnalytics(FirebaseAnalytics.getInstance(this));

        registerClickListener(R.id.buttonDavidAgreementWillFavourTheEU);
        registerClickListener(R.id.buttonDavidConfidentOfAGoodOutcome);
        registerClickListener(R.id.buttonDavidConstructiveAmbiguity);
        registerClickListener(R.id.buttonDavidDifficultToReadWhatWeIntend);
        registerClickListener(R.id.buttonDavidFollowUs);
        registerClickListener(R.id.buttonDavidIAmCalmNotClever);
        registerClickListener(R.id.buttonDavidIRuleNothingInNothingOut);
        registerClickListener(R.id.buttonDavidItsGettingABitTense);
        registerClickListener(R.id.buttonDavidItsGoingIncrediblyWell);
        registerClickListener(R.id.buttonDavidNobodyPretendedThisWillBeSimpleOrEasy);
        registerClickListener(R.id.buttonDavidSectorialAnalysis);
        registerClickListener(R.id.buttonDavidTimeAsAPressurePoint);
        registerClickListener(R.id.buttonDavidVeryGoodLawyers);
        registerClickListener(R.id.buttonDavidOnlyLastTwoMonthsMatter);
        registerClickListener(R.id.buttonDavidTheRiskIsWorthIt);
    }
}
