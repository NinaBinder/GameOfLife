package com.example.gameoflife;

enum State {LIVE,DEAD}
public class Model {
    int width, height;
    State [][] world;

    boolean drawing;

    public Model (int w, int h) {
        width = w;
        height = h;
        world = new State[w][h];
        randomize();
    }

    int countNeighbours (int x, int y) {
        int count = 0;
        for (int dx=-1; dx<2; dx++) {
            for (int dy=-1; dy<2; dy++) {
                if (dx==0 && dy==0) ;
                else if (x+dx>=0 && x+dx<width && y+dy>=0 && y+dy<height) {
                    if (world[x+dx][y+dy]==State.LIVE) count++;
                }
            }
        }
        return count;
    }
    void doTurn () {
        State[][] nextWorld = new State[width][height];
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                State nextState = world[x][y];
                int count = countNeighbours(x,y);
                if (nextState==State.LIVE && (count==2 || count==3));
                else if (nextState==State.DEAD && count==3) nextState = State.LIVE;
                else nextState = State.DEAD;
                nextWorld[x][y] = nextState;
            }
        }
        world = nextWorld;
    }

    void setPattern (int x, int y, String p) {
        switch (p) {
            case "Glider":
                State [][] glider = new State[][] {
                        new State [] {State.DEAD,State.LIVE,State.DEAD},
                        new State [] {State.DEAD,State.DEAD,State.LIVE},
                        new State [] {State.LIVE,State.LIVE,State.LIVE}
                };
                setPattern(x,y,glider);
                break;
            case "Blinker":
                State [][] blinker = new State[][] {
                        new State [] {State.LIVE,State.LIVE,State.LIVE}
                };
                setPattern(x,y,blinker);
                break;
        }
    }

    void setPattern (int x, int y, State[][] p) {
        for (int dx=0; dx<p.length; dx++) {
            for (int dy=0; dy<p[0].length; dy++) {
                State s = p[dx][dy];
                setState(x+dx,y+dy,s);
            }
        }
    }

    void setState (int x, int y, State s) {
        if (x>=0 && x<width && y>=0 && y<height)
            world[x][y] = s;
    }
    State getState (int x, int y) {
        return world[x][y];
    }

    State[][] getWorld () {
        return world;
    }

    int getWidth () {
        return width;
    }
    int getHeight () {
        return height;
    }

    void setDrawing (boolean d) {
        drawing = d;
    }

    boolean getDrawing () {
        return drawing;
    }

    void randomize () {
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                world[x][y] = (Math.random()>0.5)?State.DEAD:State.LIVE;
            }
        }
    }
}
