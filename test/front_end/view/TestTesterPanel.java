/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

<<<<<<< HEAD
import java.awt.EventQueue;
import javax.swing.JFrame;
import model.Flashcard;
import view.TesterPanel;

/**
 *
 * @author tiffanychao
 */
public class TestTesterPanel extends JFrame {
    
    public static void main (String[] argv) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestTesterPanel().setVisible(true);
            }
        });
    }

    private TestTesterPanel() {
        setTitle("AskNote");
        setResizable(true);
        setSize(500, 600);
        
        Flashcard f1 = new Flashcard("red", "green");
        
        TesterPanel tp = new TesterPanel(f1, "blue");
        getContentPane().add(tp);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
=======
import javax.swing.*;
import view.*;
import model.*;

/**
 *
 * @author Maha Alkhairy
 */
public class TestTesterPanel {
     public static void main (String[] argv) {
        // Create a frame 
        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the title and other parameters. 
        frame.setTitle ("AskNote");
        frame.setResizable (true);
        // Background is going to be Panel's background. 
        // f.getContentPane().setBackground (Color.cyan); 
        frame.setSize (500, 600);
        
        FlashCard card1= new FlashCard("d","dd");
        
        frame.getContentPane().add (new TesterPanel(card1, "dS"));

        // Show the frame. 
        frame.setVisible (true);
     } 
    
>>>>>>> ffc86d2134a4d29c3cccd21105f0b52d811aeebf
}
