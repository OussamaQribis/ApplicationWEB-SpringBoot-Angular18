package com.coderdot.services.Material;

import com.coderdot.dto.MaterialDTO;
import com.coderdot.entities.Material;
import com.coderdot.entities.TypeDeFamille;
import com.coderdot.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterilaServiceImpl implements MaterialService{

    final private MaterielRepository materielRepository;
    final private ZoneRepository zoneRepository;
    final private EmplacemantRepository emplacemantRepository;
    final private TypeDeFamilleRepository typeDeFamille;
    @Override
    public Material CreateMaterial(MaterialDTO material) {
       Material material1=new Material();
       if(material!=null){
           material1.setCode(material.getCode());
           material1.setModel(material.getModel());
           material1.setMarque(material.getMarque());
           material1.setDateDeMiseEnService(material.getDateDeMiseEnService());
           material1.setDateDacquisition(material.getDateDacquisition());
           material1.setNumeroDeMarche(material.getNumeroDeMarche());
           material1.setNumeroDeSerie(material.getNumeroDeSerie());
           return materielRepository.save(material1);
       }
        return null;
    }

    @Override
    public List<Material> materials() {
        return materielRepository.findAll();
    }

    @Override
    public List<Material> materialsByType(String type) {

        return materielRepository.findByTypeDeFamille(typeDeFamille.findByType(type).get());
    }

}
