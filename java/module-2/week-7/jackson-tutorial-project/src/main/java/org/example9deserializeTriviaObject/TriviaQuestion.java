package org.example9deserializeTriviaObject;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class TriviaQuestion {



    @JsonAlias("type")
    String type;
    String difficulty;

    String category;

    String question;
    @JsonProperty("correct_answer")
    String correctAnswer;

    @JsonProperty("incorrect_answers")
    String[] incorrectAnswers;

    public TriviaQuestion() {
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setIncorrectAnswers(String[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    @Override
    public String toString() {
        String s =  "TriviaQuestion{" +
                "type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", category='" + category + '\'' + "}" +
                "\nQ: " + question +
                "\n* " + correctAnswer;

        for (String incorrectAnswer : incorrectAnswers) {
            s += "\nx " + incorrectAnswer;
        }

        return s;
    }
}
