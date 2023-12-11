package org.example9deserializeTriviaObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // JSON taken from
        // https://opentdb.com/api.php?amount=3

        final String PATH = "C:\\Users\\Student\\Workspace\\my-projects-for-sharing\\jackson-tutorial-project\\src\\main\\java\\org\\example9deserializeTriviaObject\\singleQuestion.json";

        ObjectMapper mapper = new ObjectMapper();

        TriviaQuestion triviaQuestion = mapper.readValue(new File(PATH), TriviaQuestion.class);

        System.out.println(triviaQuestion);
    }
}
