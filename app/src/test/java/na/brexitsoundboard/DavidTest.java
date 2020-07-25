package na.brexitsoundboard;


import org.junit.Test;

public class DavidTest extends AssertMap {
    @Test
    public void ensureButtonsPlayCorrectSounds() {
        keyValueMap.put(R.id.buttonDavidAgreementWillFavourTheEU, R.raw.david_sound_agreement_will_favour_the_eu);
        keyValueMap.put(R.id.buttonDavidConfidentOfAGoodOutcome, R.raw.david_sound_confident_of_a_good_outcome);
        keyValueMap.put(R.id.buttonDavidConstructiveAmbiguity, R.raw.david_sound_constructive_ambiguity);
        keyValueMap.put(R.id.buttonDavidDifficultToReadWhatWeIntend, R.raw.david_sound_difficult_to_read_what_we_intend);
        keyValueMap.put(R.id.buttonDavidFollowUs, R.raw.david_sound_follow_us);
        keyValueMap.put(R.id.buttonDavidIRuleNothingInNothingOut, R.raw.david_sound_i_rule_nothing_in_nothing_out);
        keyValueMap.put(R.id.buttonDavidItsGettingABitTense, R.raw.david_sound_its_getting_a_bit_tense);
        keyValueMap.put(R.id.buttonDavidItsGoingIncrediblyWell, R.raw.david_sound_its_going_incredibly_well);
        keyValueMap.put(R.id.buttonDavidNobodyPretendedThisWillBeSimpleOrEasy, R.raw.david_sound_nobody_pretended_this_will_be_simple_or_easy);
        keyValueMap.put(R.id.buttonDavidTimeAsAPressurePoint, R.raw.david_sound_time_as_a_pressure_point);
        keyValueMap.put(R.id.buttonDavidVeryGoodLawyers, R.raw.david_sound_very_good_lawyers);
        keyValueMap.put(R.id.buttonDavidIAmCalmNotClever, R.raw.david_sound_i_am_calm_not_clever);
        keyValueMap.put(R.id.buttonDavidSectorialAnalysis, R.raw.david_sound_sectorial_analysis);
        keyValueMap.put(R.id.buttonDavidOnlyLastTwoMonthsMatter, R.raw.david_sound_only_last_two_months_matter);
        keyValueMap.put(R.id.buttonDavidTheRiskIsWorthIt, R.raw.david_sound_the_risk_is_worth_it);

        assertKeyValueMatch();
    }
}