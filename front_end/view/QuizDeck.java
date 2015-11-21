package view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Deck;

/**
 *
 * @author tiffanychao
 */
public class QuizDeck extends JPanel {
    
    public QuizDeck(List<Deck> decks) {
        
        setLayout(new BorderLayout());

        ViewDecksHelperPanel decksPanel = new ViewDecksHelperPanel(decks);
        JButton confirmButton = new JButton("Confirm");
        
        add(decksPanel, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.SOUTH);
        validate();
    }
}
