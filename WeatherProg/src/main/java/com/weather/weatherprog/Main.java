package com.weather.weatherprog;

import java.io.IOException;
    import java.util.List;

    public class Main {
    public static void amain(String[] args) throws IOException {
        Weather weather = new Weather("Москва");
        List<WeatherSummary> weatherSummaryDay = weather.getForDay();
        List<WeatherSummary> weatherSummaryWeek = weather.getWeekly();

        for (int i = 0; i < weatherSummaryWeek.size(); i++) {
            WeatherSummary summary = weatherSummaryWeek.get(i);
            System.out.println(summary.getDate());
            System.out.println(summary.getDateWeek());
            System.out.println(summary.getTemperature());
            System.out.println(summary.getClouds());
            System.out.println(summary.getWind() + " м/с");
            System.out.println();
        }

        for (int i = 0; i < weatherSummaryDay.size(); i++) {
             WeatherSummary summary = weatherSummaryDay.get(i);
             System.out.println(summary.getDate());
             System.out.println(summary.getTemperature());
             System.out.println(summary.getClouds());
             System.out.println(summary.getWind() + " м/с");
             System.out.println();
         }

    }
}