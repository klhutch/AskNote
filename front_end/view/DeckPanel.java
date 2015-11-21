/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Deck;

/**
 *
 * @author tiffanychao
 */
public class DeckPanel extends JPanel {
    
    public DeckPanel(List<Deck> decks) {
        
        // init top level panel
        setLayout(new BorderLayout());
            
        // init leftmost deck panel
        ViewDecksHelperPanel decksPanel = new ViewDecksHelperPanel(decks);

        // init rightmost options panel
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        
        JButton newButton = new JButton("Add Deck");
        JButton removeButton = new JButton("Remove Deck");
        JButton editButton = new JButton("Edit Deck");
        
        optionPanel.add(newButton);
        optionPanel.add(removeButton);
        optionPanel.add(editButton);
        
        // validate
        add(decksPanel, BorderLayout.CENTER);
        add(optionPanel, BorderLayout.EAST);
        validate();
    }
}
