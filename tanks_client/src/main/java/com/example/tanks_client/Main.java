package com.example.tanks_client;

import com.example.tanks_client.model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Main extends Application {
    protected volatile User user;


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/markup/intro.fxml"));
    }
}
