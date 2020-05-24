package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.microservices.currencyexchangeservice.service.ExchangeServiceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @Autowired
    ExchangeServiceRespository exchangeServiceRespository ;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveLimitsFromConfigurations(@PathVariable String from,@PathVariable String to){
        ExchangeValue USexchange=new ExchangeValue("USD","INR", BigDecimal.valueOf(65));
        ExchangeValue EURexchange=new ExchangeValue("EUR","INR", BigDecimal.valueOf(80));
        ExchangeValue AEDexchange=new ExchangeValue("AED","INR", BigDecimal.valueOf(25));

        exchangeServiceRespository.save(USexchange);
        exchangeServiceRespository.save(EURexchange);
        exchangeServiceRespository.save(AEDexchange);

        USexchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return USexchange;
    }
}
