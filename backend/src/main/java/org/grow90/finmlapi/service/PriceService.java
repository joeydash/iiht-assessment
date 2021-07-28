package org.grow90.finmlapi.service;

import org.grow90.finmlapi.entity.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceService {

    Price savePrice(Price price);

    List<Price> savePrices(List<Price> prices);

    List<Price> getPriceByCompanyAndExchange(int companyId, int exchangeId);
}
