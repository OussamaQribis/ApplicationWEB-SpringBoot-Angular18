package com.coderdot.services.Zone;

import com.coderdot.entities.Zone;
import com.coderdot.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService{
    final private ZoneRepository zoneRepository;

    @Override
    public List<Zone> findAll() {
        return zoneRepository.findAll();
    }
}
