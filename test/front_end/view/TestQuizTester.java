/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.AskNoteModel;
import model.Deck;
import model.FlashCard;
import model.PageType;
import model.Quiz;
import view.AskNoteView;
import view.QuizTesterPanel;

/**
 *
 * @author normal
 */
public class TestQuizTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AskNote");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1000, 650);
        
        
        String friend1 = "Amanda";
        FlashCard card1 = new FlashCard("I solemnly Swear I am Up to No Good", "Marauder's Map Password");
        
        Deck deck = new Deck("Harry Potter");
        deck.add(card1);
        
        AskNoteModel model = AskNoteModel.instance();
        model.addDeck(deck);
        model.addFriend(friend1);
        
        Quiz quiz = new Quiz(deck, friend1, true, "A Very Important Password");
        model.addQuiz(quiz);
        model.setActiveQuiz(quiz);
        
        model.setCurrentPage(PageType.QUIZ);
        model.setCurrentPage(PageType.QUIZ_SELECT);
        model.setCurrentPage(PageType.QUIZ_TESTER);
        
        try {
            AskNoteView.instance().updateView();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestQuizTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.add(AskNoteView.instance());
        frame.validate();
        frame.setVisible(true);
        
        
    }
}
