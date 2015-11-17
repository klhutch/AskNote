/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.User;
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
    List<User> frnds = new ArrayList<User>(); 
    User jane = new User("Jane", 90); 
    User jeff = new User("Jeff", 89); 
    User tom = new User("Tom", 90); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom);
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom); 
    frnds.add(tom); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom);
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom); 
    frnds.add(tom); 
    frnds.add(jane); 
    frnds.add(jeff); 
    frnds.add(tom);
    frnds.add(jane); 
    ////
    
    FriendsListPanel flst = new FriendsListPanel(frnds); 
   
    f.getContentPane().add (flst);

    // Show the frame. 
    f.setVisible (true);
  }

    
}
