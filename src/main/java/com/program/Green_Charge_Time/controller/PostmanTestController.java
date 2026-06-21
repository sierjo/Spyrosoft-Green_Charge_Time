package com.program.Green_Charge_Time.controller;

import com.program.Green_Charge_Time.dto.DailyStatisticsResponse;
import com.program.Green_Charge_Time.dto.OptimalTimeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/test")
public class PostmanTestController {
    // Good time for charging
    @GetMapping("/environmental-charging-window")
    public OptimalTimeResponse getOptimalWindow() {
        OptimalTimeResponse response = new OptimalTimeResponse();
        response.setTimeStastChargin("2026-06-21-12:00");
        response.setTimeEndChargin("2026-06-21-18:00");
        response.setCleanEnergyPercentage("85.5");
        return response;
    }

    @GetMapping("/energy-types")
    public DailyStatisticsResponse getDailyMix() {
        DailyStatisticsResponse response = new DailyStatisticsResponse();
        response.setDate("2026-06-21");

        Map<String, Double> mix = new HashMap<>();
        mix.put("wind", 45.5);
        mix.put("solar", 10.0);
        mix.put("gas", 20.0);

        response.setAverageMix(mix);
        response.setCleanEnergyPercentage(55.5); // wind + solar

        return response;
    }
}
