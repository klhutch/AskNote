/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JFrame;
import model.FlashCard;
import view.EditCardPanel;

/**
 *
 * @author tiffanychao
 */
public class TestEditCard extends JDialog {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AskNote");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1000, 600);
        
        FlashCard card = new FlashCard("I Solemnly Swear I am up to no good", 
                                        "The Marauder's Map Password");
        
        EditCardPanel testPanel = new EditCardPanel(card);
        
        
        frame.add(testPanel);
        frame.setVisible(true);
        
        
    }
}
