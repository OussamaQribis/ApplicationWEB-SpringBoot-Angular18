package com.coderdot.services.BonDintervention;

import com.coderdot.dto.BonDintervetionDTO;
import com.coderdot.entities.BonDintervention;
import com.coderdot.entities.Material;
import com.coderdot.enums.TypeBonDintervention;
import com.coderdot.repository.BonDinterventionRepository;
import com.coderdot.repository.MaterielRepository;
import com.coderdot.repository.UserRepository;
import com.coderdot.services.Material.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BonDinterventionServiceImpl implements BonDinterventionService{


    final private BonDinterventionRepository bonDinterventionRepository;
    final private UserRepository userRepository;
    final private MaterielRepository materielRepository;
    final  private MaterialService materialService;
    @Override
    public BonDintervention create(BonDintervetionDTO bonDintervetionDTO) throws ParseException {

        if(bonDintervetionDTO!=null) {
            if(bonDintervetionDTO.getId()!=null){
                BonDintervention bonDintervention = bonDinterventionRepository.findById(bonDintervetionDTO.getId()).get();
                bonDintervention.setTypeBonDintervention(bonDintervetionDTO.getTypeBonDintervention());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date date = formatter.parse(bonDintervetionDTO.getDate());
                bonDintervention.setDate(date);
                bonDintervention.setShift(bonDintervetionDTO.getShift());
                bonDintervention.setUser(userRepository.findById(bonDintervetionDTO.getIdUser()).get());
                bonDintervention.setMaterial(materielRepository.findByCode(bonDintervetionDTO.getCode()).get());
                bonDintervention.setTachesEffecuees(bonDintervetionDTO.getTachesEffecuees());

                bonDinterventionRepository.save(bonDintervention);
                return bonDinterventionRepository.save(bonDintervention);
            }else{

            BonDintervention bonDintervention = new BonDintervention();
            bonDintervention.setTypeBonDintervention(bonDintervetionDTO.getTypeBonDintervention());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date date = formatter.parse(bonDintervetionDTO.getDate());
            bonDintervention.setDate(date);
            bonDintervention.setShift(bonDintervetionDTO.getShift());
            bonDintervention.setUser(userRepository.findById(bonDintervetionDTO.getIdUser()).get());
            bonDintervention.setMaterial(materielRepository.findByCode(bonDintervetionDTO.getCode()).get());
            bonDintervention.setTachesEffecuees(bonDintervetionDTO.getTachesEffecuees());

            bonDinterventionRepository.save(bonDintervention);
            return bonDinterventionRepository.save(bonDintervention);
        }}


        return null;
    }

    @Override
    public List<BonDintervention> findAll() {
        return bonDinterventionRepository.findAll();
    }
    @Override
    public List<Material> findAllMaterials() {
        return materialService.materials();
    }

    @Override
    public String deleteById(Long id) {
        if(bonDinterventionRepository.existsById(id)){
            bonDinterventionRepository.deleteById(id);
            return "deleted successfully";
        }
        return null;
    }

    @Override
    public List<BonDintervention> findByTypeBonDintervention(String type) {
        if(type.equals("CURATIF")){
            List<BonDintervention> bonDinterventionList=new ArrayList<>();
            List<BonDintervention> bonDinterventions=bonDinterventionRepository.findAll();
            bonDinterventions.forEach(b->{
                if(b.getTypeBonDintervention() ==TypeBonDintervention.CURATIF)
                    bonDinterventionList.add(b);
            });
           return bonDinterventionList;
        }
        if(type.equals("PREVONTIF")){
            List<BonDintervention> bonDinterventionList=new ArrayList<>();
            List<BonDintervention> bonDinterventions=bonDinterventionRepository.findAll();
            bonDinterventions.forEach(b->{
                if(b.getTypeBonDintervention()==TypeBonDintervention.PREVONTIF)
                    bonDinterventionList.add(b);
            });
            return bonDinterventionList;
        }
        return bonDinterventionRepository.findAll();
    }


}
