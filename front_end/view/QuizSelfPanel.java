/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javafx.scene.layout.Border;
import javax.swing.*;
import model.*;
import java.util.Random; 

/**
 *
 * @author Maha Alkhairy
 */
public class QuizSelfPanel extends JPanel{
    public QuizSelfPanel(Deck deck) { 
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
       
        
        GridLayout grid = new GridLayout(); 
        grid.setColumns(1);
        grid.setRows(1);
        
        JButton back = new JButton("<"); 
        JButton flip = new JButton("flip");
        JButton forward = new JButton(">"); 
        
        
        JLabel card = new JLabel(deck.getCards().get(0).getSide2()); 
        JPanel center = new JPanel(); 
        center.setBackground(Color.white);
        center.setLayout(grid);
        center.add(card); 
        
        JPanel bottomPanel = new JPanel(); 
       
        bottomPanel.setLayout(flow);
        bottomPanel.add(back);
        bottomPanel.add(flip); 
        bottomPanel.add(forward); 
       
        
        
        
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
        
        this.add(bottomPanel, BorderLayout.SOUTH); 
        this.add(center, BorderLayout.CENTER); 
        this.add(new JPanel(), BorderLayout.EAST); 
        this.add(new JPanel(), BorderLayout.WEST); 
        this.add(new JPanel(), BorderLayout.NORTH); 
        this.validate();
       
    }
    
}
