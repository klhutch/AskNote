package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import model.Deck;
import model.FlashCard;

/**
 *
 * @author tiffanychao
 */
public class EditDeckPanel extends JPanel {
    Deck deck;
    
    public EditDeckPanel(Deck deck) {
        this.deck = deck;
        
        // init top level panel
        this.setLayout(new BorderLayout());
            
        // init leftmost deck panel
        GridLayout gl = initGridLayout(deck.getCards().size());
        
        JPanel deckPanel = new JPanel(); 
        deckPanel.setLayout(gl);
        
        // add buttons to leftmost deck panel
        for (int i = 0; i < deck.getSize(); i++) {
            
            JButton cardButton = new JButton(getCardPreview(deck.getCard(i)));
            JLabel cardLabel = new JLabel("Card " + String.valueOf(i + 1), SwingConstants.CENTER);
            
            JPanel buttonPanel = new JPanel();      
            buttonPanel.setLayout(new BorderLayout());
            buttonPanel.setPreferredSize(new Dimension(100, 100));
            buttonPanel.add(cardButton, BorderLayout.CENTER);
            buttonPanel.add(cardLabel, BorderLayout.SOUTH);
            
            deckPanel.add(buttonPanel);
        }

        JScrollPane scrollPanel = new JScrollPane(deckPanel);
        
        // init rightmost options panel
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        
        JButton newButton = new JButton("Add Card");
        JButton deleteButton = new JButton("Delete Card");
        
        optionPanel.add(newButton);
        optionPanel.add(deleteButton);
        
        // init deck title
        JLabel title = new JLabel(deck.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        
        // add to top level panel
        // should be able to rename deck, change to textfield later?
        this.add(title, BorderLayout.NORTH);
        this.add(scrollPanel, BorderLayout.WEST);
        this.add(optionPanel, BorderLayout.EAST);
        this.validate();
    }
    
    /**
     * sets number of rows based on number of cards in deck.
     * WIP, this function need to fill rows before columns.
     * Might change to GridBagLayout
     * @param numCards number of cards
     * @return the grid layout
     */
    private GridLayout initGridLayout(int numCards) {
        GridLayout gl = new GridLayout();
        
        int cols = 4;
        int remainder = numCards % cols;
        int rows = (numCards - remainder) / cols;
        
        gl.setColumns(cols);
        if (remainder != 0) {
            gl.setRows(rows + 1); // include remainder
        } else {
            gl.setRows(rows);
        }
        gl.setHgap(20);
        gl.setVgap(20);
        return gl;       
    }
    
    /**
     * get preview of flashcard content
     * @param c the flashcard
     * @return content preview
     */
    private String getCardPreview(FlashCard c) {
        String content = c.getSide1();
        if (content.length() <= 20) { // should this be a parameter?
            // don't change content
        } else {
            content = content.substring(0, 20) + "...";
        }
        return content;
    }
    
}
