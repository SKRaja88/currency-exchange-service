package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.microservices.currencyexchangeservice.service.ExchangeServiceRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger log= LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    Environment environment;

    @Autowired
    ExchangeServiceRespository exchangeServiceRespository ;
    private ExchangeValue exchangeValue;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveLimitsFromConfigurations(@PathVariable String from,@PathVariable String to){

        exchangeValue=exchangeServiceRespository.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        log.info("{}",exchangeValue);
        return exchangeValue;
    }
}
