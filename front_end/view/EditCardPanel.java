package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.FlashCard;
import javax.swing.border.LineBorder;
import model.AskNoteModel;

/**
 * Note: This JPanel should be added to a JDialog
 */
public class EditCardPanel extends JPanel {
    SidePanel side1;
    SidePanel side2;
    FlashCard card;
    
    public EditCardPanel(FlashCard card) {
        this.card = card;
        this.setLayout(new BorderLayout());
        
        this.side1 = new SidePanel(card.getSide1(), "Side 1") ;
        this.side2 = new SidePanel(card.getSide2(), "Side 2");
        
        
        JButton save = new JButton("Save");
        JButton delete = new JButton("Delete Card");
        JButton cancel = new JButton("Cancel");
        
        save.addActionListener(new SaveCardEditListener());
        cancel.addActionListener(new CancelCardEditListener());
        delete.addActionListener(new DeleteCardListener());
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        
        center.add(side1);
        center.add(side2);
        
        JPanel south = new JPanel();
        south.add(save);
        south.add(cancel);
        south.add(delete);
        
        
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);    
    }
    
    
    
    class SidePanel extends JPanel {
        JTextArea text;
        
        SidePanel(String str, String side) {
            //this.setLayout(new BorderLayout());
            JLabel title = new JLabel(side);
            this.text = new JTextArea(str, 30, 40);
            this.text.setEnabled(true);
            
            this.text.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
            this.text.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            
            this.text.setBorder(new LineBorder(Color.BLACK, 1));
            
            JPanel north = new JPanel();
            north.add(title);
            north.setPreferredSize(new Dimension(500, 30));
            
            this.add(north, BorderLayout.NORTH);
            this.add(text, BorderLayout.CENTER);
        }
    }
    
    class SaveCardEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FlashCard card = EditCardPanel.this.card;
            
            if(card.getIsNewAddition()){
                card.setIsNewAddition(false);
            }
            
            card.setSide1(EditCardPanel.this.side1.text.getText());
            card.setSide2(EditCardPanel.this.side2.text.getText());
            
            AskNoteModel.instance().setPreviousAsCurrent();
            AskNoteModel.instance().setSelectedFlashCard(null);
            AskNoteView.instance().updateView();
        }
    }
    
    class CancelCardEditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FlashCard card = EditCardPanel.this.card;
            AskNoteModel model = AskNoteModel.instance();
            
            if (card.getIsNewAddition()) {
                model.getSelectedDeck().editRemoveCard(card);
                
            }
            model.setPreviousAsCurrent();
            model.setSelectedFlashCard(null);
            AskNoteView.instance().updateView();
        }
    }
    
    class DeleteCardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.getSelectedDeck().editRemoveCard(EditCardPanel.this.card);
            
            model.setPreviousAsCurrent();
            model.setSelectedFlashCard(null);
            AskNoteView.instance().updateView();
        }
    }
    
}
