/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Deck;
import model.FlashCard;
import view.LoginPanel;
import view.QuizSelfPanel;

/**
 *
 * @author Maha Alkhairy
 */
public class TestQuizSelf {
    
    public static void main (String[] argv) {
    // Create a frame 
    JFrame f = new JFrame ();

    // Set the title and other parameters. 
    f.setTitle ("AskNote");
    f.setResizable (true);
    // Background is going to be Panel's background. 
    // f.getContentPane().setBackground (Color.cyan); 
    f.setSize (500, 600);
    
    FlashCard card1Math = new FlashCard("1 + 1", "2");
    FlashCard card2Math = new FlashCard("2 + 1", "3");
    FlashCard card3Math = new FlashCard("1 * 1", "1");
    List<FlashCard> cards = new ArrayList<>();      
    cards.add(card1Math); 
    cards.add(card2Math); 
    cards.add(card3Math);
          
    Deck math = new Deck("math", cards); 
    
    f.getContentPane().add (new QuizSelfPanel(math));

    // Show the frame. 
    f.setVisible (true);
     } 
    
}
