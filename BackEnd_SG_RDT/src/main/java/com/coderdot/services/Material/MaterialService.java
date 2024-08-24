package com.coderdot.services.Material;

import com.coderdot.dto.MaterialDTO;
import com.coderdot.entities.Material;
import com.coderdot.entities.TypeDeFamille;

import java.util.List;

public interface MaterialService{
    Material CreateMaterial(MaterialDTO material);
    List<Material> materials();
    List<Material> materialsByType(String type);
}
