package org.example8deserializationOfJSONObjectsInObjects;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Runner {
    private int bib;

    @JsonAlias("first-name")
    String firstName;
    @JsonAlias("last-name")
    private String lastName;
    private Location location = new Location();

    public int getBib() {
        return bib;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public Location getLocation() {
        return location;
    }

    public void setBib(int bib) {
        this.bib = bib;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "bib=" + bib +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location=" + location.toString() +
                '}';
    }
}
