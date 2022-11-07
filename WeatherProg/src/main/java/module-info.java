module com.weather.weatherprog {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens com.weather.weatherprog to javafx.fxml;
    exports com.weather.weatherprog;
}