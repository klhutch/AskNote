/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
 


public class HomePagePanel extends JPanel{
    // takes nothing in 
    public HomePagePanel() {        
        GridBagLayout gridBag = new GridBagLayout(); 
        OptionsPanel options = new OptionsPanel(); 
        
        //this.setLayout(border);
        
        
        
        this.add(options, BorderLayout.CENTER); 
       
        
       
       
        
        this.validate();
        }    
    
    


    class InnerPanel extends JPanel { 
        InnerPanel(String button, String label) { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEFT);
            JButton bttn = new JButton(button); 
            JLabel lbl = new JLabel(label); 

            Font font = new Font("SanSarif", Font.BOLD, 20); 

            lbl.setFont(font);
            bttn.setFont(font);

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
        OptionsPanel() {        

            InnerPanel decks = new InnerPanel("  ", "Decks");     
            InnerPanel quizzes = new InnerPanel("  ", "Quiz"); 
            InnerPanel Friends = new InnerPanel("  ", "Friends");
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 


            this.add(decks);
            this.add(quizzes); 
            this.add(Friends); 
            this.setLayout(box);

            this.validate();
            }    
    }
}

