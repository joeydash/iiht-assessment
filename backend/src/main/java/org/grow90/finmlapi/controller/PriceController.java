package org.grow90.finmlapi.controller;

import org.grow90.finmlapi.entity.Price;
import org.grow90.finmlapi.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @PostMapping("addPrice")
    public Price addPrice(@RequestBody Price price) {
        return priceService.savePrice(price);
    }


    @PostMapping("addPrices")
    public List<Price> addPrices(@RequestBody List<Price> prices) {
        return priceService.savePrices(prices);
    }

    @GetMapping("getPricesByCompanyAndExchange/{companyId}/{exchangeId}")
    public List<Price> getPricesByCompanyAndExchange(@PathVariable int companyId, @PathVariable int exchangeId) {
        return priceService.getPriceByCompanyAndExchange(companyId, exchangeId);
    }
}
