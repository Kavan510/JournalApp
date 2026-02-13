package com.example.Hanuman.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component

public class WeatherService {
    private static final String apiKey = "5a3079ed25ea857d963e3e8817bb83c7";
    private static final String API = "https://api.weatherstack.com/current?access_key=API_& query=CITY";

    @Autowired
    private RestTemplate restTemplate;

//
//    public String weatherAPI(String city){
//        String finalAPI = API.replace("CITY",city).replace("API_KEY",apiKey);
//        restTemplate.exchange(finalAPI, HttpMethod.GET,null);
//
//    }

}
