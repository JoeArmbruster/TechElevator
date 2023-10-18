package org.example;

public class Student extends Person{

    private int [] grades;
    public Student(String firstName, String lastName, int[] grades) {
        super(firstName, lastName);
        this.grades = grades;
    }

    public double getAverage (){
        int sum = 0;
        for (int grade: grades){
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public String toString() {
        String s =  super.toString() +
                "\nAverage: " + getAverage() +
                "\nGrades: ";
        for (int grade : grades) {
            s += "\t" + grade;
        }
        return s;
    }
}
