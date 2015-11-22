package front_end.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.AskNoteModel;
import model.Deck;
import model.FlashCard;
import model.PageType;
import view.AskNoteView;
import view.EditDeckPanel;

/**
 *
 * @author tiffanychao
 */
public class TestEditDeck extends JFrame {
    
    public static void main (String[] argv) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestEditDeck().setVisible(true);
            }
        });
    }

    private TestEditDeck() {
        setTitle("AskNote");
        setResizable(true);
        setSize (1000, 650);
        
        FlashCard card1 = new FlashCard("photosynthesis", "");
        FlashCard card2 = new FlashCard("Calvin Cycle", "");
        FlashCard card3 = new FlashCard("Krebs Cycle", "");
        FlashCard card4 = new FlashCard("plants produce oxygen", "");
        FlashCard card5 = new FlashCard("glucose", "");
        FlashCard card6 = new FlashCard("I Solemnly Swear I am Up to No Good", "Marauder's Map Password");
        
        
        
        List<FlashCard> cards = new ArrayList<>();
        
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        
        for (int i = 0; i < 100; i++) { 
            cards.add(card5); 
        }
        Deck deck = new Deck("Bio", cards);
        
        AskNoteModel model = AskNoteModel.instance();
        model.setCurrentPage(PageType.EDIT_DECK);
        model.setSelectedDeck(deck);
        model.addDeck(deck);
        
        AskNoteView.instance().updateView();
        getContentPane().add(AskNoteView.instance());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
