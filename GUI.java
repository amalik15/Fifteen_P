/*
*Author: Abdulaziz Malik
* Project: Fifteen Puzzle
* IDE: Intellij
* This is a fifteen puzzle game. It is a GUI puzzle game developed in the java programing language.
* */

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//this class will create the GUI with the tile buttons and the menu bar
public class GUI extends JFrame {

    private JLabel displayLabel;
    private static JButton buttons[];
    private Container container;
    private GridLayout grid;

    // set up GUI
    public GUI(Tiles[] tile, int tileNum) {
        super("Fifteen Puzzle");

        // set up File menu and its menu items
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JLabel displayLabel = new JLabel();
        displayLabel.setText("Complexity: " + MoveHistory.complexity);

        // set up About... menu item
        JMenuItem aboutItem = new JMenuItem("About");
        fileMenu.add(aboutItem);

        aboutItem.addActionListener(
                new ActionListener() { // anonymous inner class
                    // display message dialog when user selects About...
                    public void actionPerformed(ActionEvent event) {
                        JOptionPane.showMessageDialog(GUI.this,
                                "Project: Fifteen Puzzle\nAuthor: Abdulaziz Malik\nDate:10/3/2017",
                                "About", JOptionPane.PLAIN_MESSAGE);
                    }
                } // end anonymous inner class
        ); // end call to addActionListener

        // set up undo menu item
        JMenuItem undoItem = new JMenuItem("Undo");
        fileMenu.add(undoItem);

        // set up undoAll menu item
        JMenuItem undoAllItem = new JMenuItem("Undo All");
        fileMenu.add(undoAllItem);

        // set up mix menu item
        JMenuItem mixItem = new JMenuItem("Mix");
        fileMenu.add(mixItem);

        // set up Help menu item
        JMenuItem helpItem = new JMenuItem("Help");
        fileMenu.add(helpItem);

        helpItem.addActionListener(
                new ActionListener() { // anonymous inner class
                    // display message dialog when user selects About...
                    public void actionPerformed(ActionEvent event) {
                        JOptionPane.showMessageDialog(GUI.this,
                                "About: Desplay author information\nUndo: undo last move\nUndo " +
                                        "All: rest's the board to the start\nMix: rearrange the board",
                                "About", JOptionPane.PLAIN_MESSAGE);
                    }
                } // end anonymous inner class
        ); // end call to addActionListener


        // set up Exit menu item
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        exitItem.addActionListener(
                new ActionListener() { // anonymous inner class
                    // terminate application when user clicks exitItem
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                } // end anonymous inner class
        ); // end call to addActionListener

        // create menu bar and attach it to GUI window
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu);
        bar.add(displayLabel);

        grid = new GridLayout(4, 4); //create a 4X4 grid for the gui buttons

        //get content pane and set its layout
        container = getContentPane();
        container.setLayout(grid);

        // create and add buttons
        buttons = new JButton[tileNum];

        //add contents to the buttons and attach event handlers
        for (int count = 0; count < tileNum; count++) {
            buttons[count] = new JButton(tile[count].getTileContent());

            MoveEvent moveEvent = new MoveEvent(buttons, count, tile[count].getTileContent(), tile);
            buttons[count].addActionListener(moveEvent);

            container.add(buttons[count]);
        }

        //create even handlers for undo, undo all, mix
        UndoEvent undo = new UndoEvent(buttons, container);
        UndoAllEvent undoAll = new UndoAllEvent(buttons, container);
        MixEvent mix = new MixEvent(buttons, tile, container);
        undoAllItem.addActionListener(undoAll);
        undoItem.addActionListener(undo);
        mixItem.addActionListener(mix);

        //create 400x400 pixel gui
        setSize(400, 400);
        setVisible(true);

    }

}