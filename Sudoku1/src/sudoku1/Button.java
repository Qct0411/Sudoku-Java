/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 * <h1>Sudoku Button Class</h1>
 * This is the Button class of the Sudoku game which handle
 * the main game buttons. This class inherits the JButton class.
 * 
 * @author caoquan
 * @version 1.0
 * @since 2022-02-15
 */
public class Button extends JButton {
    
    Boolean displayed;
    Boolean defButton;
    int displayNum;
    int correctNum;
    Color c2 = new Color(242,242,242);
    /**
     * This is the Button class constructor with two parameters
     * 
     * @param num - This constructor input an int value to set
     * the button display value and correct value
     * @param visible - This constructor input a Boolean value
     * to determine if the button is a concrete button or a 
     * blank button
     */
    public Button(int num, boolean visible) {
        defButton = visible;
        correctNum = num;
        this.setPreferredSize(new Dimension(70,70));
        this.setBackground(Color.white);
        if (visible == true) {
            this.setText(String.valueOf(num));
            this.setFont(new Font("Arial", Font.PLAIN, 40));
            this.setBackground(c2);
            displayNum = num;
        }
    }
    /**
     * This method collect an int value to display on the blank
     * buttons
     * 
     * @param num - The int value to be displayed on the blank button.
     */
    public void showNum(int num) {
        if (this.defButton == false) {
            displayNum = num;
            this.setText(String.valueOf(displayNum));
            this.setFont(new Font("Arial", Font.ITALIC, 40));
        }
    }
}
