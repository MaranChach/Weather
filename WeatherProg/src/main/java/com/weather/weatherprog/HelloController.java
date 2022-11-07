package com.weather.weatherprog;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {



    //region fields
    @FXML
    private ImageView BackgroundImage;
    private Weather weather;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ComboBox ComboPoisk;
    @FXML
    private Label errorMessage;
    @FXML
    private Button ButtonPoisk;

    @FXML
    private URL location;

    @FXML
    private Label Davlenie;

    @FXML
    private Label Day1;

    @FXML
    private Label Day2;

    @FXML
    private Label Day3;

    @FXML
    private Label Day4;

    @FXML
    private Label Day5;

    @FXML
    private Label Day6;

    @FXML
    private Label Day7;

    @FXML
    private Label Gorod;

    @FXML
    private ImageView ImgPogoda1;

    @FXML
    private ImageView ImgPogoda2;

    @FXML
    private ImageView ImgPogoda3;

    @FXML
    private ImageView ImgPogoda4;

    @FXML
    private ImageView ImgPogoda5;

    @FXML
    private ImageView ImgPogoda6;

    @FXML
    private ImageView ImgPogoda7;

    @FXML
    private ImageView ImgPogodaDay1;

    @FXML
    private ImageView ImgPogodaDay2;

    @FXML
    private ImageView ImgPogodaDay3;

    @FXML
    private ImageView ImgPogodaDay4;

    @FXML
    private ImageView ImgPogodaDay5;

    @FXML
    private ImageView ImgPogodaDay6;

    @FXML
    private ImageView ImgPogodaDay7;

    @FXML
    private ImageView ImgPogodaNow;

    @FXML
    private Label PogodaDay1;

    @FXML
    private Label PogodaDay2;

    @FXML
    private Label PogodaDay3;

    @FXML
    private Label PogodaDay4;

    @FXML
    private Label PogodaDay5;

    @FXML
    private Label PogodaDay6;

    @FXML
    private Label PogodaDay7;

    @FXML
    private Label PogodaHor1;

    @FXML
    private Label PogodaHor2;

    @FXML
    private Label PogodaHor3;

    @FXML
    private Label PogodaHor4;

    @FXML
    private Label PogodaHor5;

    @FXML
    private Label PogodaHor6;

    @FXML
    private Label PogodaHor7;

    @FXML
    private Label PogodaNow;

    @FXML
    private Label TempDay1;

    @FXML
    private Label TempDay2;

    @FXML
    private Label TempDay3;

    @FXML
    private Label TempDay4;

    @FXML
    private Label TempDay5;

    @FXML
    private Label TempDay6;

    @FXML
    private Label TempDay7;

    @FXML
    private Label TempHor1;

    @FXML
    private Label TempHor2;

    @FXML
    private Label TempHor3;

    @FXML
    private Label TempHor4;

    @FXML
    private Label TempHor5;

    @FXML
    private Label TempHor6;

    @FXML
    private Label TempHor7;

    @FXML
    private Label TepmNow;

    @FXML
    private Label Time1;

    @FXML
    private Label Time2;

    @FXML
    private Label Time3;

    @FXML
    private Label Time4;

    @FXML
    private Label Time5;

    @FXML
    private Label Time6;

    @FXML
    private Label Time7;

    @FXML
    private Label Veter;

    @FXML
    private Label Veter1;

    @FXML
    private Label Veter2;

    @FXML
    private Label Veter3;

    @FXML
    private Label Veter4;

    @FXML
    private Label Veter5;

    @FXML
    private Label Veter6;

    @FXML
    private Label Veter7;

    @FXML
    private Label Vlaga;
    //endregion


    @FXML
    void initialize() throws IOException {
        weather = new Weather("Москва");
        ComboPoisk.setItems(FXCollections.observableArrayList(weather.getCities().keySet()));
        setWeatherNow();
        setWeatherToday();
        setWeatherWeek();
    }

    public void onSearchClick(ActionEvent actionEvent) throws IOException {
        String validFoundCity = ComboPoisk.getValue().toString().substring(0, 1).toUpperCase() + ComboPoisk.getValue().toString().substring(1).toLowerCase();
        System.out.println(validFoundCity);
        if (!weather.getCities().containsKey(validFoundCity)){
            errorMessage.setVisible(true);
            return;
        }

        errorMessage.setVisible(false);
        weather = new Weather(validFoundCity);
        setWeatherNow();
        setWeatherToday();
        setWeatherWeek();
    }
    private void setWeatherNow(){
        Davlenie.setText(weather.getPressure());
        TepmNow.setText(weather.getTemperature());
        Vlaga.setText(weather.getHumidity());
        PogodaNow.setText(weather.getClouds());
        Veter.setText(weather.getWind());
        Gorod.setText(weather.getCity());
        ImgPogodaNow.setImage(getImage(weather.getClouds()));
        BackgroundImage.setImage(getImageBack(weather.getClouds()));
    }
    private void setWeatherToday(){
        List<WeatherSummary> weatherToday = weather.getForDay();
        Time1.setText(weatherToday.get(0).getDate());
        TempHor1.setText(weatherToday.get(0).getTemperature());
        PogodaHor1.setText(weatherToday.get(0).getClouds());
        ImgPogoda1.setImage(getImage(weatherToday.get(0).getClouds()));

        Time2.setText(weatherToday.get(1).getDate());
        TempHor2.setText(weatherToday.get(1).getTemperature());
        PogodaHor2.setText(weatherToday.get(1).getClouds());
        ImgPogoda2.setImage(getImage(weatherToday.get(1).getClouds()));

        Time3.setText(weatherToday.get(2).getDate());
        TempHor3.setText(weatherToday.get(2).getTemperature());
        PogodaHor3.setText(weatherToday.get(2).getClouds());
        ImgPogoda3.setImage(getImage(weatherToday.get(2).getClouds()));

        Time4.setText(weatherToday.get(3).getDate());
        TempHor4.setText(weatherToday.get(3).getTemperature());
        PogodaHor4.setText(weatherToday.get(3).getClouds());
        ImgPogoda4.setImage(getImage(weatherToday.get(3).getClouds()));

        Time5.setText(weatherToday.get(4).getDate());
        TempHor5.setText(weatherToday.get(4).getTemperature());
        PogodaHor5.setText(weatherToday.get(4).getClouds());
        ImgPogoda5.setImage(getImage(weatherToday.get(4).getClouds()));

        Time6.setText(weatherToday.get(5).getDate());
        TempHor6.setText(weatherToday.get(5).getTemperature());
        PogodaHor6.setText(weatherToday.get(5).getClouds());
        ImgPogoda6.setImage(getImage(weatherToday.get(5).getClouds()));

        Time7.setText(weatherToday.get(6).getDate());
        TempHor7.setText(weatherToday.get(6).getTemperature());
        PogodaHor7.setText(weatherToday.get(6).getClouds());
        ImgPogoda7.setImage(getImage(weatherToday.get(6).getClouds()));
    }
    private void setWeatherWeek(){
        List<WeatherSummary> weatherWeek = weather.getWeekly();

        Day1.setText(weatherWeek.get(0).getDateWeek() + ", " + weatherWeek.get(0).getDate());
        TempDay1.setText(weatherWeek.get(0).getTemperature());
        PogodaDay1.setText(weatherWeek.get(0).getClouds());
        Veter1.setText(weatherWeek.get(0).getWind());
        ImgPogodaDay1.setImage(getImage(weatherWeek.get(0).getClouds()));

        Day2.setText(weatherWeek.get(1).getDateWeek() + ", " + weatherWeek.get(1).getDate());
        TempDay2.setText(weatherWeek.get(1).getTemperature());
        PogodaDay2.setText(weatherWeek.get(1).getClouds());
        Veter2.setText(weatherWeek.get(1).getWind());
        ImgPogodaDay2.setImage(getImage(weatherWeek.get(1).getClouds()));

        Day3.setText(weatherWeek.get(2).getDateWeek() + ", " + weatherWeek.get(2).getDate());
        TempDay3.setText(weatherWeek.get(2).getTemperature());
        PogodaDay3.setText(weatherWeek.get(2).getClouds());
        Veter3.setText(weatherWeek.get(2).getWind());
        ImgPogodaDay3.setImage(getImage(weatherWeek.get(2).getClouds()));

        Day4.setText(weatherWeek.get(3).getDateWeek() + ", " + weatherWeek.get(3).getDate());
        TempDay4.setText(weatherWeek.get(3).getTemperature());
        PogodaDay4.setText(weatherWeek.get(3).getClouds());
        Veter4.setText(weatherWeek.get(3).getWind());
        ImgPogodaDay4.setImage(getImage(weatherWeek.get(3).getClouds()));

        Day5.setText(weatherWeek.get(4).getDateWeek() + ", " + weatherWeek.get(4).getDate());
        TempDay5.setText(weatherWeek.get(4).getTemperature());
        PogodaDay5.setText(weatherWeek.get(4).getClouds());
        Veter5.setText(weatherWeek.get(4).getWind());
        ImgPogodaDay5.setImage(getImage(weatherWeek.get(4).getClouds()));

        Day6.setText(weatherWeek.get(5).getDateWeek() + ", " + weatherWeek.get(5).getDate());
        TempDay6.setText(weatherWeek.get(5).getTemperature());
        PogodaDay6.setText(weatherWeek.get(5).getClouds());
        Veter6.setText(weatherWeek.get(5).getWind());
        ImgPogodaDay6.setImage(getImage(weatherWeek.get(5).getClouds()));

        Day7.setText(weatherWeek.get(6).getDateWeek() + ", " + weatherWeek.get(6).getDate());
        TempDay7.setText(weatherWeek.get(6).getTemperature());
        PogodaDay7.setText(weatherWeek.get(6).getClouds());
        Veter7.setText(weatherWeek.get(6).getWind());
        ImgPogodaDay7.setImage(getImage(weatherWeek.get(6).getClouds()));
    }

    private Image getImage(String clouds){
        if(clouds.toLowerCase().contains("снег"))
            return new Image(getClass().getResource("Pictures/Снег.png").getFile().substring(1));
        else if (clouds.toLowerCase().contains("дождь"))
            return new Image(getClass().getResource("Pictures/Дождь.png").getFile().substring(1));
        else if (clouds.toLowerCase().contains("пасмурно") || clouds.toLowerCase().contains("облачно"))
            return new Image(getClass().getResource("Pictures/Пасмурно.png").getFile().substring(1));
        else if (clouds.toLowerCase().contains("ясно"))
            return new Image(getClass().getResource("Pictures/sun.png").getFile().substring(1));
        else
            return new Image(getClass().getResource("Pictures/Пасмурно.png").getFile().substring(1));


        /**switch (clouds){
            case "Пасмурно" : return new Image(getClass().getResource("Pictures/Пасмурно.png").getFile().substring(1));
            case "Ясно" : return new Image(getClass().getResource("Pictures/sun.png").getFile().substring(1));
            default : return new Image(getClass().getResource("Pictures/Пасмурно.Png").getFile().substring(1));
        }**/
    }

    private Image getImageBack(String clouds){
        if(clouds.toLowerCase().contains("снег"))
            return new Image(getClass().getResource("Pictures/cnegopadBack.jpg").getFile().substring(1));
        else if (clouds.toLowerCase().contains("пасмурно") || clouds.toLowerCase().contains("облачно"))
            return new Image(getClass().getResource("Pictures/oblachnoBack.jpg").getFile().substring(1));
        else if (clouds.toLowerCase().contains("ясно"))
            return new Image(getClass().getResource("Pictures/solnecnoBack.jpg").getFile().substring(1));
        else
            return new Image(getClass().getResource("Pictures/sun.png").getFile().substring(1));

        /**switch (clouds){
            case "Пасмурно" : return new Image(getClass().getResource("Pictures/Пасмурно.png").getFile().substring(1));
            case "Ясно" : return new Image(getClass().getResource("Pictures/sun.png").getFile().substring(1));
            default : return new Image(getClass().getResource("Pictures/Пасмурно.Png").getFile().substring(1));
        }**/
    }
}