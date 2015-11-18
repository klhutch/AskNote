/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import model.Quiz;

/**
 *
 * @author normal
 */
public class SelectQuizPanel extends JPanel {
    private QuizListPanel quizzesPanel;
    private QuizFriendPanel friendsPanel;
    
    public SelectQuizPanel(ArrayList<Quiz> quizzes, ArrayList<String> friends) {
        this.quizzesPanel = new QuizListPanel(quizzes);
        this.friendsPanel = new QuizFriendPanel(friends);
        
        GridLayout grid = new GridLayout(1,2);
        
        this.setLayout(grid);
        
        this.add(quizzesPanel);
        this.add(friendsPanel);
        
        this.validate();
    }
    
    
    
    
    class QuizListPanel extends JPanel {
        List<OneQuizPanel> activeQuizzes;
        
        QuizListPanel(ArrayList<Quiz> quizzes) {
            this.setLayout(new BorderLayout());
            
            JPanel center = new JPanel();
            GridLayout grid = new GridLayout(quizzes.size(), 1);
            center.setLayout(grid);
            
            if (quizzes.size() > 0) {
                for (Quiz quiz : quizzes) {
                    OneQuizPanel quizPanel = new OneQuizPanel(quiz);
                    activeQuizzes.add(quizPanel);
                    center.add(quizPanel);
                }
            }
            else {
                center.add(new JLabel("No Active Quizzes"));
            }
            
            this.add(center, BorderLayout.CENTER);
            
            JPanel top = new JPanel();
            top.add(new JLabel("Current"));
            
            this.add(top, BorderLayout.NORTH);
            this.validate();
        }
    }
    
    class OneQuizPanel extends JPanel {
        Quiz quiz;
        
        OneQuizPanel(Quiz quiz) {
            this.quiz = quiz;
            
            JButton cont = new JButton("Continue");
            JButton end = new JButton("End");
            
            JLabel friendName = new JLabel(quiz.getFriend());
            JLabel deckTitle = new JLabel(quiz.getDeck().getTitle());
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(cont);
            buttonPanel.add(end);
            
            this.add(friendName);
            this.add(deckTitle);
            this.add(buttonPanel);
            
        }
    
    }
    
    
    
    
    class QuizFriendPanel extends JPanel {
        List<String> friends;
        
        QuizFriendPanel(ArrayList<String> friends) {
            this.friends = friends;
            
            this.setLayout(new BorderLayout());
            
            
            
            JPanel inner = new JPanel();
            inner.setLayout(null);
            
            
            JButton confirm = new JButton("Confirm");
            
            JPanel friendList = new JPanel();
            GridLayout grid = new GridLayout(friends.size(), 2);
            friendList.setLayout(grid);
            
            ButtonGroup selectFriend = new ButtonGroup();
            
            for (String friend : friends) {
                JRadioButton friendSelection = new JRadioButton(friend);
                selectFriend.add(friendSelection);
            }
            
            inner.add(friendList, BorderLayout.CENTER);
            inner.add(confirm, BorderLayout.SOUTH);
            
            
            
            this.add(inner, BorderLayout.CENTER);
            
            JPanel top = new JPanel();
            top.add(new JLabel("New"));
            
            this.add(top, BorderLayout.NORTH);
            this.validate();
        }
        
    }
}
