/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.*;
import model.*;
import java.util.Random; 

/**
 *
 * @author Maha Alkhairy
 */


public class QuizSelfPanel extends JPanel{
      Deck deck;
      Boolean side1Shown;
      
      ShownTextPanel shownText;
      
    public QuizSelfPanel(Deck deck) { 
        this.deck = deck; 
       
        
        this.shownText =  new ShownTextPanel(deck.getCurrentCard().getSide1()); 
        this.side1Shown = true;
        
        ButtonPanel buttons = new ButtonPanel(); 
        EndButtonPanel end = new EndButtonPanel(); 
        
        JPanel bottomPanel = new JPanel(); 
        bottomPanel.add(buttons); 
        bottomPanel.add(end); 
        
        
        
        
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
        
        this.add(buttons, BorderLayout.SOUTH); 
        this.add(shownText, BorderLayout.CENTER); 
        
        
        this.add(new JPanel(), BorderLayout.EAST); 
        this.add(new JPanel(), BorderLayout.WEST); 
        this.add(new JPanel(), BorderLayout.NORTH); 
        
        this.validate();
       
    } 
    
    
    class ShownTextPanel extends JPanel {
        JLabel shownText;
        
        ShownTextPanel (String text) {
            
           FlowLayout flow = new FlowLayout(); 
           flow.setAlignment(FlowLayout.CENTER);
           flow.setVgap(200); 
            this.shownText = new JLabel(text); 
            
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
         ButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            JButton previousCard = new JButton("<"); 
            JButton flip = new JButton("flip");
            JButton nextCard = new JButton(">"); 
            
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
         EndButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            JButton end = new JButton("end");


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
} 
    

