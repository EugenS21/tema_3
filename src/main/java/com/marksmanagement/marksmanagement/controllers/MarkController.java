package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Lesson;
import com.marksmanagement.marksmanagement.classes.Mark;
import com.marksmanagement.marksmanagement.classes.Student;
import com.marksmanagement.marksmanagement.services.LessonService;
import com.marksmanagement.marksmanagement.services.MarkService;
import com.marksmanagement.marksmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarkController {
    @Autowired
    private MarkService markService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LessonService lessonService;
//    @PostMapping(value="/inputMarks")
//    public String addMark(@ModelAttribute("newmark") Mark mark
//            , Errors error, Model model){
//        markService.addMark();
//    }
    @GetMapping(value = "/catalog")
    public String getMarkOfStudentsToLessons(Model model){
        model.addAttribute("marks", markService.getAllMarks());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("lessons", lessonService.getAllLessons());
        return "Catalog";
    }
}
