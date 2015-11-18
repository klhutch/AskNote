/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import model.*;

public class TesterPanel extends JPanel{
     
    public TesterPanel(FlashCard card, String response, Boolean side1wasShown) {
    
        this.setLayout(new BorderLayout());
        
        CardPanel cardPanel;
        if(side1wasShown) {
            cardPanel = new CardPanel(card.getSide1(), card.getSide2());
        }
        else {
            cardPanel = new CardPanel(card.getSide2(), card.getSide1());
        }
        
        ResponsePanel responsePanel = new ResponsePanel(response);
        
        JButton correctButton = new JButton("Correct");
        JButton incorrectButton = new JButton("Incorrect");
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        
        center.add(cardPanel);
        center.add(responsePanel);
        
        JPanel south = new JPanel();
        south.add(correctButton);
        south.add(incorrectButton);
        
        
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);
}

    class CardPanel extends JPanel {
        String shownSide;
        String reverseSide;
        JLabel title;
        JTextArea responseArea;
        
        CardPanel(String shownSide, String reverseSide) {
            this.shownSide = shownSide;
            this.reverseSide = reverseSide;
            
            //this.setLayout(new BorderLayout());
            this.title = new JLabel("Shown Side");
            JButton flip = new JButton("flip");
            
            flip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(CardPanel.this.title.getText().equals("Shown Side")) {
                        CardPanel.this.title.setText("Reverse Side");
                        CardPanel.this.responseArea.setText(CardPanel.this.reverseSide);
                        CardPanel.this.repaint();
                    }
                    else {
                        CardPanel.this.title.setText("Shown Side");
                        CardPanel.this.responseArea.setText(CardPanel.this.shownSide);
                        CardPanel.this.repaint();
                    }
                }
            });
            
            
            
            this.responseArea = new JTextArea(shownSide, 30, 40);
            responseArea.setEnabled(false);
            
            
            responseArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
            responseArea.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            
            responseArea.setBorder(new LineBorder(Color.BLACK, 1));
            
            JPanel north = new JPanel();
            north.add(title);
            north.add(flip);
            north.setPreferredSize(new Dimension(500, 30));
            
            this.add(north, BorderLayout.NORTH);
            this.add(responseArea, BorderLayout.CENTER);
        }
        
    }
    
    class ResponsePanel extends JPanel {
        String response;
        
        ResponsePanel(String response) {
            this.response = response;
            //this.setLayout(new BorderLayout());
            JLabel title = new JLabel("Response");
            JTextArea responseArea = new JTextArea(response, 30, 40);
            responseArea.setEnabled(false);
//            showText.setRows(10);
//            showText.setMinimumSize(new Dimension(300, 300));
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