import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        try{
            Document document = Jsoup.connect("https://www.gismeteo.ru/weather-washington-7150/").get();

            Element elementWeather = document.selectFirst("body > section > div > section > div > a > div > div.tab-content");

            System.out.println(elementWeather);

            Element elementDate = document.selectFirst("body > section > div > section > div > a > div > div > div.date");
            Element elementTime = document.selectFirst("body > section > div > section > div > a > div > div > div.day");
            Element elementTemp = document.selectFirst("body > section > div > section > div > a > div > div > div > div > span.unit");

            System.out.println(elementDate.ownText());
            System.out.println(elementTime.ownText());
            System.out.println(elementTemp.ownText());
        }
        catch (Exception e){

        }

    }
}