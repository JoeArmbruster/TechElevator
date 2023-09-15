package com.techelevator;

public class Elevator {

    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    public Elevator(int numberOfFloors){
        this.numberOfFloors = numberOfFloors;
        this.currentFloor = 1;
    }

    public void openDoor(){
        if(!doorOpen){
            doorOpen = true;
        }
    }

    public void closeDoor(){
        if (doorOpen){
            doorOpen = false;
        }
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen){
            if (desiredFloor > currentFloor && desiredFloor <= numberOfFloors){
                currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiresFloor){
        if (!doorOpen) {
            if (desiresFloor < currentFloor && desiresFloor >= 1){
                currentFloor = desiresFloor;
            }
        }
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public int getNumberOfFloors(){
        return numberOfFloors;
    }

    public boolean isDoorOpen(){
        return doorOpen;
    }

}
