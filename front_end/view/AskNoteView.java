package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiffanychao
 */
public class AskNoteView  extends JPanel{
    
    public AskNoteView(JPanel currentView, String title, List<String> notifications) { 
        JPanel header = new HeaderPanel(title, notifications.size()); 
      
        
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
        
        this.add(header, BorderLayout.NORTH);
        this.add(currentView, BorderLayout.CENTER);
        
        this.validate();
    } 
    
   
}