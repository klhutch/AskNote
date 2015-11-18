package front_end.view;

/**
 *
 * @author tiffanychao
 */
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Deck;
import view.DeckPanel;

public class TestDeckView extends JFrame {
    
    public static void main (String[] argv) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestDeckView().setVisible(true);
            }
        });
    }

    private TestDeckView() {
        setTitle ("AskNote");
        setResizable(true);
        
        List<Deck> decks = new ArrayList<>();
        decks.add(new Deck("Bio1"));
        decks.add(new Deck("Bio2"));
        decks.add(new Deck("Chem"));
        decks.add(new Deck("Zoology"));
        decks.add(new Deck("PreCalc"));
        decks.add(new Deck("OOD"));
        decks.add(new Deck("Discrete Structs"));
        decks.add(new Deck("Music"));
        
        DeckPanel ed = new DeckPanel(decks);
        getContentPane().add(ed);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
