package com.coderdot.repository;

import com.coderdot.entities.Emplacemant;
import com.coderdot.entities.Material;
import com.coderdot.entities.TypeDeFamille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterielRepository extends JpaRepository<Material,Long> {
    Optional<Material> findByNumeroDeSerie(String numeroDeSerie);

    Optional<Material> findByCode(String code);
    List<Material> findByTypeDeFamille(TypeDeFamille typeDeFamille);
}
