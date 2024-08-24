package com.coderdot.repository;

import com.coderdot.entities.Emplacemant;
import com.coderdot.entities.Material;
import com.coderdot.entities.SuiviAffectationTerminal;
import com.coderdot.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuiviATRepository extends JpaRepository<SuiviAffectationTerminal,Long> {

    @Override
    List<SuiviAffectationTerminal> findAll();
    boolean existsById(String id);
    Optional<SuiviAffectationTerminal> findById(String id);


}
