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
public class QuizChoose extends JPanel{
    public QuizChoose() { 
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);
        flow.setHgap(20);
        flow.setVgap(200);
        this.setLayout(flow);
        
        
        JButton self = new JButton("Quiz self"); 
        JButton friends = new JButton("Quiz with a friend"); 
      
        this.add(self); 
        this.add(friends); 
        this.validate();
        } 
        
    }    
    