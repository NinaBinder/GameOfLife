package com.example.gameoflife;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    public HelloModel model;
    public HelloView view;
    public void HelloController(){

    }
    //Peiyang und Seda
    //1. init(): die init Methode macht Folgendes:
    //(1) Initialisieren und Updaten der View,
    //(2) setzen der Event Handler auf allen GUI Elementen (Drag and Drop, Button Action)
    //und den Zellen des Spielfelds (Mouse Clicked).
    public void init(){

        view.initView(/*int x,int y*/);
        view.updateView(/*State [][] w*/);
    }


    //2. doTurn(): Ausführen eines Schritts in der Game of Life Simulation.
    // (1) Zug im Model ausführen
    // (2) View updaten.
    public void doTurn(){

        view.updateView(/*State [][] w*/);
    }
}