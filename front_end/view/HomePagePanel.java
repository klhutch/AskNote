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
<<<<<<< HEAD
    public HomePagePanel() {
        
        // create layout managers
        FlowLayout titleFlow = new FlowLayout(); 
        titleFlow.setAlignment(FlowLayout.CENTER);
        
        FlowLayout optionsFlow = new FlowLayout(); 
        optionsFlow.setAlignment(FlowLayout.CENTER);
        optionsFlow.setHgap(20);
        optionsFlow.setVgap(20);
        
        // create nested JPanels, set layout managers
        this.setLayout(new BorderLayout());
        
        JPanel title = new JPanel(); 
        title.setLayout(titleFlow);
        JPanel options = new JPanel(); 
        options.setLayout(optionsFlow);
        
        // create components
        JButton decks = new JButton("Decks");
        decks.setPreferredSize(new Dimension(100, 100));
        JButton quiz = new JButton("Quiz"); 
        quiz.setPreferredSize(new Dimension(100, 100));
        JButton friends = new JButton("Friends");
        friends.setPreferredSize(new Dimension(100, 100));
        JLabel hello = new JLabel("Welcome to AskNote");    
        
        // add components to JPanels
        title.add(hello); 
        
        options.add(decks); 
        options.add(quiz); 
        options.add(friends);
=======
    public HomePagePanel() {        
       
        InnerPanel decks = new InnerPanel("D", "Decks");     
        InnerPanel quizzes = new InnerPanel("Q", "Quiz"); 
        InnerPanel Friends = new InnerPanel("F", "Friends");
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 
        
        
        this.add(decks);
        this.add(quizzes); 
        this.add(Friends); 
        this.setLayout(box);
>>>>>>> ffc86d2134a4d29c3cccd21105f0b52d811aeebf
        
        this.add(title, BorderLayout.NORTH);
        this.add(options, BorderLayout.CENTER);
    
        this.validate();
        
        }    
}
