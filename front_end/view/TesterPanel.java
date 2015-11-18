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
    
<<<<<<< HEAD
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
=======
     ResponsePanel (String str) {
        JPanel response = new JPanel();
        JLabel resp = new JLabel(str);
        JButton correct = new JButton("correct");
        JButton wrong = new JButton("wrong");
>>>>>>> ffc86d2134a4d29c3cccd21105f0b52d811aeebf
        
        TitledBorder titleResponse = BorderFactory.createTitledBorder("Response");
        titleResponse.setTitleJustification(TitledBorder.CENTER);
        
<<<<<<< HEAD
        TitledBorder titleCard = BorderFactory.createTitledBorder("Card");
        titleCard.setTitleJustification(TitledBorder.CENTER);
        
        response.setBorder(titleResponse);
        cards.setBorder(titleCard);
=======
        response.setBorder(title);
>>>>>>> ffc86d2134a4d29c3cccd21105f0b52d811aeebf
        
        // add components to this panel
        response.add(resp);
<<<<<<< HEAD
        cards.add(side1);
        
        buttons.add(flip); 
        buttons.add(correct); 
        buttons.add(incorrect); 
        
        cardAndResponse.add(cards);
        cardAndResponse.add(response);
        
        this.add(cardAndResponse, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);
        
        validate();
=======
        response.add(correct);
        response.add(wrong);
        
        this.add(response); 
    }
    
}

class CardPanel extends JPanel {
      
     CardPanel (FlashCard card) {
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
     
    
    public TesterPanel(FlashCard card, String str) {
        
        GridLayout grid = new GridLayout();
        grid.setColumns(2);
        grid.setRows(1);
        this.setLayout(grid);
        
        this.response = new ResponsePanel(str);
        this.cardsides = new CardPanel (card);
        
        this.add(cardsides);
        this.add(response);
        this.validate();
>>>>>>> ffc86d2134a4d29c3cccd21105f0b52d811aeebf
    }
} 