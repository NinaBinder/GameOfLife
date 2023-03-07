package com.example.gameoflife;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HelloModel model = new HelloModel();
        HelloController controller = new HelloController();
        HelloView view= new HelloView();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        //Erzeugen und starten eines AnimationTimer Objekts, welches in regelmäßigen
        //Intervallen einen Zug der Simulation ausführt.

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Game of Life");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}