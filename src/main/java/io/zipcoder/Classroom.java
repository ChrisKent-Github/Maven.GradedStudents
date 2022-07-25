package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {
    Student[] students;

public Classroom(int maxNumberOfStudents){
    this.students = new Student[maxNumberOfStudents];
}

public Classroom(Student[] student) {
        students = student;
}

public Classroom(){
    this.students = new Student[30];
}

public Student[] getStudents(){
    return students;
}

public double getAverageExamScore(){
    Double averageClassScores = 0.0;
    for (int i = 0; i < students.length; i++) {
        averageClassScores += students[i].getAverageExamScore();
    }
    averageClassScores /= students.length;
    System.out.println(averageClassScores.toString());
    return averageClassScores;
}

    public Student addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null){
             students[i] = student;
             break;
            }
        }
        return student;
    }

    public Integer getStudentIndex(String firstName, String lastName) {
    Integer index = -1;
        for (int i = 0; i < students.length; i++) {
            if(students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)){
                index = i;
                break;
            }
            else {
                index = -1;
            }
        }
    return index;
    }

    public Student[] removeStudent(String firstName, String lastName){
        ArrayList<Student> beforeList = new ArrayList<>(Arrays.asList(students));
        ArrayList<Student> afterList = new ArrayList<>(0);

        Integer index = getStudentIndex(firstName, lastName);
        beforeList.set(index, null);
        for (int i = 0; i < beforeList.size(); i++) {
            if (beforeList.get(i) != null) {
                afterList.add(beforeList.get(i));
            }
        }
        for (int j = afterList.size(); j < students.length - afterList.size() + 1; j++) {
                    afterList.add(null);
        }

        for (int i = 0; i < students.length; i++) {
            students[i] = afterList.get(i);
        }

        return students;
    }

    public Student[] getStudentsByScore(){

        return students;
    }

    public String toString(){
        return String.format("%s", students);
    }

}
