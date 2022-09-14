/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * <h1>Sudoku Clicker Class</h1>
 * This is the clicking handler class for the Sudoku game.
 * This class implements the ActionListener interface. This
 * class determine what to do when each button is pressed 
 * in the game.
 * 
 * @author caoquan
 * @version 1.0
 * @since 2022-02-15
 */
public class Clicker implements ActionListener {

    private Sudoku1 sudoku;
    /**
     * This is the class constructor.
     * 
     * @param sudoku - the Game object 
     */
    public Clicker(Sudoku1 sudoku) {
        this.sudoku = sudoku;
    }
    
    /**
     * This method is used to determine what happen when a button
     * is pressed in the game.
     * 
     * @param e - the action event
     */
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        if (Sudoku1.winstate == false) {
            if (b instanceof Button == true) {
                Button v = (Button)e.getSource();
                // Setting the game curNum value to the pressed button
                if (sudoku.curNum != 0) {
                    v.showNum(sudoku.curNum);
                }
                sudoku.checkWin();
            } else if (b instanceof NumPad == true){
                NumPad p = (NumPad)e.getSource();
                // Setting the value of the pressed button on the numpad
                // to the curNum variable on the main game
                sudoku.curNum = p.npCurrentNum;
            }   
        }        
    }
}
