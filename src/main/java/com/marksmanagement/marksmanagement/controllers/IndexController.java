package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.services.LessonService;
import com.marksmanagement.marksmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private StudentService studentService;

    @GetMapping(value="/")
    public String displayItems(Model model){
        model.addAttribute("lessons", lessonService.getAllLessons());
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
}
