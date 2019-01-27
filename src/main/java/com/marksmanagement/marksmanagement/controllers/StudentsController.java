package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Student;
import com.marksmanagement.marksmanagement.models.AddGenderModel;
import com.marksmanagement.marksmanagement.models.AddGradeModel;
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
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<String> genders = Arrays.asList("F", "M");

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

    @GetMapping(value = "/addGender")
    public String getStudentsAndGenders(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("genders", genders);
        model.addAttribute("gender", new AddGenderModel());


        return "AdaugareGen";
    }

    @PostMapping(value = "/addGender")
    public String displayGender(@ModelAttribute("gender") AddGenderModel getStudentMarkModel, Errors errors, Model model){
        Student student = studentService.getStudentById(getStudentMarkModel.getStudentId()).orElse(null);
        if (student == null) {
            errors.reject("studentID", "Student Inexistent");
        }
        student.setGen(getStudentMarkModel.getGender());
        studentService.addGender(student);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("genders", genders);

        model.addAttribute("successMessage", String.format("Genul a fost setat cu succes"));

        return "AdaugareGen";
    }
}
