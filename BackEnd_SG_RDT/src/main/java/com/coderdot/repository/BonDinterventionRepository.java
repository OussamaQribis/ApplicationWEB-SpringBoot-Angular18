package com.coderdot.repository;

import com.coderdot.entities.BonDintervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonDinterventionRepository extends JpaRepository<BonDintervention,Long> {
    List<BonDintervention> findByTypeBonDintervention(String type);
}
