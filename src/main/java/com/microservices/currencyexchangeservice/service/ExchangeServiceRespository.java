package com.microservices.currencyexchangeservice.service;

import com.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public
interface ExchangeServiceRespository extends CrudRepository<ExchangeValue,Long> {


}
