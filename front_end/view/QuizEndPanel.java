/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Maha Alkhairy
 */
public class QuizEndPanel extends JPanel {
    public QuizEndPanel () { 
       BorderLayout border = new BorderLayout();
       this.setLayout(border);
       
       TextPanel completePanel = new TextPanel(); 
       ButtonPanel buttons = new ButtonPanel(); 
       
       this.add(completePanel, BorderLayout.CENTER);
       this.add(buttons, BorderLayout.SOUTH); 
       this.validate();
       
    }
    
    class TextPanel extends JPanel { 
        TextPanel() {
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.CENTER);
        JLabel complete = new JLabel("complete"); 
        complete.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        flow.setVgap(200);
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
            JButton repeat = new JButton("repeat");
            JButton end = new JButton("end"); 
            
            
            
            this.setLayout(flow);
            this.add(repeat);
            this.add(end); 
            
         } 
    }

}
