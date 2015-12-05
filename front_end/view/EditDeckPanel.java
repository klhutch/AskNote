package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.border.*;
import javax.swing.border.LineBorder;
import model.AskNoteModel;
import model.Deck;
import model.FlashCard;
import model.PageType;

/**
 *
 * @author tiffanychao
 */
public class EditDeckPanel extends JPanel {
    private final Dimension flashCardPanelSize = new Dimension(225, 100);
    Deck deck;
    TitlePanel title;
    FlashCardsPanel flashCards;
    
    public EditDeckPanel(Deck deck) throws MalformedURLException {
        this.deck = deck;
        this.deck.startEdits();
        
        this.flashCards = new FlashCardsPanel(this.deck);
        this.title = new TitlePanel(this.deck); 
        
        BorderLayout border = new BorderLayout(); 
        border.setHgap(10); 
        border.setVgap(10);  
        this.setLayout(border);
      
        ButtonPanel buttons = new ButtonPanel(); 
        JScrollPane scrollPanel = new JScrollPane(flashCards);
        
        scrollPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        
        this.add(buttons, BorderLayout.SOUTH);
        this.add(title, BorderLayout.NORTH);
        this.add(scrollPanel, BorderLayout.CENTER);
       
        this.validate(); 
    }
    
//// title and edit button top // 
  class TitlePanel extends JPanel { 
        JLabel text;
        Constants constant;
        TitlePanel (Deck deck) throws MalformedURLException { 
            this.constant = new Constants();
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            
            this.text = new JLabel(deck.getEditTitle()); 
            this.text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            JButton edit = new JButton(constant.getImage("Edit")); 
            
            edit.addActionListener(new EditTitleListener());
            
            this.setLayout(flow);
            this.add(text);
            this.add(edit);   
         }
        
        class EditTitleListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = "Edit Deck Title";
                String newText = JOptionPane.showInputDialog(AskNoteView.instance(),
                        msg, TitlePanel.this.text.getText());

                if (newText != null && !newText.equals("")) {
                    TitlePanel.this.text.setText(newText);
                    EditDeckPanel.this.deck.editTitle(newText);
                }
            }
        }
    }

///////// Buttons  Bottom ////////   
    class ButtonPanel extends JPanel { 
         ButtonPanel () throws MalformedURLException { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            
            Constants constant = new Constants();
            
            JButton add = new JButton(constant.getImage("Add"));  
            JButton save = new JButton(constant.getImage("Save")); 
            JButton cancel = new JButton(constant.getImage("Cancel")); 
            
            add.addActionListener(new AddCardListener());
            save.addActionListener(new SaveEditListener());
            cancel.addActionListener(new CancelEditListener());
            
            this.setLayout(flow);
            this.add(add);
            this.add(save);
            this.add(cancel); 
            
            
         } 
    }

/****************************** LISTENERS ********************************/
    
    class SaveEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel.instance().setPreviousAsCurrent();
            //TODO add a confirmation dialog
            EditDeckPanel.this.deck.saveEdits();
            
            if(EditDeckPanel.this.deck.getIsNewAddition()){
                AskNoteModel.instance().addDeck(EditDeckPanel.this.deck);
            }
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EditDeckPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class CancelEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel.instance().setPreviousAsCurrent();
       
              
                
                String msg = "All changes to the deck will be discarded, are you sure you want to cancel?";
                int response = JOptionPane.showConfirmDialog(EditDeckPanel.this, msg,
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (response == JOptionPane.YES_OPTION) {
                     //TODO add a confirmation dialog
                      EditDeckPanel.this.deck.cancelEdits();
                try {
                    AskNoteView.instance().updateView();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(EditDeckPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                
           
        }
    }
    
    class AddCardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            
            FlashCard card = new FlashCard();
            card.setIsNewAddition(true);
            EditDeckPanel.this.deck.editAddCard(card);
            
            model.setSelectedFlashCard(card);
            model.setCurrentPage(PageType.EDIT_CARD);
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EditDeckPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }


/////////////// for flash cards///////////
    class FlashCardsPanel extends JPanel implements Scrollable {

        FlashCardsPanel(Deck deck) throws MalformedURLException {
            setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
            setPreferredSize(findPreferredSize(deck.getSize()));
            List<FlashCardPanel> cardPanels = new ArrayList<FlashCardPanel>();

            for (FlashCard card : deck.getEditCards()) {
                cardPanels.add(new FlashCardPanel(card));
            }

            for (FlashCardPanel card : cardPanels) {
                this.add(card);
            }
        }
        
        private Dimension findPreferredSize(int numCards) {
            // AskNoteView.width == 1000. should put this in a global constant 
            // flashcardpanelsize.width = 225
            // FlowLayout hgap = 8
            // 225 * 4 = 900, 900 + 20 * 5 = 1000
            int cols = 4;
            int remainder = numCards % cols;
            int rows;
            if (remainder == 0) {
                rows = numCards / cols;
            } else {
                rows = ((numCards - remainder) / cols) + 1;
            }
            return new Dimension(1000, flashCardPanelSize.height * rows + 20 * rows + 20);
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            // AskNoteView.height == 600. should put this in a global constant 
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

        class FlashCardPanel extends JPanel {
            FlashCard card;
            Boolean side1Shown = true;
            JLabel shownText;
            
            FlashCardPanel(FlashCard card) throws MalformedURLException {
                this.card = card;
                this.setLayout(new BorderLayout(5, 5));
                this.setPreferredSize(flashCardPanelSize);
                this.setBackground(Color.WHITE);               

                this.shownText = new JLabel(card.getSide1(), SwingConstants.CENTER);
                this.shownText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
                FlashCardButtonPanel buttons = new FlashCardButtonPanel();

                this.setBorder(new LineBorder(Color.BLACK, 1));

                this.add(shownText, BorderLayout.CENTER);
                this.add(buttons, BorderLayout.SOUTH);
            }
            
            void updateText(String text){
                shownText.setText(text);
            }
            
            class FlashCardButtonPanel extends JPanel {

                Constants constant;
                
                FlashCardButtonPanel() throws MalformedURLException {
                    this.constant = new Constants();
                    FlowLayout flow = new FlowLayout();
                    flow.setAlignment(FlowLayout.CENTER);

                    JButton edit = new JButton(constant.getImage("Edit"));
                    JButton flip = new JButton(constant.getImage("Flip"));
                    
                    edit.addActionListener(new EditCardListener());
                    flip.addActionListener(new FlipCardListener());
                    
                    this.setLayout(flow);
                    this.add(flip);
                    this.add(edit);
                    this.setBackground(Color.WHITE);
                }
            }

            class FlipCardListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    FlashCardPanel cardPanel = FlashCardPanel.this;
            
                    if(cardPanel.side1Shown) {
                        cardPanel.side1Shown = false;
                        cardPanel.updateText(cardPanel.card.getSide2());
                    }
                    else {
                        cardPanel.side1Shown = true;
                        cardPanel.updateText(cardPanel.card.getSide1());
                    }
                }
            }
            
            class EditCardListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    AskNoteModel model = AskNoteModel.instance();
            
                    FlashCard card = FlashCardPanel.this.card;

                    model.setSelectedFlashCard(card);
                    model.setCurrentPage(PageType.EDIT_CARD);
                    try {
                        AskNoteView.instance().updateView();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(EditDeckPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}