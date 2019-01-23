package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Lesson;
import com.marksmanagement.marksmanagement.classes.Mark;
import com.marksmanagement.marksmanagement.classes.Student;
import com.marksmanagement.marksmanagement.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping(value="/inputMarks")
    public String addMark(@ModelAttribute("newmark") Mark mark
            , Errors error, Model model){
        markService.addMark();
    }
}
