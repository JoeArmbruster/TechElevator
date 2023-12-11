package org.example10deserializeOpenTDBJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example9deserializeTriviaObject.TriviaQuestion;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final String PATH = "C:\\Users\\Student\\Workspace\\my-projects-for-sharing\\jackson-udemy\\untitled\\src\\main\\java\\org\\example10deserializeOpenTDBJson\\multipleQuestionJson.json";
        ObjectMapper mapper = new ObjectMapper();

        DB_TriviaQuestionSet questions = mapper.readValue(new File(PATH), DB_TriviaQuestionSet.class);

        System.out.println(questions);
    }
}
