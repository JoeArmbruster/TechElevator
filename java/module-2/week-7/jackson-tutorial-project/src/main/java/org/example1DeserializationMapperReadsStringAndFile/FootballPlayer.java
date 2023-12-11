package org.example1DeserializationMapperReadsStringAndFile;

class FootballPlayer {
    private String name;
    private int number;

    public FootballPlayer() {
    }

    public FootballPlayer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;


    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}