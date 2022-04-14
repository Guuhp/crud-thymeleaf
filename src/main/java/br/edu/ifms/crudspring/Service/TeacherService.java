package br.edu.ifms.crudspring.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.Model.Teacher;
import br.edu.ifms.crudspring.Repository.TeacherRepository;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;

    public List<Teacher> getTeachers() {
        return repository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    public Optional<Teacher> findById(UUID id) {
        return repository.findById(id);
    }

    public void deleteTeacher(Teacher teacher) {
        repository.delete(teacher);
    }
}
