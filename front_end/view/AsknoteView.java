package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import model.AsknoteModel;
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

public class AsknoteView extends JPanel implements ActionListener {
    
    private final AsknoteModel model = initModel();
    private JPanel currentView;
    
    public AsknoteView(String title, List<String> notifications) { 
        
        JPanel header = new HeaderPanel(title, notifications.size()); 
        BorderLayout border = new BorderLayout(); 
        this.setLayout(border);
        updateView();
        
        this.add(header, BorderLayout.NORTH);
        this.add(currentView, BorderLayout.CENTER);
        
        this.validate();
    }
    
    /** initialize the model.
     * The next implementation of AskNote should get values for the model from a database
     * @return the model
     */
    private AsknoteModel initModel() {
        // default
        return new AsknoteModel();
    }
    
    /** based on state of model, update current view **/
    public void updateView() {
            
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
            case 11: currentView = new TesterPanel(model.getActiveFlashcard(), "", true); // change to model.getResponse
                break;
            case 12: currentView = new TesteePanel(""); // add boolean isSide1Visible to flashcard                         
        }
    }
    
    /**
     * need to get events from nested jpanels
     * @param evt 
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        System.out.println("Parent" + cmd);
        switch(model.getCurrentPage().getValue()) {
            case 0: 
                if (cmd.equals("D")) {
                    model.pushPage(PageType.CHOOSE_DECK);
                } else if (cmd.equals("Q")) {
                    model.pushPage(PageType.QUIZ);
                } else if (cmd.equals("F")) {
                    model.pushPage(PageType.FRIENDS_LIST);
                }
                updateView();
                System.out.println("updated view");
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break; 
        }
  }
}

