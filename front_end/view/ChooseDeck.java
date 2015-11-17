/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import model.Deck;

/**
 *
 * @author tiffanychao
 */
public class ChooseDeck extends JPanel {
    
    public ChooseDeck(List<Deck> decks) {
        
        // init top level panel
        this.setLayout(new BorderLayout());
            
        // init leftmost deck panel
        GridLayout gl1 = initGridLayout(decks.size());
        
        JPanel deckPanel = new JPanel(); 
        deckPanel.setLayout(gl1);
        
        // add buttons to leftmost deck panel
        for (int i = 0; i < decks.size(); i++) {
            
            JButton deckButton = new JButton(decks.get(i).getTitle());
            deckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel deckLabel = new JLabel("Deck " + String.valueOf(i + 1), SwingConstants.CENTER);
            deckLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            JPanel buttonPanel = new JPanel();      
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
            buttonPanel.add(deckButton);
            buttonPanel.add(deckLabel);
            
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
        
        JButton newButton = new JButton("Add Deck");
        JButton deleteButton = new JButton("Delete Deck");
        
        optionPanel.add(newButton);
        optionPanel.add(deleteButton);
        
        // validate
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
    private GridLayout initGridLayout(int numDecks) {
        GridLayout gl = new GridLayout();
        
        int cols = 4;
        int remainder = numDecks % cols;
        int rows = (numDecks - remainder) / cols;
        
        gl.setColumns(cols);
        gl.setRows(rows + 1); // include remainder
        gl.setHgap(20);
        gl.setHgap(20);
        return gl;       
    }
}
