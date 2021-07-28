package org.grow90.finmlapi.repository;


import org.grow90.finmlapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByCompanyName(String name);
}
