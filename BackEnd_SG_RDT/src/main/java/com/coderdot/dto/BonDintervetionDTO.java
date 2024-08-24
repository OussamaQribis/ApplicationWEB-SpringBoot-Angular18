package com.coderdot.dto;

import com.coderdot.entities.Material;
import com.coderdot.entities.User;
import com.coderdot.enums.TypeBonDintervention;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class BonDintervetionDTO {
    private Long id;
    private Long idUser;
    private String date;
    private String shift;

    private String code;
    private String TachesEffecuees;
    private TypeBonDintervention typeBonDintervention;
}
