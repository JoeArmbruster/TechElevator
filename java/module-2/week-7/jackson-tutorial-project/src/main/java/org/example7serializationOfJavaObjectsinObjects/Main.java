package org.example7serializationOfJavaObjectsinObjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

       ObjectMapper mapper = new ObjectMapper();

//       String jsonString = "{\"bib\":1002,\"firstName\":\"Enrique\",\"lastName\":\"Jimenez\"" +
//               " \"location\" : { \"city\": \"Boulder\", \"state\": \"CO\" }" +
//               "}" ;

       Engine engine = new Engine(6, 200);
       Car car = new Car ("Prius", engine);

       String jsonString = mapper.writeValueAsString(car);
       System.out.println(jsonString);


    }

}





