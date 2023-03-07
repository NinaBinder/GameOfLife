package com.example.gameoflife;

enum State {LEBENDIG,TOT}
public class HelloModel {

    int dimension;
    //Integer Variablen width und height in denen die Dimensionen des Felds
    //gespeichert sind.
    int width = 2*dimension;
    int height = dimension;

    //Ein Zweidimensionales Array vom Typ State mit dem Namen world.
    State[][] world;

    public void HelloModel(){
        // this.dimension = dimension;
        //this.world = new State[dimension][dimension];
        this.world = new State[width][height];
    }
//Alice und Nina (Peiyang)
    //1. getter und setter für die Felder der Klasse (z.B. getWidth())

    //2. eine getState(int x, int y) und setState(int x, int y, State s)
    //Methode, die den Zugriff auf einzelne Zellen der world ermöglichen. Diese
    //Methoden sollten überprüfen, ob die zu lesende/schreibende Position innerhalb des
    //Arrays liegt.

    //3. eine Methode countNeighbors(int x, int y), welche die Anzahl der
    //lebendigen Zellen in den 8 angrenzenden Zellen um x/y zurückgibt. Beachte die
    //Ecken und Ränder!

    //4. eine Methode randomizeWorld(), welche alle Zellen der Welt auf einen zufälligen
    //State setzt.

 //Peiyang und Seda
    //5. eine Methode setPattern(int x, int y, String p), welche die besonderen
    //Zellen-Konstellationen mit dem Name p ausgehend von x/y setzt (siehe Objekte)

    //6. eine Methode setPattern (int x, int y, State[][] p), welche eine
    //Zellen-Konstellation beschrieben durch p um x/y setzt. Diese Methode soll in
    //setPattern(int x, int y, String p) verwendet werden um Pattern-Namen
    //in States umzusetzen

}
