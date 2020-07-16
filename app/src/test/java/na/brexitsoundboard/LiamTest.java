package na.brexitsoundboard;


import org.junit.Test;

public class LiamTest extends AssertMap {
    @Test
    public void ensureButtonsPlayCorrectSounds() {
        keyValueMap.put(R.id.buttonLiamBlamingTheMedia, R.raw.liam_sound_blaming_the_media);
        keyValueMap.put(R.id.buttonLiamChickenObsessedMedia, R.raw.liam_sound_chicken_obsessed_media);
        keyValueMap.put(R.id.buttonLiamCitizensFirstNotPolitics, R.raw.liam_sound_citizens_first_not_politics);
        keyValueMap.put(R.id.buttonLiamEasiestInHumanHistory, R.raw.liam_sound_easiest_in_human_history);
        keyValueMap.put(R.id.buttonLiamHowWeConductOurselves, R.raw.liam_sound_how_we_conduct_ourselves);
        keyValueMap.put(R.id.buttonLiamIntemperateLanguage, R.raw.liam_sound_intemperate_language);
        keyValueMap.put(R.id.buttonLiamNotHavingADealWouldBeBad, R.raw.liam_sound_not_having_a_deal_would_be_bad);
        keyValueMap.put(R.id.buttonLiamThisIsNotJustAboutEurope, R.raw.liam_sound_this_is_not_just_about_europe);
        keyValueMap.put(R.id.buttonLiamTooLazyAndTooFat, R.raw.liam_sound_too_lazy_and_too_fat);
        keyValueMap.put(R.id.buttonLiamTremendousOpportunitiesOutThere, R.raw.liam_sound_tremendous_opportunities_out_there);
        keyValueMap.put(R.id.buttonLiamWeCantBeBlackmailed, R.raw.liam_sound_we_cant_be_blackmailed);
        keyValueMap.put(R.id.buttonLiamSelfDefeating, R.raw.liam_sound_self_defeating_pessimist);
        keyValueMap.put(R.id.buttonLiamIwantGovernmentsDeal, R.raw.laim_sound_i_want_governments_deal);
        keyValueMap.put(R.id.buttonLiamFullConfidenceInPM, R.raw.liam_sound_full_confidence_in_pm);
        keyValueMap.put(R.id.buttonLiamOldMenOfBrussels, R.raw.liam_sound_old_men_of_brussels);
        keyValueMap.put(R.id.buttonLiamReachAgreementCivilly, R.raw.liam_sound_reach_agreement_civilly);
        keyValueMap.put(R.id.buttonLiamRuleTakersSellout, R.raw.liam_sound_rule_takers_sellout);
        keyValueMap.put(R.id.buttonLiamScleroticInwardLookingEurope, R.raw.liam_sound_sclerotic_inward_looking_europe);
        keyValueMap.put(R.id.buttonLiamShockTherapyRequiredForEu, R.raw.liam_sound_shock_therapy_required_for_eu);
        keyValueMap.put(R.id.buttonLiamStealingBrexit, R.raw.liam_sound_stealing_brexit);
        keyValueMap.put(R.id.buttonLiamAccessToEu, R.raw.liam_sound_we_have_to_maintain_access_to_eu);

        assertKeyValueMatch();
    }
}