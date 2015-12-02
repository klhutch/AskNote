/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import model.*;

/**
 *
 * @author Maha Alkhairy
 */


public class FriendsListPanel extends JPanel {
    JList friendList;
    List<String> friends;
    
    public FriendsListPanel(List<String> friends) { 
        this.friends = friends;
        BorderLayout border = new BorderLayout(); 
        
        JPanel left = new JPanel(); 
        left.setLayout(border);
             
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
        
          
         
        OptionPanel add = new OptionPanel("  ", "Add Friend");     
        OptionPanel checkAll = new OptionPanel("  ", "Select all"); 
        OptionPanel uncheckAll = new OptionPanel("  ", "Uncheck all");
        OptionPanel delete = new OptionPanel("  ", "Delete"); 
        
        List<OptionPanel> options = new ArrayList<>();
        options.add(add); 
        options.add(delete);
        //options.add(checkAll); 
        //options.add(uncheckAll);
        
        
        SelectionPanel right = new SelectionPanel(options); 

         
        add.button.addActionListener(new AddFriendListener());
        delete.button.addActionListener(new RemoveFriendsListener());
        checkAll.button.addActionListener(new SelectAllListener());
        uncheckAll.button.addActionListener(new UnselectAllListener());
        
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
                AskNoteView.instance().updateView();
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
                    AskNoteView.instance().updateView();
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
        OptionPanel(String button, String label) { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEADING);
            JButton bttn = new JButton(button); 
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
