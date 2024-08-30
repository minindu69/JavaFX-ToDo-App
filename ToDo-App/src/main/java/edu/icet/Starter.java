package edu.icet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage){
        try {
            primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../../view/add_todo.fxml")))));
        } catch (IOException e) {
            //loading error
            throw new RuntimeException(e);
        }
//        primaryStage.getIcons().add(new Image("img/dashboard.png"));
        primaryStage.setTitle("Add ToDos");
        primaryStage.setResizable(false);
        primaryStage.show();

        //get DB connection

        //application exits
        primaryStage.setOnCloseRequest(e->{
            Platform.exit(); // dispose the JavaFX toolkit
            System.exit(0); // shutdown the JVM
        });

    }
}

