/*
*Author: Abdulaziz Malik
* Project: Fifteen Puzzle
* IDE: Intellij
* This is a fifteen puzzle game. It is a GUI puzzle game developed in the java programing language.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;


public class UndoAllEvent implements ActionListener {
    Timer time = new Timer(500, this);
    private JButton buttons[];
    private Container container;
    private int tileNum;
    private Tiles[] tile;

    public UndoAllEvent(JButton Buttons[], Container Container) {
        buttons = Buttons;
        container = Container;
    }
    public void actionPerformed(ActionEvent event) {
        while (!MoveHistory.stack.empty()) {
            //time.setDelay();

            String tmp[] = MoveHistory.stack.pop();

            for (int count = 0; count < 16; count++) {
                buttons[count].setText(tmp[count]);
            }
            container.validate();
        }
    }
}