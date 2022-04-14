package br.edu.ifms.crudspring.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.Model.Teacher;
import br.edu.ifms.crudspring.Service.TeacherService;

@Controller
@RequestMapping(value = "/teachers")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @GetMapping("/")
    public String listTeacher(Model model) {
        List<Teacher> teacher = service.getTeachers();
        model.addAttribute("teachers", teacher);
        model.addAttribute("newteacher", new Teacher());
        return "listteacher";
    }

    @GetMapping("/form")
    public String newTeacher(Model model) {
        model.addAttribute("newteacher", new Teacher());
        return "cadteacher";
    }

    @PostMapping("/save")
    public String savTeacher(@ModelAttribute Teacher teacher) {
        service.saveTeacher(teacher);
        return "redirect:/teachers/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        var teacher = service.findById(id);
        service.deleteTeacher(teacher.get());

        return "redirect:/teachers/";
    }

    @GetMapping("/edit/{id}")
    public String editTeacher(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("newTeacher", service.findById(id).get());

        return "updateteacher";
    }

    @PostMapping("/update/{id}")
    public String updateTeacher(Teacher teacher) {
        service.saveTeacher(teacher);
        return "redirect:/teachers/";
    }
}
