package org.example6jsonIgnoreDuringDeserialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// You can't have a value in the JSON that doesn't get assigned over to the object

public class Main {
    public static void main(String[] args) throws IOException {

        String jsonString = "{\"countryOfOrigin\" : \"Brazil\", \"color\":\"yellow\", \"quantity\": 20}";

        ObjectMapper mapper = new ObjectMapper();
        Banana banana = mapper.readValue(jsonString, Banana.class);

        System.out.println(banana);

    }

}


class Banana {
    public String countryOfOrigin;
    public String color;

//    @JsonIgnore
    public int quantity;
    public boolean inSeason;

    @Override
    public String toString() {
        return "Banana{" +
                "countryOfOrigin='" + countryOfOrigin + '\'' +
                ", color='" + color + '\'' +
               ", quantity=" + quantity +
                ", inSeason=" + inSeason +
                '}';
    }
}



