/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.util.ArrayList;
import javax.swing.JFrame;
import model.Deck;
import model.Quiz;
import view.SelectQuizPanel;


/**
 *
 * @author normal
 */
public class TestSelectQuizPanel {
    public static void main(String[] args) {
        //Create Frame
        JFrame frame = new JFrame();
        frame.setTitle("AskNote");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1000, 600);
        
        String friend1 = "Marie";
        Deck deck1 = new Deck("English");
        Quiz quiz1 = new Quiz(deck1, friend1, false);
        
        String friend2 = "Alex";
        Deck deck2 = new Deck(friend2);
        Quiz quiz2 = new Quiz(deck2, friend2, true);
        
        ArrayList<Quiz> quizzes = new ArrayList();
        quizzes.add(quiz1);
        quizzes.add(quiz2);
        
        ArrayList<String> friends = new ArrayList();
        friends.add(friend1);
        friends.add(friend2);
        
        
        frame.add(new SelectQuizPanel(quizzes, friends));
        
        
        
        
        
        frame.setVisible(true);
        
        
    }
}
