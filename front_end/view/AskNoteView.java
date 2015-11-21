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
    
    private HeaderPanel header;
    private JPanel appPanel;
    
    
    private AskNoteView() { 
        this.setLayout(new BorderLayout()); 
        
        this.header = new HeaderPanel("Home",0);   
        this.appPanel = new HomePagePanel();
        
        this.add(header, BorderLayout.NORTH);
        this.add(appPanel, BorderLayout.CENTER);
        
        this.validate();
    }
    
    
    
    /** based on state of model, update current view **/
    public void updateView() {
        AskNoteModel model = AskNoteModel.instance();
        this.remove(appPanel);
        
        switch(model.getCurrentPage()) {
            case HOME: 
                this.appPanel = new HomePagePanel();
                break;
            case DECK: 
                System.out.println("Switching to Deck Panel");
                this.appPanel = new DeckPanel(model.getDecks());
                break;
            case QUIZ: 
                this.appPanel = new QuizPanel();
                break;
            case QUIZ_DECK: 
                this.appPanel = new QuizDeckPanel(model.getDecks()); // CHANGE THIS ///////
                break;
            case EDIT_CARD: 
                this.appPanel = new EditCardPanel(model.getSelectedFlashCard());
                break;
            case EDIT_DECK: 
                this.appPanel = new EditDeckPanel(model.getSelectedDeck());
                break;
            case FRIENDS_LIST: 
                this.appPanel = new FriendsListPanel(model.getFriends());
                break;
            case LOGIN: 
                this.appPanel = new LoginPanel();
                break;
            case NOTIFICATIONS: 
                //this.appPanel = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case QUIZ_SELF: 
                this.appPanel = new QuizSelfPanel(model.getSelectedDeck());
                break;
            case QUIZ_SELECT: 
                this.appPanel = new QuizSelectPanel(model.getQuizzes(), model.getFriends());
                break;
            case QUIZ_TESTER: 
                this.appPanel = new QuizTesterPanel(model.getActiveQuiz().getCurrentCard(), model.getActiveQuiz().getResponse(), true);
                break;
            case QUIZ_TESTEE: 
                this.appPanel = new QuizTesteePanel(model.getActiveQuiz().getShownSide()); 
                break;
            case QUIZ_WAITING:
                this.appPanel = new QuizWaitingPanel(model.getActiveQuiz());
        }
        
        
        if(model.getCurrentPage() == PageType.HOME)
            this.setHeaderButtonsVisibility(false);
        else
            this.setHeaderButtonsVisibility(true);
        
        this.add(this.appPanel, BorderLayout.CENTER);
        appPanel.repaint();
        this.repaint();
        this.validate();
    }
    
    private void setHeaderButtonsVisibility(Boolean visible) {
        this.header.setHomeVisible(visible);
        this.header.setBackVisible(visible);
    }
    
    
}

