package com.ronald.calculationservice.service;

import com.ronald.calculationservice.payload.CalculatedAmount;

import java.math.BigDecimal;

public interface CurrencyCalculationService {

    CalculatedAmount calculateExchangeCurrency(String from, String to, BigDecimal quantity);

}
