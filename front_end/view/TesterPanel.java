/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import model.*;

/**
 *
 * @author Maha Alkhairy
 */
public class TesterPanel extends JPanel{
    
    public TesterPanel(Flashcard card, String str) {
        
        // init panels and layouts
        setLayout(new BorderLayout());
        
        JPanel cards = new JPanel();
        JPanel response = new JPanel();
        JPanel cardAndResponse = new JPanel(); // container for cards and response
        cardAndResponse.setLayout(new GridLayout(1, 2));
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        // init components
        JButton flip = new JButton("flip");
        JButton correct = new JButton("correct");
        JButton incorrect = new JButton("incorrect");
        
        JLabel resp = new JLabel(str);
        JLabel side1 = new JLabel(card.getSide1());
        
        TitledBorder titleResponse = BorderFactory.createTitledBorder("Response");
        titleResponse.setTitleJustification(TitledBorder.CENTER);
        
        TitledBorder titleCard = BorderFactory.createTitledBorder("Card");
        titleCard.setTitleJustification(TitledBorder.CENTER);
        
        response.setBorder(titleResponse);
        cards.setBorder(titleCard);
        
        // add components to this panel
        response.add(resp);
        cards.add(side1);
        
        buttons.add(flip); 
        buttons.add(correct); 
        buttons.add(incorrect); 
        
        cardAndResponse.add(cards);
        cardAndResponse.add(response);
        
        this.add(cardAndResponse, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
        
        validate();
    }
} 