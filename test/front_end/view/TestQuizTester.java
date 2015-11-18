/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import javax.swing.JFrame;
import model.Flashcard;
import view.TesterPanel;

/**
 *
 * @author normal
 */
public class TestQuizTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AskNote");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1000, 600);
        
        Flashcard card = new Flashcard("I Solemnly Swear I am up to no good", 
                                        "The Marauder's Map Password");
        
        TesterPanel testPanel = new TesterPanel(card, "An important password", true);
        
        
        frame.add(testPanel);
        frame.setVisible(true);
        
        
    }
}
