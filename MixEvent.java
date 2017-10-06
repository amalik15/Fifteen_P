/*
*Author: Abdulaziz Malik
* Project: Fifteen Puzzle
* IDE: Intellij
* This is a fifteen puzzle game. It is a GUI puzzle game developed in the java programing language.
* */

import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;

//event handler to mix board
public class MixEvent implements ActionListener {
    private JButton buttons[];
    private Tiles tilesPointer[];
    private Tiles tiles[];
    private Container container;


    public MixEvent(JButton Buttons[], Tiles Tile[], Container Container) {
        buttons = Buttons;
        tilesPointer = Tile;
        container = Container;
    }

    public void actionPerformed(ActionEvent event) {

        //get a rearranged number array
        int mixArray[] = TileArrayMaker.arrayRandom(tilesPointer.length);

        //make a new copy of the tile array
        tiles = new Tiles[tilesPointer.length];
        for (int i = 0; i < 16; i++) {
            tiles[i] = new Tiles();
            tiles[i] = tilesPointer[i];
        }

        //replace the button content
        for (int i = 0; i < tiles.length; i++) {
            if (mixArray[i] != 16) {
                tiles[i].setTileContent(Integer.toString(mixArray[i]));
                buttons[i].setText(Integer.toString(mixArray[i]));
            }
            else{
                tiles[i].setTileContent(" ");
                buttons[i].setText(" ");
            }
            container.validate();
        }

        //empty the stack
        String tmp[] = new String[tiles.length];
        while(!MoveHistory.stack.empty()){
            tmp = MoveHistory.stack.pop();
        }

        //make a string array with all the button content
        for (int j = 0; j < 16; j++) {
            tmp[j] = tiles[j].getTileContent();
        }

        //push the button content to the stack
        MoveHistory.stack.push(tmp);
        MoveHistory.moveNum++;
    }

}