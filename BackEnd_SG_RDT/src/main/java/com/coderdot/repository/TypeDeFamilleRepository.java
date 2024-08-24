package com.coderdot.repository;

import com.coderdot.entities.Emplacemant;
import com.coderdot.entities.TypeDeFamille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeDeFamilleRepository extends JpaRepository<TypeDeFamille,Long> {
    Optional<TypeDeFamille> findByType(String type);
}
