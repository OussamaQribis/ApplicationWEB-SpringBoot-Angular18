package com.coderdot.repository;

import com.coderdot.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    boolean existsByNom(String nom);
    Optional<Utilisateur> findByNom(String nom);
}
