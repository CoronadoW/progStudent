package com.exercises.progstudent.servivce;

import com.exercises.progstudent.model.Curso;
import com.exercises.progstudent.model.Tema;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ICursoService {

    public void createCurso(Curso curso);

    public List<Curso> getAllCurso();

    public List<Tema> getListTema(Long idCurso);

    public List<String> getJavaName();

    public ResponseEntity<String> editCurso(Long idCurso, Curso curso);

}
