package kz.kaznitu.course.controllers;

import kz.kaznitu.course.models.Teacher;
import kz.kaznitu.course.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String clubList(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("teacher", new Teacher());
        return "teachers";
    }

    @RequestMapping(value = "/saveteacher", method = RequestMethod.POST)
    public String saveClub(@ModelAttribute Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }
}
