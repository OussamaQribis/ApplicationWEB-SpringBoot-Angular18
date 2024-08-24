package com.coderdot.entities;

import com.coderdot.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;
    private UserRole userRole;

    @OneToMany
    @JsonBackReference
    private List<SuiviAffectationTerminal> suiviAffectationTerminal;

    @OneToMany
    @JsonBackReference
    private List<BonDintervention> bonDintrventions;



}
