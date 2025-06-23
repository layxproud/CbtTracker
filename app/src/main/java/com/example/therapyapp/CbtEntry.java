package com.example.therapyapp;

import java.io.Serializable;

public class CbtEntry implements Serializable {
    private String title;
    private String q1_situation;
    private String q2_thoughtConfidence;
    private String q3_emotions;
    private String q4_supportingEvidence;
    private String q5_contradictingEvidence;
    private String q6_alternativeExplanation;
    private String q7_worstCase;
    private String q8_bestCase;
    private String q9_realisticOutcome;
    private String q10_consequencesBelief;
    private String q11_consequencesChange;
    private String q12_actions;
    private String q13_friendAdvice;
    private String q14_distortion;
    private String q15_nextSteps;

    public CbtEntry(String title) {
        this.title = title;
        q1_situation = "";
        q2_thoughtConfidence = "";
        q3_emotions = "";
        q4_supportingEvidence = "";
        q5_contradictingEvidence = "";
        q6_alternativeExplanation = "";
        q7_worstCase = "";
        q8_bestCase = "";
        q9_realisticOutcome = "";
        q10_consequencesBelief = "";
        q11_consequencesChange = "";
        q12_actions = "";
        q13_friendAdvice = "";
        q14_distortion = "";
        q15_nextSteps = "";
    }

    public String getTitle() { return title; }
    public String getQ1_situation() { return q1_situation; }
    public String getQ2_thoughtConfidence() { return q2_thoughtConfidence; }
    public String getQ3_emotions() { return q3_emotions; }
    public String getQ4_supportingEvidence() { return q4_supportingEvidence; }
    public String getQ5_contradictingEvidence() { return q5_contradictingEvidence; }
    public String getQ6_alternativeExplanation() { return q6_alternativeExplanation; }
    public String getQ7_worstCase() { return q7_worstCase; }
    public String getQ8_bestCase() { return q8_bestCase; }
    public String getQ9_realisticOutcome() { return q9_realisticOutcome; }
    public String getQ10_consequencesBelief() { return q10_consequencesBelief; }
    public String getQ11_consequencesChange() { return q11_consequencesChange; }
    public String getQ12_actions() { return q12_actions; }
    public String getQ13_friendAdvice() { return q13_friendAdvice; }
    public String getQ14_distortion() { return q14_distortion; }
    public String getQ15_nextSteps() { return q15_nextSteps; }
    public void setTitle(String title) { this.title = title; }
    public void setQ1_situation(String q1_situation) { this.q1_situation = q1_situation; }
    public void setQ2_thoughtConfidence(String q2_thoughtConfidence) { this.q2_thoughtConfidence = q2_thoughtConfidence; }
    public void setQ3_emotions(String q3_emotions) { this.q3_emotions = q3_emotions; }
    public void setQ4_supportingEvidence(String q4_supportingEvidence) { this.q4_supportingEvidence = q4_supportingEvidence; }
    public void setQ5_contradictingEvidence(String q5_contradictingEvidence) { this.q5_contradictingEvidence = q5_contradictingEvidence; }
    public void setQ6_alternativeExplanation(String q6_alternativeExplanation) { this.q6_alternativeExplanation = q6_alternativeExplanation; }
    public void setQ7_worstCase(String q7_worstCase) { this.q7_worstCase = q7_worstCase; }
    public void setQ8_bestCase(String q8_bestCase) { this.q8_bestCase = q8_bestCase; }
    public void setQ9_realisticOutcome(String q9_realisticOutcome) { this.q9_realisticOutcome = q9_realisticOutcome; }
    public void setQ10_consequencesBelief(String q10_consequencesBelief) { this.q10_consequencesBelief = q10_consequencesBelief; }
    public void setQ11_consequencesChange(String q11_consequencesChange) { this.q11_consequencesChange = q11_consequencesChange; }
    public void setQ12_actions(String q12_actions) { this.q12_actions = q12_actions; }
    public void setQ13_friendAdvice(String q13_friendAdvice) { this.q13_friendAdvice = q13_friendAdvice; }
    public void setQ14_distortion(String q14_distortion) { this.q14_distortion = q14_distortion; }
    public void setQ15_nextSteps(String q15_nextSteps) { this.q15_nextSteps = q15_nextSteps; }
}
