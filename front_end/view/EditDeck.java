/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
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
public class EditDeck extends JPanel {
    
    public EditDeck(Deck deck) {
        
        // init top level panel
        this.setLayout(new BorderLayout());
            
        // init leftmost deck panel
        GridLayout gl1 = initGridLayout(deck.getCards().size());
        
        JPanel deckPanel = new JPanel(); 
        deckPanel.setLayout(gl1);
        
        // add buttons to leftmost deck panel
        for (int i = 0; i < deck.getSize(); i++) {
            
            JButton cardButton = new JButton(getCardPreview(deck.getCard(i)));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel cardLabel = new JLabel("Card " + String.valueOf(i + 1), SwingConstants.CENTER);
            cardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            JPanel buttonPanel = new JPanel();      
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
            buttonPanel.add(cardButton);
            buttonPanel.add(cardLabel);
            
            deckPanel.add(buttonPanel);
        }

        JScrollPane scrollPanel = new JScrollPane(deckPanel);
        scrollPanel.createHorizontalScrollBar();

        // init rightmost options panel
        JPanel optionPanel = new JPanel();
        GridLayout gl2 = new GridLayout();
        gl2.setColumns(1);
        gl2.setRows(2);
        gl2.setHgap(20);
        gl2.setVgap(20);
        optionPanel.setLayout(gl2);
        
        JButton newButton = new JButton("Add Card");
        JButton deleteButton = new JButton("Delete Card");
        
        optionPanel.add(newButton);
        optionPanel.add(deleteButton);
        
        // validate
        
        // should be able to rename deck, change to textfield later?
        this.add(new JLabel(deck.getTitle()), BorderLayout.NORTH);
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
        gl.setRows(rows + 1); // include remainder
        gl.setHgap(20);
        gl.setHgap(20);
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
