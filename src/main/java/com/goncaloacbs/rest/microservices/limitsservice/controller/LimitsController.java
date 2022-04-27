package com.goncaloacbs.rest.microservices.limitsservice.controller;


import com.goncaloacbs.rest.microservices.limitsservice.bean.Limits;
import com.goncaloacbs.rest.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

}
