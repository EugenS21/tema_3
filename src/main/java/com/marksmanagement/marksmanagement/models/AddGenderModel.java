package com.marksmanagement.marksmanagement.models;

public class AddGenderModel {
    private Long studentId;
    private String gender;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
