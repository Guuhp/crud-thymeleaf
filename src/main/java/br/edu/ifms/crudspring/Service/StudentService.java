package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Student;
import br.edu.ifms.crudspring.Repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> findById(UUID id) {
        return repository.findById(id);
    }

    public void deleteStudent(Student student) {
        repository.delete(student);
    }
}
