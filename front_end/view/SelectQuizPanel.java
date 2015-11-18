/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import model.Quiz;

/**
 *
 * @author normal
 */
public class SelectQuizPanel extends JPanel {
    private QuizListPanel quizzesPanel;
    private QuizFriendPanel friendsPanel;
    
    public SelectQuizPanel(List<Quiz> quizzes, List<String> friends) {
        this.quizzesPanel = new QuizListPanel(quizzes);
        this.friendsPanel = new QuizFriendPanel(friends);
        
        
                
        JPanel southPlaceholder = new JPanel();
        JPanel eastPlaceholder = new JPanel();
        JPanel westPlaceholder = new JPanel();
        
        JPanel innerPanel = new JPanel();
        GridLayout grid = new GridLayout(1,2);
        
        innerPanel.setLayout(grid);
        
        innerPanel.add(quizzesPanel);
        innerPanel.add(friendsPanel);
        
        this.setLayout(new BorderLayout());
        this.add(innerPanel, BorderLayout.CENTER);
        this.add(southPlaceholder, BorderLayout.SOUTH);
        this.add(eastPlaceholder, BorderLayout.EAST);
        this.add(westPlaceholder, BorderLayout.WEST);
        
        this.validate();
    }
    
    
    
    
    class QuizListPanel extends JPanel {
        List<OneQuizPanel> activeQuizzes = new ArrayList();
        
        QuizListPanel(List<Quiz> quizzes) {
            
            this.setBorder(new MatteBorder(0, 0, 0, 1, Color.BLACK));
            this.setLayout(new BorderLayout());
            
            JPanel center = new JPanel();
            
            
            if (quizzes.size() > 0) {
                center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
                
                for (Quiz quiz : quizzes) {
                    OneQuizPanel quizPanel = new OneQuizPanel(quiz);
                    activeQuizzes.add(quizPanel);
                    center.add(quizPanel);
                }
            }
            else {
                center.add(new JLabel("No Active Quizzes"));
            }
            
            //center.setBackground(Color.WHITE);
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
            
            this.setLayout(new GridLayout(1, 3));
            
            this.setMaximumSize(new Dimension(1000, 100));
            this.setPreferredSize(new Dimension(100, 70));
            
            JButton cont = new JButton("Continue");
            JButton end = new JButton("End");
            
            JLabel friendName = new JLabel(quiz.getFriend());
            JLabel deckTitle = new JLabel(quiz.getDeck().getTitle());
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.add(cont);
            buttonPanel.add(end);
            
            friendName.setBorder(new LineBorder(Color.BLACK, 1));
            deckTitle.setBorder(new LineBorder(Color.BLACK, 1));
            buttonPanel.setBorder(new LineBorder(Color.BLACK, 1));
            
            
            this.setBackground(Color.WHITE);
            buttonPanel.setBackground(Color.WHITE);
            
            this.add(friendName);
            this.add(deckTitle);
            this.add(buttonPanel);
            
        }
    
    }
    
    
    
    
    class QuizFriendPanel extends JPanel {
        List<String> friends;
        
        QuizFriendPanel(List<String> friends) {
            this.friends = friends;
            
            this.setLayout(new BorderLayout());
            
            
            JPanel inner = new JPanel();
            inner.setLayout(new BorderLayout());
            
            
            JButton confirm = new JButton("Confirm");
            
            JList friendList; 
//            GridLayout grid = new GridLayout(friends.size(), 2);
//            friendList.setLayout(grid);
//            friendList.setBackground(Color.WHITE);
            
//            ButtonGroup selectFriend = new ButtonGroup();
//            
//            for (String friend : friends) {
//                JRadioButton friendSelection = new JRadioButton(friend);
//                selectFriend.add(friendSelection);
//            }
            
            if (friends.size() > 0) {
                friendList = new JList(friends.toArray());
                friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
            }
            else {
                String[] friendArray = {"No Friends Added"};
                friendList = new JList(friendArray);
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
