package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Student;
import com.marksmanagement.marksmanagement.models.GetStudentMarkModel;
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
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MarkService markService;

    @GetMapping(value = "/notestudent")
    public String getLessons(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("choseStudent", new GetStudentMarkModel());
        return "NoteStudent";
    }


    @PostMapping(value = "/notestudent")
    public String displayLessonMarks(@ModelAttribute("choseStudent") GetStudentMarkModel getStudentMarkModel,
                                     Errors error, Model model) {
        Student student = studentService.getStudentById(getStudentMarkModel.getStudentID()).orElse(null);
        if (student == null) {
            error.reject("studentID", "Student Inexistent");
        }
        model.addAttribute("students", studentService.getAllStudents());

        if (!error.hasErrors()) {
            model.addAttribute("selectedStudent", student.getNume());
            model.addAttribute("marks", markService.getMarkByStudentID(student.getID()));
        }

        return "NoteStudent";
    }
}
