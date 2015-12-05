package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        try {   
            this.header = new HeaderPanel("Home",0);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AskNoteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.appPanel = new HomePagePanel();
        } catch (MalformedURLException ex) {
            Logger.getLogger(AskNoteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.add(header, BorderLayout.NORTH);
        this.add(appPanel, BorderLayout.CENTER);
        
        this.validate();
    }
    
    
    
    /** based on state of model, update current view **/
    public void updateView() throws MalformedURLException {
        AskNoteModel model = AskNoteModel.instance();
        this.remove(appPanel);
        
        switch(model.getCurrentPage()) {
            case HOME: 
                this.appPanel = new HomePagePanel();
                this.header.setTitle("Home");
                break;
            case DECK: 
                this.appPanel = new DeckPanel(model.getDecks());
                this.header.setTitle("Flashcard Decks");
                break;
            case QUIZ: 
                this.appPanel = new QuizPanel();
                this.header.setTitle("");
                break;
            case QUIZ_DECK: 
                this.appPanel = new QuizDeckPanel(model.getDecks()); // CHANGE THIS ///////
                this.header.setTitle("Choose A Deck to Quiz With");
                break;
            case EDIT_CARD: 
                this.appPanel = new EditCardPanel(model.getSelectedFlashCard());
                this.header.setTitle("Edit Flashcard");
                break;
            case EDIT_DECK: 
                this.appPanel = new EditDeckPanel(model.getSelectedDeck());
                this.header.setTitle("Edit Deck");
                break;
            case FRIENDS_LIST: 
                this.appPanel = new FriendsListPanel(model.getFriends());
                this.header.setTitle("Friends List");
                break;
            case LOGIN: 
                this.appPanel = new LoginPanel();
                break;
            case NOTIFICATIONS: 
                //this.appPanel = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case QUIZ_SELF: 
                this.appPanel = new QuizSelfPanel(model.getSelectedDeck());
                this.header.setTitle("");
                break;
            case QUIZ_SELECT: 
                this.appPanel = new QuizSelectPanel(model.getQuizzes(), model.getFriends());
                this.header.setTitle("Select a Quiz");
                break;
            case QUIZ_TESTER: 
                this.appPanel = new QuizTesterPanel(model.getActiveQuiz());
                this.header.setTitle("Quiz View");
                break;
            case QUIZ_TESTEE: 
                this.appPanel = new QuizTesteePanel(model.getActiveQuiz()); 
                this.header.setTitle("Quiz View");
                break;
            case QUIZ_WAITING:
                this.appPanel = new QuizWaitingPanel(model.getActiveQuiz());
                this.header.setTitle("Quiz View");
                
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

