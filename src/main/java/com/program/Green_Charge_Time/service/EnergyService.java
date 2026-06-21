package com.program.Green_Charge_Time.service;

import com.program.Green_Charge_Time.dto.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnergyService {
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.carbonintensity.org.uk/generation/{from}/{to}";


    public EnergyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ApiResponse fetchRawEnergyData(String from, String to) {

        return restTemplate.getForObject(API_URL, ApiResponse.class, from, to);
    }
}
