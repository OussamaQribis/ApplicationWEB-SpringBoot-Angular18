package com.coderdot.controllers.ajouts;

import com.coderdot.dto.Auth.SignupRequest;
import com.coderdot.dto.BonDintervetionDTO;
import com.coderdot.entities.*;
import com.coderdot.enums.TypeBonDintervention;
import com.coderdot.enums.UserRole;
import com.coderdot.repository.*;
import com.coderdot.services.Auth.AuthService;
import com.coderdot.services.BonDintervention.BonDinterventionService;
import com.coderdot.services.Material.MaterialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class Ajouts {
    @Bean
    CommandLineRunner commandLineRunner(MaterielRepository materielRepository,
                                        EmplacemantRepository emplacemantRepository,
                                        FamilleRepository familleRepository,
                                        SuiviATRepository suiviATRepository,
                                        TypeDeFamilleRepository typeDeFamilleRepository,
                                        ZoneRepository zoneRepository,
                                        UtilisateurRepository utilisateurRepository,
                                        UserRepository userRepository,
                                        AuthService authService,
                                        MaterialService materialService,
                                        BonDinterventionService bonDinterventionService
                                       ){
        return args -> {





            Zone zone =new Zone();
            Zone zone2 =new Zone();
            Zone zone3 =new Zone();
            Zone zone4 =new Zone();

            zone.setZonNom("DTC");
            zoneRepository.save(zone);
            zone2.setZonNom("DTP");
            zoneRepository.save(zone2);
            zone3.setZonNom("DSI");
            zoneRepository.save(zone3);
            zone4.setZonNom("DTV");
            zoneRepository.save(zone4);

            Emplacemant emplacemants =new Emplacemant();
            Emplacemant emplacemants2 =new Emplacemant();
            Emplacemant emplacemants3 =new Emplacemant();
            emplacemants.setZone(zoneRepository.findByZonNom(zone.getZonNom()).get());
            emplacemants.setObservation("observastion 1 ");

            emplacemants2.setZone(zoneRepository.findByZonNom(zone2.getZonNom()).get());
            emplacemants2.setObservation("observastion 2 ");

            emplacemants3.setZone(zoneRepository.findByZonNom(zone4.getZonNom()).get());
            emplacemants3.setObservation("observastion 3 ");
            emplacemantRepository.save(emplacemants);
            emplacemantRepository.save(emplacemants2);
            emplacemantRepository.save(emplacemants3);


            TypeDeFamille typeDeFamille=new TypeDeFamille();
            typeDeFamille.setType("HHT");
            typeDeFamilleRepository.save(typeDeFamille);
            TypeDeFamille typeDeFamille1=new TypeDeFamille();
            typeDeFamille1.setType("VMT");
            typeDeFamilleRepository.save(typeDeFamille1);


            Famille famille=new Famille();
            famille.setNom("RDT");
            famille.setTypeDeFamille(typeDeFamilleRepository.findByType(typeDeFamille.getType()).get());
            familleRepository.save(famille);

            Famille famille1=new Famille();
            famille1.setNom("RDT");
            famille1.setTypeDeFamille(typeDeFamilleRepository.findByType(typeDeFamille1.getType()).get());
            familleRepository.save(famille1);

            Utilisateur utilisateur=new Utilisateur();
            utilisateur.setNom("WADDY");
            utilisateurRepository.save(utilisateur);

            Utilisateur utilisateur1=new Utilisateur();
            utilisateur1.setNom("ALLAM");
            utilisateurRepository.save(utilisateur1);

            Material material=new Material();
            material.setTypeDeFamille(typeDeFamilleRepository.findByType("HHT").get());
            material.setEmplacemant(emplacemantRepository.findByZone(zoneRepository.findByZonNom("DTC").get()).get());
            material.setCode("08");
            material.setModel("CK65");
            material.setMarque("Honeywell");
            material.setNumeroDeSerie("21022D8322");
            material.setDateDacquisition(new Date());
            material.setDateDeMiseEnService(new Date());
            material.setNumeroDeMarche("N°254");
            materielRepository.save(material);

            Material material1=new Material();
            material1.setTypeDeFamille(typeDeFamilleRepository.findByType("HHT").get());
            material1.setEmplacemant(emplacemantRepository.findByZone(zoneRepository.findByZonNom("DTC").get()).get());
            material1.setCode("10");
            material1.setModel("CK65");
            material1.setMarque("Honeywell");
            material1.setNumeroDeSerie("21022D8541");
            material1.setDateDacquisition(new Date());
            material1.setDateDeMiseEnService(new Date());
            material1.setNumeroDeMarche("N°254");
            materielRepository.save(material1);

            Material material2=new Material();
            material2.setTypeDeFamille(typeDeFamilleRepository.findByType("VMT").get());
            material2.setEmplacemant(emplacemantRepository.findByZone(zoneRepository.findByZonNom("DTC").get()).get());
            material2.setCode("52");
            material2.setModel("VM1A");
            material2.setMarque("Honeywell");
            material2.setNumeroDeSerie("2103561332");
            material2.setDateDacquisition(new Date());
            material2.setDateDeMiseEnService(new Date());
            material2.setNumeroDeMarche("N°254");
            materielRepository.save(material2);

            SignupRequest signupRequest=new SignupRequest();
            signupRequest.setName("admin");
            signupRequest.setEmail("admin@gmail.com");
            signupRequest.setPassword("123");
            signupRequest.setUserRole(0);
            User user=authService.createUser(signupRequest);

                    SuiviAffectationTerminal suiviAffectationTerminal=new SuiviAffectationTerminal();
            suiviAffectationTerminal.setObservation(" ----- ");
            suiviAffectationTerminal.setRonduNoRondu(false);
            suiviAffectationTerminal.setMaterial(materielRepository.findByCode(material1.getCode()).get());
            suiviAffectationTerminal.setUtilisateur(utilisateurRepository.findByNom(utilisateur.getNom()).get());
            suiviAffectationTerminal.setDateDaffictation(new Date());
            suiviAffectationTerminal.setShift("1er Shift");
            suiviAffectationTerminal.setUser(userRepository.findById(1L).get());
            suiviATRepository.save(suiviAffectationTerminal);

            SuiviAffectationTerminal suiviAffectationTerminal1=new SuiviAffectationTerminal();
            suiviAffectationTerminal1.setObservation(" ----- ");
            suiviAffectationTerminal1.setRonduNoRondu(true);
            suiviAffectationTerminal1.setMaterial(materielRepository.findByCode(material.getCode()).get());
            suiviAffectationTerminal1.setUtilisateur(utilisateurRepository.findByNom(utilisateur1.getNom()).get());
            suiviAffectationTerminal1.setDateDaffictation(new Date());
            suiviAffectationTerminal1.setDateDretour(new Date());
            suiviAffectationTerminal1.setShift("2émé Shift");
            suiviAffectationTerminal1.setUser(userRepository.findById(1L).get());;
            suiviATRepository.save(suiviAffectationTerminal1);

            SuiviAffectationTerminal suiviAffectationTerminal3=new SuiviAffectationTerminal();
            suiviAffectationTerminal3.setObservation(" ----- ");
            suiviAffectationTerminal3.setRonduNoRondu(false);
            suiviAffectationTerminal3.setMaterial(materielRepository.findByCode(material1.getCode()).get());
            suiviAffectationTerminal3.setUtilisateur(utilisateurRepository.findByNom(utilisateur.getNom()).get());
            suiviAffectationTerminal3.setDateDaffictation(new Date());
            suiviAffectationTerminal3.setShift("3émé Shift");
            suiviAffectationTerminal3.setUser(userRepository.findById(1L).get());
            suiviATRepository.save(suiviAffectationTerminal3);


            BonDintervetionDTO bonDintervetionDTO=new BonDintervetionDTO();
            bonDintervetionDTO.setCode("08");
            bonDintervetionDTO.setDate("2024-08-01 22:00");
            bonDintervetionDTO.setShift("1er Shift");
            bonDintervetionDTO.setIdUser(1L);
            bonDintervetionDTO.setTypeBonDintervention(TypeBonDintervention.CURATIF);
            bonDintervetionDTO.setTachesEffecuees("observation 1 ------");

            bonDinterventionService.create(bonDintervetionDTO);

            System.out.println(emplacemantRepository.findByZone(zoneRepository.findByZonNom("DTC").get()).get().getZone().getZonNom());

            List<BonDintervention> bonDinterventions=bonDinterventionService.findByTypeBonDintervention("CURATIF");
            bonDinterventions.forEach(c->{
                System.out.println(c.getMaterial().getCode());
            });
        };
    }
}
