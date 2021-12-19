package com.example.tanks_client.controllers;

import com.example.tanks_client.model.User;
import com.example.tanks_protocol.UserAction;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu {
    User user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private void exit(MouseEvent e){
        user.setAction(UserAction.EXIT);
        System.exit(0);
    }
    public void setUser(User user){
        this.user = user;
    }

}
