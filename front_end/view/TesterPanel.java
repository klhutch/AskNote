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
class ResponsePanel extends JPanel {

     ResponsePanel (String str) {
        JPanel response = new JPanel();
        JLabel resp = new JLabel(str);
        JButton correct = new JButton("correct");
        JButton wrong = new JButton("wrong");
        
        TitledBorder title = BorderFactory.createTitledBorder("Response");
        title.setTitleJustification(TitledBorder.CENTER);
        
        response.setBorder(title);

        response.add(resp);
        response.add(correct);
        response.add(wrong);
        
        this.add(response); 
    }
    
}

class CardPanel extends JPanel {
      
     CardPanel (Flashcard card) {
        JPanel cardsides = new JPanel();
        cardsides.setMinimumSize(new Dimension(100, 100));
        JLabel car = new JLabel(card.getSide1());
        JButton flip = new JButton("flip");
        
       // TitledBorder title = BorderFactory.createTitledBorder("Card");
       // title.setTitleJustification(TitledBorder.CENTER);
        
       // cardsides.setBorder(title);
       
        cardsides.add(car);
        cardsides.add(flip);
        this.add(cardsides); 
    }
    
}


public class TesterPanel extends JPanel{
     ResponsePanel response;
     CardPanel cardsides;
     
    
    public TesterPanel(Flashcard card, String str) {
        
        GridLayout grid = new GridLayout();
        grid.setColumns(2);
        grid.setRows(1);
        this.setLayout(grid);
        
        this.response = new ResponsePanel(str);
        this.cardsides = new CardPanel (card);
        
        this.add(cardsides);
        this.add(response);
        this.validate();
    }
} 