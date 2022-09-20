package com.ronald.exchangeservice.repository;

import com.ronald.exchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findExchangeValueByFromIgnoreCaseAndToIgnoreCase(String from, String to);

}
