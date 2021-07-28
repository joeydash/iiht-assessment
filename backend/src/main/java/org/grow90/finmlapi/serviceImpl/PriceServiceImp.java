package org.grow90.finmlapi.serviceImpl;

import org.grow90.finmlapi.entity.Company;
import org.grow90.finmlapi.entity.Exchange;
import org.grow90.finmlapi.entity.Price;
import org.grow90.finmlapi.repository.CompanyRepository;
import org.grow90.finmlapi.repository.ExchangeRepository;
import org.grow90.finmlapi.repository.PriceRepository;
import org.grow90.finmlapi.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImp implements PriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public List<Price> savePrices(List<Price> prices) {
        return priceRepository.saveAll(prices);
    }

    @Override
    public List<Price> getPriceByCompanyAndExchange(int companyId, int exchangeId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        Exchange exchange = exchangeRepository.findById(exchangeId).orElse(null);
        return priceRepository.findByCompanyAndExchange(company, exchange);
    }
}
