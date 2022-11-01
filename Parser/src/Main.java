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
        Weather weather = new Weather("Москва");
        List<WeatherSummary> weatherSummary = weather.getForDay();

        /**for (int i = 0; i < weatherSummary.size(); i++) {
            WeatherSummary summary = weatherSummary.get(i);
            System.out.println(summary.getDate());
            System.out.println(summary.getDateWeek());
            System.out.println(summary.getTemperature());
            System.out.println(summary.getClouds());
            System.out.println(summary.getWind() + " м/с");
            System.out.println();
        }**/

        for (int i = 0; i < weatherSummary.size(); i++) {
             WeatherSummary summary = weatherSummary.get(i);
             System.out.println(summary.getDate());
             System.out.println(summary.getTemperature());
             System.out.println(summary.getClouds());
             System.out.println(summary.getWind() + " м/с");
             System.out.println();
         }

    }
}