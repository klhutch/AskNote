/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.net.MalformedURLException;
import javax.swing.*;

/**
 *
 * @author Maha Alkhairy
 */

// Not used 
public class QuizEndPanel extends JPanel {
    public QuizEndPanel () throws MalformedURLException { 
       FlowLayout flow = new FlowLayout(); 
       flow.setAlignment(FlowLayout.CENTER);
       flow.setVgap(200);
       CombinedButtonTextPanel innerPanel = new CombinedButtonTextPanel(); 
   
       this.setLayout(flow);
       this.add(innerPanel); 
       
       
       this.validate();
       
    }
    
    class TextPanel extends JPanel { 
        TextPanel() throws MalformedURLException {
       Constants constant = new Constants(); 
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.CENTER);
        JLabel complete = new JLabel("complete"); 
        complete.setFont(constant.getFont("Larger"));
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
            JButton repeat = new JButton("repeat");
            JButton end = new JButton("end"); 
            
            this.setLayout(flow);
            this.add(repeat);
            this.add(end); 
            
         } 
    }
    
    class CombinedButtonTextPanel extends JPanel { 
        CombinedButtonTextPanel () throws MalformedURLException { 
            
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 
            this.setLayout(box);
            TextPanel text = new TextPanel(); 
            ButtonPanel buttons = new ButtonPanel(); 
            
            this.add(text); 
            this.add(buttons);
            
        }
      }

}
