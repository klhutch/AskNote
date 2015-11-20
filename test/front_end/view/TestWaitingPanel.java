/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import javax.swing.JFrame;
import model.Quiz;
import view.QuizEndPanel;
import view.QuizWaitingPanel;

/**
 *
 * @author Maha Alkhairy
 */
public class TestWaitingPanel {
     public static void main(String[] args) {
            // Create a frame 
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the title and other parameters. 
        frame.setTitle("AskNote");
        frame.setResizable (true);
        // Background is going to be Panel's background. 
        // f.getContentPane().setBackground (Color.cyan); 
        frame.setSize(1000, 600);

        frame.getContentPane().add(new QuizWaitingPanel(new Quiz()));

        // Show the frame. 
        frame.setVisible(true);
     } 
    
}
