/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.util.ArrayList;
import javax.swing.JFrame;
import view.*;

/**
 *
 * @author Maha Alkhairy
 */
public class TestAskNoteView {
    public static void main (String[] argv) {
    JFrame f = new JFrame ();
    

    // Set the title and other parameters. 
    f.setTitle ("AskNote");
    f.setResizable (true);
    // Background is going to be Panel's background. 
    // f.getContentPane().setBackground (Color.cyan); 
    f.setSize (500, 600);
    AsknoteView asknote = new AsknoteView("Home", new ArrayList<>());      
    f.getContentPane().add(asknote);

    // Show the frame. 
    f.setVisible (true);
    } 
    
}
