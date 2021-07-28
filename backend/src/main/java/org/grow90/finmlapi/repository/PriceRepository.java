package org.grow90.finmlapi.repository;

import org.grow90.finmlapi.entity.Company;
import org.grow90.finmlapi.entity.Exchange;
import org.grow90.finmlapi.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    List<Price> findByCompanyAndExchange(Company company, Exchange exchange);
}
