package com.github.jameshnsears.brexitsoundboard.sound

import com.github.jameshnsears.brexitsoundboard.R
import org.junit.Test

class MapButtonToSoundBorisTest : AbstractMapButtonToSound() {
    @Test
    fun ensureButtonsPlayCorrectSounds() {
        keyValueMap[R.id.buttonBoris350MillionPoundsAWeek] = R.raw.boris_sound_350_million_pounds_a_week
        keyValueMap[R.id.buttonBorisAllYourOptionsAreGood] = R.raw.boris_sound_all_your_options_are_good
        keyValueMap[R.id.buttonBorisCostOfGettingOutVirtuallyNil] = R.raw.boris_sound_cost_of_getting_out_virtually_nil
        keyValueMap[R.id.buttonBorisGoWhistle] = R.raw.boris_sound_go_whistle
        keyValueMap[R.id.buttonBorisHiggeldyPiggeldyNations] = R.raw.boris_sound_higgeldy_piggeldy_nations
        keyValueMap[R.id.buttonBorisPoundIsStable] = R.raw.boris_sound_pound_is_stable
        keyValueMap[R.id.buttonBorisTalkingWithoutDetail] = R.raw.boris_sound_talking_without_detail
        keyValueMap[R.id.buttonBorisTigerIntheTank] = R.raw.boris_sound_tiger_in_the_tank
        keyValueMap[R.id.buttonBorisVindicatedByHistory] = R.raw.boris_sound_vindicated_by_history
        keyValueMap[R.id.buttonBorisWeExportTvAerials] = R.raw.boris_sound_we_export_tv_aerials
        keyValueMap[R.id.buttonBorisWeightLiftedFromBritishBusiness] = R.raw.boris_sound_weight_lifted_from_british_business
        keyValueMap[R.id.buttonBorisWinWinForAllOfUs] = R.raw.boris_sound_win_win_for_all_off_us
        keyValueMap[R.id.buttonBorisUsaVeryEnthusiasticAboutFreeTradeDeal] = R.raw.boris_sound_usa_very_enthusiastic_about_free_trade_deal
        keyValueMap[R.id.buttonBorisLittleBenefitFromEU] = R.raw.boris_sound_little_benefit_from_single_market_and_customs_union
        keyValueMap[R.id.buttonBorisNotAPlagueOfBoils] = R.raw.boris_sound_not_a_plague_of_boils
        keyValueMap[R.id.buttonBorisUkShapingTheModernWorld] = R.raw.boris_sound_uk_shaping_the_modern_world
        keyValueMap[R.id.buttonBorisWeWantToBeLessInsular] = R.raw.boris_sound_we_want_to_be_less_insular
        keyValueMap[R.id.buttonBorisBrexitHasNotDamagedCountry] = R.raw.boris_sound_brexit_has_not_damaged_our_country
        keyValueMap[R.id.buttonBorisDoNotUnderestimate] = R.raw.boris_sound_do_not_underestimate
        keyValueMap[R.id.buttonBorisAsLongAsItTakes] = R.raw.boris_sound_keep_going_for_as_long_as_it_takes
        keyValueMap[R.id.buttonBorisStunningSuccess] = R.raw.boris_sound_a_stunning_success
        keyValueMap[R.id.buttonBorisDeadInADitch] = R.raw.boris_sound_dead_in_a_ditch
        keyValueMap[R.id.buttonBorisDealIsTouchAndGo] = R.raw.boris_sound_deal_is_touch_and_go
        keyValueMap[R.id.buttonBorisDoNotWorryAboutNoDeal] = R.raw.boris_sound_do_not_worry_about_no_deal
        keyValueMap[R.id.buttonBorisFriendsAreABitNegative] = R.raw.boris_sound_friends_are_a_bit_negative
        keyValueMap[R.id.buttonBorisGangbustersInSoManyWays] = R.raw.boris_sound_gangbusters_in_so_many_ways
        keyValueMap[R.id.buttonBorisIWantAWorld] = R.raw.boris_sound_i_want_a_world
        keyValueMap[R.id.buttonBorisLetsGetBrexitDone] = R.raw.boris_sound_lets_get_brexit_done
        keyValueMap[R.id.buttonBorisNoNIChecks] = R.raw.boris_sound_no_ni_checks
        keyValueMap[R.id.buttonBorisPutItInTheMicrowave] = R.raw.boris_sound_put_it_in_the_microwave
        keyValueMap[R.id.buttonBorisResponsibleHumanBeings] = R.raw.boris_sound_responsible_human_beings
        keyValueMap[R.id.buttonBorisTheFlagIsGoingUp] = R.raw.boris_sound_the_flag_is_going_up
        keyValueMap[R.id.buttonBorisPeopleAreLookingAtUs] = R.raw.boris_sound_people_are_looking_at_us
        keyValueMap[R.id.buttonBorisWTOisNoProblem] = R.raw.boris_sound_wto_is_no_problem
        keyValueMap[R.id.buttonBorisWeHaveADeal] = R.raw.boris_sound_we_have_a_deal

        assertKeyValueMatch()
    }
}
