package com.exercises.progstudent.servivce;

import com.exercises.progstudent.model.Curso;
import com.exercises.progstudent.model.Tema;
import com.exercises.progstudent.respository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository iCurRepo;

    @Override
    public void createCurso(Curso curso) {
        iCurRepo.save(curso);
    }

    @Override
    public List<Curso> getAllCurso() {
        List<Curso> cursoList = iCurRepo.findAll();
        return cursoList;
    }

    @Override
    public List<Tema> getListTema(Long idCurso) {
        Curso cur = iCurRepo.findById(idCurso).orElse(null);
        List<Tema> temaList = cur.getListaTemas();
        return temaList;
    }

    @Override
    public List<String> getJavaName() {
        List<Curso> cursoList = iCurRepo.findAll();
        List<String> cursoJavaList = new ArrayList<>();
        for (Curso cur : cursoList) {
            if (cur.getNombre().toLowerCase().contains("java")) {
                cursoJavaList.add(cur.getNombre());
            }
        }
        return cursoJavaList;
    }

    @Override
    public ResponseEntity<String> editCurso(Long idCurso, Curso curso) {
        Optional<Curso> cur = iCurRepo.findById(idCurso);
        if (cur.isPresent()) {
            Curso curExist = cur.get();
            curExist.setNombre(curso.getNombre());
            curExist.setModalidad(curso.getModalidad());
            iCurRepo.save(curExist);
        }else{
            return new ResponseEntity("No se encontro un curso con esa id", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Curso editado con exito", HttpStatus.OK);
    }

}
