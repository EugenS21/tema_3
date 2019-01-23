package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping(value="/inputMarks")
    public String addMark(@ModelAttribute("newmark"))
}
