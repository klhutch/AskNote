/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.AskNoteModel;
import model.Deck;
import model.FlashCard;
import model.PageType;
import view.AskNoteView;
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
        frame.setSize (1000, 600);

        FlashCard card1Math = new FlashCard("1 + 1", "2");
        FlashCard card2Math = new FlashCard("2 + 1", "3");
        FlashCard card3Math = new FlashCard("1 * 1", "1");
        List<FlashCard> cards = new ArrayList<>();      
        cards.add(card1Math); 
        cards.add(card2Math); 
        cards.add(card3Math);

        Deck math = new Deck("math", cards); 
        List<Deck> decks = new ArrayList();
        decks.add(math);
        
        AskNoteModel model = AskNoteModel.instance();
        model.setDecks(decks);
        model.setSelectedDeck(math);
        model.setCurrentPage(PageType.QUIZ);
        model.setCurrentPage(PageType.QUIZ_DECK);
        model.setCurrentPage(PageType.QUIZ_SELF);
        
        try {
            AskNoteView.instance().updateView();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestQuizSelf.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.getContentPane().add (AskNoteView.instance());

        // Show the frame. 
        frame.setVisible (true);
     } 
    
}
