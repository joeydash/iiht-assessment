package org.grow90.finmlapi.controller;

import org.grow90.finmlapi.entity.Company;
import org.grow90.finmlapi.entity.Exchange;
import org.grow90.finmlapi.entity.Sector;
import org.grow90.finmlapi.service.CompanyService;
import org.grow90.finmlapi.service.ExchangeService;
import org.grow90.finmlapi.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private SectorService sectorService;


    @PostMapping("addStockExchange")
    public Exchange addSector(@RequestBody Exchange exchange) {
        return exchangeService.saveStockExchange(exchange);
    }


    @PostMapping("addSector")
    public Sector addSector(@RequestBody Sector sector) {
        return sectorService.saveSector(sector);
    }

    @PostMapping("addCompany")
    public Company addCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @GetMapping("getAllCompanies")
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("getAllSectors")
    public List<Sector> getAllSectors() {
        return sectorService.getAllSectors();
    }

    @GetMapping("getAllExchanges")
    public List<Exchange> getAllExchanges() {
        return exchangeService.getAllExchanges();
    }

}
