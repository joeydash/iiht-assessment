package org.grow90.finmlapi.repository;

import org.grow90.finmlapi.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
}
