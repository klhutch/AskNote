package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import model.Deck;
import model.FlashCard;

/**
 *
 * @author tiffanychao
 */
public class EditDeckPanel extends JPanel {
    Deck deck;
    
    public EditDeckPanel(Deck deck) {
    } 
      
    } 


    
    class CardsPanel extends JPanel { 
        CardsPanel(Deck deck) {
            
            
            List<FlashCardPanel> cardPanels = new ArrayList<FlashCardPanel>(); 
            
            for (FlashCard card: deck.getCards()) { 
                
                cardPanels.add(new FlashCardPanel(card)); 
               
            }
            
            for (FlashCardPanel card: cardPanels) { 
                this.add(card); 
            }
            } 
        
        
    class FlashCardPanel extends JPanel { 
        FlashCardPanel(FlashCard card) {
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.CENTER);
        
        JLabel cardSideText = new JLabel(card.getSide1()); 
        CardButtonPanel buttons = new CardButtonPanel();
        
        cardSideText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20)); 
        
        
        flow.setVgap(200);
        flow.setHgap(20);
        this.setLayout(flow);
        
        this.add(cardSideText); 
                
        
        }
       
    }
    
      class CardButtonPanel extends JPanel { 
         CardButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            JButton edit = new JButton("edit");   
            JButton flip = new JButton("flip"); 
            this.setLayout(flow);
            this.add(flip); 
            this.add(edit);
            
         } 
    }
} 
    
    

