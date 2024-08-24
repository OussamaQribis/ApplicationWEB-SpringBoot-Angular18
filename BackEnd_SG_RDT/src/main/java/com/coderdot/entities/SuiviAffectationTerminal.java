package com.coderdot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class SuiviAffectationTerminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDaffictation;
    private Date dateDretour;
    private Boolean ronduNoRondu;
    private String Observation;
    private String shift;

    @ManyToOne
    @JsonManagedReference
    private User user;
    @ManyToOne
    @JsonManagedReference
    private Material material;
    @ManyToOne
    @JsonManagedReference
    private Utilisateur utilisateur;


}
