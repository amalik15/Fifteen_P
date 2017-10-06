/*
*Author: Abdulaziz Malik
* Project: Fifteen Puzzle
* IDE: Intellij
* This is a fifteen puzzle game. It is a GUI puzzle game developed in the java programing language.
* */

import java.lang.*;
import javax.swing.*;

//this is the main class that will start the game
public class Game extends TileArrayMaker {
    public static void main(String[] args){

        //create the necessary tile objects for each button on the board
        int tileNum = 16;
        Tiles[] tile = new Tiles[tileNum];
        createTials(tile, tileNum);
        setNeighbors(tile, tileNum);

        //makes a gui object that will create the gui
        GUI gui = new GUI(tile, tileNum);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}