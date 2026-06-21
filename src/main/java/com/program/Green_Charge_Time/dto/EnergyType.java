package com.program.Green_Charge_Time.dto;

import lombok.Data;

@Data
public class EnergyType {
    private String fuel; // (wind, solar, gas, coal ...)
    private double percent;
}
