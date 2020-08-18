package com.github.jameshnsears.brexitsoundboard.sound

import android.annotation.SuppressLint
import com.github.jameshnsears.brexitsoundboard.R
import java.util.concurrent.ConcurrentHashMap

class MapButtonToSound {
    @JvmField
    @SuppressLint("UseSparseArrays")
    val buttonIdToSoundIdMap: MutableMap<Int, Int> = ConcurrentHashMap()

    private fun mapBorisButtonsToSounds() {
        buttonIdToSoundIdMap[R.id.buttonBoris350MillionPoundsAWeek] = R.raw.boris_sound_350_million_pounds_a_week
        buttonIdToSoundIdMap[R.id.buttonBorisAllYourOptionsAreGood] = R.raw.boris_sound_all_your_options_are_good
        buttonIdToSoundIdMap[R.id.buttonBorisCostOfGettingOutVirtuallyNil] = R.raw.boris_sound_cost_of_getting_out_virtually_nil
        buttonIdToSoundIdMap[R.id.buttonBorisGoWhistle] = R.raw.boris_sound_go_whistle
        buttonIdToSoundIdMap[R.id.buttonBorisHiggeldyPiggeldyNations] = R.raw.boris_sound_higgeldy_piggeldy_nations
        buttonIdToSoundIdMap[R.id.buttonBorisPoundIsStable] = R.raw.boris_sound_pound_is_stable
        buttonIdToSoundIdMap[R.id.buttonBorisTalkingWithoutDetail] = R.raw.boris_sound_talking_without_detail
        buttonIdToSoundIdMap[R.id.buttonBorisTigerIntheTank] = R.raw.boris_sound_tiger_in_the_tank
        buttonIdToSoundIdMap[R.id.buttonBorisVindicatedByHistory] = R.raw.boris_sound_vindicated_by_history
        buttonIdToSoundIdMap[R.id.buttonBorisWeExportTvAerials] = R.raw.boris_sound_we_export_tv_aerials
        buttonIdToSoundIdMap[R.id.buttonBorisWeightLiftedFromBritishBusiness] = R.raw.boris_sound_weight_lifted_from_british_business
        buttonIdToSoundIdMap[R.id.buttonBorisWinWinForAllOfUs] = R.raw.boris_sound_win_win_for_all_off_us
        buttonIdToSoundIdMap[R.id.buttonBorisUsaVeryEnthusiasticAboutFreeTradeDeal] = R.raw.boris_sound_usa_very_enthusiastic_about_free_trade_deal
        buttonIdToSoundIdMap[R.id.buttonBorisLittleBenefitFromEU] = R.raw.boris_sound_little_benefit_from_single_market_and_customs_union
        buttonIdToSoundIdMap[R.id.buttonBorisNotAPlagueOfBoils] = R.raw.boris_sound_not_a_plague_of_boils
        buttonIdToSoundIdMap[R.id.buttonBorisUkShapingTheModernWorld] = R.raw.boris_sound_uk_shaping_the_modern_world
        buttonIdToSoundIdMap[R.id.buttonBorisWeWantToBeLessInsular] = R.raw.boris_sound_we_want_to_be_less_insular
        buttonIdToSoundIdMap[R.id.buttonBorisBrexitHasNotDamagedCountry] = R.raw.boris_sound_brexit_has_not_damaged_our_country
        buttonIdToSoundIdMap[R.id.buttonBorisDoNotUnderestimate] = R.raw.boris_sound_do_not_underestimate
        buttonIdToSoundIdMap[R.id.buttonBorisAsLongAsItTakes] = R.raw.boris_sound_keep_going_for_as_long_as_it_takes
        buttonIdToSoundIdMap[R.id.buttonBorisStunningSuccess] = R.raw.boris_sound_a_stunning_success
        buttonIdToSoundIdMap[R.id.buttonBorisDeadInADitch] = R.raw.boris_sound_dead_in_a_ditch
        buttonIdToSoundIdMap[R.id.buttonBorisDealIsTouchAndGo] = R.raw.boris_sound_deal_is_touch_and_go
        buttonIdToSoundIdMap[R.id.buttonBorisDoNotWorryAboutNoDeal] = R.raw.boris_sound_do_not_worry_about_no_deal
        buttonIdToSoundIdMap[R.id.buttonBorisFriendsAreABitNegative] = R.raw.boris_sound_friends_are_a_bit_negative
        buttonIdToSoundIdMap[R.id.buttonBorisGangbustersInSoManyWays] = R.raw.boris_sound_gangbusters_in_so_many_ways
        buttonIdToSoundIdMap[R.id.buttonBorisIWantAWorld] = R.raw.boris_sound_i_want_a_world
        buttonIdToSoundIdMap[R.id.buttonBorisLetsGetBrexitDone] = R.raw.boris_sound_lets_get_brexit_done
        buttonIdToSoundIdMap[R.id.buttonBorisNoNIChecks] = R.raw.boris_sound_no_ni_checks
        buttonIdToSoundIdMap[R.id.buttonBorisPutItInTheMicrowave] = R.raw.boris_sound_put_it_in_the_microwave
        buttonIdToSoundIdMap[R.id.buttonBorisResponsibleHumanBeings] = R.raw.boris_sound_responsible_human_beings
        buttonIdToSoundIdMap[R.id.buttonBorisTheFlagIsGoingUp] = R.raw.boris_sound_the_flag_is_going_up
        buttonIdToSoundIdMap[R.id.buttonBorisPeopleAreLookingAtUs] = R.raw.boris_sound_people_are_looking_at_us
        buttonIdToSoundIdMap[R.id.buttonBorisWTOisNoProblem] = R.raw.boris_sound_wto_is_no_problem
        buttonIdToSoundIdMap[R.id.buttonBorisWeHaveADeal] = R.raw.boris_sound_we_have_a_deal
    }

    private fun mapDavidButtonsToSounds() {
        buttonIdToSoundIdMap[R.id.buttonDavidAgreementWillFavourTheEU] = R.raw.david_sound_agreement_will_favour_the_eu
        buttonIdToSoundIdMap[R.id.buttonDavidConfidentOfAGoodOutcome] = R.raw.david_sound_confident_of_a_good_outcome
        buttonIdToSoundIdMap[R.id.buttonDavidConstructiveAmbiguity] = R.raw.david_sound_constructive_ambiguity
        buttonIdToSoundIdMap[R.id.buttonDavidDifficultToReadWhatWeIntend] = R.raw.david_sound_difficult_to_read_what_we_intend
        buttonIdToSoundIdMap[R.id.buttonDavidFollowUs] = R.raw.david_sound_follow_us
        buttonIdToSoundIdMap[R.id.buttonDavidIRuleNothingInNothingOut] = R.raw.david_sound_i_rule_nothing_in_nothing_out
        buttonIdToSoundIdMap[R.id.buttonDavidItsGettingABitTense] = R.raw.david_sound_its_getting_a_bit_tense
        buttonIdToSoundIdMap[R.id.buttonDavidItsGoingIncrediblyWell] = R.raw.david_sound_its_going_incredibly_well
        buttonIdToSoundIdMap[R.id.buttonDavidNobodyPretendedThisWillBeSimpleOrEasy] = R.raw.david_sound_nobody_pretended_this_will_be_simple_or_easy
        buttonIdToSoundIdMap[R.id.buttonDavidVeryGoodLawyers] = R.raw.david_sound_very_good_lawyers
        buttonIdToSoundIdMap[R.id.buttonDavidIAmCalmNotClever] = R.raw.david_sound_i_am_calm_not_clever
        buttonIdToSoundIdMap[R.id.buttonDavidSectorialAnalysis] = R.raw.david_sound_sectorial_analysis
        buttonIdToSoundIdMap[R.id.buttonDavidOnlyLastTwoMonthsMatter] = R.raw.david_sound_only_last_two_months_matter
        buttonIdToSoundIdMap[R.id.buttonDavidTheRiskIsWorthIt] = R.raw.david_sound_the_risk_is_worth_it
        buttonIdToSoundIdMap[R.id.buttonDavidDamageWorseForEurope] = R.raw.david_sound_damage_worse_for_europe
        buttonIdToSoundIdMap[R.id.buttonDavidTrumpMoment] = R.raw.david_sound_trump_moment
        buttonIdToSoundIdMap[R.id.buttonDavidDoNotBlameMe] = R.raw.david_sound_not_about_blame
        buttonIdToSoundIdMap[R.id.buttonDavidWeCanLookAfterOurselves] = R.raw.david_sound_we_can_look_after_ourselves
    }

    private fun mapLiamButtonsToSounds() {
        buttonIdToSoundIdMap[R.id.buttonLiamChickenObsessedMedia] = R.raw.liam_sound_chicken_obsessed_media
        buttonIdToSoundIdMap[R.id.buttonLiamCitizensFirstNotPolitics] = R.raw.liam_sound_citizens_first_not_politics
        buttonIdToSoundIdMap[R.id.buttonLiamEasiestInHumanHistory] = R.raw.liam_sound_easiest_in_human_history
        buttonIdToSoundIdMap[R.id.buttonLiamNotHavingADealWouldBeBad] = R.raw.liam_sound_not_having_a_deal_would_be_bad
        buttonIdToSoundIdMap[R.id.buttonLiamThisIsNotJustAboutEurope] = R.raw.liam_sound_this_is_not_just_about_europe
        buttonIdToSoundIdMap[R.id.buttonLiamTooLazyAndTooFat] = R.raw.liam_sound_too_lazy_and_too_fat
        buttonIdToSoundIdMap[R.id.buttonLiamWeCantBeBlackmailed] = R.raw.liam_sound_we_cant_be_blackmailed
        buttonIdToSoundIdMap[R.id.buttonLiamSelfDefeating] = R.raw.liam_sound_self_defeating_pessimist
        buttonIdToSoundIdMap[R.id.buttonLiamIwantGovernmentsDeal] = R.raw.laim_sound_i_want_governments_deal
        buttonIdToSoundIdMap[R.id.buttonLiamFullConfidenceInPM] = R.raw.liam_sound_full_confidence_in_pm
        buttonIdToSoundIdMap[R.id.buttonLiamOldMenOfBrussels] = R.raw.liam_sound_old_men_of_brussels
        buttonIdToSoundIdMap[R.id.buttonLiamRuleTakersSellout] = R.raw.liam_sound_rule_takers_sellout
        buttonIdToSoundIdMap[R.id.buttonLiamShockTherapyRequiredForEu] = R.raw.liam_sound_shock_therapy_required_for_eu
        buttonIdToSoundIdMap[R.id.buttonLiamStealingBrexit] = R.raw.liam_sound_stealing_brexit
        buttonIdToSoundIdMap[R.id.buttonLiamAccessToEu] = R.raw.liam_sound_we_have_to_maintain_access_to_eu
        buttonIdToSoundIdMap[R.id.buttonLiamQuiteIrresponsible] = R.raw.liam_sound_quite_irresponsible
        buttonIdToSoundIdMap[R.id.buttonLiamThinkOfTheConsequences] = R.raw.liam_sound_think_of_the_political_consequences
        buttonIdToSoundIdMap[R.id.buttonLiamPotentially] = R.raw.liam_sound_potentially_all_things_are_possible
    }

    private fun mapTheresaButtonsToSounds() {
        buttonIdToSoundIdMap[R.id.buttonTheresaBrexitMeansBrexit] = R.raw.theresa_sound_brexit_means_brexit
        buttonIdToSoundIdMap[R.id.buttonTheresaNoDealBetterThanABadDeal] = R.raw.theresa_sound_no_deal_better_than_a_bad_deal
        buttonIdToSoundIdMap[R.id.buttonTheresaNoNeedForAnElection] = R.raw.theresa_sound_no_need_for_an_election
        buttonIdToSoundIdMap[R.id.buttonTheresaRedWhiteAndBlueBrexit] = R.raw.theresa_sound_red_white_and_blue_brexit
        buttonIdToSoundIdMap[R.id.buttonTheresaStrongAndStableLeadership] = R.raw.theresa_sound_strong_and_stable_leadership
        buttonIdToSoundIdMap[R.id.buttonTheresAPlan] = R.raw.theresa_sound_a_plan_for_britain
        buttonIdToSoundIdMap[R.id.buttonTheresaCertaintyAndClarity] = R.raw.theresa_sound_certainty_and_clarity
        buttonIdToSoundIdMap[R.id.buttonTheresaWeShouldStayInTheEu] = R.raw.theresa_sound_we_should_stay_inside_eu
        buttonIdToSoundIdMap[R.id.buttonTheresaNIisPartOfTheUK] = R.raw.theresa_sound_ni_is_part_of_the_uk
        buttonIdToSoundIdMap[R.id.buttonTheresaIWillNeverAgreeTo] = R.raw.theresa_sound_something_i_will_never_agree_to
        buttonIdToSoundIdMap[R.id.buttonTheresaCitizenOfNowhere] = R.raw.theresa_sound_citizen_of_nowhere
    }

    init {
        mapBorisButtonsToSounds()
        mapDavidButtonsToSounds()
        mapLiamButtonsToSounds()
        mapTheresaButtonsToSounds()
    }
}
