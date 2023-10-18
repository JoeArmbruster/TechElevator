package org.example;

import java.text.NumberFormat;

public class Teacher extends Person{

    private final static NumberFormat FORMATTER = NumberFormat.getCurrencyInstance();

    private double salary;
    public Teacher(String firstName, String lastName, double salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalary: " + FORMATTER.format(salary);
    }
}
