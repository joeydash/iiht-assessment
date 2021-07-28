package org.grow90.finmlapi.service;


import org.grow90.finmlapi.entity.Company;

import java.util.List;

public interface CompanyService {


    Company saveCompany(Company company);

    List<Company> saveCompany(List<Company> companies);

    List<Company> getCompanies();

    Company getProductById(int id);

    Company getProductByName(String name);

    String deleteCompany(int id);

    Company updateCompany(Company company);
}
