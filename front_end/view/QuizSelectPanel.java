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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import model.AskNoteModel;
import model.PageType;
import model.Quiz;

/**
 *
 * @author normal
 */
public class QuizSelectPanel extends JPanel {
    private QuizListPanel quizzesPanel;
    private QuizFriendPanel friendsPanel;
    
    public QuizSelectPanel(List<Quiz> quizzes, List<String> friends) throws MalformedURLException {
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
        Constants constant; 
        
        QuizListPanel(List<Quiz> quizzes) throws MalformedURLException {
            
            this.setBorder(new MatteBorder(0, 0, 0, 1, Color.BLACK));
            this.setLayout(new BorderLayout());
            
            this.constant = new Constants(); 
            
            JPanel center = new JPanel();
            
            
            if (quizzes.size() > 0) {
                center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
                
                for (Quiz quiz : quizzes) {
                    OneQuizPanel quizPanel = new OneQuizPanel(quiz);
                    activeQuizzes.add(quizPanel);
                    center.add(quizPanel);
                    center.add(Box.createRigidArea(new Dimension(0,5)));
                }
            }
            else {
                JLabel noActive = new JLabel("No Active Quizzes"); 
                noActive.setFont(constant.getFont("Label"));
                center.add(noActive);
            }
            
            //center.setBackground(Color.WHITE);
            this.add(center, BorderLayout.CENTER);
            
            JPanel top = new JPanel();
            JLabel current = new JLabel("Current"); 
            current.setFont(constant.getFont("Label")); 
            top.add(current);
            
            this.add(top, BorderLayout.NORTH);
            this.validate();
        }
    }
    
    class OneQuizPanel extends JPanel {
        Quiz quiz;
        Constants constant; 
        
        OneQuizPanel(Quiz quiz) throws MalformedURLException {
            this.quiz = quiz;
            this.constant = new Constants(); 
            
            this.setLayout(new GridLayout(1, 3));
            
            this.setMaximumSize(new Dimension(1000, 100));
            this.setPreferredSize(new Dimension(100, 70));
            
            JButton cont = new JButton("Continue");
            cont.setFont(constant.getFont("Label"));
            JButton end = new JButton("End");
            end.setFont(constant.getFont("Label"));
            
            cont.addActionListener(new ContinueQuizListener());
            end.addActionListener(new RemoveQuizListener());
            
            JLabel friendName = new JLabel(quiz.getFriend());
            JLabel deckTitle = new JLabel(quiz.getDeck().getTitle());
            
            friendName.setFont(constant.getFont("Label"));
            deckTitle.setFont(constant.getFont("Label")); 
            
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
        
        class ContinueQuizListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                AskNoteModel model = AskNoteModel.instance();
                Quiz quiz = OneQuizPanel.this.quiz;
                
                model.setActiveQuiz(quiz);
                
                if (quiz.inWaitingState()) {
                    model.setCurrentPage(PageType.QUIZ_WAITING);
                }
                else if (quiz.getUserIsTester()){
                    model.setCurrentPage(PageType.QUIZ_TESTER);
                }
                else {
                    model.setCurrentPage(PageType.QUIZ_TESTEE);
                }
                
                try {
                    AskNoteView.instance().updateView();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(QuizSelectPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        class RemoveQuizListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                AskNoteModel model = AskNoteModel.instance();
                Quiz toRemove = OneQuizPanel.this.quiz;
                        
                String msg = "Are you sure you want to end your quiz on  \"" + 
                        toRemove.getDeck().getTitle() + "\" with " + toRemove.getFriend()+"?";
                int response = JOptionPane.showConfirmDialog(AskNoteView.instance(), msg,
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (response == JOptionPane.YES_OPTION) {
                    model.deleteQuiz(toRemove);
                    model.setActiveQuiz(null);
                    try {
                        AskNoteView.instance().updateView();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(QuizSelectPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    
    }
    
    
    
    
    class QuizFriendPanel extends JPanel {
        List<String> friends;
        JList friendList; 
        Constants constant; 
        
        QuizFriendPanel(List<String> friends) throws MalformedURLException {
            this.friends = friends;
            this.constant = new Constants(); 
            
            
            this.setLayout(new BorderLayout());
            
            
            JPanel inner = new JPanel();
            inner.setLayout(new BorderLayout());
            
            
            JButton confirm = new JButton("Confirm");
            confirm.setFont(constant.getFont("Label")); 
            confirm.addActionListener(new NewQuizListener());
            
            
            
            if (friends.size() > 0) {
                friendList = new JList(friends.toArray());
                friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                friendList.setFont(constant.getFont("Regular")); 
                
            }
            else {
                String[] friendArray = {"No Friends Added"};
                friendList = new JList(friendArray);
                friendList.setFont(constant.getFont("Regular"));
                
            }
            
            inner.add(friendList, BorderLayout.CENTER);
            inner.add(confirm, BorderLayout.SOUTH);
            
            
            
            this.add(inner, BorderLayout.CENTER);
            
            JPanel top = new JPanel();
            JLabel newB = new JLabel("New");
            newB.setFont(constant.getFont("Label"));
            
            top.add(newB);
            
            this.add(top, BorderLayout.NORTH);
            this.validate();
        }
        
        
        class NewQuizListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                AskNoteModel model = AskNoteModel.instance();
                
                int index = QuizFriendPanel.this.friendList.getMinSelectionIndex();
                
                if (index >= 0) {
                    String friend = QuizFriendPanel.this.friends.get(index);
                    Quiz quiz = new Quiz(null, friend, false, "");
                    quiz.setNotYetAccepted(true);
              
                    model.addQuiz(quiz);
                    model.setActiveQuiz(quiz);
                    model.setCurrentPage(PageType.QUIZ_DECK);
                    try {
                        AskNoteView.instance().updateView();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(QuizSelectPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }
        
    }
}
