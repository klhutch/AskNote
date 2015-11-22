/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.*;

/**
 *
 * @author Maha Alkhairy
 */
public class QuizWaitingPanel extends JPanel {
    Quiz quiz;
    public QuizWaitingPanel (Quiz quiz) { 
        this.quiz = quiz;
        BorderLayout border = new BorderLayout();
        this.setLayout(border);

        TextPanel textPanel = new TextPanel(quiz); 
        ButtonPanel buttons = new ButtonPanel(); 

        this.add(textPanel, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH); 
        this.validate();
       
    }
    
    void stopRequest(){
        if (this.quiz.getNotYetAccepted()) {
            AskNoteModel model = AskNoteModel.instance();
            Quiz toRemove = model.getActiveQuiz();

            String msg = "Are you sure you want to stop your request to quiz with " + toRemove.getFriend()+"?";
            int response = JOptionPane.showConfirmDialog(AskNoteView.instance(), msg,
                    "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                model.deleteQuiz(toRemove);
                model.setActiveQuiz(null);
                model.setPreviousAsCurrent();
                AskNoteView.instance().updateView();
            }
        
        }
    }
    
    class TextPanel extends JPanel { 
        TextPanel(Quiz quiz) {
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.CENTER);
        
        //flow.setVgap(200);
        flow.setHgap(20);
        this.setLayout(new GridLayout());
        
        
        String message = "Waiting for " + quiz.getFriend() + " to ";
        if(quiz.getNotYetAccepted()) {
            message += "accept your request";
        }
        else if (quiz.getWaitingOnResponse()){
            message += "respond to the last card";
        }
//        JTextArea waitingMessage = new JTextArea(message);
//        waitingMessage.setWrapStyleWord(true);
//        waitingMessage.setLineWrap(true);
//        
//        waitingMessage.setEnabled(false);
//        waitingMessage.setDisabledTextColor(Color.BLACK);
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        
//        waitingMessage.setFont(font);
//        this.add(waitingMessage);
//        JLabel waitingFor = new JLabel("Waiting for "); 
//        JLabel friend = new JLabel(quiz.getFriend()); 
//        JLabel to = new JLabel("to"); 
//        JLabel action = new JLabel(); 
        
//        if(quiz.getNotYetAccepted()) {
//            action.setText("accept your request");
//        }
//        else if (quiz.getWaitingOnResponse()){
//            action.setText("respond to the last card");
//        }
//        waitingFor.setFont(font); 
//        friend.setFont(font);
//        to.setFont(font); 
//        action.setFont(font);
//        this.add(waitingFor); 
//        this.add(friend); 
//        this.add(to); 
//        this.add(action); 
        
        JLabel waiting = new JLabel(message, JLabel.CENTER);
        waiting.setVerticalAlignment(JLabel.CENTER);
        waiting.setFont(font);
        this.add(waiting);
        
        
        this.validate();
        
       
        } 
        
    }
    
    class ButtonPanel extends JPanel { 
         ButtonPanel () { 
            FlowLayout flow = new FlowLayout(); 
            flow.setAlignment(FlowLayout.CENTER);
            flow.setHgap(25); 
            flow.setVgap(20); 
            
            JButton end = new JButton("end quiz");  
            JButton okay = new JButton("okay"); 
            
            end.addActionListener(new EndQuizButtonListener());
            okay.addActionListener(new OkayButtonListener());
            this.setLayout(flow);
            this.add(end);
            this.add(okay); 
            
            
         } 
    }
    
    class OkayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizWaitingPanel quizPanel = QuizWaitingPanel.this;
            AskNoteModel model = AskNoteModel.instance();
            model.setPreviousAsCurrent();
            model.setActiveQuiz(null);
            AskNoteView.instance().updateView();
            
            
        }
    
    }
    
    class EndQuizButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizWaitingPanel quizPanel = QuizWaitingPanel.this;
            
            if (quizPanel.quiz.getNotYetAccepted()){
                quizPanel.stopRequest();
            }
            else { //if(quizPanel.quiz.getWaitingOnResponse()) {
                AskNoteModel model = AskNoteModel.instance();
                Quiz toRemove = model.getActiveQuiz();

                String msg = "Are you sure you want to end your quiz on \"" + 
                        toRemove.getDeck().getTitle() + "\" with " + toRemove.getFriend()+"?";
                int response = JOptionPane.showConfirmDialog(AskNoteView.instance(), msg,
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    model.deleteQuiz(toRemove);
                    model.setActiveQuiz(null);
                    model.setPreviousAsCurrent();
                    AskNoteView.instance().updateView();
                }
            }
        }
    
    }

}
