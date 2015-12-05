/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import model.AskNoteModel;
import model.Quiz;

/**
 *
 * @author normal
 */
public class QuizTesteePanel extends JPanel {
    Quiz quiz;
    ResponsePanel responsePanel;
    Constants constant; 
    
    public QuizTesteePanel(Quiz quiz) throws MalformedURLException {
        this.quiz = quiz;
        this.constant = new Constants(); 
        String shownSide = quiz.getShownSide();
        this.setLayout(new BorderLayout());
        
        CardPanel cardPanel = new CardPanel(shownSide);
        this.responsePanel = new ResponsePanel();
        
        JButton sendButton = new JButton("Send");
        sendButton.setFont(constant.getFont("Label"));
        sendButton.addActionListener(new SendResponseButtonListener());
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        
        center.add(cardPanel);
        center.add(responsePanel);
        
        this.add(center, BorderLayout.CENTER);
        this.add(sendButton, BorderLayout.SOUTH);
        
        
        
    }
    
    class CardPanel extends JPanel {
        String shownSide;
        Constants constant;
        CardPanel(String shownSide) throws MalformedURLException {
            this.shownSide = shownSide;
            this.constant = new Constants(); 
            
            JLabel shown = new JLabel("Shown Side");
            JTextArea showText = new JTextArea(shownSide, 30, 40);
            
            shown.setFont(constant.getFont("Label"));
            showText.setFont(constant.getFont("Regular"));
            showText.setEnabled(false);
            
            showText.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
            showText.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            
            showText.setBorder(new LineBorder(Color.BLACK, 1));
            this.add(shown);
            this.add(showText);
        }
        
    }
    
    class ResponsePanel extends JPanel {
        JTextArea responseArea;
        Constants constant;
        
        ResponsePanel() throws MalformedURLException {
            this.constant = new Constants(); 
            JLabel otherSide = new JLabel("What's On The Other Side?");
            otherSide.setFont(constant.getFont("Label"));
            this.responseArea = new JTextArea(30, 40);
            responseArea.setEnabled(true);
            
            responseArea.setBorder(new LineBorder(Color.BLACK, 1));
            this.add(otherSide);
            this.add(responseArea);
        }
    }
    
    class SendResponseButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setPreviousAsCurrent();
            String response = QuizTesteePanel.this.responsePanel.responseArea.getText();
            
            Quiz quiz = QuizTesteePanel.this.quiz;
            quiz.setResponse(TOOL_TIP_TEXT_KEY);
            quiz.setWaitingOnResponse(true);
            model.setActiveQuiz(null);
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(QuizTesteePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
