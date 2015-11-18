/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.util.ArrayList;
import javax.swing.JFrame;
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
        frame.setSize(500, 600);
        
        frame.add(new SelectQuizPanel(new ArrayList<Quiz>(), new ArrayList<String>()));
        
        frame.setVisible(true);
        
        
    }
}
