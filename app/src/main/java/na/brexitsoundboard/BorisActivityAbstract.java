package na.brexitsoundboard;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class BorisActivityAbstract extends AbstractBrexitSoundboardActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boris);

        firebaseWrapper.setFirebaseAnalytics(FirebaseAnalytics.getInstance(this));

        registerClickListener(R.id.buttonBoris350MillionPoundsAWeek);
        registerClickListener(R.id.buttonBorisAbsurdToObey);
        registerClickListener(R.id.buttonBorisAllYourOptionsAreGood);
        registerClickListener(R.id.buttonBorisCostOfGettingOutVirtuallyNil);
        registerClickListener(R.id.buttonBorisDoggerLand);
        registerClickListener(R.id.buttonBorisGoWhistle);
        registerClickListener(R.id.buttonBorisHiggeldyPiggeldyNations);
        registerClickListener(R.id.buttonBorisLittleBenefitFromEU);
        registerClickListener(R.id.buttonBorisMeetOurObligations);
        registerClickListener(R.id.buttonBorisNotAPlagueOfBoils);
        registerClickListener(R.id.buttonBorisNotSpam);
        registerClickListener(R.id.buttonBorisNotPayingIn);
        registerClickListener(R.id.buttonBorisPoundIsStable);
        registerClickListener(R.id.buttonBorisTalkingWithoutDetail);
        registerClickListener(R.id.buttonBorisRightsCompletelyProtected);
        registerClickListener(R.id.buttonBorisTalkingWithoutDetail);
        registerClickListener(R.id.buttonBorisTigerIntheTank);
        registerClickListener(R.id.buttonBorisUkShapingTheModernWorld);
        registerClickListener(R.id.buttonBorisVindicatedByHistory);
        registerClickListener(R.id.buttonBorisWeExportTvAerials);
        registerClickListener(R.id.buttonBorisWeWantToBeLessInsular);
        registerClickListener(R.id.buttonBorisWeWillContinueToBeEuropeans);
        registerClickListener(R.id.buttonBorisWeightLiftedFromBritishBusiness);
        registerClickListener(R.id.buttonBorisWinWinForAllOfUs);
        registerClickListener(R.id.buttonBorisUsaVeryEnthusiasticAboutFreeTradeDeal);
        registerClickListener(R.id.buttonBorisAHistoricMistake);
        registerClickListener(R.id.buttonBorisBrexitHasNotDamagedCountry);
        registerClickListener(R.id.buttonBorisDoNotUnderestimate);
        registerClickListener(R.id.buttonBorisAsLongAsItTakes);
        registerClickListener(R.id.buttonBorisConfidenceAndZap);
    }
}