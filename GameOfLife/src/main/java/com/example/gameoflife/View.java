package com.example.gameoflife;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class View {
    Stage stage;
    Scene scene;

    BorderPane mainFrame;
    HBox guiElements;
    Button randomButton;
    Label blinkerLabel;
    Label gliderLabel;

    GridPane world;

    public View (Stage s) {
        stage = s;
    }

    void initView (int width, int height) {
        mainFrame = new BorderPane();
        guiElements = new HBox();
        world = new GridPane();
        randomButton = new Button("random world");
        blinkerLabel = new Label("Blinker");
        gliderLabel = new Label("Glider");

        for (int i=0; i<width*height; i++) {
            Rectangle cell = new Rectangle(10,10);
            cell.setFill(Color.GREY);
            cell.setStroke(Color.LIGHTGRAY);
            cell.setId(""+i);
            world.add(cell,i%width,i/width);
        }

        guiElements.getChildren().add(blinkerLabel);
        guiElements.getChildren().add(randomButton);
        guiElements.getChildren().add(gliderLabel);
        guiElements.setPadding(new Insets(15, 12, 15, 12));
        guiElements.setSpacing(10);
        guiElements.setAlignment(Pos.CENTER);
        mainFrame.setCenter(world);
        mainFrame.setBottom(guiElements);

        scene = new Scene(mainFrame);
        stage.setScene(scene);
    }

    void updateView (State[][] w) {

        for (int x=0; x<w.length; x++) {
            for (int y=0; y<w[0].length; y++) {
                int i = x + y*w.length;
                State state = w[x][y];
                Shape cell = (Shape) world.getChildren().get(i);
                cell.setFill((state==State.LIVE) ? Color.BLACK : Color.WHITE);
            }
        }
    }

    GridPane getWorld () {
        return world;
    }

    Button getRandomButton () {
        return randomButton;
    }

    Label getBlinkerLabel () {
        return blinkerLabel;
    }

    Label getGliderLabel () {
        return gliderLabel;
    }
}