package com.program.Green_Charge_Time.dto;

import lombok.Data;

import java.util.Map;

@Data
public class DailyStatisticsResponse {
    private String date;


    private Map<String, Double> averageMix;

    //  biomass, nuclear, hydro, wind, solar
    private double cleanEnergyPercentage;
}
