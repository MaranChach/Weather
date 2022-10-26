    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        Weather weather = new Weather("https://www.gismeteo.ru/weather-chelyabinsk-4565/now/");
        weather.printSummary();
    }
}