package org.example7serializationOfJavaObjectsinObjects;



public class Engine {
    private int cylinders;
    private int horsepower;

    public Engine(int cylinders, int horsepower) {
        this.cylinders = cylinders;
        this.horsepower = horsepower;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getHorsepower() {
        return horsepower;
    }
}