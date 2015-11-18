package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import model.AskNoteModel;
import model.PageType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiffanychao
 */

public class AskNoteView extends JPanel {
    private static class AskNoteViewSingleton {
        private static final AskNoteView SINGLETON = new AskNoteView();
    }
    public static AskNoteView instance() {
        return AskNoteViewSingleton.SINGLETON;
    }
    
    private JPanel headerPanel;
    private JPanel appPanel;
    
    
    private AskNoteView() { 
        this.setLayout(new BorderLayout()); 
        
        this.headerPanel = new HeaderPanel("Home",0);   
        this.appPanel = new HomePagePanel();
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(appPanel, BorderLayout.CENTER);
        
        this.validate();
    }
    
    
    
    /** based on state of model, update current view **/
    public void updateView() {
        AskNoteModel model = AskNoteModel.instance();
        
        switch(model.getCurrentPage().getValue()) {
            case 0: 
                this.appPanel = new HomePagePanel();
                break;
            case 1: 
                this.appPanel = new DeckPanel(model.getDecks());
                break;
            case 2: 
                this.appPanel = new QuizPanel();
                break;
            case 3: 
                this.appPanel = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case 4: 
                this.appPanel = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case 5: 
                this.appPanel = new EditDeckPanel(model.getSelectedDeck());
                break;
            case 6: 
                this.appPanel = new FriendsListPanel(model.getFriends());
                break;
            case 7: 
                this.appPanel = new LoginPanel();
                break;
            case 8: 
                this.appPanel = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case 9: 
                this.appPanel = new QuizSelfPanel(model.getSelectedDeck());
                break;
            case 10: 
                this.appPanel = new SelectQuizPanel(model.getQuizzes(), model.getFriends());
                break;
            case 11: 
                this.appPanel = new TesterPanel(model.getActiveQuiz().getCurrentCard(), model.getActiveQuiz().getResponse(), true);
                break;
            case 12: 
                this.appPanel = new TesteePanel(model.getActiveQuiz().getShownSide());                          
        }
        
        this.repaint();
    }
    
    
}

