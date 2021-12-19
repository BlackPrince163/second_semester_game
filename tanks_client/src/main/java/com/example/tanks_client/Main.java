package com.example.tanks_client;

import com.example.tanks_client.controllers.IntroController;
import com.example.tanks_client.model.User;
import com.example.tanks_protocol.UserAction;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {
    protected volatile User user;

    @Override
    public void start(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/markup/intro.fxml"));

            Parent root = loader.load();

            this.user = new User();
            AppClient appClient = new AppClient(user);

            user.setAction(UserAction.INTRO_MENU);

            IntroController controller = loader.getController();
            controller.setUser(user);

            while(appClient.getMessageAccepter() == null){
            }

            controller.setMessageAccepter(appClient.getMessageAccepter());

            primaryStage.setTitle("Pixel Battle");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(true);
            primaryStage.setFullScreenExitHint("");
            primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Throwable {
        launch(args);
    }
}

