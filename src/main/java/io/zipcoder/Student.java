package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {


    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public Double getNumberOfExamsTaken(){
        return Double.valueOf(examScores.size());
    }

    public String getExamScores(){
        String result = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
            result += "Exam " + (i + 1) + " -> " + (examScores.get(i) / 1) + "\n";
        }
        System.out.println(result);
        return result;
    }

    public String addExamScore(double examScore){
        this.examScores.add(examScore);
        return getExamScores();
    }

    public String setExamScore(int examNumber, double newScore){
        examScores.set(examNumber - 1, newScore);
        System.out.println(examScores);
        return getExamScores();
    }

    public Double getAverageExamScore(){
        Double average = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            average += examScores.get(i);
        }
        average /= examScores.size();
        System.out.println(average);
        return average;
    }


    public String toString(){
//        System.out.println(Student.toString);
        return String.format("%s %s Exam Scores: %s", firstName, lastName, examScores);
    }



    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }


}
