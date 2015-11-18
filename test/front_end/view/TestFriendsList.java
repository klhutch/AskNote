/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import view.FriendsListPanel;

/**
 *
 * @author Maha Alkhairy
 */
public class TestFriendsList {
     public static void main (String[] argv) {
    // Create a frame 
    JFrame f = new JFrame ();

    // Set the title and other parameters. 
    f.setTitle ("AskNote");
    f.setResizable (true);
    // Background is going to be Panel's background. 
    // f.getContentPane().setBackground (Color.cyan); 
    f.setSize (500, 600);
    
    /// make a FriendsList
    List<String> frnds = new ArrayList<>(); 
    
    for (int i = 0; i < 100; i++) { 
         String str = "friend" + i; 
         frnds.add(str); 
     }
    
   
    ////
    
    FriendsListPanel flst = new FriendsListPanel(frnds); 
   
    f.getContentPane().add (flst);

    // Show the frame. 
    f.setVisible (true);
  }

    
}
