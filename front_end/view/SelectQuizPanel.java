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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
            
            for (int i = 0; i < quizzes.size(); i++) {
                activeQuizzes.add(new OneQuizPanel(quizzes.get(i)));
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
            GridLayout grid = new GridLayout(friends.size(), 1);
            friendList.setLayout(grid);
            
            for (int i = 0; i < friends.size(); i++) {
                
            }
            
            inner.add(friendList, BorderLayout.CENTER);
            inner.add(confirm, BorderLayout.SOUTH);
            
            
            
            this.add(inner, BorderLayout.CENTER);
            
            JPanel top = new JPanel();
            top.add(new JLabel("Current"));
            
            this.add(top, BorderLayout.NORTH);
            this.validate();
        }
        
    }
}
