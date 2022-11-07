package com.weather.weatherprog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage curStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1360, 768);
        stage.setTitle("Погода");
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResource("Pictures/iconpng.png").getFile().substring(1)));
        stage.setScene(scene);
        curStage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}