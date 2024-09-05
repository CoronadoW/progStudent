
package com.exercises.progstudent.controller;

import com.exercises.progstudent.model.Curso;
import com.exercises.progstudent.model.Tema;
import com.exercises.progstudent.servivce.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    @Autowired
    private ICursoService icurServ;
    
    @PostMapping ("curso/crear")
    public void crearCurso(@RequestBody Curso curso){
        icurServ.createCurso(curso);
    }
    
    @GetMapping ("/curso/lista")
    public List<Curso> getAllCurso(){
        List<Curso> cursoList = icurServ.getAllCurso();
        return cursoList;
    }
    
    @GetMapping ("/curso/listaTemas/{idCurso}")
    public List<Tema> getListTema(@PathVariable Long idCurso){
        List<Tema> temasList =  icurServ.getListTema(idCurso);
        return temasList;
    }
    
    @GetMapping ("/curso/listaJava")
    public List<String> getListJava(){
        List<String> listaJava = icurServ.getJavaName();
        return listaJava;
    }
    
    @PutMapping("/curso/edit/{idCurso}")
    
    public void cursoEdit(@PathVariable Long idCurso,
            @RequestBody Curso curso){
        icurServ.editCurso(idCurso, curso);
    }
}
