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
    
    public TesterPanel(FlashCard card, String str) {
        JPanel cardsides = new JPanel();
        JPanel response = new JPanel();
        JPanel buttons = new JPanel();
        JButton flip = new JButton("flip");
        JButton correct = new JButton("correct");
        JButton wrong = new JButton("wrong");
        JLabel resp = new JLabel(str);
        JLabel car = new JLabel(card.getSide1());
        
    
        
        TitledBorder title = BorderFactory.createTitledBorder("Response");
        title.setTitleJustification(TitledBorder.CENTER);
        
        TitledBorder title2 = BorderFactory.createTitledBorder("Card");
        title.setTitleJustification(TitledBorder.CENTER);
        
        response.setBorder(title);
        cardsides.setBorder(title2);
        
        response.add(resp);
        cardsides.add(car);
        
        buttons.add(flip); 
        buttons.add(correct); 
        buttons.add(wrong); 
        
        
    }
    
}
