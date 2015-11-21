
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import model.Deck;

/**
 *
 * @author tiffanychao
 */
public class ViewDecksHelperPanel extends JPanel {
    
    // should maintain references to decktitlepanels
    
    public ViewDecksHelperPanel(List<Deck> decks) {
        
        setLayout(new BorderLayout());
        
        JPanel deckPanel = new JPanel();
        deckPanel.setLayout(new FlowLayout());
        deckPanel.setPreferredSize(new Dimension(450, 450));
        
        for (Deck d : decks) {
            DeckTitlePanel dtp = new DeckTitlePanel(d);
            deckPanel.add(dtp);
        }
        
        JScrollPane scrollPanel = new JScrollPane(deckPanel);
        add(scrollPanel, BorderLayout.CENTER);
        validate();
    }
    
    class DeckTitlePanel extends JPanel {
        
        DeckTitlePanel(Deck deck) {
            setLayout(new BorderLayout());
            setOpaque(true);
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setPreferredSize(new Dimension(100, 100));
            JLabel deckTitle = new JLabel(deck.getTitle(), SwingConstants.CENTER);
            add(deckTitle, BorderLayout.CENTER);
        }
    }
}
