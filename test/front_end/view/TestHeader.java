/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.net.MalformedURLException;
import javax.swing.*;
import view.*;

/**
 *
 * @author Maha Alkhairy
 */
public class TestHeader {

    public static void main (String[] argv) throws MalformedURLException {
    JFrame f = new JFrame ();
    

    // Set the title and other parameters. 
    f.setTitle ("AskNote");
    f.setResizable (true);
    // Background is going to be Panel's background. 
    // f.getContentPane().setBackground (Color.cyan); 
    f.setSize (1000, 600);
    
    f.getContentPane().add (new HeaderPanel("Home", 0));

    // Show the frame. 
    f.setVisible (true);
    } 
}
