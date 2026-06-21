package com.program.Green_Charge_Time.dto;

import lombok.Data;

import java.util.List;

@Data
public class EnergyData {
    private String from; // start interval
    private String to;  // end interval
    private List<EnergyType> generationmix; // energy sources List
}
