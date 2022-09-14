/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudoku1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


/**
 * <h1>Sudoku Main Game Class</h1>
 * This is the main class for the 9x9 Sudoku game. This class constructs
 * the number on the game, setting buttons for each number and constructs
 * the number pad to input value into the empty space in the game. This
 * class handle most function of the game such as checking the correct
 * number and declaring the win-state of the game.
 * 
 * @author caoquan
 * @version 1.0
 * @since 2022-02-15
 */
public class Sudoku1 extends JFrame {
    static int [][] sudokuArr = { {5, 3, 4, 6, 1, 7, 8, 9, 2},
                                {2, 8, 6, 9, 3, 5, 7, 1, 4},
                                {9, 7, 1, 8, 4, 2, 3, 5, 6},
                                {6, 9, 5, 7, 2, 4, 1, 8, 3},
                                {1, 2, 8, 3, 9, 6, 4, 7, 5},
                                {3, 4, 7, 1, 5, 8, 6, 2, 9},
                                {4, 1, 9, 5, 8, 3, 2, 6, 7},
                                {8, 6, 2, 4, 7, 9, 5, 3, 1},
                                {7, 5, 3, 2, 6, 1, 9, 4, 8} };

    /*static boolean [][] spaceOrNot = {{true, false, true, true, false, true, false, true, true},
                                    {true, true, false, false, false, false, true, true, false},
                                    {true, true, true, true, true, false, true, false, true},
                                    {true, true, true, true, false, true, false, true, false},
                                    {false, true, true, true, true, false, true, true, true},
                                    {true, false, false, true, false, true, true, false, false},
                                    {true, true, false, true, true, true, true, false, false},
                                    {false, true, true, false, false, true, true, true, true},
                                    {true, false, true, false, true, false, true, false, true} };*/
    static boolean [][] spaceOrNot = {{true, true, true, true, true, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true},
                                    {true, true, true, true, false, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true},
                                    {true, true, true, true, true, true, true, true, true},
                                    {true, true, true, true, true, true, false, true, false} };
    
    JPanel[][] sections;
    static Button[][] buttons;
    int curNum;
    static Button[][] buttons2 = new Button[9][9];
    static boolean winstate = false;
    
    /**
     * Constructor for the main game class.
     */
    public Sudoku1() {
        super ("Sudoku");
        
    }
    /**
     * This method is used to construct a window frame containing the buttons
     * in the Sudoku game and the number pad. The method constructs a 9x9 array
     * of Sudoku buttons and a 3x3 array of number pad buttons.
     */
    private void createGUI() {
        //JFrame basic settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        JPanel everything = new JPanel();
        JPanel panel = new JPanel();
        JPanel padPanel = new JPanel();
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));
        padPanel.setBorder(new EmptyBorder(10, 0, 10, 50));
        GridLayout layout = new GridLayout(3,3);
        panel.setLayout(layout);
        padPanel.setLayout(layout);
        sections = new JPanel[3][3];
        buttons = new Button[9][9];
        Color c1 = new Color(204,255,229);
        everything.setBackground(c1);
        panel.setBackground(c1);
        padPanel.setBackground(c1);
        
        Clicker click = new Clicker(this);
        
        // Nested for loop constructing the panels and sudoku button
        for (int pRow = 0; pRow < 3;pRow++) {
            for (int pCol = 0; pCol < 3; pCol++) {
                // Adding the panels
                sections[pRow][pCol] = new JPanel();
                sections[pRow][pCol].setLayout(layout);
                sections[pRow][pCol].setBorder(blackLine);
                panel.add(sections[pRow][pCol]);
                for (int bRow = 0; bRow < 3; bRow++) {
                    for (int bCol = 0; bCol < 3; bCol++){
                        // Adding the buttons
                        buttons[bRow][bCol] = new Button(sudokuArr[pRow*3+bRow][pCol*3+bCol], 
                                                         spaceOrNot[pRow*3+bRow][pCol*3+bCol]);
                        buttons2[pRow*3+bRow][pCol*3+bCol] = buttons[bRow][bCol];
                        buttons[bRow][bCol].addActionListener(click);
                        sections[pRow][pCol].add(buttons[bRow][bCol]);
                    }
                } 
            }
        }
        // Constructing the numpad buttons
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                k++;
                NumPad np = new NumPad(k);
                padPanel.add(np);
                np.addActionListener(click);
            }
        }
        // Adding all the panel
        everything.add(panel);
        everything.add(padPanel);
        this.add(everything);
        this.pack();  
    }    
    /**
     * This method is used to check if the empty space of the game
     * have the correct number in it. If one number is wrong, the 
     * game will continue playing until all the buttons have the
     * correct number. If all number is correct. It will activate
     * the winFrame method.
     */
    public void checkWin() {
        boolean correct = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Loop through all button to check the correct value
                if (Sudoku1.buttons2[i][j].displayNum != Sudoku1.buttons2[i][j].correctNum) {
                    // If one button have the incorrect value then set
                    // the game-state to lose
                    correct = false;
                    System.out.println(Sudoku1.buttons2[i][j].displayNum);
                    System.out.println(Sudoku1.buttons2[i][j].correctNum);
                }
            }
        }
        if (correct == true) {
            // If all buttons have correct value then activate the winFrame method
            // Wining the game
            System.out.println("Win");
            winScreen();
        }
    }
    /**
     * This method is made to declare the you have won the game.
     * By creating a JFrame with label.
     */
    private void winScreen() {
        winstate = true;
        JFrame winFrame = new JFrame();
        winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winFrame.setVisible(true);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("You Win!");
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setBorder(new EmptyBorder(50, 50, 50, 50));
        panel.add(label);
        panel.setBackground(Color.white);
        winFrame.add(panel);
        winFrame.pack();
        
    }
    /**
     * This is the main method that initialize the GUI of the game.
     * @param args Unused.
     */
    public static void main(String[] args) {

        Sudoku1 sudoku = new Sudoku1();
        
        sudoku.createGUI();
        System.out.println(Sudoku1.buttons2[4][2].correctNum);
    }    
}
    
