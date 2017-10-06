/*
*Author: Abdulaziz Malik
* Project: Fifteen Puzzle
* IDE: Intellij
* This is a fifteen puzzle game. It is a GUI puzzle game developed in the java programing language.
*/

import java.lang.*;
import java.awt.event.*;
import javax.swing.*;

//event handler to move buttons into the empty button spot
public class MoveEvent implements ActionListener {

    private JButton buttons[];
    private int tileNum;
    private Tiles tilesPointer[];
    private Tiles tiles[];
    private String tileContent;

    public MoveEvent(JButton Buttons[], int TileNum, String TileContent, Tiles Tile[]) {
        buttons = Buttons;
        tileNum = TileNum;
        tileContent = TileContent;
        tilesPointer = Tile;
    }

    public void actionPerformed(ActionEvent event) {
        //copies the tiles into a new tile array
        tiles = new Tiles[16];
        for (int i = 0; i < 16; i++) {
            tiles[i] = new Tiles();
            tiles[i] = tilesPointer[i];
        }

        //checks the neighbors for the button that has " " container;
        int neighbors[] = tiles[tileNum].getNeighbors();
        for (int i = 0; i < 4; i++) {
            if (tiles[tileNum].getNeighborLoc(i) != -1 && tiles[neighbors[i]].getTileContent() == " ") {

                //get a string array that will have all the contents of the buttons
                String[] tmp = new String[tiles.length];
                for (int j = 0; j < 16; j++) {
                    tmp[j] = tiles[j].getTileContent();
                }

                //update the tile array
                tiles[neighbors[i]].setTileContent(tileContent);
                tiles[tileNum].setTileContent(" ");

                //update buttons
                buttons[neighbors[i]].setText(tileContent);
                buttons[tileNum].setText(" ");

                //update the stack
                MoveHistory.stack.push(tmp);
                MoveHistory.moveNum++;
                break;
            }
        }
    }
}