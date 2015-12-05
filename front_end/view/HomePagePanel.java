/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ArrayList; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.*;


    /**
     *
     * @author Maha Alkhairy
     */
public class HomePagePanel extends JPanel{
    // takes nothing in 
    public HomePagePanel() throws MalformedURLException {     
         
         
        // create nested JPanels, set layout managers
       FlowLayout flow = new FlowLayout(); 
       flow.setAlignment(FlowLayout.CENTER);     
       this.setLayout(flow);
        
       Constants constant = new Constants(); 
       
        InnerPanel decks = new InnerPanel(constant.getImage("Deck"), "Decks");     
        InnerPanel quiz = new InnerPanel(constant.getImage("Quiz"), "Quiz"); 
        InnerPanel friends = new InnerPanel(constant.getImage("Friend"), "Friends");
        
        List<InnerPanel> options = new ArrayList<>();
        options.add(decks); 
        options.add(quiz); 
        options.add(friends); 
       
        OptionsPanel optionsPanel = new OptionsPanel(options); 
       
        this.add(optionsPanel);
        
        this.validate(); 
        
        
        
        
        //////// for mouse listners /////////////
        JButton decksButton = decks.button; 
        JButton quizButton = quiz.button; 
        JButton friendsButton = friends.button; 
        
          
        decksButton.addActionListener(new DeckButtonListener());
        quizButton.addActionListener(new QuizButtonListener());
        friendsButton.addActionListener(new FriendButtonListener());  
    }


    class InnerPanel extends JPanel { 
        JButton button; 
        JLabel label; 
        InnerPanel(ImageIcon icon, String label) { 
           
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEADING);
            JButton bttn = new JButton(icon); 
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

     class OptionsPanel extends JPanel{
        // takes nothing in 
        OptionsPanel(List<InnerPanel> panels) {        

            
            BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS); 
            
             this.add(new JPanel()); 
             this.add(new JPanel()); 
             this.add(new JPanel()); 
            for (InnerPanel panel : panels) {
                this.add(new JPanel()); 
                this.add(new JPanel()); 
                this.add(new JPanel()); 
                this.add(panel);
               
            }
            this.setLayout(box);

            this.validate();
            }    
    }
     
    class DeckButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.DECK);
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(HomePagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    class QuizButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.QUIZ);
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(HomePagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
 }
    
    }
    
    class FriendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.FRIENDS_LIST);
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(HomePagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
}
