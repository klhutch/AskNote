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
        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the title and other parameters. 
        frame.setTitle ("AskNote");
        frame.setResizable (true);
        // Background is going to be Panel's background. 
        // f.getContentPane().setBackground (Color.cyan); 
        frame.setSize (500, 600);

<<<<<<< HEAD
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
=======
        /// make a FriendsList
        List<User> friends = new ArrayList<User>(); 
        User jane = new User("Jane", 90); 
        User jeff = new User("Jeff", 89); 
        User tom = new User("Tom", 90); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom);
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom); 
        friends.add(tom); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom);
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom); 
        friends.add(tom); 
        friends.add(jane); 
        friends.add(jeff); 
        friends.add(tom);
        friends.add(jane); 
        ////

        FriendsListPanel flst = new FriendsListPanel(friends); 

        frame.getContentPane().add (flst);
>>>>>>> 81116294f9e28c18943233eb9318677846228280

        // Show the frame. 
        frame.setVisible (true);
  }

    
}
