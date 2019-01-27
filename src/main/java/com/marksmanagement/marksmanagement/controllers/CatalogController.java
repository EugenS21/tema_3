package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Lesson;
import com.marksmanagement.marksmanagement.classes.Mark;
import com.marksmanagement.marksmanagement.classes.Student;
import com.marksmanagement.marksmanagement.models.DisplayGradeModel;
import com.marksmanagement.marksmanagement.services.LessonService;
import com.marksmanagement.marksmanagement.services.MarkService;
import com.marksmanagement.marksmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CatalogController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private MarkService markService;

    @GetMapping(value = "/catalog")
    public String displayMarksOfStudentToLesson(Model model) {

        List<Student> students = studentService.getAllStudents();
        List<Lesson> lessons = lessonService.getAllLessons();
        List<List<DisplayGradeModel>> listGradeModels = new ArrayList<>();
        List<DisplayGradeModel> gradeModels = new ArrayList<>();

        for (Student student : students) {
            for (Lesson lesson : lessons) {
                DisplayGradeModel mod = new DisplayGradeModel();
                Optional<Mark> nota = markService.getMarksForStudentsAndLessons(student.getID(), lesson.getID());

                mod.setStudent(student);
                mod.setLesson(lesson);


                if(nota.isPresent()){
                    mod.setMark(nota.get().getNota());
                }
                else
                    mod.setMark(0);

                gradeModels.add(mod);
            }
            listGradeModels.add(gradeModels);
            gradeModels = new ArrayList<>();
        }

        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("lessons", lessonService.getAllLessons());
        model.addAttribute("marksForStudent", listGradeModels);

        return "catalog";
    }
}
