package com.program.Green_Charge_Time.controller;

import com.program.Green_Charge_Time.dto.ApiResponse;
import com.program.Green_Charge_Time.service.EnergyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/energy")
public class EnergyController {

    private final EnergyService energyService;

    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }


    @GetMapping("/raw")
    public ApiResponse getRawData(
            @RequestParam String from,
            @RequestParam String to) {
        return energyService.fetchRawEnergyData(from, to);
    }
}
