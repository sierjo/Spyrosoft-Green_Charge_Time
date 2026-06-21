package com.program.Green_Charge_Time.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private List<EnergyData> data;
}