package com.ronald.exchangeservice.controller;

import com.netflix.discovery.converters.Auto;
import com.ronald.exchangeservice.entity.ExchangeValue;
import com.ronald.exchangeservice.service.ExchangeValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExchangeValueController {
    @Autowired
    private ExchangeValueService exchangeValueService;

    @GetMapping("/exchange-value/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from,
                                          @PathVariable("to") String toVariable) {
        log.info("from value: " + from);
        log.info("to value: " + toVariable);
        return exchangeValueService.getExchangeValue(from, toVariable);
    }

}
