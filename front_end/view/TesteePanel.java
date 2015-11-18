/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author normal
 */
public class TesteePanel extends JPanel {
    
    public TesteePanel(String shownSide) {
    
        this.setLayout(new BorderLayout());
        
        CardPanel cardPanel = new CardPanel(shownSide);
        ResponsePanel responsePanel = new ResponsePanel();
        
        JButton sendButton = new JButton("Send");
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        
        center.add(cardPanel);
        center.add(responsePanel);
        
        this.add(center, BorderLayout.CENTER);
        this.add(sendButton, BorderLayout.SOUTH);
        
        
        
    }
    
    class CardPanel extends JPanel {
        String shownSide;
        
        CardPanel(String shownSide) {
            this.shownSide = shownSide;
            //this.setLayout(new BorderLayout());
            JLabel shown = new JLabel("Shown Side");
            JTextArea showText = new JTextArea(shownSide, 30, 40);
            showText.setEnabled(false);
//            showText.setRows(10);
//            showText.setMinimumSize(new Dimension(300, 300));
            showText.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
            showText.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            
            showText.setBorder(new LineBorder(Color.BLACK, 1));
            this.add(shown);
            this.add(showText);
        }
        
    }
    
    class ResponsePanel extends JPanel {
    
        ResponsePanel() {
            //this.setLayout(new BorderLayout());
            JLabel otherSide = new JLabel("What's On The Other Side?");
            JTextArea responseArea = new JTextArea(30, 40);
            responseArea.setEnabled(true);
            
//            responseArea.setRows(10);
//            responseArea.setPreferredSize(new Dimension(300, 300));
            
            responseArea.setBorder(new LineBorder(Color.BLACK, 1));
            this.add(otherSide);
            this.add(responseArea);
        }
    }
}
