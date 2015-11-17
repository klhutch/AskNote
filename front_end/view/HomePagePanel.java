/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

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
        this.setLayout(flow);
        
        JButton decks = new JButton("Decks"); 
        JButton quiz = new JButton("Quiz"); 
        JButton friends = new JButton("Friends");
        JLabel hello = new JLabel("Welcome to AskNote");       
        this.add(decks); 
        this.add(quiz); 
        this.add(friends);   
        this.validate();
        }    
}
