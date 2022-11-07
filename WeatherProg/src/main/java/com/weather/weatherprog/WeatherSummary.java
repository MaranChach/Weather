package com.weather.weatherprog;

public class WeatherSummary {
    private String date;
    private String dateWeek;
    private String temperature;
    private String clouds;
    private String wind;

    public WeatherSummary(String date, String dateWeek, String temperature, String clouds, String wind){
        this.date = date;
        this.dateWeek = dateWeek;
        this.temperature = temperature;
        this.clouds = clouds;
        this.wind = wind;
    }

    public WeatherSummary(String date, String temperature, String clouds, String wind){
        this.date = date;
        this.temperature = temperature;
        this.clouds = clouds;
        this.wind = wind;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getClouds() {
        return clouds;
    }

    public String getWind() {
        return wind;
    }

    public String getDate() {
        return date;
    }

    public String getDateWeek() {
        return dateWeek;
    }
}
