package com.marksmanagement.marksmanagement.controllers;
import com.marksmanagement.marksmanagement.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LessonsController {
    @Autowired
    private LessonService lessonService;


}
