package front_end.view;

/**
 *
 * @author tiffanychao
 */
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.AskNoteModel;
import model.Deck;
import model.PageType;
import view.AskNoteView;
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
        setSize(new Dimension(1000, 600));
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
        
        AskNoteModel model = AskNoteModel.instance();
        model.setDecks(decks);
        model.setCurrentPage(PageType.DECK);
        
        AskNoteView view = AskNoteView.instance();
        view.updateView();
        getContentPane().add(view);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
