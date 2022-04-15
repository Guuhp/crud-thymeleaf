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

import br.edu.ifms.crudspring.Model.Student;
import br.edu.ifms.crudspring.Service.StudentService;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String listStudent(Model model) {
        List<Student> students = service.getStudents();
        model.addAttribute("listStudents", students);
        model.addAttribute("student", new Student());

        return "list";
    }

    @GetMapping("/form")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "cad";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        var student = service.findById(id);
        service.deleteStudent(student.get());

        return "redirect:/students/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") UUID id, Model model) {
        // try para verificar se o estudante existe
        model.addAttribute("student", service.findById(id).get());

        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute Student student) {

        service.saveStudent(student);
        return "redirect:/students/";
    }

}
