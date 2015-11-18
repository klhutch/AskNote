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


class CardShownPanel extends JPanel { 
    CardShownPanel (String sideText) { 
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
        JLabel card = new JLabel(sideText); 
        this.setBackground(Color.white);
       
        this.add(card, BorderLayout.CENTER); 
        
        
        
    }
       
}


class ButtonPanel extends JPanel { 
     ButtonPanel () { 
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
        JButton back = new JButton("<"); 
        JButton flip = new JButton("flip");
        JButton forward = new JButton(">"); 
        
       
        this.setLayout(flow);
        this.add(back);
        this.add(flip); 
        this.add(forward); 
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
public class QuizSelfPanel extends JPanel{
      Deck deck; 
    public QuizSelfPanel(Deck deck) { 
        this.deck = deck; 
       
        
        CardShownPanel card = new CardShownPanel(deck.getCards().get(0).getSide1()); 
        ButtonPanel buttons = new ButtonPanel(); 
        EndButtonPanel end = new EndButtonPanel(); 
        
        JPanel bottomPanel = new JPanel(); 
        bottomPanel.add(buttons); 
        bottomPanel.add(end); 
        
        
        
        
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
        
        this.add(buttons, BorderLayout.SOUTH); 
        this.add(card, BorderLayout.CENTER); 
        this.add(new JPanel(), BorderLayout.EAST); 
        this.add(new JPanel(), BorderLayout.WEST); 
        this.add(new JPanel(), BorderLayout.NORTH); 
        this.validate();
       
    } 
} 
    

