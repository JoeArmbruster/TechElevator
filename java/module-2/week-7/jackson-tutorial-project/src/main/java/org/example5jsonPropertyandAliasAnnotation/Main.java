package org.example5jsonPropertyandAliasAnnotation;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        String jsonCarString = "{\"brand_name\" : \"Toyota\", \"model\":\"Prius\", \"color\": \"silver\"}";

        ObjectMapper mapper = new ObjectMapper();

        Car car = mapper.readValue (jsonCarString, Car.class);

        System.out.println(car);

    }

}


class Car {
    // map this field to the json key-value pair that has
    // "brand", "brandName", "brand_name", or "myBrandName"

    @JsonAlias({"brandName", "brand_name", "myBrandName"})
    public String brand;

    // map this field to the json key-value pair that has
    // "type" or "model"

    @JsonProperty("type") // this annotation makes 'type' the only valid name
    public String model;
    public String color;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}


