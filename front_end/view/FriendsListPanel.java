/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.*;

/**
 *
 * @author Maha Alkhairy
 */


public class FriendsListPanel extends JPanel {
    JList friendList;
    List<String> friends;
    
    public FriendsListPanel(List<String> friends) throws MalformedURLException { 
        this.friends = friends;
        BorderLayout border = new BorderLayout(); 
        
        JPanel left = new JPanel(); 
        left.setLayout(border);
        
        Constants constant = new Constants();
        
        GridLayout grid2 = new GridLayout(); 
        grid2.setColumns(2);
        grid2.setRows(-1); 
        
        this.setLayout(grid2);
        
        
        
                                    
         if (friends.size() > 0) {
                this.friendList = new JList(friends.toArray());
                this.friendList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                
            }
            else {
                String[] friendArray = {"No Friends Added"};
                this.friendList = new JList(friendArray);
            }
        
          
         
        OptionPanel add = new OptionPanel(constant.getImage("Add"), "Add Friend");     
        OptionPanel delete = new OptionPanel(constant.getImage("Delete"), "Delete"); 
        
        List<OptionPanel> options = new ArrayList<>();
        options.add(add); 
        options.add(delete);
        
        
        SelectionPanel right = new SelectionPanel(options); 

         
        add.button.addActionListener(new AddFriendListener());
        delete.button.addActionListener(new RemoveFriendsListener());

        left.add(friendList, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(left); 
        
        this.add(scroll); 
        this.add(right); 
        this.validate(); 
    }    

    class AddFriendListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            String msg = "Add New Friend";
            String newText = JOptionPane.showInputDialog(AskNoteView.instance(), msg, "Friend's Name");

            if (newText != null && !newText.equals("")) {
                AskNoteModel.instance().addFriend(newText);
                try {
                    AskNoteView.instance().updateView();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(FriendsListPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    class RemoveFriendsListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
                
                int index = FriendsListPanel.this.friendList.getMinSelectionIndex();
                
                   
                String msg = "Are you sure that you want to remove this friend?" ;
                int response = JOptionPane.showConfirmDialog(FriendsListPanel.this, msg,
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (response == JOptionPane.YES_OPTION) {
                    if (index >= 0) {
                    String friend = FriendsListPanel.this.friends.get(index);
                    
                   
                    model.deleteFriend(friend);
                        try {
                            AskNoteView.instance().updateView();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(FriendsListPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                    
              }
                
              
        }
    }

    class SelectAllListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

    }

    class UnselectAllListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

    }
   
    class OptionPanel  extends JPanel { 
           JButton button; 
           JLabel label; 
        OptionPanel(ImageIcon icon, String label) { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEADING);
            JButton bttn = new JButton(icon); 
            JLabel lbl = new JLabel(label); 

            Font font = new Font("SanSarif", Font.BOLD, 20); 

            lbl.setFont(font);
            bttn.setFont(font);
             
            this.button = bttn; 
            
            flow.setHgap(25);
            this.setMaximumSize(new Dimension(500, 100));

            this.setLayout(flow); 
            this.add(bttn); 
            this.add(lbl); 
            
            this.validate();

        }
    }

    /**
     *
     * @author Maha Alkhairy
     */
    class SelectionPanel extends JPanel{
        // takes nothing in 
        SelectionPanel(List<OptionPanel> panels) {        

            
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 
             
            for (OptionPanel panel : panels) {
                this.add(panel);
            }
            this.setLayout(box);

            this.validate();
            }    
    }
}
