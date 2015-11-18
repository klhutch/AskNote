package front_end.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Deck;
import model.Flashcard;
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
        setSize(500, 600);
        
        Flashcard f1 = new Flashcard("photosynthesis", "");
        Flashcard f2 = new Flashcard("Calvin Cycle", "");
        Flashcard f3 = new Flashcard("Krebs Cycle", "");
        Flashcard f4 = new Flashcard("plants produce oxygen", "");
        Flashcard f5 = new Flashcard("glucose", "");
        
        List<Flashcard> cards = new ArrayList<>();
        
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
