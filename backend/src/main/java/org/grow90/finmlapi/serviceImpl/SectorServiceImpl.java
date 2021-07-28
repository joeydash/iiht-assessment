package org.grow90.finmlapi.serviceImpl;

import org.grow90.finmlapi.entity.Sector;
import org.grow90.finmlapi.repository.SectorRepository;
import org.grow90.finmlapi.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public Sector saveSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    @Override
    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }
}
