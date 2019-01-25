package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Mark;
import com.marksmanagement.marksmanagement.models.AddGradeModel;
import com.marksmanagement.marksmanagement.services.LessonService;
import com.marksmanagement.marksmanagement.services.MarkService;
import com.marksmanagement.marksmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MarkController {
    @Autowired
    MarkService markService;
    @Autowired
    LessonService lessonService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/addMark", method = RequestMethod.POST)
    public String addMark(@ModelAttribute("newMark") AddGradeModel newMark, Errors errors, Model model) {
        Mark mark = new Mark();
        mark.setLesson(lessonService.getLessonById(newMark.getLessonId()).get());
        mark.setStudent(studentService.getStudentById(newMark.getStudentId()).get());
        mark.setNota(newMark.getMark());
        if (markService.getMarksLessonsForAndStudents(newMark.getLessonId(), newMark.getStudentId()).isEmpty()) {
            markService.addMark(mark);
            model.addAttribute("lessons", lessonService.getAllLessons());
            model.addAttribute("students", studentService.getAllStudents());
            model.addAttribute("successMessage", String.format("Studentul %s %s are nota %d la disciplina %s",
                    mark.getStudent().getNume(), mark.getStudent().getPrenume(), mark.getNota(), mark.getLesson().getNume()));
        } else
            model.addAttribute("successMessage", String.format("Studentul %s %s are deja nota o nota la disciplina %s",
                    mark.getStudent().getNume(), mark.getStudent().getPrenume(), mark.getNota(), mark.getLesson().getNume()));
        return "index";
    }
}
