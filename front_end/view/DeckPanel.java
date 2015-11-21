/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.AskNoteModel;
import model.Deck;
import model.PageType;

/**
 *
 * @author tiffanychao
 */
public class DeckPanel extends JPanel {
    ViewDecksHelperPanel decksPanel;
    
    public DeckPanel(List<Deck> decks) {
        
        // init top level panel
        setLayout(new BorderLayout());
            
        // init leftmost deck panel
        this.decksPanel = new ViewDecksHelperPanel(decks);

        // init rightmost options panel
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        
        JButton addButton = new JButton("Add Deck");
        JButton removeButton = new JButton("Remove Deck");
        JButton editButton = new JButton("Edit Deck");
        
        addButton.addActionListener(new AddDeckButtonListener());
        removeButton.addActionListener(new RemoveDeckButtonListener());
        editButton.addActionListener(new EditDeckButtonListener());
        
        optionPanel.add(addButton);
        optionPanel.add(removeButton);
        optionPanel.add(editButton);
        
        // validate
        add(decksPanel, BorderLayout.CENTER);
        add(optionPanel, BorderLayout.EAST);
        validate();
    }
    
    class AddDeckButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ViewDecksHelperPanel decksPanel = DeckPanel.this.decksPanel;
            AskNoteModel model = AskNoteModel.instance();
            
            if (decksPanel.selected != null){
                decksPanel.selected.deSelect();
                decksPanel.selected = null;
            }
            
            model.setCurrentPage(PageType.EDIT_DECK);
            
            Deck deck = new Deck();
            deck.setIsNewAddition(true);
            
            model.setSelectedDeck(deck);
            
            AskNoteView.instance().updateView();
        }
    
    }
    
    
    class EditDeckButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            AskNoteView view = AskNoteView.instance();
            ViewDecksHelperPanel decksPanel = DeckPanel.this.decksPanel;
            
            if (decksPanel.selected != null){
                Deck deck = decksPanel.selected.deck;
                deck.setIsNewAddition(false);
                model.setSelectedDeck(deck);
                
                model.setCurrentPage(PageType.EDIT_DECK);
                view.updateView();
                
            }
            //TODO - what should be done if nothing is selected
        }
    
    }
    
    class RemoveDeckButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteView view = AskNoteView.instance();
            AskNoteModel model = AskNoteModel.instance();
            ViewDecksHelperPanel decksPanel = DeckPanel.this.decksPanel;
            
            if (decksPanel.selected != null){
                Deck toRemove = decksPanel.selected.deck;
                
                String msg = "Are you sure you want to delete the deck \"" + 
                        toRemove.getTitle() + "\"?";
                int response = JOptionPane.showConfirmDialog(decksPanel, msg,
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (response == JOptionPane.YES_OPTION) {
                    model.deleteDeck(toRemove);
                    view.updateView();
                }
            }
            //TODO - what should happen if nothing is selected?
            
        }
        
    
    }
}
