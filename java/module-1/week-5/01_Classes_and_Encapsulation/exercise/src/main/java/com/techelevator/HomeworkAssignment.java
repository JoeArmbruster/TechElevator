package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
        this.earnedMarks = 0;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        double percentage = (earnedMarks * 100.0) / possibleMarks;
        if(percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
