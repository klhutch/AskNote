/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
public class ChooseDeckPanel extends JPanel {
    
    public ChooseDeckPanel(List<Deck> decks) {
        
        // init top level panel
        this.setLayout(new BorderLayout());
            
        // init leftmost deck panel
        GridLayout gl = initGridLayout(decks.size());
        
        JPanel deckPanel = new JPanel(); 
        deckPanel.setLayout(gl);
        
        // add buttons to leftmost deck panel
        for (int i = 0; i < decks.size(); i++) {
            
            JButton deckButton = new JButton(decks.get(i).getTitle());
            JLabel deckLabel = new JLabel("Deck " + String.valueOf(i + 1), SwingConstants.CENTER);
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BorderLayout());
            buttonPanel.setPreferredSize(new Dimension(100, 100));
            buttonPanel.add(deckButton, BorderLayout.CENTER);
            buttonPanel.add(deckLabel, BorderLayout.SOUTH);
            
            deckPanel.add(buttonPanel);
        }

        JScrollPane scrollPanel = new JScrollPane(deckPanel);

        // init rightmost options panel
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        
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
        if (remainder != 0) {
            gl.setRows(rows + 1); // include remainder
        } else {
            gl.setRows(rows);
        }
        gl.setHgap(20);
        gl.setVgap(20);
        return gl;       
    }
}
