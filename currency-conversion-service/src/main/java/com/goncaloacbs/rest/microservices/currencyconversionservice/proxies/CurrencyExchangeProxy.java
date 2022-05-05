package com.goncaloacbs.rest.microservices.currencyconversionservice.proxies;

import com.goncaloacbs.rest.microservices.currencyconversionservice.beans.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
