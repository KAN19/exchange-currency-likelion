package com.ronald.exchangeservice.config;

import com.ronald.exchangeservice.entity.ExchangeValue;
import com.ronald.exchangeservice.repository.ExchangeValueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ExchangeValueConfig {

    @Bean
    CommandLineRunner createSampleExchangeValue(ExchangeValueRepository exchangeValueRepository) {

        List<ExchangeValue> exchangeValues = List.of(
                new ExchangeValue(10001L, "USD", "VND", new BigDecimal(23300), 0),
                new ExchangeValue(10002L, "EUR", "VND", new BigDecimal(23800) , 0)
        );

        return args -> {
            exchangeValueRepository.saveAll(exchangeValues);
        };
    }

}
