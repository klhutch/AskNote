/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
       flow.setVgap(200);
       CombinedButtonTextPanel innerPanel = new CombinedButtonTextPanel(); 
       
       this.setLayout(flow);
       this.add(innerPanel); 
       
       
       this.validate();
       
    }
    
    class TextPanel extends JPanel { 
        TextPanel() {
            FlowLayout flow = new FlowLayout();
            flow.setAlignment(FlowLayout.CENTER);

            JLabel quiz = new JLabel("Quiz"); 
            quiz.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

            this.setMaximumSize(new Dimension(300, 70));
            
            flow.setVgap(10);
            
            this.setLayout(flow);
            this.add(quiz); 
            this.validate();
        
       
        } 
        
    }
    
    class ButtonPanel extends JPanel { 
         ButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            
            JButton self = new JButton("self");
            JButton friends = new JButton("friends"); 
            
            self.addActionListener(new QuizSelfButtonListener());
            friends.addActionListener(new QuizFriendsButtonListener());
            
            this.setLayout(flow);
            this.add(self);
            this.add(friends); 
            
         } 
    }
    
    class CombinedButtonTextPanel extends JPanel { 
        CombinedButtonTextPanel () { 
            
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 
            this.setLayout(box);
            TextPanel text = new TextPanel(); 
            ButtonPanel buttons = new ButtonPanel(); 
            
            this.add(text); 
            this.add(buttons);
            
        }
    }
    
    
    private class QuizSelfButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.QUIZ_DECK);
            
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(QuizPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
    private class QuizFriendsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.QUIZ_SELECT);
            
            
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(QuizPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
        
}    
    