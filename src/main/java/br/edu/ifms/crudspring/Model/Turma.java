package br.edu.ifms.crudspring.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String nome;
    // @OneToMany(mappedBy = "turma")
    // List<Teacher> teachers;

}
