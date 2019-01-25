package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.models.DisplayGradeModel;
import com.marksmanagement.marksmanagement.services.LessonService;
import com.marksmanagement.marksmanagement.services.MarkService;
import com.marksmanagement.marksmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CatalogController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private MarkService markService;

    @GetMapping(value = "/catalog")
    public String displayMarksOfStudentToLesson(DisplayGradeModel gradeModel, Model model) {


        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("lessons", lessonService.getAllLessons());
        model.addAttribute("marks", markService.getAllMarks());

        return "catalog";
    }
}
