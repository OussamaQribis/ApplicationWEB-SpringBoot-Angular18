package com.coderdot.services.TypeDeFamille;

import com.coderdot.entities.TypeDeFamille;
import com.coderdot.repository.TypeDeFamilleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeDeFamilleImpl implements TypeDeFamilleService{

    final private TypeDeFamilleRepository typeDeFamilleRepository;
    @Override
    public List<TypeDeFamille> findAll() {
        return typeDeFamilleRepository.findAll();
    }
}
