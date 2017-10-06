/*
*Author: Abdulaziz Malik
* Project: Fifteen Puzzle
* IDE: Intellij
* This is a fifteen puzzle game. It is a GUI puzzle game developed in the java programing language.
*/

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//event handler to undo last move
public class UndoEvent implements ActionListener{

    private JButton buttons[];
    private Container container;

    public UndoEvent(JButton Buttons[], Container Container){

        buttons = Buttons;
        container = Container;
    }
    public void actionPerformed( ActionEvent event)
    {
        //pops the last button layout from the move stack and update the buttons
        if(!MoveHistory.stack.empty()) {
            String tmp[] = MoveHistory.stack.pop();
            for (int count = 0; count < 16; count++) {
                buttons[count].setText(tmp[count]);
            }

            container.validate();
        }
    }
}
