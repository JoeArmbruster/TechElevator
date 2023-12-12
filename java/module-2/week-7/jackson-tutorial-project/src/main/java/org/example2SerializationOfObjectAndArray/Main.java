package org.example2SerializationOfObjectAndArray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        FootballPlayer footballPlayer = new FootballPlayer("Patrick Mahomes", 15);
        List<String> shoppingList = new ArrayList<>();

        shoppingList.add("milk");
        shoppingList.add("coffee");
        shoppingList.add("bread");

        String objectJsonString = mapper.writeValueAsString(footballPlayer);
        String arrayJsonString = mapper.writeValueAsString(shoppingList);

        System.out.println(objectJsonString);
        System.out.println(arrayJsonString);


    }


}
