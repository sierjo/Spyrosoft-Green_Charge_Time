package com.program.Green_Charge_Time.controller;

import com.program.Green_Charge_Time.dto.OptimalTimeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
}
