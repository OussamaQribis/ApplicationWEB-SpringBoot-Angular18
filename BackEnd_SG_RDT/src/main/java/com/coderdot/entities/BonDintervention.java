package com.coderdot.entities;

import com.coderdot.enums.TypeBonDintervention;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class BonDintervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    private User user;
    private Date date;
    private String shift;
    @ManyToOne
    @JsonManagedReference
    private Material material;
    private String TachesEffecuees;
    private TypeBonDintervention typeBonDintervention;

}
