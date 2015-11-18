/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList; 
import javax.swing.*;

public class HomePagePanel extends JPanel{
    // takes nothing in 
    public HomePagePanel() {        

        // create layout managers
//        FlowLayout titleFlow = new FlowLayout(); 
//        titleFlow.setAlignment(FlowLayout.CENTER);
//        
//        FlowLayout optionsFlow = new FlowLayout(); 
//        optionsFlow.setAlignment(FlowLayout.CENTER);
//        optionsFlow.setHgap(20);
//        optionsFlow.setVgap(20);
//        
        // create nested JPanels, set layout managers
        this.setLayout(new BorderLayout());
        
        
        InnerPanel decks = new InnerPanel(" D ", "Decks");     
        InnerPanel quiz = new InnerPanel(" Q ", "Quiz"); 
        InnerPanel friends = new InnerPanel(" F ", "Friends");
        
        List<InnerPanel> options = new ArrayList<>();
        options.add(decks); 
        options.add(quiz); 
        options.add(friends); 
       
        OptionsPanel optionsPanel = new OptionsPanel(options); 
      
        this.add(optionsPanel, BorderLayout.CENTER);
        this.validate(); 
        
        
        //////// for mouse listners /////////////
        JButton decksButton = decks.button; 
        JButton quizButton = quiz.button; 
        JButton friendsButton = friends.button; 
        
          
         decksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {;
                System.out.println(evt.getActionCommand());
                // should send event to parent asknoteview
                getParent().dispatchEvent(evt);
            }
        });
        
        
        quizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(evt.getActionCommand());
                getParent().dispatchEvent(evt);
            }
        });
        
        friendsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(evt.getActionCommand());
                getParent().dispatchEvent(evt);
            }
        });
        
         
        
       
    }
}

    class InnerPanel extends JPanel { 
        JButton button; 
        JLabel label; 
        InnerPanel(String button, String label) { 
           
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEFT);
            JButton bttn = new JButton(button); 
            JLabel lbl = new JLabel(label); 

            Font font = new Font("SanSarif", Font.BOLD, 20); 

            lbl.setFont(font);
            bttn.setFont(font);
            
            this.button = bttn; 
            this.label = lbl; 

            flow.setHgap(25);
            this.setMaximumSize(new Dimension(1000, 100));

            this.setLayout(flow); 
            this.add(bttn); 
            this.add(lbl); 
            this.validate();

        }
    }

    /**
     *
     * @author Maha Alkhairy
     */
     class OptionsPanel extends JPanel{
        // takes nothing in 
        OptionsPanel(List<InnerPanel> panels) {        

            
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 
             
            for (InnerPanel panel : panels) {
                this.add(panel);
            }
            this.setLayout(box);

            this.validate();
            }    
    }

