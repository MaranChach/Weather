import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;
import java.io.IOException;

public class Weather {
    private String url;
    private Document document;

    public void printSummary(){
        System.out.println(getTemperature());
        System.out.println(getClouds());
        System.out.println(getWind());
        System.out.println(getPressure());
        System.out.println(getHumidity());
    }

    public Weather(String url) throws IOException {
        this.url = url;
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

            return elementSign.ownText() + elementTemp.ownText() + elementLower.ownText();
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
}
