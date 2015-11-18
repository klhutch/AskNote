package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.AskNoteModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiffanychao
 */
public class AsknoteView extends JPanel {
    
    protected final AskNoteModel model;
    private JPanel currentView;
    
    public AsknoteView(String title, List<String> notifications) {
        this.model = initModel();
        
        switch(model.getCurrentPage().getValue()) {
            case 0: currentView = new HomePagePanel();
                break;
            case 1: currentView = new ChooseDeckPanel(model.getDecks());
                break;
            case 2: currentView = new QuizPanel();
                break;
            case 3: currentView = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case 4: currentView = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case 5: currentView = new EditDeckPanel(model.getActiveDeck());
                break;
            case 6: currentView = new FriendsListPanel(model.getFriends());
                break;
            case 7: currentView = new LoginPanel();
                break;
            case 8: currentView = new HomePagePanel(); // CHANGE THIS ///////
                break;
            case 9: currentView = new QuizSelfPanel(model.getActiveDeck());
                break;
            case 10: currentView = new SelectQuizPanel(model.getQuizzes(), model.getFriends());
                break;
            case 11: currentView = new TesterPanel(model.getActiveFlashcard(), ""); // change to model.getResponse
                break;
            case 12: currentView = new TesteePanel();
                           
        }
        JPanel header = new HeaderPanel(title, notifications.size()); 
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
        
        this.add(header, BorderLayout.NORTH);
        this.add(currentView, BorderLayout.CENTER);
        
        this.validate();
    }
    
    /** initialize the model.
     * The next implementation of AskNote should get values for the model from a database
     * @return the model
     */
    private AskNoteModel initModel() {
        // default
        return new AskNoteModel();
    }  
}
