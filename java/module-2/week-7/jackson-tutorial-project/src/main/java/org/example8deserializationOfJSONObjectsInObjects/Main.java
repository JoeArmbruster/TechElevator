package org.example8deserializationOfJSONObjectsInObjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

       ObjectMapper mapper = new ObjectMapper();

       String jsonString = "{\"bib\":1002,\"first-name\":\"Enrique\",\"last-name\":\"Jimenez\"," +
               " \"location\" : { \"city\": \"Boulder\", \"state\": \"CO\" }" +
               "}" ;

        String jsonArrayString = "[" +
                "{\"bib\":1002,\"firstName\":\"Enrique\",\"lastName\":\"Jimenez\"," +
                " \"location\" : { \"city\": \"Phoenix\", \"state\": \"AZ\" }" +
                "}," + // end of first Runner object
                "{\"bib\":2002,\"firstName\":\"Casey\",\"lastName\":\"McCullough\"," +
                " \"location\" : { \"city\": \"Boulder\", \"state\": \"CO\" }" +
                "}" + // end of second Runner object
                "]" ;


        Runner runner1 = mapper.readValue(jsonString, Runner.class);
        Runner[] runners = mapper.readValue (jsonArrayString, Runner[].class);

        System.out.println(runner1.toString());

        for (Runner runner : runners){
            System.out.println(runner);

        }


    }

}





