package com.goncaloacbs.rest.microservices.currencyexchangeservice.controllers;

import com.goncaloacbs.rest.microservices.currencyexchangeservice.beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);

}
