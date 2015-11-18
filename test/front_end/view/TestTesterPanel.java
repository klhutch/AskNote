/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import model.Flashcard;
import view.TesterPanel;

/**
 *
 * @author tiffanychao
 */
public class TestTesterPanel extends JFrame {
    
    public static void main (String[] argv) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestTesterPanel().setVisible(true);
            }
        });
    }

    private TestTesterPanel() {
        setTitle("AskNote");
        setResizable(true);
        setSize(500, 600);
        
        Flashcard f1 = new Flashcard("red", "green");
        
        TesterPanel tp = new TesterPanel(f1, "blue");
        getContentPane().add(tp);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}
