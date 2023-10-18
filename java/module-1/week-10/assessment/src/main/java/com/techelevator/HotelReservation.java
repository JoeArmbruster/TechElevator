package com.techelevator;

public class HotelReservation {

    private String name;
    private int numberOfNights;
    private int nightlyRate;
    private int estimatedTotal;

    private static final int CLEANING_FEE = 25;
    private static final int MINIBAR_FEE = 15;

    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
        this.estimatedTotal = numberOfNights * nightlyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
        this.estimatedTotal = numberOfNights * nightlyRate;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
        this.estimatedTotal = numberOfNights * nightlyRate;
    }

    public int getEstimatedTotal() {
        return estimatedTotal;
    }

    public int getActualTotal (boolean requiresCleaning, boolean usedMinibar){
        int actualTotal = estimatedTotal;

        if (requiresCleaning && usedMinibar){
            actualTotal += MINIBAR_FEE;
            actualTotal += 2 * CLEANING_FEE;
        } else if (requiresCleaning) {
            actualTotal += CLEANING_FEE;
        } else if (usedMinibar) {
            actualTotal += MINIBAR_FEE;
        }
        return actualTotal;
    }

    @Override
    public String toString() {
        return name + ":" + estimatedTotal;
    }
}
