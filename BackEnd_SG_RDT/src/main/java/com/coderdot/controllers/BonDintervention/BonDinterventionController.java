package com.coderdot.controllers.BonDintervention;

import com.coderdot.dto.BonDintervetionDTO;
import com.coderdot.entities.BonDintervention;
import com.coderdot.entities.Material;
import com.coderdot.entities.TypeDeFamille;
import com.coderdot.entities.Zone;
import com.coderdot.services.BonDintervention.BonDinterventionService;
import com.coderdot.services.Material.MaterialService;
import com.coderdot.services.TypeDeFamille.TypeDeFamilleService;
import com.coderdot.services.Zone.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/BonDintervention")
@RequiredArgsConstructor
public class BonDinterventionController {

    final private BonDinterventionService bonDinterventionService;
    final private ZoneService zoneService;
    final private TypeDeFamilleService typeDeFamilleService;
    final private MaterialService materialService;
    @GetMapping("/findAll")
    public List<BonDintervention> findALL(){
        return bonDinterventionService.findAll();
    }
    @GetMapping("/findAllZones")
    public List<Zone> findAllZones(){
        return zoneService.findAll();
    }

    @GetMapping("/findAllTypeDeFamilles")
    public List<TypeDeFamille> findAllTypeDeFamilles(){
        return typeDeFamilleService.findAll();
    }
    @GetMapping("/findALLMaterial")
    public List<Material> findALLMaterial(){
        return materialService.materials();
    }

    @PostMapping("/create")
    public BonDintervention create(@RequestBody BonDintervetionDTO bonDintervetionDTO) throws ParseException {

        return bonDinterventionService.create(bonDintervetionDTO);
    }
    @PostMapping("/deletById")
    public ResponseEntity<String> deletById(@RequestBody Long id){
        bonDinterventionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PostMapping("/findByType")
    public List<BonDintervention> findByType(@RequestBody String type){

        return bonDinterventionService.findByTypeBonDintervention(type);
    }
}
