import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weather {
    private String url;
    private Document document;
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

        this.url = "https://www.gismeteo.ru" + cities.get(city) + "now/";
        try{
            this.document = Jsoup.connect(url).get();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getTemperature(){
        try{
            Element elementWeather = this.document.selectFirst("body > section > div > section > div > a > div > div.tab-content");

            Element elementTemp = document.selectFirst("div > div > span.unit");
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
            Element elementWeather = this.document.selectFirst("body > section > div > section > div > a");

            return elementWeather.attr("data-text");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String getWind(){
        try{
            Element elementWeather = this.document.selectFirst("body > section > div > section > div > div > div.info-wrap");

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
            Element elementWeather = this.document.selectFirst("body > section > div > section > div > div > div.info-wrap");

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
            Element elementWeather = document.selectFirst("body > section > div > section > div > div > div.info-wrap");

            Element elementPressure = elementWeather.selectFirst("div > div.humidity > div.item-value");

            return elementPressure.ownText() + " %";

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
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
