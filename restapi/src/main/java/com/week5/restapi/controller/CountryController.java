package com.week5.restapi.controller;

import com.week5.restapi.model.Countries;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class CountryController {

    private final RestTemplate restTemplate;

    public CountryController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/countries/{code}")
    public Countries getCountry(@PathVariable String code) {
        String url = "https://topups.reloadly.com/countries/" + code;
        return restTemplate.getForObject(url, Countries.class);
    }
}
