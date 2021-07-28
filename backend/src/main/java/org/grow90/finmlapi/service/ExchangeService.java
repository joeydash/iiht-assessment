package org.grow90.finmlapi.service;

import org.grow90.finmlapi.entity.Exchange;

import java.util.List;


public interface ExchangeService {

    Exchange saveStockExchange(Exchange exchange);

    List<Exchange> getAllExchanges();
}
