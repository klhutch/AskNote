/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
 



class InnerPanel extends JPanel { 
    InnerPanel(String button, String label) { 
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
        JButton bttn = new JButton(button); 
        JLabel lbl = new JLabel(label); 
        flow.setHgap(50);
        flow.setVgap(70); 
        this.setSize(500, 10);
        
        
        this.add(bttn); 
        this.add(lbl); 
        this.validate();
        
    }
}

/**
 *
 * @author Maha Alkhairy
 */
public class HomePagePanel extends JPanel{
    // takes nothing in 
    public HomePagePanel() {        
       
        InnerPanel decks = new InnerPanel("D", "Decks");     
        InnerPanel quizzes = new InnerPanel("Q", "Quiz"); 
        InnerPanel Friends = new InnerPanel("F", "Friends");
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 
        
        
        this.add(decks);
        this.add(quizzes); 
        this.add(Friends); 
        this.setLayout(box);
        
        this.validate();
        
        }    
}
