package com.ronald.exchangeservice.service.impl;

import com.netflix.discovery.converters.Auto;
import com.ronald.exchangeservice.entity.ExchangeValue;
import com.ronald.exchangeservice.repository.ExchangeValueRepository;
import com.ronald.exchangeservice.service.ExchangeValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExchangeValueServiceImpl implements ExchangeValueService {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private Environment environment;

    @Override
    public ExchangeValue getExchangeValue(String from, String to) {
        log.info("inside get exchange value " + from + " " + to);
        ExchangeValue exchangeValue = exchangeValueRepository.findExchangeValueByFromIgnoreCaseAndToIgnoreCase(from, to);
        exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
