package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LessonsController {
    @Autowired
    private LessonService lessonService;
    @GetMapping(value="/lessons")
    public String displayLessons(Model model){
        model.addAttribute("lessons", lessonService.getAllLessons());
        return "index";
    }
}
