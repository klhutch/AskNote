
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import model.Deck;

/**
 *
 * @author tiffanychao
 */
public class ViewDecksHelperPanel extends JPanel {
    DeckTitlePanel selected = null;
    // should maintain references to decktitlepanels
    
    public ViewDecksHelperPanel(List<Deck> decks) {
        
        setLayout(new BorderLayout());
        
        JPanel decksPanel = new JPanel();
        decksPanel.setLayout(new FlowLayout());
        decksPanel.setPreferredSize(new Dimension(450, 450));
        
        for (Deck deck : decks) {
            DeckTitlePanel deckPanel = new DeckTitlePanel(deck);
            decksPanel.add(deckPanel);
            deckPanel.addMouseListener(new DeckSelectedListener());
        }
        
        JScrollPane scrollPanel = new JScrollPane(decksPanel);
        add(scrollPanel, BorderLayout.CENTER);
        validate();
    }
    
    class DeckTitlePanel extends JPanel {
        final LineBorder SELECTED = new LineBorder(Color.GREEN, 2);
        final LineBorder UNSELECTED = new LineBorder(Color.BLACK, 1);
        Deck deck;
        
        DeckTitlePanel(Deck deck) {
            this.deck = deck;
            
            setLayout(new BorderLayout());
            setOpaque(true);
            setBackground(Color.WHITE);
            setBorder(UNSELECTED);
            setPreferredSize(new Dimension(100, 100));
            JLabel deckTitle = new JLabel(deck.getTitle(), SwingConstants.CENTER);
            add(deckTitle, BorderLayout.CENTER);
        }
        
        void deSelect() {
            this.setBorder(UNSELECTED);      
        }
        
        void select() {
            this.setBorder(SELECTED);
            ViewDecksHelperPanel.this.selected = this;
        }
    }
    
    class DeckSelectedListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            ViewDecksHelperPanel deckPanel = ViewDecksHelperPanel.this;
            
            if (deckPanel.selected != null) {
                deckPanel.selected.deSelect();
            }
            ((DeckTitlePanel)e.getSource()).select();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    
    }
}
