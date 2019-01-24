package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Lesson;
import com.marksmanagement.marksmanagement.models.GetLessonMarkModel;
import com.marksmanagement.marksmanagement.services.LessonService;
import com.marksmanagement.marksmanagement.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class LessonsController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private MarkService markService;

    @GetMapping(value="/notedisciplina")
    public String getLessons(Model model) {
        model.addAttribute("lessons", lessonService.getAllLessons());
        model.addAttribute("choseMark", new GetLessonMarkModel());
        return "NoteDisciplina";
    }

    @PostMapping(value="/notedisciplina")
    public String displayLessonMarks(@ModelAttribute("choseMark") GetLessonMarkModel getLessonMarkModel,
                                     Errors error, Model model) {
        Lesson lesson = lessonService.getLessonById(getLessonMarkModel.getLessonID()).orElse(null);
        if (lesson == null) {
            error.reject("lessonID", "Disciplina invalida");
        }
        model.addAttribute("lessons", lessonService.getAllLessons());

        if(!error.hasErrors()){
            model.addAttribute("selectedLesson",lesson.getNume());
            model.addAttribute("marks", markService.getMarkByLessonID(lesson.getID()));
        }

        return "NoteDisciplina";
    }

}
