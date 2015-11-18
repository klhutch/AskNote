/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
//    
//      class CardPanel extends JPanel {
//        FlashCard card; 
//        boolean side1Shown; 
//        JLabel title;
//        
//        CardPanel(FlashCard card) {
//             this.card = card; 
//             
//           
//            
//            //this.setLayout(new BorderLayout());
//            this.title = new JLabel("Shown Side");
//            JButton flip = new JButton("flip");
//            
//            flip.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if(CardPanel.this.side1Shown) {
//                        CardPanel.this.title.setText(card.getSide2());
//                        CardPanel.this.repaint();
//                    }
//                    else {
//                        CardPanel.this.title.setText(card.getSide1());
//                        CardPanel.this.repaint();
//                    }
//                }
//            });
//            
//            
//            
////            this.responseArea = new JTextArea(shownSide, 30, 40);
////            responseArea.setEnabled(false);
////            
////            
////            responseArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
////            responseArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
////            
////            responseArea.setBorder(new LineBorder(Color.BLACK, 1));
////            
////            JPanel north = new JPanel();
////            north.add(title);
////            north.add(flip);
////            north.setPreferredSize(new Dimension(500, 30));
////            
////            this.add(north, BorderLayout.NORTH);
////            this.add(responseArea, BorderLayout.CENTER);
////        }
//        
//    }
//    
    
} 
