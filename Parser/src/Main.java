    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

    import java.io.IOException;

    public class Main {
    public static void main(String[] args) throws IOException {
        Weather weather = new Weather("https://www.gismeteo.ru/weather-chelyabinsk-4565/now/");
        weather.printSummary();
    }
}