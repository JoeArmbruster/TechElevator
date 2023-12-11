package org.example10deserializeOpenTDBJson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB_TriviaQuestionSet {

    @JsonProperty ("response_code")
    private int responseCode;

    @JsonProperty("results")
    private TriviaQuestion[] triviaQuestions;


    public DB_TriviaQuestionSet() {
    }

    public int getResponseCode() {
        return responseCode;
    }

    public TriviaQuestion[] getTriviaQuestions(){
            return triviaQuestions;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setTriviaQuestions(TriviaQuestion[] triviaQuestions) {
        this.triviaQuestions = triviaQuestions;
    }

    @Override
    public String toString() {
        String s = "responseCode=" + responseCode;

        for (int i = 0; i < triviaQuestions.length; i++) {
            s += "\nQUESTION # " + (i + 1) + ": ";
            s += "\n" + triviaQuestions[i];
        }
        return s;

    }
}
