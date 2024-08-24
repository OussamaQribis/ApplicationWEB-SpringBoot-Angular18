package com.coderdot.services.BonDintervention;

import com.coderdot.dto.BonDintervetionDTO;
import com.coderdot.entities.BonDintervention;
import com.coderdot.entities.Material;

import java.text.ParseException;
import java.util.List;

public interface BonDinterventionService {
    BonDintervention create(BonDintervetionDTO bonDintervetionDTO) throws ParseException;

    List<BonDintervention> findAll();

    List<Material> findAllMaterials();
    String deleteById(Long id);

    List<BonDintervention> findByTypeBonDintervention(String type);
}
