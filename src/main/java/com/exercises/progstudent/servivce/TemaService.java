package com.exercises.progstudent.servivce;

import com.exercises.progstudent.model.Tema;
import com.exercises.progstudent.respository.ITemaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService {

    @Autowired
    private ITemaRepository iTemaRepo;

    @Override
    public Optional<Tema> getTema(Long id) {
        Optional<Tema> tema = iTemaRepo.findById(id);
        return tema;
    }

    @Override
    public void createTema(Tema tema) {
        iTemaRepo.save(tema);
    }

    @Override
    public Optional<Tema> editTema(Long idTema, Tema tema) {
        Optional<Tema> tem = iTemaRepo.findById(idTema);

        if (tem.isPresent()) {
            Tema temaExist = tem.get();
            temaExist.setNombre(tema.getNombre());
            temaExist.setDescripcion(tema.getDescripcion());
            iTemaRepo.save(temaExist);
            return Optional.of(temaExist);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void editarTema(Tema tema) {
        iTemaRepo.save(tema);
    }

}
