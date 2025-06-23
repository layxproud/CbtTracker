package com.example.therapyapp;

import java.io.Serializable;

public class CbtEntry implements Serializable {
    private String title; // User-defined thought name

    // Free-text responses
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
    private String q14_distortion; // Dropdown selection
    private String q15_nextSteps;

    public CbtEntry(String title) {
        this.title = title;
        // initialize fields to empty strings
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
    public void setTitle(String title) { this.title = title; }
}
