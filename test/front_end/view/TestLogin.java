/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import javax.swing.JFrame;
import view.*;

/**
 *
 * @author Maha Alkhairy
 */
public class TestLogin {
    public static void main (String[] argv) {
    // Create a frame 
    JFrame f = new JFrame ();

    // Set the title and other parameters. 
    f.setTitle ("AskNote");
    f.setResizable (true);
    // Background is going to be Panel's background. 
    // f.getContentPane().setBackground (Color.cyan); 
    f.setSize (500, 600);
    
    f.getContentPane().add (new LoginPanel());

    // Show the frame. 
    f.setVisible (true);
     } 
}
