package com.weather.weatherprog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Weather {

    private String city;
    private String url;
    private String urlNow;
    private String urlWeekly;
    private Document document;
    private Document documentNow;
    private Document documentWeekly;
    private Map<String, String> cities;

    public void printSummary(){
        System.out.println(getTemperature());
        System.out.println(getClouds());
        System.out.println(getWind());
        System.out.println(getPressure());
        System.out.println(getHumidity());
    }

    public Weather(String city) throws IOException {

        this.cities = getCities();
        if (cities.get(city) == null){
            System.out.println("Город не найден");
            return;
        }
        this.city = city;
        this.url = "https://www.gismeteo.ru" + cities.get(city);
        this.urlNow = "https://www.gismeteo.ru" + cities.get(city) + "now/";
        this.urlWeekly = "https://www.gismeteo.ru" + cities.get(city) + "weekly/";
        try{
            this.document = Jsoup.connect(url).get();
            this.documentNow = Jsoup.connect(urlNow).get();
            this.documentWeekly = Jsoup.connect(urlWeekly).get();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getCity() {
        return city;
    }

    public String getTemperature(){
        try{
            Element elementWeather = this.documentNow.selectFirst("body > section > div > section > div > a > div > div.tab-content");

            Element elementTemp = documentNow.selectFirst("div > div > span.unit");
            Element elementSign = elementTemp.selectFirst("span.sign");
            Element elementLower = elementTemp.selectFirst("span.lower");

            String result = (elementLower != null) ? elementSign.ownText() + elementTemp.ownText() + elementLower.ownText() : elementSign.ownText() + elementTemp.ownText();

            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String getClouds(){
        try{
            Element elementWeather = this.documentNow.selectFirst("body > section > div > section > div > a");

            return elementWeather.attr("data-text");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String getWind() throws NullPointerException{
        try{
            Element elementWeather = this.documentNow.selectFirst("body > section > div > section > div > div > div.info-wrap");

            Element elementWind = elementWeather.selectFirst("div > div > div.unit_wind_m_s");
            Element elementWindMeasure = elementWind.selectFirst("div.item-measure");

            return elementWind.ownText() + " " + elementWindMeasure.text();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String getPressure(){
        try{
            Element elementWeather = this.documentNow.selectFirst("body > section > div > section > div > div > div.info-wrap");

            Element elementPressure = elementWeather.selectFirst("div > div > div.unit_pressure_mm_hg_atm");

            return elementPressure.ownText() + " мм рт.ст.";

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String getHumidity(){
        try{
            Element elementWeather = documentNow.selectFirst("body > section > div > section > div > div > div.info-wrap");

            Element elementPressure = elementWeather.selectFirst("div > div.humidity > div.item-value");

            return elementPressure.ownText() + " %";

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public List getWeekly(){
        List<WeatherSummary> weatherWeekly = new LinkedList<WeatherSummary>();
        try {
            Elements weatherBlock = documentWeekly.select("body > section > div > section > div.widget-weather > div.widget-columns-7 > div.widget-items");

            Elements dateWeek = weatherBlock.select("div > a > div.day");
            Elements date = weatherBlock.select("div > a > div.date");
            Elements tmax = weatherBlock.select("div > div > div > div > div > div.maxt > span.unit_temperature_c");
            Elements tmin = weatherBlock.select("div > div > div > div > div > div.mint > span.unit_temperature_c");
            Elements clouds = weatherBlock.select("div > div > div.weather-icon");
            Elements wind = weatherBlock.select("div.widget-row-wind-gust > div > span.unit_wind_m_s");


            for (int i = 0; i < date.size(); i++) {
                weatherWeekly.add(new WeatherSummary(date.get(i).text(), dateWeek.get(i).text(), tmax.get(i).text(), clouds.get(i).attr("data-text"), wind.get(i).text() + " м/c"));
            }

            return weatherWeekly;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherWeekly;
    }

    public List getForDay(){
        List<WeatherSummary> weatherForDay = new LinkedList<>();
        try{
            Elements weatherBlock =
                    document.select("body > section > div > section")
                            .attr("data-column-place", "C1P3")
                            .select("div.widget-weather > div.widget-columns-8 > div.widget-items");


            Elements timeUpper = weatherBlock.select("div.widget-row-time > div.row-item > span");
            Elements timeLower = weatherBlock.select("div.widget-row-time > div.row-item > span > sup");

            Elements temp = weatherBlock.select("div > div > div > div > span.unit_temperature_c");
            Elements clouds = weatherBlock.select("div > div > div.weather-icon");
            Elements wind = weatherBlock.select("div > div > span.unit_wind_m_s");

            for (int i = 0; i < timeUpper.size(); i++) {
                weatherForDay.add(new WeatherSummary(timeUpper.get(i).ownText() + ":" + timeLower.get(i).ownText(), temp.get(i).ownText(), clouds.get(i).attr("data-text"), wind.get(i).ownText()));
            }

            return weatherForDay;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return weatherForDay;
    }

    public Map<String, String> getCities() throws IOException {
        Map<String, String> citiesStruct = new HashMap<>();
        try {
            Document citiesDoc = Jsoup.connect("https://www.gismeteo.ru/catalog/russia/").get();

            Elements cities = citiesDoc.select("body > section > div > section > section > div.popular-cities > div > div > div > a.link-item");

            List<String> citiesKey = cities.eachText();
            List<String> citiesValue = cities.eachAttr("href");

            for (int i = 0; i < citiesKey.size(); i++) {
                citiesStruct.put(citiesKey.get(i), citiesValue.get(i));
            }
            return citiesStruct;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
