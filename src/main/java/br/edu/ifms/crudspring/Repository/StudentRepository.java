package br.edu.ifms.crudspring.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.crudspring.Model.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
