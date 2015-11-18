/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import javax.swing.JFrame;
import view.QuizTesteePanel;

/**
 *
 * @author normal
 */
public class TestQuizTestee {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AskNote");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1000, 600);
        
        QuizTesteePanel testPanel = new QuizTesteePanel("I solemnly Swear I am Up to No Good");
        
        frame.add(testPanel);
        frame.setVisible(true);
        
        
    }
}
