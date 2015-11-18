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
             
        GridLayout grid2 = new GridLayout(); 
        grid2.setColumns(2);
        grid2.setRows(-1); 
        
        this.setLayout(grid2);
        
        SelectionPanel right = new SelectionPanel(); 
        
        
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
                 
        
        
        this.add(leftPane);
        this.add(right); 
        this.validate(); 
    }    
   
    class OptionPanel  extends JPanel { 
        OptionPanel(String button, String label) { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEADING);
            JButton bttn = new JButton(button); 
            JLabel lbl = new JLabel(label); 

            Font font = new Font("SanSarif", Font.BOLD, 20); 

            lbl.setFont(font);
            bttn.setFont(font);

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
        public SelectionPanel() {        

            OptionPanel add = new OptionPanel("  ", "Add Friend");     
            OptionPanel checkAll = new OptionPanel("  ", "Check all"); 
            OptionPanel uncheckAll = new OptionPanel("  ", "Uncheck all");
            OptionPanel delete = new OptionPanel("  ", "Delete"); 

            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 


            this.add(add);
            this.add(checkAll); 
            this.add(uncheckAll); 
            this.add(delete); 
            this.setLayout(box);

            this.validate();
            }    
    }
}
