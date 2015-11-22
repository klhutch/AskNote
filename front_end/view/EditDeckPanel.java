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
import java.util.ArrayList;
import java.util.List;
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
    
    public EditDeckPanel(Deck deck) {
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
        TitlePanel (Deck deck) { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            
            this.text = new JLabel(deck.getEditTitle());  
            JButton edit = new JButton("edit"); 
            
            edit.addActionListener(new EditTitleListener());
            
            this.setLayout(flow);
            this.add(text);
            this.add(edit);
            
            
         }
        
        class EditTitleListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = "Edit Deck Title";
                String text = JOptionPane.showInputDialog(AskNoteView.instance(),
                        msg, TitlePanel.this.text.getText());
                TitlePanel.this.text.setText(text);
                EditDeckPanel.this.deck.editTitle(text);            
            }
        }
    }

///////// Buttons  Bottom ////////   
    class ButtonPanel extends JPanel { 
         ButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            
            JButton add = new JButton("add");  
            JButton save = new JButton("save"); 
            JButton cancel = new JButton("cancel"); 
            
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
            AskNoteView.instance().updateView();
        }
        
    }
    
    class CancelEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel.instance().setPreviousAsCurrent();
            //TODO add a confirmation dialog
            EditDeckPanel.this.deck.cancelEdits();
            AskNoteView.instance().updateView();
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
            AskNoteView.instance().updateView();
        }
        
    }


/////////////// for flash cards///////////
    class FlashCardsPanel extends JPanel implements Scrollable {

        FlashCardsPanel(Deck deck) {
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
            CardTextPanel shownText;
            
            FlashCardPanel(FlashCard card) {
                this.card = card;
                //BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
                this.setLayout(new BorderLayout());
                this.setPreferredSize(flashCardPanelSize);
                this.setBackground(Color.WHITE);               

                this.shownText = new CardTextPanel(card.getSide1());
                FlashCardButtonPanel buttons = new FlashCardButtonPanel();

                this.setBorder(new LineBorder(Color.BLACK, 1));

                this.add(shownText, BorderLayout.CENTER);
                this.add(buttons, BorderLayout.SOUTH);
            }
            
            class FlashCardButtonPanel extends JPanel {

                FlashCardButtonPanel() {
                    FlowLayout flow = new FlowLayout();
                    flow.setAlignment(FlowLayout.CENTER);

                    JButton edit = new JButton("edit");
                    JButton flip = new JButton("flip");
                    
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
                        cardPanel.shownText.updateText(cardPanel.card.getSide2());
                    }
                    else {
                        cardPanel.side1Shown = true;
                        cardPanel.shownText.updateText(cardPanel.card.getSide1());
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
                    AskNoteView.instance().updateView();
                }
            }
        }

        class CardTextPanel extends JPanel {
            JTextArea cardSideText;
            CardTextPanel(String text) {
                this.setBackground(Color.WHITE);
                FlowLayout flow = new FlowLayout();
                flow.setAlignment(FlowLayout.CENTER);
                this.setLayout(flow);

                cardSideText = new JTextArea(text);
                cardSideText.setEnabled(false);
                cardSideText.setDisabledTextColor(Color.BLACK);
                cardSideText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
                cardSideText.setLineWrap(true);
                cardSideText.setWrapStyleWord(true);

                cardSideText.setCaretPosition(0);

                this.add(cardSideText);
            }
            
            void updateText(String text){
                cardSideText.setText(text);
            }
        }
    }
}