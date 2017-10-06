/*
*Author: Abdulaziz Malik
* Project: Fifteen Puzzle
* IDE: Intellij
* This is a fifteen puzzle game. It is a GUI puzzle game developed in the java programing language.
*/

import java.lang.*;

/*class thar will hold all the tile information such as the array location,
the string that will display on the button, and array index of the neighbors*/
public class Tiles {
    private int arrayLocation;
    private String tileContent;
    private int[] neighbors = new int[4]; //[0] = left, [1] = up, [2] = right, [3] = down;

    public Tiles() {
        arrayLocation = 0;
        tileContent = " ";

        for (int i = 0; i < 4; i++) {
            neighbors[i] = -999;
        }
    }

    public int getArrayLocation() {
        return arrayLocation;
    }

    public void setArrayLocation(int value) {
        this.arrayLocation = value;
    }

    public String getTileContent() {
        return tileContent;
    }

    public void setTileContent(String tileContent) {
        this.tileContent = tileContent;
    }

    public int[] getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(int left, int up, int right, int down) {
        this.neighbors[0] = left;
        this.neighbors[1] = up;
        this.neighbors[2] = right;
        this.neighbors[3] = down;
    }

    public int getNeighborLoc(int location) {
        return this.neighbors[location];
    }
}