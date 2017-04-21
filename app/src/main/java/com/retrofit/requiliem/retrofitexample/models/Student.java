package com.retrofit.requiliem.retrofitexample.models;

/**
 * Created by OmarV on 21/04/2017.
 */

public class Student {

    private int StudentId;
    private String StudentName;
    private String StudentMarks;

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentMarks() {
        return StudentMarks;
    }

    public void setStudentMarks(String studentMarks) {
        StudentMarks = studentMarks;
    }
}