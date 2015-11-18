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
        GridLayout grid = new GridLayout(); 
        grid.setColumns(1);
        grid.setRows(-1);
        
        JPanel left = new JPanel(); 
        left.setLayout(grid);
        left.doLayout();
             
        GridLayout grid2 = new GridLayout(); 
        grid2.setColumns(2);
        grid2.setRows(-1); 
        
        this.setLayout(grid2);
        
        JPanel right = new JPanel(); 
        right.setLayout(grid); 
        
        
        JScrollPane leftPane = new JScrollPane(); 
        leftPane.setViewportView(left);
        
        leftPane.setAutoscrolls(true);
             
        List<JCheckBox> frnds = new ArrayList<JCheckBox>(); 
                                    
        for (int i = 0; i < friends.size(); i++) { 
           String name = friends.get(i); 
           JCheckBox frnd = new JCheckBox(name); 
           frnds.add(frnd); 
        }
        
         for (int i = 0; i < frnds.size(); i++) {           
           left.add(frnds.get(i)); 
        }
                 
        JButton addFriend = new JButton("Add Friend");
        JButton uncheck = new JButton("Uncheck All"); 
        JButton checkAll = new JButton("Check All"); 
        JButton delete = new JButton("Delete"); 
        
        right.add(addFriend); 
        right.add(uncheck); 
        right.add(checkAll); 
        right.add(delete); 
         
        this.add(leftPane);
        this.add(right); 
        this.validate(); 
    }    
}
