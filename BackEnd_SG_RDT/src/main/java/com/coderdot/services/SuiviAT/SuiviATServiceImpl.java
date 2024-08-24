package com.coderdot.services.SuiviAT;

import com.coderdot.dto.SuiviATDTO;
import com.coderdot.entities.SuiviAffectationTerminal;
import com.coderdot.entities.User;
import com.coderdot.entities.Utilisateur;
import com.coderdot.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuiviATServiceImpl implements SuiviATService{

    @Autowired
    MaterielRepository materielRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    SuiviATRepository suiviATRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public SuiviAffectationTerminal createSuiviAT(SuiviATDTO suiviATDTO) throws ParseException {
        if(suiviATDTO!=null) {
            if(suiviATDTO.getId()!=null){
                if(suiviATRepository.existsById(suiviATDTO.getId())){
                   SuiviAffectationTerminal suiviAffectationTerminal= suiviATRepository.findById(suiviATDTO.getId()).get();
                    suiviAffectationTerminal.setObservation(suiviATDTO.getObservation());
                    if(suiviATDTO.getRonduNoRondu()==1){
                    suiviAffectationTerminal.setRonduNoRondu(true);}
                    if(suiviATDTO.getRonduNoRondu()==0){
                        suiviAffectationTerminal.setRonduNoRondu(false);}
                    suiviAffectationTerminal.setMaterial(materielRepository.findByCode(suiviATDTO.getCode()).get());

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                    Date date = formatter.parse(suiviATDTO.getDateDaffictation());
                    suiviAffectationTerminal.setDateDaffictation(date);
                    if(!suiviATDTO.getDateDretour().equals("")){
                    Date date1 = formatter.parse(suiviATDTO.getDateDretour());
                    suiviAffectationTerminal.setDateDretour(date1);}
                    else {
                        suiviAffectationTerminal.setDateDretour(null);
                    }
                    suiviAffectationTerminal.setShift(suiviATDTO.getShift());

                    suiviAffectationTerminal.setUser(userRepository.findById(suiviATDTO.getUserId()).get());
                    return suiviATRepository.save(suiviAffectationTerminal);
                }

            }else{
            SuiviAffectationTerminal suiviAffectationTerminal = new SuiviAffectationTerminal();
            suiviAffectationTerminal.setObservation(suiviATDTO.getObservation());


                if((suiviATDTO.getRonduNoRondu() == 1)){
                    suiviAffectationTerminal.setRonduNoRondu(true);}
                if(suiviATDTO.getRonduNoRondu()==0){
                    suiviAffectationTerminal.setRonduNoRondu(false);}
            suiviAffectationTerminal.setMaterial(materielRepository.findByCode(suiviATDTO.getCode()).get());
            if(utilisateurRepository.existsByNom(suiviATDTO.getNomUtilisateur())) {
                suiviAffectationTerminal.setUtilisateur(utilisateurRepository.findByNom(suiviATDTO.getNomUtilisateur()).get());
            }else{
                Utilisateur utilisateur=new Utilisateur();
                utilisateur.setNom(suiviATDTO.getNomUtilisateur());
                suiviAffectationTerminal.setUtilisateur(utilisateurRepository.save(utilisateur));
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date date = formatter.parse(suiviATDTO.getDateDaffictation());
            suiviAffectationTerminal.setDateDaffictation(date);
                if(!suiviATDTO.getDateDretour().equals("")){
                    Date date1 = formatter.parse(suiviATDTO.getDateDretour());
                    suiviAffectationTerminal.setDateDretour(date1);}
                else {
                    suiviAffectationTerminal.setDateDretour(null);
                }
            suiviAffectationTerminal.setShift(suiviATDTO.getShift());
            suiviAffectationTerminal.setUser(userRepository.findById(suiviATDTO.getUserId()).get());
            return suiviATRepository.save(suiviAffectationTerminal);
        }}
        return null;
    }


    @Override
    public List<SuiviAffectationTerminal> findALLSuiviAT() {
            return suiviATRepository.findAll();
    }

    @Override
    public String deletById(Long id) {
        if(id!=null){
            suiviATRepository.deleteById(id);
        return "Deleted successfully";}
        return "Not Found!!!";
    }

    @Override
    public SuiviAffectationTerminal RenduNoRendu(SuiviATDTO suiviATDTO) {

        if(suiviATDTO!=null){
            if(suiviATRepository.existsById(suiviATDTO.getId())){
                SuiviAffectationTerminal suiviAffectationTerminal= suiviATRepository.findById(suiviATDTO.getId()).get();
            if((suiviATDTO.getRonduNoRondu() == 1)){
                suiviAffectationTerminal.setRonduNoRondu(false);}
            if(suiviATDTO.getRonduNoRondu()==0){
                suiviAffectationTerminal.setRonduNoRondu(true);}

                return suiviATRepository.save(suiviAffectationTerminal);
        }}
        return null;
    }
}
