
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import model.Deck;

/**
 *
 * @author tiffanychao
 */
public class ViewDecksHelperPanel extends JPanel {
    private final Dimension deckTitlePanelSize = new Dimension(100, 100);
    DeckTitlePanel selected = null;
    // should maintain references to decktitlepanels
    
    public ViewDecksHelperPanel(List<Deck> decks) throws MalformedURLException {
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        JPanel decksPanel = new ScrollableDecksPanel(decks);
        
        JScrollPane scrollPanel = new JScrollPane(decksPanel);
        
        add(scrollPanel, BorderLayout.CENTER);
        validate();
    }
    
    class ScrollableDecksPanel extends JPanel implements Scrollable {
        
        ScrollableDecksPanel(List<Deck> decks) throws MalformedURLException {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            setPreferredSize(findPreferredSize(decks.size()));
            this.setBackground(Color.WHITE);
            
            for (Deck deck : decks) {
                DeckTitlePanel deckPanel = new DeckTitlePanel(deck);
                this.add(deckPanel);
                deckPanel.addMouseListener(new DeckSelectedListener());
            }
            
            
        }
        
        private Dimension findPreferredSize(int numDecks) {
            int cols = 4;
            int remainder = numDecks % cols;
            int rows;
            if (remainder == 0) {
                rows = numDecks / cols;
            } else {
                rows = ((numDecks - remainder) / cols) + 1;
            }
            // default hgap and vgap for FlowLayout is 5 pixels
            return new Dimension(deckTitlePanelSize.width * cols + 5 * cols + 5,
                    deckTitlePanelSize.height * rows + 5 * rows + 5);
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            // 600 is height of AskNoteView
            return new Dimension(getPreferredSize().width, 600);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 5;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 5;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
        
    }
    
    class DeckTitlePanel extends JPanel {
        final LineBorder SELECTED = new LineBorder(Color.GREEN, 2);
        final LineBorder UNSELECTED = new LineBorder(Color.BLACK, 1);
        Deck deck;
        Constants constant; 
        
        DeckTitlePanel(Deck deck) throws MalformedURLException {
            this.deck = deck;
            this.constant = new Constants(); 
            setLayout(new BorderLayout());
            setOpaque(true);
            setBackground(Color.WHITE);
            setBorder(UNSELECTED);
            setPreferredSize(deckTitlePanelSize);
            JLabel deckTitle = new JLabel(deck.getTitle(), SwingConstants.CENTER);
            deckTitle.setFont(constant.getFont("Label"));
            
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
            if (e.getSource() instanceof DeckTitlePanel){
                if (deckPanel.selected != null) {
                    deckPanel.selected.deSelect();
                }
                ((DeckTitlePanel)e.getSource()).select();
            }
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
