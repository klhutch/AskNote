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
import model.Flashcard;
import view.LoginPanel;
import view.QuizSelfPanel;

/**
 *
 * @author Maha Alkhairy
 */
public class TestQuizSelf {
    
    public static void main (String[] argv) {
        // Create a frame 
        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the title and other parameters. 
        frame.setTitle ("AskNote");
        frame.setResizable (true);
        // Background is going to be Panel's background. 
        // f.getContentPane().setBackground (Color.cyan); 
        frame.setSize (500, 600);

        Flashcard card1Math = new Flashcard("1 + 1", "2");
        Flashcard card2Math = new Flashcard("2 + 1", "3");
        Flashcard card3Math = new Flashcard("1 * 1", "1");
        List<Flashcard> cards = new ArrayList<>();      
        cards.add(card1Math); 
        cards.add(card2Math); 
        cards.add(card3Math);

        Deck math = new Deck("math", cards); 

        frame.getContentPane().add (new QuizSelfPanel(math));

        // Show the frame. 
        frame.setVisible (true);
     } 
    
}
