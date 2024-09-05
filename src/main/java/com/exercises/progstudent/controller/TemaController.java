
package com.exercises.progstudent.controller;

import com.exercises.progstudent.model.Tema;
import com.exercises.progstudent.servivce.ITemaService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {
    @Autowired
    private ITemaService iTemaServ;
    
    @PostMapping("/tema/crear")
    public void temaCrear(@RequestBody Tema tema){
        iTemaServ.createTema(tema);
    }
    /*
    @PutMapping("/tema/edit/{idTema}")
    public ResponseEntity<String> temaEditar(@PathVariable Long idTema,
            @RequestBody Tema tema){
        iTemaServ.editTema(idTema, tema);
        return new ResponseEntity("Tema con id " + idTema + " editado", HttpStatus.OK);
    }*/
    
    @PutMapping ("/tema/edit/{id}")
    public ResponseEntity<String> temaEdit(@PathVariable Long id,
            @RequestBody Tema tema){
        Optional<Tema> tem = iTemaServ.editTema(id, tema);
        if(tem.isPresent()){
            return new ResponseEntity("Tema editado", HttpStatus.OK);
        }else{
            return new ResponseEntity("Tema no encontrado con esa Id", HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/tema/reeditar")
    public String editarTema(@RequestBody Tema tema){
        iTemaServ.editarTema(tema);
        return "Listo, se edito y ya";
    }
}