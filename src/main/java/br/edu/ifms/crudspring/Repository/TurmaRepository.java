package br.edu.ifms.crudspring.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.crudspring.Model.Turma;



public interface TurmaRepository extends JpaRepository<Turma, UUID> {
    
}
