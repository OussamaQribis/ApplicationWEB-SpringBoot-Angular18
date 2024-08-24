package com.coderdot.services.SuiviAT;

import com.coderdot.dto.SuiviATDTO;
import com.coderdot.entities.SuiviAffectationTerminal;

import java.text.ParseException;
import java.util.List;

public interface SuiviATService {
    SuiviAffectationTerminal createSuiviAT(SuiviATDTO suiviATDTO) throws ParseException;
    List<SuiviAffectationTerminal> findALLSuiviAT();

    String deletById(Long id);

    SuiviAffectationTerminal RenduNoRendu(SuiviATDTO suiviATDTO);
}
