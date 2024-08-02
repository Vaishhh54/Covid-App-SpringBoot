package com.covidApp.Covid_SpringBoot_App.Service;

import com.covidApp.Covid_SpringBoot_App.Utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CovidDataService {
    @Autowired
    RestTemplate restTemplate;

    public Integer getCovidData(String cityName) {
        Map<String, Object> map = restTemplate.getForObject(Util.CovidDataApi, Map.class);
        Map<String, String> stateCityMap = new HashMap<>();
        stateCityMap.put("Agra", "Uttar Pradesh");
        stateCityMap.put("Rampur", "Uttar Pradesh");
        stateCityMap.put("Noida", "Uttar Pradesh");
        stateCityMap.put("Hapur", "Uttar Pradesh");
        stateCityMap.put("Amritsar", "Punjab");
        stateCityMap.put("Barnala", "Punjab");
        stateCityMap.put("Bathinda", "Punjab");
        stateCityMap.put("Surat", "Gujarat");
        stateCityMap.put("Ahmedabad", "Gujarat");

        String stateName = stateCityMap.get(cityName);
        if (stateName == null) {
            System.out.println("City not found in stateCityMap: " + cityName);
            return null;
        }

        Map<String, Object> cityObjectMap = (Map<String, Object>) map.get(stateName);
        if (cityObjectMap == null) {
            System.out.println("State not found in API response: " + stateName);
            return null;
        }

        Map<String, Object> districtData = (Map<String, Object>) cityObjectMap.get("districtData");
        if (districtData == null) {
            System.out.println("District data not found for state: " + stateName);
            return null;
        }

        Map<String, Object> city = (Map<String, Object>) districtData.get(cityName);
        if (city == null) {
            System.out.println("City not found in district data: " + cityName);
            return null;
        }

        Integer active = (Integer) city.get("active");
        return active;
    }
}
