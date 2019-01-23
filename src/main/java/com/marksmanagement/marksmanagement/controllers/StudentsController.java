package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentsController {
    @Autowired
    private StudentService studentService;


}
