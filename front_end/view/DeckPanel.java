/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    
    public DeckPanel(List<Deck> decks) throws MalformedURLException {
        
        // init top level panel
        
         
        setLayout(new BorderLayout());
            
        // init leftmost deck panel
        this.decksPanel = new ViewDecksHelperPanel(decks);

        // init rightmost options panel
        JPanel oPanel = new JPanel();
        
        BoxLayout box = new BoxLayout(oPanel, BoxLayout.Y_AXIS); 
        oPanel.setLayout(box);
        
//        JButton addButton = new JButton("Add Deck");   
//        JButton removeButton = new JButton("Remove Deck");
//        JButton editButton = new JButton("Edit Deck");
        
        Constants constant = new Constants();
        
      
        
        OptionPanel add = new OptionPanel(constant.getImage("Add"), "Add Deck");     
        OptionPanel delete = new OptionPanel(constant.getImage("Delete"), "Remove Deck");
        OptionPanel edit = new OptionPanel(constant.getImage("Edit"), "Edit Deck");
        
          add.button.addActionListener(new AddDeckButtonListener());
        delete.button.addActionListener(new RemoveDeckButtonListener());
        edit.button.addActionListener(new EditDeckButtonListener());
        
        oPanel.add(add); 
        oPanel.add(delete);
        oPanel.add(edit);
        
        // validate
        add(decksPanel, BorderLayout.CENTER);
        add(oPanel, BorderLayout.EAST);
        validate();
    }
    
    class OptionPanel  extends JPanel { 
           JButton button; 
           JLabel label; 
        OptionPanel(ImageIcon icon, String label) { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEADING);
            JButton bttn = new JButton(icon); 
            JLabel lbl = new JLabel(label); 

            Font font = new Font("SanSarif", Font.BOLD, 20); 

            lbl.setFont(font);
            bttn.setFont(font);
             
            this.button = bttn; 
            
            flow.setHgap(25);
            this.setMaximumSize(new Dimension(500, 100));

            this.setLayout(flow); 
            this.add(bttn); 
            this.add(lbl); 
            
            this.validate();

        }
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
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(DeckPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                try {                    
                    view.updateView();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(DeckPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

                
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
                    try {
                        view.updateView();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(DeckPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            //TODO - what should happen if nothing is selected?
            
        }
        
    
    }
}
