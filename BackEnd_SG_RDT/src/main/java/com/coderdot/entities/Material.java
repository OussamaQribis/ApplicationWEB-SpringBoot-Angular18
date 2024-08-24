package com.coderdot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String marque;
    private String model;
    private String numeroDeMarche;
    private String numeroDeSerie;
    private Date dateDacquisition;
    private Date dateDeMiseEnService;
    @ManyToOne
    @JsonManagedReference
    private TypeDeFamille typeDeFamille;
    @ManyToOne
    @JsonManagedReference
    private Emplacemant emplacemant;
    @OneToMany
    @JsonBackReference
    private List<SuiviAffectationTerminal> suiviAffectationTerminal;
    @OneToMany
    @JsonBackReference
    private List<BonDintervention> bonDintrventions;


}
