package org.grow90.finmlapi.serviceImpl;

import org.grow90.finmlapi.entity.Exchange;
import org.grow90.finmlapi.repository.ExchangeRepository;
import org.grow90.finmlapi.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public Exchange saveStockExchange(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

    @Override
    public List<Exchange> getAllExchanges() {
        return exchangeRepository.findAll();
    }
}
