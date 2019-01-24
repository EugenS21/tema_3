package com.marksmanagement.marksmanagement.controllers;

import com.marksmanagement.marksmanagement.classes.Mark;
import com.marksmanagement.marksmanagement.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MarkController {
    @Autowired
    MarkService markService;

    @RequestMapping(value="/addMark", method = RequestMethod.POST)
    public String addMark(@ModelAttribute("newMark") Mark mark, Model model){
        markService.addMark(mark);
        model.addAttribute("successMessage", String.format("Studentul %s %s are nota %d la disciplina %s",
                mark.getStudent().getNume(), mark.getStudent().getPrenume(), mark.getNota(), mark.getLesson().getNume()));
        return "index";
    }
}
