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
        
        
        FlashCardsPanel flashCards = new FlashCardsPanel(deck);
        this.add(flashCards);
        this.validate();

    }

}

/////////////// for flash cards///////////
class FlashCardsPanel extends JPanel {

    FlashCardsPanel(Deck deck) {
       
        GridLayout grid = new GridLayout(-1, 3);
        grid.setVgap(10);
        grid.setHgap(10);
        this.setLayout(grid);
        List<FlashCardViewPanel> cardPanels = new ArrayList<FlashCardViewPanel>();

        for (FlashCard card : deck.getCards()) {

            cardPanels.add(new FlashCardViewPanel(card));

        }

        for (FlashCardViewPanel card : cardPanels) {
            this.add(card);
        }
        
        
        
    }

    class FlashCardViewPanel extends JPanel {

        FlashCardViewPanel(FlashCard card) {
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
            this.setLayout(box);

            FlashCardPanel text = new FlashCardPanel(card);
            FlashCardButtonPanel buttons = new FlashCardButtonPanel();

            Border linedBorder = BorderFactory.createLineBorder(Color.BLACK);
            this.setBorder(linedBorder);

            this.add(text);
            this.add(buttons);

            this.setMaximumSize(new Dimension(50, 50));

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

        }
    }
}
