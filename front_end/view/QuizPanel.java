/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.AskNoteModel;
import model.PageType;

/**
 *
 * @author Maha Alkhairy
 */
public class QuizPanel extends JPanel{
    public QuizPanel() { 
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
        flow.setHgap(20);
        flow.setVgap(200);
        this.setLayout(flow);
        
        JLabel quiz = new JLabel("Quiz"); 
        JButton self = new JButton("Self"); 
        JButton friends = new JButton("Friend"); 
        
        self.addActionListener(new QuizSelfButtonListener());
        friends.addActionListener(new QuizFriendsButtonListener());
        
        this.add(self); 
        this.add(friends); 
        this.validate();
    }
    
    private class QuizSelfButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.QUIZ_DECK);
            
            
            AskNoteView.instance().updateView();
        }
    
    }
    
    
    private class QuizFriendsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.QUIZ_SELECT);
            
            
            
            AskNoteView.instance().updateView();
        }
    
    }
    
    
        
}    
    