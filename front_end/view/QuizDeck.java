package view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;
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
