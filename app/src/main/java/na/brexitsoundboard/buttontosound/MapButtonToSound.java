package na.brexitsoundboard.buttontosound;

import android.annotation.SuppressLint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import na.brexitsoundboard.R;

public class MapButtonToSound {
    @SuppressLint("UseSparseArrays")
    public final Map<Integer, Integer> buttonIdToSoundIdMap = new ConcurrentHashMap<>();

    public MapButtonToSound() {
        mapBorisButtonsToSounds();
        mapDavidButtonsToSounds();
        mapLiamButtonsToSounds();
        mapTheresaButtonsToSounds();
    }

    private void mapBorisButtonsToSounds() {
        buttonIdToSoundIdMap.put(R.id.buttonBoris350MillionPoundsAWeek, R.raw.boris_sound_350_million_pounds_a_week);
        buttonIdToSoundIdMap.put(R.id.buttonBorisAllYourOptionsAreGood, R.raw.boris_sound_all_your_options_are_good);
        buttonIdToSoundIdMap.put(R.id.buttonBorisCostOfGettingOutVirtuallyNil, R.raw.boris_sound_cost_of_getting_out_virtually_nil);
        buttonIdToSoundIdMap.put(R.id.buttonBorisGoWhistle, R.raw.boris_sound_go_whistle);
        buttonIdToSoundIdMap.put(R.id.buttonBorisHiggeldyPiggeldyNations, R.raw.boris_sound_higgeldy_piggeldy_nations);
        buttonIdToSoundIdMap.put(R.id.buttonBorisMeetOurObligations, R.raw.boris_sound_meet_our_obligations);
        buttonIdToSoundIdMap.put(R.id.buttonBorisPoundIsStable, R.raw.boris_sound_pound_is_stable);
        buttonIdToSoundIdMap.put(R.id.buttonBorisRightsCompletelyProtected, R.raw.boris_sound_rights_completely_protected);
        buttonIdToSoundIdMap.put(R.id.buttonBorisTalkingWithoutDetail, R.raw.boris_sound_talking_without_detail);
        buttonIdToSoundIdMap.put(R.id.buttonBorisTigerIntheTank, R.raw.boris_sound_tiger_in_the_tank);
        buttonIdToSoundIdMap.put(R.id.buttonBorisVindicatedByHistory, R.raw.boris_sound_vindicated_by_history);
        buttonIdToSoundIdMap.put(R.id.buttonBorisWeExportTvAerials, R.raw.boris_sound_we_export_tv_aerials);
        buttonIdToSoundIdMap.put(R.id.buttonBorisWeightLiftedFromBritishBusiness, R.raw.boris_sound_weight_lifted_from_british_business);
        buttonIdToSoundIdMap.put(R.id.buttonBorisWinWinForAllOfUs, R.raw.boris_sound_win_win_for_all_off_us);
        buttonIdToSoundIdMap.put(R.id.buttonBorisUsaVeryEnthusiasticAboutFreeTradeDeal, R.raw.boris_sound_usa_very_enthusiastic_about_free_trade_deal);
        buttonIdToSoundIdMap.put(R.id.buttonBorisAbsurdToObey, R.raw.boris_sound_absurd_to_obey);
        buttonIdToSoundIdMap.put(R.id.buttonBorisDoggerLand, R.raw.boris_sound_doggerland);
        buttonIdToSoundIdMap.put(R.id.buttonBorisLittleBenefitFromEU, R.raw.boris_sound_little_benefit_from_single_market_and_customs_union);
        buttonIdToSoundIdMap.put(R.id.buttonBorisNotAPlagueOfBoils, R.raw.boris_sound_not_a_plague_of_boils);
        buttonIdToSoundIdMap.put(R.id.buttonBorisNotSpam, R.raw.boris_sound_not_about_spam_and_cabbage);
        buttonIdToSoundIdMap.put(R.id.buttonBorisUkShapingTheModernWorld, R.raw.boris_sound_uk_shaping_the_modern_world);
        buttonIdToSoundIdMap.put(R.id.buttonBorisNotPayingIn, R.raw.boris_sound_were_not_going_to_be_paying_in);
        buttonIdToSoundIdMap.put(R.id.buttonBorisWeWantToBeLessInsular, R.raw.boris_sound_we_want_to_be_less_insular);
        buttonIdToSoundIdMap.put(R.id.buttonBorisWeWillContinueToBeEuropeans, R.raw.boris_sound_we_will_continue_to_be_europeans);
        buttonIdToSoundIdMap.put(R.id.buttonBorisAHistoricMistake, R.raw.boris_sound_a_historic_mistake);
        buttonIdToSoundIdMap.put(R.id.buttonBorisBrexitHasNotDamagedCountry, R.raw.boris_sound_brexit_has_not_damaged_our_country);
        buttonIdToSoundIdMap.put(R.id.buttonBorisDoNotUnderestimate, R.raw.boris_sound_do_not_underestimate);
        buttonIdToSoundIdMap.put(R.id.buttonBorisAsLongAsItTakes, R.raw.boris_sound_keep_going_for_as_long_as_it_takes);
        buttonIdToSoundIdMap.put(R.id.buttonBorisConfidenceAndZap, R.raw.boris_sound_confidence_and_zap);
    }

    private void mapDavidButtonsToSounds() {
        buttonIdToSoundIdMap.put(R.id.buttonDavidAgreementWillFavourTheEU, R.raw.david_sound_agreement_will_favour_the_eu);
        buttonIdToSoundIdMap.put(R.id.buttonDavidConfidentOfAGoodOutcome, R.raw.david_sound_confident_of_a_good_outcome);
        buttonIdToSoundIdMap.put(R.id.buttonDavidConstructiveAmbiguity, R.raw.david_sound_constructive_ambiguity);
        buttonIdToSoundIdMap.put(R.id.buttonDavidDifficultToReadWhatWeIntend, R.raw.david_sound_difficult_to_read_what_we_intend);
        buttonIdToSoundIdMap.put(R.id.buttonDavidFollowUs, R.raw.david_sound_follow_us);
        buttonIdToSoundIdMap.put(R.id.buttonDavidIRuleNothingInNothingOut, R.raw.david_sound_i_rule_nothing_in_nothing_out);
        buttonIdToSoundIdMap.put(R.id.buttonDavidItsGettingABitTense, R.raw.david_sound_its_getting_a_bit_tense);
        buttonIdToSoundIdMap.put(R.id.buttonDavidItsGoingIncrediblyWell, R.raw.david_sound_its_going_incredibly_well);
        buttonIdToSoundIdMap.put(R.id.buttonDavidNobodyPretendedThisWillBeSimpleOrEasy, R.raw.david_sound_nobody_pretended_this_will_be_simple_or_easy);
        buttonIdToSoundIdMap.put(R.id.buttonDavidTimeAsAPressurePoint, R.raw.david_sound_time_as_a_pressure_point);
        buttonIdToSoundIdMap.put(R.id.buttonDavidVeryGoodLawyers, R.raw.david_sound_very_good_lawyers);
        buttonIdToSoundIdMap.put(R.id.buttonDavidIAmCalmNotClever, R.raw.david_sound_i_am_calm_not_clever);
        buttonIdToSoundIdMap.put(R.id.buttonDavidSectorialAnalysis, R.raw.david_sound_sectorial_analysis);
        buttonIdToSoundIdMap.put(R.id.buttonDavidOnlyLastTwoMonthsMatter, R.raw.david_sound_only_last_two_months_matter);
        buttonIdToSoundIdMap.put(R.id.buttonDavidTheRiskIsWorthIt, R.raw.david_sound_the_risk_is_worth_it);
    }

    private void mapLiamButtonsToSounds() {
        buttonIdToSoundIdMap.put(R.id.buttonLiamBlamingTheMedia, R.raw.liam_sound_blaming_the_media);
        buttonIdToSoundIdMap.put(R.id.buttonLiamChickenObsessedMedia, R.raw.liam_sound_chicken_obsessed_media);
        buttonIdToSoundIdMap.put(R.id.buttonLiamCitizensFirstNotPolitics, R.raw.liam_sound_citizens_first_not_politics);
        buttonIdToSoundIdMap.put(R.id.buttonLiamEasiestInHumanHistory, R.raw.liam_sound_easiest_in_human_history);
        buttonIdToSoundIdMap.put(R.id.buttonLiamHowWeConductOurselves, R.raw.liam_sound_how_we_conduct_ourselves);
        buttonIdToSoundIdMap.put(R.id.buttonLiamIntemperateLanguage, R.raw.liam_sound_intemperate_language);
        buttonIdToSoundIdMap.put(R.id.buttonLiamNotHavingADealWouldBeBad, R.raw.liam_sound_not_having_a_deal_would_be_bad);
        buttonIdToSoundIdMap.put(R.id.buttonLiamThisIsNotJustAboutEurope, R.raw.liam_sound_this_is_not_just_about_europe);
        buttonIdToSoundIdMap.put(R.id.buttonLiamTooLazyAndTooFat, R.raw.liam_sound_too_lazy_and_too_fat);
        buttonIdToSoundIdMap.put(R.id.buttonLiamTremendousOpportunitiesOutThere, R.raw.liam_sound_tremendous_opportunities_out_there);
        buttonIdToSoundIdMap.put(R.id.buttonLiamWeCantBeBlackmailed, R.raw.liam_sound_we_cant_be_blackmailed);
        buttonIdToSoundIdMap.put(R.id.buttonBoris350MillionPoundsAWeek, R.raw.boris_sound_350_million_pounds_a_week);
        buttonIdToSoundIdMap.put(R.id.buttonLiamSelfDefeating, R.raw.liam_sound_self_defeating_pessimist);

        buttonIdToSoundIdMap.put(R.id.buttonLiamIwantGovernmentsDeal, R.raw.laim_sound_i_want_governments_deal);
        buttonIdToSoundIdMap.put(R.id.buttonLiamFullConfidenceInPM, R.raw.liam_sound_full_confidence_in_pm);
        buttonIdToSoundIdMap.put(R.id.buttonLiamOldMenOfBrussels, R.raw.liam_sound_old_men_of_brussels);
        buttonIdToSoundIdMap.put(R.id.buttonLiamReachAgreementCivilly, R.raw.liam_sound_reach_agreement_civilly);
        buttonIdToSoundIdMap.put(R.id.buttonLiamRuleTakersSellout, R.raw.liam_sound_rule_takers_sellout);
        buttonIdToSoundIdMap.put(R.id.buttonLiamScleroticInwardLookingEurope, R.raw.liam_sound_sclerotic_inward_looking_europe);
        buttonIdToSoundIdMap.put(R.id.buttonLiamShockTherapyRequiredForEu, R.raw.liam_sound_shock_therapy_required_for_eu);
        buttonIdToSoundIdMap.put(R.id.buttonLiamStealingBrexit, R.raw.liam_sound_stealing_brexit);
        buttonIdToSoundIdMap.put(R.id.buttonLiamAccessToEu, R.raw.liam_sound_we_have_to_maintain_access_to_eu);
    }

    private void mapTheresaButtonsToSounds() {
        buttonIdToSoundIdMap.put(R.id.buttonTheresaBrexitMeansBrexit, R.raw.theresa_sound_brexit_means_brexit);
        buttonIdToSoundIdMap.put(R.id.buttonTheresaEveryVoteForMe, R.raw.theresa_sound_every_vote_for_me);
        buttonIdToSoundIdMap.put(R.id.buttonTheresaNoDealBetterThanABadDeal, R.raw.theresa_sound_no_deal_better_than_a_bad_deal);
        buttonIdToSoundIdMap.put(R.id.buttonTheresaNoNeedForAnElection, R.raw.theresa_sound_no_need_for_an_election);
        buttonIdToSoundIdMap.put(R.id.buttonTheresaRedWhiteAndBlueBrexit, R.raw.theresa_sound_red_white_and_blue_brexit);
        buttonIdToSoundIdMap.put(R.id.buttonTheresaStrongAndStableLeadership, R.raw.theresa_sound_strong_and_stable_leadership);
        buttonIdToSoundIdMap.put(R.id.buttonTheresAPlan, R.raw.theresa_sound_a_plan_for_britain);
        buttonIdToSoundIdMap.put(R.id.buttonTheresaCertainityAndClarity, R.raw.theresa_sound_certainty_and_clarity);
        buttonIdToSoundIdMap.put(R.id.buttonTheresaWeShouldStayInTheEu, R.raw.theresa_sound_we_should_stay_inside_eu);
    }
}
