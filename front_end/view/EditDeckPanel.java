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
import javax.swing.SwingConstants;
import javax.swing.border.*;
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
        
        
        BorderLayout border = new BorderLayout(); 
        border.setHgap(10); 
        border.setVgap(10); 
        
        this.setLayout(border);
        
        FlashCardsPanel flashCards = new FlashCardsPanel(deck);
        ButtonPanel buttons = new ButtonPanel(); 
        TitlePanel title = new TitlePanel(deck); 
        JScrollPane scrollPanel = new JScrollPane(flashCards);
        
        this.add(buttons, BorderLayout.SOUTH);
        this.add(title, BorderLayout.NORTH);
        this.add(scrollPanel, BorderLayout.CENTER);
       
        this.validate(); 
    }

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


/////////////// for flash cards///////////
class FlashCardsPanel extends JPanel {

    FlashCardsPanel(Deck deck) {
       
        GridLayout grid = new GridLayout(-1, 3);
        grid.setVgap(20);
        grid.setHgap(20);
        this.setLayout(grid);
        List<FlashCardViewPanel> cardPanels = new ArrayList<FlashCardViewPanel>();

        for (FlashCard card : deck.getCards()) {

            cardPanels.add(new FlashCardViewPanel(card));

        }

        for (FlashCardViewPanel card : cardPanels) {
            this.add(card);
        }
        
        this.setSize(new Dimension(200, 100));
        
        
    }

    class FlashCardViewPanel extends JPanel {

        FlashCardViewPanel(FlashCard card) {
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
            this.setLayout(box);
            this.setBackground(Color.WHITE);

            FlashCardPanel text = new FlashCardPanel(card);
            FlashCardButtonPanel buttons = new FlashCardButtonPanel();

            Border linedBorder = BorderFactory.createLineBorder(Color.BLACK);
            //this.setBorder(linedBorder);

            this.add(text);
            this.add(buttons);

          //  this.setMaximumSize(new Dimension(100, 100));
            

        }
    }

    class FlashCardPanel extends JPanel {

        FlashCardPanel(FlashCard card) {

            FlowLayout flow = new FlowLayout();
            flow.setAlignment(FlowLayout.CENTER);

            flow.setVgap(20);
            flow.setHgap(20);

            JPanel textPanel = new JPanel();
            textPanel.setLayout(flow);

            JLabel cardSideText = new JLabel(card.getSide1());

            cardSideText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

            this.setLayout(flow);
            this.add(cardSideText);
            this.setBackground(Color.WHITE);

        }

    }

    class FlashCardButtonPanel extends JPanel {

        FlashCardButtonPanel() {
            FlowLayout flow = new FlowLayout();
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25);
            flow.setVgap(20);
            JButton edit = new JButton("edit");
            JButton flip = new JButton("flip");
            this.setLayout(flow);
            this.add(flip);
            this.add(edit);
            this.setBackground(Color.WHITE);

        }
    }
}
