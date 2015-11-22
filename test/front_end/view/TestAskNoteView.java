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
        JFrame frame = new JFrame(); 
        frame.setTitle("AskNote");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 650);
        
        AskNoteView asknote = AskNoteView.instance();      
        frame.add(asknote);

        // Show the frame. 
        frame.setVisible (true);
    } 
    
}
