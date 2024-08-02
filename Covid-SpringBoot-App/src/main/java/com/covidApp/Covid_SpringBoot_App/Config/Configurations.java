package com.covidApp.Covid_SpringBoot_App.Config;

//package com.covidApp.Covid_SpringBoot_App.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configurations {
    @Bean //it is method level
    public RestTemplate getInstance(){
        return new RestTemplate();
    }
}

