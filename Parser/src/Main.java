    import org.jsoup.Connection;
    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

    import java.io.IOException;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Main {
    public static void main(String[] args) throws IOException {
        Weather weather = new Weather("Санкт-Петербург");
        weather.printSummary();
        /**Document a = Jsoup.connect("https://api.gismeteo.net/v2/search/cities/?lang=ru&query=%D0%BC%D0%BE%D1%81%D0%BA%D0%B2")
                .method(Connection.Method.GET)
                .data("X-Gismeteo-Token", "56b30cb255.3443075")
                .get();**/



    }
}