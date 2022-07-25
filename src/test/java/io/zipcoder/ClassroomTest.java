package io.zipcoder;


import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {


    @Test
    public void getAverageExamScore() {
        // : Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudent() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void getStudentIndex() {
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores2 = { 0.0, 110.0, 20.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student2 = new Student("Twon", "Hunter", examScores2);
        String firstName = "Twon";
        String lastName = "Hunter";

        classroom.addStudent(student);
        classroom.addStudent(student2);

        int index = classroom.getStudentIndex(firstName, lastName);
        Assert.assertEquals(1, index);
    }

    @Test
    public void removeStudent() {
        // : Given
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores2 = { 0.0, 110.0, 20.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student2 = new Student("Twon", "Hunter", examScores2);

        // When
        classroom.addStudent(student);
        classroom.addStudent(student2);

        // Then
        classroom.removeStudent("Leon", "Hunter");

        System.out.println(Arrays.toString(classroom.getStudents()));
    }
}
