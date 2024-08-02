package com.covidApp.Covid_SpringBoot_App.Controller;

import com.covidApp.Covid_SpringBoot_App.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-data")
public class CovidController {
    @Autowired
    CovidDataService covidDataService;
    @GetMapping("/citywise/{city}") //dynamic variable , or path variable
    public String getCovidCases(@PathVariable String city){
        //System.out.println(city);
        Integer covidData = covidDataService.getCovidData(city);
        return "covid Active cass in "+city+" = "+covidData;
    }
}
