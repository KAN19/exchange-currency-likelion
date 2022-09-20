package com.ronald.calculationservice.controller;

import com.ronald.calculationservice.payload.CalculatedAmount;
import com.ronald.calculationservice.service.CurrencyCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyCalculationController {

    @Autowired
    private CurrencyCalculationService currencyCalculationService;

    @GetMapping("/currency-calculate/from/{from}/to/{to}/quantity/{quantity}")
    public CalculatedAmount exchangeCurrency(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("quantity")BigDecimal quantity
            ) {
       return currencyCalculationService.calculateExchangeCurrency(from, to, quantity);
    }


}
