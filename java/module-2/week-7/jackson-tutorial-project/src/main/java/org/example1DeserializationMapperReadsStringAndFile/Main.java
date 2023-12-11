package org.example1DeserializationMapperReadsStringAndFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        List<FootballPlayer> players = new ArrayList<>();

        final String jsonString = "{ \"name\" : \"Jared\" , \"number\" : 20}";
        final String PATH = "C:\\Users\\Student\\Workspace\\my-projects-for-sharing\\jackson-tutorial-project\\src\\main\\java\\org\\example1DeserializationMapperReadsStringAndFile\\infile.json";

        ObjectMapper mapper = new ObjectMapper();

        FootballPlayer player1 = new FootballPlayer ("Joe", 10);
        FootballPlayer player2 = mapper.readValue(jsonString, FootballPlayer.class);
        FootballPlayer player3 = mapper.readValue(new File(PATH), FootballPlayer.class);

        players.add(player1);
        players.add(player2);
        players.add(player3);

        for (FootballPlayer player : players){
            System.out.println(player);
        }

        /*
            // Get JSON String from existing object
            String createdJsonString = mapper.writeValueAsString(player1);
            System.out.println(createdJsonString);
         */


    }


}
