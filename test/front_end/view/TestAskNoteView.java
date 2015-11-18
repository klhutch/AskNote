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
<<<<<<< HEAD:test/front_end/view/TestAsknoteView.java
    AsknoteView asknote = new AsknoteView("Home", new ArrayList<>());  
=======
    AskNoteView asknote = new AskNoteView(new HomePagePanel(), "Home", new ArrayList<String>());  
>>>>>>> ffc86d2134a4d29c3cccd21105f0b52d811aeebf:test/front_end/view/TestAskNoteView.java
    
    f.getContentPane().add (asknote);

    // Show the frame. 
    f.setVisible (true);
    } 
    
}
