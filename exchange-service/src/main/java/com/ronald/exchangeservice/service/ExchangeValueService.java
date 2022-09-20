package com.ronald.exchangeservice.service;

import com.ronald.exchangeservice.entity.ExchangeValue;
import com.ronald.exchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ExchangeValueService {

    ExchangeValue getExchangeValue(String from, String to);
}
