
package com.exercises.progstudent.servivce;

import com.exercises.progstudent.model.Tema;
import java.util.Optional;

public interface ITemaService {
    
    public void createTema(Tema tema);
    
    public Optional<Tema> editTema(Long idTema, Tema tema);

    public Optional<Tema> getTema(Long id);
    
    public void editarTema(Tema tema);
}
