/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import model.*;

/**
 *
 * @author Maha Alkhairy
 */


public class FriendsListPanel extends JPanel {
    
    
    public FriendsListPanel(List<String> friends) { 
        BorderLayout border = new BorderLayout(); 
        
        JPanel left = new JPanel(); 
        left.setLayout(border);
             
        GridLayout grid2 = new GridLayout(); 
        grid2.setColumns(2);
        grid2.setRows(-1); 
        
        this.setLayout(grid2);
        
        
        
        JList friendList = new JList();                            
         if (friends.size() > 0) {
                friendList = new JList(friends.toArray());
                friendList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                
            }
            else {
                String[] friendArray = {"No Friends Added"};
                friendList = new JList(friendArray);
            }
        
        OptionPanel add = new OptionPanel("  ", "Add Friend");     
        OptionPanel checkAll = new OptionPanel("  ", "Check all"); 
        OptionPanel uncheckAll = new OptionPanel("  ", "Uncheck all");
        OptionPanel delete = new OptionPanel("  ", "Delete"); 
        
        List<OptionPanel> options = new ArrayList<>();
        options.add(add); 
        options.add(checkAll); 
        
        
        SelectionPanel right = new SelectionPanel(options); 

         
                 
        
        
        left.add(friendList, BorderLayout.CENTER);
        this.add(left); 
        this.add(right); 
        this.validate(); 
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
