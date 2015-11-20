/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.*;

/**
 *
 * @author Maha Alkhairy
 */
public class QuizWaitingPanel extends JPanel {
    public QuizWaitingPanel (Quiz quiz) { 
       BorderLayout border = new BorderLayout();
       this.setLayout(border);
       
       TextPanel textPanel = new TextPanel(quiz); 
       ButtonPanel buttons = new ButtonPanel(); 
       
       this.add(textPanel, BorderLayout.CENTER);
       this.add(buttons, BorderLayout.SOUTH); 
       this.validate();
       
    }
    
    class TextPanel extends JPanel { 
        TextPanel(Quiz quiz) {
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.CENTER);
        
        JLabel waitingFor = new JLabel("Waiting for "); 
        JLabel friend = new JLabel(quiz.getFriend()); 
        JLabel to = new JLabel("to"); 
        JLabel action = new JLabel("start quiz"); 
        
        
        
        
        waitingFor.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40)); 
        friend.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        to.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40)); 
        action.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        
        
        flow.setVgap(200);
        flow.setHgap(20);
        this.setLayout(flow);
        
        this.add(waitingFor); 
        this.add(friend); 
        this.add(to); 
        this.add(action); 
        this.validate();
        
       
        } 
        

        
    }
    
    class ButtonPanel extends JPanel { 
         ButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            JButton cancel = new JButton("cancel");        
            this.setLayout(flow);
            this.add(cancel);
            
         } 
    }

}
