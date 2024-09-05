
package com.exercises.progstudent.respository;

import com.exercises.progstudent.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITemaRepository extends JpaRepository <Tema, Long>{
    
}
