package org.example7serializationOfJavaObjectsinObjects;

public class Car {
        private String model;
        private Engine engine;

    public Car() {
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }
}
