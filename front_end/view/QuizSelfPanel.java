/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.*;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maha Alkhairy
 */


public class QuizSelfPanel extends JPanel{
      Deck deck;
      Boolean side1Shown;
      ShownTextPanel shownText;
      Constants constant; 
      
      
    public QuizSelfPanel(Deck deck) throws MalformedURLException { 
        this.deck = deck; 
        this.constant = new Constants(); 
        
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
       
        if(!deck.isEmpty()) {
            try {
                this.shownText =  new ShownTextPanel(deck.getCurrentCard().getSide1());
                this.add(shownText, BorderLayout.CENTER);
                this.side1Shown = true;
                
                ButtonPanel buttons = new ButtonPanel();
                EndButtonPanel end = new EndButtonPanel();
                
                JPanel bottomPanel = new JPanel();
                bottomPanel.add(buttons);
                bottomPanel.add(end);
                 
                this.add(buttons, BorderLayout.SOUTH);
            } catch (MalformedURLException ex) {
                Logger.getLogger(QuizSelfPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        else {
            JLabel noCards = new JLabel("No Cards in this Deck", SwingConstants.CENTER);
            noCards.setFont(constant.getFont("Large")); 
            noCards.setVerticalAlignment(SwingConstants.CENTER);
            this.add(noCards, BorderLayout.CENTER);
            
            JButton okay = new JButton("okay");
            okay.setFont(constant.getFont("Label"));
            okay.addActionListener(new EndQuizButtonListener());
            
            JPanel south = new JPanel();
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            south.setLayout(flow);
            south.add(okay);
            
            this.add(south, BorderLayout.SOUTH);
        }
        
        
        
        this.add(new JPanel(), BorderLayout.EAST); 
        this.add(new JPanel(), BorderLayout.WEST); 
        this.add(new JPanel(), BorderLayout.NORTH); 
        
        this.validate();
       
    } 
    
    
    class ShownTextPanel extends JPanel {
        JLabel shownText;
        Constants constant; 
        
        ShownTextPanel (String text) throws MalformedURLException {
           this.constant = new Constants(); 
            
           FlowLayout flow = new FlowLayout(); 
           flow.setAlignment(FlowLayout.CENTER);
           flow.setVgap(200); 
           this.shownText = new JLabel(text); 
           shownText.setFont(constant.getFont("Regular"));
            
            this.setBackground(Color.white);

            this.add(this.shownText);//, BorderLayout.CENTER); 
            this.setLayout(flow);

        }
        
        void updateText(String text) {
            this.shownText.setText(text);
            QuizSelfPanel.this.validate();
        }

    }


    
    class ButtonPanel extends JPanel { 
        Constants constant;
         ButtonPanel () throws MalformedURLException { 
             this.constant = new Constants();
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            JButton previousCard = new JButton(constant.getImage("<")); 
            JButton flip = new JButton(constant.getImage("Flip"));
            JButton nextCard = new JButton(constant.getImage(">")); 
            
            flip.addActionListener(new FlipCardButtonListener());
            previousCard.addActionListener(new PreviousCardButtonListener());
            nextCard.addActionListener(new NextCardButtonListener());
            
            this.setLayout(flow);
            this.add(previousCard);
            this.add(flip); 
            this.add(nextCard); 
         } 
    }

    class EndButtonPanel extends JPanel { 
         EndButtonPanel () throws MalformedURLException { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            JButton end = new JButton("end");
            Constants constant = new Constants(); 
            
            end.setFont(constant.getFont("Label"));
           
            end.addActionListener(new EndQuizButtonListener());

            this.setLayout(flow);
            this.add(end); 
         } 
    }
    
    class FlipCardButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizSelfPanel quizPanel = QuizSelfPanel.this;
            
            if(quizPanel.side1Shown) {
                quizPanel.side1Shown = false;
                quizPanel.shownText.updateText(quizPanel.deck.getCurrentCard().getSide2());
            }
            else {
                quizPanel.side1Shown = true;
                quizPanel.shownText.updateText(quizPanel.deck.getCurrentCard().getSide1());
            }
        }
        
        
    } 
    
    class PreviousCardButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizSelfPanel quizPanel = QuizSelfPanel.this;
            quizPanel.shownText.updateText(quizPanel.deck.getPreviousCard().getSide1());
            quizPanel.side1Shown = true;
        }
        
    }

    
    class NextCardButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizSelfPanel quizPanel = QuizSelfPanel.this;
            quizPanel.shownText.updateText(quizPanel.deck.getNextCard().getSide1());
            quizPanel.side1Shown = true;
        }
        
    }
    
    
    class EndQuizButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel.instance().setSelectedDeck(null);
            AskNoteModel.instance().setPreviousAsCurrent();
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(QuizSelfPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
} 
    

