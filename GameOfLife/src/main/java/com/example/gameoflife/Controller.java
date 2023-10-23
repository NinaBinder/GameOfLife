package com.example.gameoflife;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Controller {

    Model model;
    View view;

    public Controller (Model m, View v) {
        model = m;
        view = v;
    }

    void init () {
        view.initView(model.getWidth(),model.getHeight());
        view.updateView(model.getWorld());

        view.getRandomButton().setOnAction(e -> {
            model.randomize();
            view.updateView(model.getWorld());
        });

        Label blinker = view.getBlinkerLabel();
        blinker.setOnDragDetected(e -> {
            System.out.println("drag started");
            Dragboard db = blinker.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(blinker.getText());
            db.setContent(content);
            e.consume();
        });

        Label glider = view.getGliderLabel();
        glider.setOnDragDetected(e -> {
            System.out.println("drag started");
            Dragboard db = glider.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(glider.getText());
            db.setContent(content);
            e.consume();
        });

        GridPane gui = view.getWorld();
        for (int i=0; i<model.getWidth()*model.getHeight(); i++) {
            Shape cell = (Shape) gui.getChildren().get(i);
            cell.setOnMousePressed(e -> {
                System.out.println("pressed");
                model.setDrawing(true);
            });
            cell.setOnMouseReleased(e -> {
                System.out.println("released");
                model.setDrawing(false);
            });
            cell.setOnMouseDragEntered(e -> {
                if (model.getDrawing()) {
                    System.out.println("*");
                    Node n = (Node)e.getSource();
                    System.out.println(n.getId());
                    int id = Integer.parseInt(n.getId());
                    int x = id%model.getWidth();
                    int y = id/model.getWidth();
                    State currentState = model.getState(x,y);
                    model.setState(x,y,(currentState==State.DEAD)?State.LIVE:State.DEAD);
                    view.updateView(model.getWorld());
                }
            });
            cell.setOnMouseClicked(e -> {
                Node n = (Node)e.getSource();
                System.out.println(n.getId());
                int id = Integer.parseInt(n.getId());
                int x = id%model.getWidth();
                int y = id/model.getWidth();
                State currentState = model.getState(x,y);
                model.setState(x,y,(currentState==State.DEAD)?State.LIVE:State.DEAD);
                view.updateView(model.getWorld());
            });
            cell.setOnDragOver(e -> {
                if (e.getGestureSource() != cell && e.getDragboard().hasString()) {
                    e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                e.consume();
            });
            cell.setOnDragDropped(e -> {
                Dragboard db = e.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    Node n = (Node)e.getSource();
                    int id = Integer.parseInt(n.getId());
                    int x = id%model.getWidth();
                    int y = id/model.getWidth();

                    String pattern = db.getString();
                    System.out.println("set: "+pattern);
                    model.setPattern(x,y,pattern);
                    success = true;
                }
                e.setDropCompleted(success);
                e.consume();
            });
        }
    }

    void doTurn () {
        model.doTurn();
        view.updateView(model.getWorld());
    }


}