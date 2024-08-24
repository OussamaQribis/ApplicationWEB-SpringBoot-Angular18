package com.coderdot.repository;

import com.coderdot.entities.Emplacemant;
import com.coderdot.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamilleRepository extends JpaRepository<Famille,Long> {
    Optional<Famille> findByNom(String rdt);
}
