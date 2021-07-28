package org.grow90.finmlapi.service;

import org.grow90.finmlapi.entity.Sector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectorService {

    Sector saveSector(Sector sector);

    List<Sector> getAllSectors();
}
