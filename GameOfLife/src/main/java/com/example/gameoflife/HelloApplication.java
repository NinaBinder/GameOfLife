package com.example.gameoflife;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Model model = new Model (80,50);
        View view = new View (stage);
        Controller controller = new Controller (model,view);
        controller.init();

        AnimationTimer gameLoop = new AnimationTimer() {
            long lastFrame = 0;
            @Override
            public void handle(long l) {
                if (l-lastFrame>100000000) {
                    controller.doTurn();
                    lastFrame = l;
                }
            }
        };
        gameLoop.start();

        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}