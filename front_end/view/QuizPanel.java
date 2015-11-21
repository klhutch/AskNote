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
        JLabel complete = new JLabel("quiz"); 
        complete.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        this.setMaximumSize(new Dimension(300, 70));
        flow.setVgap(10);
        this.setLayout(flow);
        this.add(complete); 
        this.validate();
        
       
        } 
        
    }
    
    class ButtonPanel extends JPanel { 
         ButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            JButton repeat = new JButton("self");
            JButton end = new JButton("friend"); 
            
            this.setLayout(flow);
            this.add(repeat);
            this.add(end); 
            
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
    