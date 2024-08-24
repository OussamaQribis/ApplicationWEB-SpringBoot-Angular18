package com.coderdot.controllers.suiviAT;

import com.coderdot.dto.SuiviATDTO;
import com.coderdot.entities.Material;
import com.coderdot.entities.SuiviAffectationTerminal;
import com.coderdot.entities.User;
import com.coderdot.services.Material.MaterialService;
import com.coderdot.services.SuiviAT.SuiviATService;
import com.coderdot.services.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/suiviAT")
@RequiredArgsConstructor
public class SuiviATController {

    final SuiviATService suiviATService;
    final UserService userService;
    final MaterialService materialService;
    @PostMapping("/create")
    public SuiviAffectationTerminal createSuiviAT(@RequestBody SuiviATDTO suiviATDTO) throws ParseException {
        SuiviAffectationTerminal suiviAffectationTerminal=suiviATService.createSuiviAT(suiviATDTO);
        if(suiviAffectationTerminal!=null)
        return suiviAffectationTerminal;
        return null;
    }
    @PostMapping("/RenduNoRendu")
    public ResponseEntity<?> RenduNoRendu(@RequestBody SuiviATDTO suiviATDTO) throws ParseException {
        SuiviAffectationTerminal suiviAffectationTerminal=suiviATService.RenduNoRendu(suiviATDTO);
        if(suiviAffectationTerminal!=null)
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return null;
    }
    @PostMapping("/deletById")
    public ResponseEntity<String> deletById(@RequestBody Long id){
        suiviATService.deletById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/findAll")
    public List<SuiviAffectationTerminal> findAllSuiviAT(){
        return suiviATService.findALLSuiviAT();
    }

    @GetMapping("/findALLUsers")
    public List<User> findAllUsers(){
        return userService.getALL();
    }
    @GetMapping("/findALLMaterial")
    public List<Material> findALLMaterial(){
        return materialService.materialsByType("HHT");
    }

}