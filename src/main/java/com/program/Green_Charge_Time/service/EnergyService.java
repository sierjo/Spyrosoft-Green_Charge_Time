package com.program.Green_Charge_Time.service;

import com.program.Green_Charge_Time.dto.ApiResponse;
import com.program.Green_Charge_Time.dto.DailyStatisticsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnergyService {
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.carbonintensity.org.uk/generation/{from}/{to}";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");

    public EnergyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<DailyStatisticsResponse> getThreeDaysStatistics() {
        List<DailyStatisticsResponse> threeDaysStats = new ArrayList<>();

        // Today
        ZonedDateTime todayStart = ZonedDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.DAYS);

        // for three days
        for (int i = 0; i < 3; i++) {
            ZonedDateTime startOfDay = todayStart.plusDays(i);
            ZonedDateTime endOfDay = startOfDay.plusDays(1);

            String from = startOfDay.format(DATE_TIME_FORMATTER);
            String to = endOfDay.format(DATE_TIME_FORMATTER);

            ApiResponse rawData = restTemplate.getForObject(API_URL, ApiResponse.class, from, to);

            DailyStatisticsResponse dailyStat = calculateDailyAverage(rawData,startOfDay.toLocalDate().toString());
            threeDaysStats.add(dailyStat);
        }

        return threeDaysStats;
    }

    private DailyStatisticsResponse calculateDailyAverage(ApiResponse apiResponse, String date) {
        DailyStatisticsResponse response = new DailyStatisticsResponse();
        response.setDate(date);

        return response;
    }
}
