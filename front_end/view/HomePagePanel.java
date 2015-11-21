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
import model.AskNoteModel;
import model.Deck;
import model.PageType;


    /**
     *
     * @author Maha Alkhairy
     */
public class HomePagePanel extends JPanel{
    // takes nothing in 
    public HomePagePanel() {     
         
         
        // create nested JPanels, set layout managers
        BorderLayout border = new BorderLayout(); 
        
        border.setHgap(350);
        border.setVgap(100); 
        this.setLayout(border);
        
        
        InnerPanel decks = new InnerPanel(" D ", "Decks");     
        InnerPanel quiz = new InnerPanel(" Q ", "Quiz"); 
        InnerPanel friends = new InnerPanel(" F ", "Friends");
        
        List<InnerPanel> options = new ArrayList<>();
        options.add(decks); 
        options.add(quiz); 
        options.add(friends); 
       
        OptionsPanel optionsPanel = new OptionsPanel(options); 
       
        this.add(new JPanel(), BorderLayout.WEST); 
        this.add(new JPanel(), BorderLayout.EAST); 
        this.add(optionsPanel, BorderLayout.CENTER);
        
        this.add(new JPanel(), BorderLayout.NORTH); 
        
        this.add(new JPanel(), BorderLayout.SOUTH); 
        
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
        InnerPanel(String button, String label) { 
           
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.LEADING);
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
     
    class DeckButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.DECK);
            
            AskNoteView.instance().updateView();
        }
    
    }
    
    class QuizButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.QUIZ);
            
            AskNoteView.instance().updateView();        }
    
    }
    
    class FriendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.FRIENDS_LIST);
            
            AskNoteView.instance().updateView();
            
        }
    
    }
}

