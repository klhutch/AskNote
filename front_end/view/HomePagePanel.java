/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Maha Alkhairy
 */
public class HomePagePanel extends JPanel{
    // takes nothing in 
    public HomePagePanel() { 
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
        flow.setHgap(20);
        flow.setVgap(200);
        
        FlowLayout flow2 = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
        
        
        GridLayout grid = new GridLayout(); 
        grid.setRows(2);
        grid.setColumns(1);
        
        JButton decks = new JButton("Decks"); 
        JButton quiz = new JButton("Quiz"); 
        JButton friends = new JButton("Friends");
        JLabel hello = new JLabel("Welcome to AskNote");    
        
       
        JPanel top = new JPanel(); 
        top.add(hello); 
        JPanel bottom = new JPanel(); 
        
        bottom.add(decks); 
        bottom.add(quiz); 
        bottom.add(friends);
        
        
        this.add(top);
        this.add(bottom);
        
        
        this.setLayout(grid);
        bottom.setLayout(flow);
        top.setLayout(flow2);
        
        
        
        
        this.validate();
        }    
}
