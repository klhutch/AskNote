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
import model.Flashcard;
import javax.swing.border.LineBorder;

/**
 * Note: This JPanel should be added to a JDialog
 */
public class EditCardPanel extends JPanel {
    SidePanel side1;
    SidePanel side2;
    
    public EditCardPanel(Flashcard card) {
    
        this.setLayout(new BorderLayout());
        
        this.side1 = new SidePanel(card.getSide1(), "Side 1") ;
        this.side2 = new SidePanel(card.getSide2(), "Side 2");
        
        
        JButton correctButton = new JButton("Save");
        JButton incorrectButton = new JButton("Delete Card");
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        
        center.add(side1);
        center.add(side2);
        
        JPanel south = new JPanel();
        south.add(correctButton);
        south.add(incorrectButton);
        
        
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);    
    }
    
    
    
    class SidePanel extends JPanel {
        String text;
        
        SidePanel(String text, String side) {
            this.text = text;
            //this.setLayout(new BorderLayout());
            JLabel title = new JLabel(side);
            JTextArea responseArea = new JTextArea(text, 30, 40);
            responseArea.setEnabled(true);
            
            responseArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
            responseArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            
            responseArea.setBorder(new LineBorder(Color.BLACK, 1));
            
            JPanel north = new JPanel();
            north.add(title);
            north.setPreferredSize(new Dimension(500, 30));
            
            this.add(north, BorderLayout.NORTH);
            this.add(responseArea, BorderLayout.CENTER);
        }
    }
}
