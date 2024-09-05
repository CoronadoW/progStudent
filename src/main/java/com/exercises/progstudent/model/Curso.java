
package com.exercises.progstudent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idCurso;
    private String nombre;
    private String modalidad;
    private LocalDate fechaFinalizacion;
    @OneToMany(mappedBy="curso")    
    private List<Tema> listaTemas;
    
    public Curso() {
    }

    public Curso(Long idCurso, String nombre, String modalidad, LocalDate fechaFinalizacion, List<Tema> listaTemas) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fechaFinalizacion = fechaFinalizacion;
        this.listaTemas = listaTemas;
    }
    
    

  
    
    
}
