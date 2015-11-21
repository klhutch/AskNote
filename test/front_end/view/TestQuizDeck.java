/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.AskNoteModel;
import model.Deck;
import model.PageType;
import view.AskNoteView;
import view.QuizDeckPanel;

/**
 *
 * @author tiffanychao
 */
public class TestQuizDeck extends JFrame {
    
    public static void main (String[] argv) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestQuizDeck().setVisible(true);
            }
        });
    }

    private TestQuizDeck() {
        setTitle ("AskNote");
        setResizable(true);
        setSize(new Dimension(1000, 600));
        
        List<Deck> decks = new ArrayList<>();
        decks.add(new Deck("Bio1"));
        decks.add(new Deck("Bio2"));
        decks.add(new Deck("Chem"));
        decks.add(new Deck("Zoology"));
        decks.add(new Deck("PreCalc"));
        decks.add(new Deck("OOD"));
        decks.add(new Deck("Discrete Structs"));
        
        AskNoteModel model = AskNoteModel.instance();
        model.setDecks(decks);
        model.setCurrentPage(PageType.QUIZ);
        model.setCurrentPage(PageType.QUIZ_DECK);
        
        AskNoteView.instance().updateView();
        getContentPane().add(AskNoteView.instance());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
