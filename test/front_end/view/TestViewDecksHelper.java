package front_end.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.Deck;
import view.ViewDecksHelperPanel;

/**
 *
 * @author tiffanychao
 */
public class TestViewDecksHelper extends JFrame {
    
    public static void main (String[] argv) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestViewDecksHelper().setVisible(true);
            }
        });
    }

    private TestViewDecksHelper() {
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
        decks.add(new Deck("NewDeck1"));
        decks.add(new Deck("NewDeck2"));
        decks.add(new Deck("NewDeck3"));
        decks.add(new Deck("NewDeck4"));
        decks.add(new Deck("NewDeck5"));
        decks.add(new Deck("NewDeck6"));
        decks.add(new Deck("NewDeck7"));
        decks.add(new Deck("NewDeck8"));
        decks.add(new Deck("NewDeck9"));
        decks.add(new Deck("NewDeck10"));
        
        ViewDecksHelperPanel ed = new ViewDecksHelperPanel(decks);
        getContentPane().add(ed);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}
