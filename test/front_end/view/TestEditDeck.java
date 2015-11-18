package front_end.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Deck;
import model.FlashCard;
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
        setSize (1000, 600);
        
        FlashCard f1 = new FlashCard("photosynthesis", "");
        FlashCard f2 = new FlashCard("Calvin Cycle", "");
        FlashCard f3 = new FlashCard("Krebs Cycle", "");
        FlashCard f4 = new FlashCard("plants produce oxygen", "");
        FlashCard f5 = new FlashCard("glucose", "");
        
        List<FlashCard> cards = new ArrayList<>();
        
        cards.add(f1);
        cards.add(f2);
        cards.add(f3);
        cards.add(f4);
        cards.add(f5);
        
        EditDeckPanel ed = new EditDeckPanel(new Deck("Bio", cards));
        getContentPane().add(ed);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
