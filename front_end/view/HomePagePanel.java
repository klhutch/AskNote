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
        
        // create layout managers
        FlowLayout titleFlow = new FlowLayout(); 
        titleFlow.setAlignment(FlowLayout.CENTER);
        
        FlowLayout optionsFlow = new FlowLayout(); 
        optionsFlow.setAlignment(FlowLayout.CENTER);
        optionsFlow.setHgap(20);
        optionsFlow.setVgap(20);
        
        // create nested JPanels, set layout managers
        this.setLayout(new BorderLayout());
        
        JPanel title = new JPanel(); 
        title.setLayout(titleFlow);
        JPanel options = new JPanel(); 
        options.setLayout(optionsFlow);
        
        // create components
        JButton decks = new JButton("Decks");
        decks.setPreferredSize(new Dimension(100, 100));
        JButton quiz = new JButton("Quiz"); 
        quiz.setPreferredSize(new Dimension(100, 100));
        JButton friends = new JButton("Friends");
        friends.setPreferredSize(new Dimension(100, 100));
        JLabel hello = new JLabel("Welcome to AskNote");    
        
        // add components to JPanels
        title.add(hello); 
        
        options.add(decks); 
        options.add(quiz); 
        options.add(friends);
        
        this.add(title, BorderLayout.NORTH);
        this.add(options, BorderLayout.CENTER);
    
        this.validate();
        }    
}
