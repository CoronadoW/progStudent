
package com.exercises.progstudent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tema {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idTema;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name="fk_idCurso")
    @JsonIgnore
    private Curso curso;
    
    public Tema() {
    }

    public Tema(Long idTema, String nombre, String descripcion, Curso curso) {
        this.idTema = idTema;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.curso = curso;
    }

    
    
    
}
