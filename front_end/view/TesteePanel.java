/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author normal
 */
public class TesteePanel extends JPanel {
    String shownSide;
    
    public TesteePanel(String shownSide) {
        this.shownSide = shownSide;
        
        
        this.setLayout(new BorderLayout());
        
        CardPanel cardPanel = new CardPanel();
        ResponsePanel responsePanel = new ResponsePanel();
        
        JButton sendButton = new JButton("Send");
        
        this.add(cardPanel, BorderLayout.EAST);
        this.add(responsePanel, BorderLayout.WEST);
        this.add(sendButton, BorderLayout.SOUTH);
        
        
        
    }
    
    class CardPanel extends JPanel {
        
    }
    
    class ResponsePanel extends JPanel {
        
    }
}
