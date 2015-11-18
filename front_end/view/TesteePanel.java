/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
        
        this.add(cardPanel, BorderLayout.EAST);
        this.add(responsePanel, BorderLayout.WEST);
        this.add(sendButton, BorderLayout.SOUTH);
        
        
        
    }
    
    class CardPanel extends JPanel {
        String shownSide;
        
        CardPanel(String shownSide) {
            this.shownSide = shownSide;
            
            JTextArea showText = new JTextArea(shownSide);
            showText.setEnabled(false);
            
            this.add(showText);
        }
        
    }
    
    class ResponsePanel extends JPanel {
    
        ResponsePanel() {
            
            JTextArea responseArea = new JTextArea();
            
            this.add(responseArea);
        }
    }
}
