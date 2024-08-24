package com.coderdot.dto;

import com.coderdot.entities.Material;
import com.coderdot.entities.Utilisateur;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class SuiviATDTO {

    private Long id;
    private String dateDaffictation;
    private String dateDretour;
    private int ronduNoRondu;
    private String observation;
    private String code;
    private String NomUtilisateur;
    private String shift;
    private String userName;
    private Long userId;
}
