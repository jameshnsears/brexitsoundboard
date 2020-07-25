package na.brexitsoundboard;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class LiamActivityAbstract extends AbstractBrexitSoundboardActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liam);

        firebaseWrapper.setFirebaseAnalytics(FirebaseAnalytics.getInstance(this));

        registerClickListener(R.id.buttonLiamBlamingTheMedia);
        registerClickListener(R.id.buttonLiamChickenObsessedMedia);
        registerClickListener(R.id.buttonLiamCitizensFirstNotPolitics);
        registerClickListener(R.id.buttonLiamEasiestInHumanHistory);
        registerClickListener(R.id.buttonLiamHowWeConductOurselves);
        registerClickListener(R.id.buttonLiamIntemperateLanguage);
        registerClickListener(R.id.buttonLiamNotHavingADealWouldBeBad);
        registerClickListener(R.id.buttonLiamSelfDefeating);
        registerClickListener(R.id.buttonLiamThisIsNotJustAboutEurope);
        registerClickListener(R.id.buttonLiamTooLazyAndTooFat);
        registerClickListener(R.id.buttonLiamTremendousOpportunitiesOutThere);
        registerClickListener(R.id.buttonLiamWeCantBeBlackmailed);
        registerClickListener(R.id.buttonLiamIwantGovernmentsDeal);
        registerClickListener(R.id.buttonLiamFullConfidenceInPM);
        registerClickListener(R.id.buttonLiamOldMenOfBrussels);
        registerClickListener(R.id.buttonLiamReachAgreementCivilly);
        registerClickListener(R.id.buttonLiamRuleTakersSellout);
        registerClickListener(R.id.buttonLiamScleroticInwardLookingEurope);
        registerClickListener(R.id.buttonLiamShockTherapyRequiredForEu);
        registerClickListener(R.id.buttonLiamStealingBrexit);
        registerClickListener(R.id.buttonLiamAccessToEu);
    }
}
