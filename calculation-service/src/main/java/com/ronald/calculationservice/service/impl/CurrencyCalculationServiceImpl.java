package com.ronald.calculationservice.service.impl;

import com.ronald.calculationservice.payload.CalculatedAmount;
import com.ronald.calculationservice.payload.ExchangeValue;
import com.ronald.calculationservice.service.CurrencyCalculationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class CurrencyCalculationServiceImpl implements CurrencyCalculationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Environment environment;

    @Override
    public CalculatedAmount calculateExchangeCurrency(String from, String to, BigDecimal quantity) {
        ExchangeValue exchangeValue = restTemplate
                .getForObject("http://CURRENCY-EXCHANGE-SERVICE/exchange-value/from/" + from + "/to/" + to, ExchangeValue.class);

        if (exchangeValue != null) {

            BigDecimal resultMultiply = quantity.multiply(exchangeValue.getConversionMultiple());

            CalculatedAmount calculatedAmount = modelMapper.map(exchangeValue, CalculatedAmount.class);
            calculatedAmount.setTotalCalculatedAmount(resultMultiply);
            calculatedAmount.setQuantity(quantity);
            calculatedAmount.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
            return calculatedAmount;
        }
        return null;
    }
}
