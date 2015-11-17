package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.FlashCard;

/**
 * Note: This JPanel should be added to a dialog box
 */
public class EditCardPanel extends JPanel {
    
    public EditCardPanel(FlashCard card) {
        
        // init jpanels for each side        
        JLabel side1Label = new JLabel("Side 1");
        JTextArea side1Text = new JTextArea(card.getSide1(), 8, 16);
        JLabel side2Label = new JLabel("Side 2");
        JTextArea side2Text = new JTextArea(card.getSide2(), 8, 16);
        
        JPanel side1Panel = new JPanel();      
        side1Panel.setLayout(new BorderLayout());
        side1Panel.add(side1Label, BorderLayout.NORTH);
        side1Panel.add(side1Text, BorderLayout.CENTER);
        
        JPanel side2Panel = new JPanel();      
        side2Panel.setLayout(new BorderLayout());
        side2Panel.add(side2Label, BorderLayout.NORTH);
        side2Panel.add(side2Text, BorderLayout.CENTER);
        
        JPanel cardPanel = new JPanel(new FlowLayout());
        cardPanel.add(side1Panel);
        cardPanel.add(side2Panel);
        
        // init save/cancel buttons
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        
        // top level panel
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        validate();
    }
}
