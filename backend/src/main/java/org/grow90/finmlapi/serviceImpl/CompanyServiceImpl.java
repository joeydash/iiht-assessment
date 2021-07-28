package org.grow90.finmlapi.serviceImpl;

import org.grow90.finmlapi.entity.Company;
import org.grow90.finmlapi.repository.CompanyRepository;
import org.grow90.finmlapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company saveCompany(Company company) {

        return companyRepository.save(company);
//     return company;
    }

    @Override
    public List<Company> saveCompany(List<Company> companies) {
        return companyRepository.saveAll(companies);
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getProductById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company getProductByName(String name) {
        return companyRepository.findByCompanyName(name);
    }

    @Override
    public String deleteCompany(int id) {
        companyRepository.deleteById(id);
        return "Company Deleted || " + id;
    }

    @Override
    public Company updateCompany(Company company) {
        Company existingCompany = companyRepository.findById(company.getId()).orElse(null);
        existingCompany.setCompanyName(company.getCompanyName());
        return companyRepository.save(existingCompany);
    }
}
