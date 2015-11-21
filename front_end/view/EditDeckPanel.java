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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.*;
import javax.swing.border.LineBorder;
import model.AskNoteModel;
import model.Deck;
import model.FlashCard;

/**
 *
 * @author tiffanychao
 */
public class EditDeckPanel extends JPanel {

    Deck deck;
    private Deck original;
    
    public EditDeckPanel(Deck deck) {
        this.original = deck;
        this.deck = new Deck(deck);
        
        BorderLayout border = new BorderLayout(); 
        border.setHgap(10); 
        border.setVgap(10); 
        
        this.setLayout(border);
        
        FlashCardsPanel flashCards = new FlashCardsPanel(this.deck);
        ButtonPanel buttons = new ButtonPanel(); 
        TitlePanel title = new TitlePanel(this.deck); 
        JScrollPane scrollPanel = new JScrollPane(flashCards);
        
        scrollPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        
        this.add(buttons, BorderLayout.SOUTH);
        this.add(title, BorderLayout.NORTH);
        this.add(scrollPanel, BorderLayout.CENTER);
       
        this.validate(); 
    }
    
    void updateOriginal(){
        original.setTitle(new String(deck.getTitle()));
        original.setCards(deck.getCards());
    }
    




//// title and edit button top // 

  class TitlePanel extends JPanel { 
         TitlePanel (Deck deck) { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            
            JLabel title = new JLabel(deck.getTitle());  
            JButton edit = new JButton("edit"); 
            
            this.setLayout(flow);
            this.add(title);
            this.add(edit);
            
            
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
            
            this.setLayout(flow);
            this.add(add);
            this.add(save);
            this.add(cancel); 
            
            
         } 
    }

/****************************** LISTENERS ********************************/
    
    
    
    class EditTitleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    class SaveEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel.instance().setPreviousAsCurrent();
            EditDeckPanel.this.updateOriginal();
            AskNoteView.instance().updateView();
        }
        
    }
    
    class CancelEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel.instance().setPreviousAsCurrent();
            AskNoteView.instance().updateView();
        }
    }


/////////////// for flash cards///////////
    class FlashCardsPanel extends JPanel {

        FlashCardsPanel(Deck deck) {
            //TODO: make the number of columns dynamic
            GridLayout grid = new GridLayout(-1, 3);
            grid.setVgap(20);
            grid.setHgap(20);

            this.setLayout(grid);
            List<FlashCardPanel> cardPanels = new ArrayList<FlashCardPanel>();

            for (FlashCard card : deck.getCards()) {

                cardPanels.add(new FlashCardPanel(card));

            }

            for (FlashCardPanel card : cardPanels) {
                this.add(card);
            }

            this.setSize(new Dimension(200, 150));


        }

        class FlashCardPanel extends JPanel {

            FlashCardPanel(FlashCard card) {
                //BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
                this.setLayout(new BorderLayout());
                this.setBackground(Color.WHITE);


                CardTextPanel text = new CardTextPanel(card.getSide1());
                FlashCardButtonPanel buttons = new FlashCardButtonPanel();

                this.setBorder(new LineBorder(Color.BLACK, 1));

                this.add(text, BorderLayout.CENTER);
                this.add(buttons, BorderLayout.SOUTH);

                //this.setPreferredSize(new Dimension(200, 100));


            }

            class FlipCardListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

            }
            class EditCardListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
        }

        class CardTextPanel extends JPanel {

            CardTextPanel(String text) {
                this.setBackground(Color.WHITE);
                FlowLayout flow = new FlowLayout();
                flow.setAlignment(FlowLayout.CENTER);
                this.setLayout(flow);



                JTextArea cardSideText = new JTextArea(text);
                cardSideText.setEnabled(false);
                cardSideText.setDisabledTextColor(Color.BLACK);
                cardSideText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                cardSideText.setLineWrap(true);
                cardSideText.setWrapStyleWord(true);

                cardSideText.setCaretPosition(0);

                this.add(cardSideText);


            }

        }

        class FlashCardButtonPanel extends JPanel {

            FlashCardButtonPanel() {
                FlowLayout flow = new FlowLayout();
                flow.setAlignment(FlowLayout.CENTER);

                JButton edit = new JButton("edit");
                JButton flip = new JButton("flip");
                this.setLayout(flow);
                this.add(flip);
                this.add(edit);
                this.setBackground(Color.WHITE);

            }
        }



    }
}