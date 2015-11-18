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
<<<<<<< HEAD:front_end/view/AsknoteView.java
public class AsknoteView  extends JPanel{
    
    public AsknoteView(JPanel currentView, String title, List<String> notifications) { 
        JPanel header = new HeaderPanel(title, notifications.size()); 
=======
public class AskNoteView {
    protected static AskNoteModel model = new AskNoteModel();
    
    public AskNoteView() { 
      
>>>>>>> 81116294f9e28c18943233eb9318677846228280:front_end/view/AskNoteView.java
        
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
        
        this.add(header, BorderLayout.NORTH);
        this.add(currentView, BorderLayout.CENTER);
        
        this.validate();
    } 
    
   
}
