/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.AskNoteModel;
import model.PageType;
import view.AskNoteView;
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
        frame.setSize (1000, 650);


        /// make a list of friends
        List<String> friends = new ArrayList<>(); 

        for (int i = 0; i < 100; i++) { 
            String str = "friend" + i; 
            friends.add(str); 
        }

        AskNoteModel model = AskNoteModel.instance();
        model.setFriends(friends);
        model.setCurrentPage(PageType.FRIENDS_LIST);

        try {
            AskNoteView.instance().updateView();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestFriendsList.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.add(AskNoteView.instance());
        frame.setVisible (true);
    }

    
}
