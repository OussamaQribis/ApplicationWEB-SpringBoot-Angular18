package com.coderdot.repository;

import com.coderdot.entities.Emplacemant;
import com.coderdot.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Long> {
    Optional<Zone> findByZonNom(String zonNom);
}
