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
 * <h1>Sudoku NumPad Class</h1>
 * This is the NumPad class for the Sudoku game. This class
 * is a button class that inherits the JButton class. 
 * 
 * @author caoquan
 * @version 1.0
 * @since 2022-02-15
 */
public class NumPad extends JButton {
    
    int npCurrentNum;
    /**
     * This is a constructor of the NumPad class.
     * 
     * @param num - This constructor input an int to set the
     * display value of the number pad button and the number
     * pad value.
     */
    public NumPad(int num) {
        this.setPreferredSize(new Dimension(70,70));
        this.setBackground(Color.white);
        this.setFont(new Font("Arial", Font.PLAIN, 40));
        this.setText(String.valueOf(num));
        npCurrentNum = num;
    }
}
