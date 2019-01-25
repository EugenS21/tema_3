package com.marksmanagement.marksmanagement.models;

import com.marksmanagement.marksmanagement.classes.Lesson;
import com.marksmanagement.marksmanagement.classes.Student;

public class DisplayGradeModel {
    private Long studentID;
    private Long lessonID;
    private int mark;

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getLessonID() {
        return lessonID;
    }

    public void setLessonID(Long lessonID) {
        this.lessonID = lessonID;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
