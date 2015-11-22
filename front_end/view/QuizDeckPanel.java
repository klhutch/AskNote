package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import model.AskNoteModel;
import model.Deck;
import model.PageType;
import model.Quiz;

/**
 *
 * @author tiffanychao
 */
public class QuizDeckPanel extends JPanel {
    ViewDecksHelperPanel decksPanel;
    public QuizDeckPanel(List<Deck> decks) {
        
        setLayout(new BorderLayout());

        decksPanel = new ViewDecksHelperPanel(decks);
        JButton confirm = new JButton("Confirm");
        JButton cancel = new JButton("Cancel");
        
        confirm.addActionListener(new ConfirmDeckListener());
        cancel.addActionListener(new RemoveQuizListener());
        
        JPanel buttons = new JPanel();
        FlowLayout flow = new FlowLayout(); 
        flow.setAlignment(FlowLayout.CENTER);     
        buttons.setLayout(flow);
        
        buttons.add(confirm);
        buttons.add(cancel);
        
        add(decksPanel, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        validate();
    }
    
    class RemoveQuizListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            
            if (model.getPreviousPage() ==  PageType.QUIZ_SELECT){
                //Quizzing qith friends
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
            else {
                //Quizzing self
                model.setPreviousAsCurrent();
                AskNoteView.instance().updateView();
            }
        }
    }
    
    class ConfirmDeckListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteView view = AskNoteView.instance();
            AskNoteModel model = AskNoteModel.instance();
            ViewDecksHelperPanel decksPanel = QuizDeckPanel.this.decksPanel;
            
            if (decksPanel.selected != null){
                Deck quizWith = decksPanel.selected.deck;
                
                String msg = "Are you sure you want to use the deck \"" + 
                        quizWith.getTitle() + "\"?";
                int response = JOptionPane.showConfirmDialog(decksPanel, msg,
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if (response == JOptionPane.YES_OPTION) {
                    model.setSelectedDeck(quizWith);
                    if(model.getPreviousPage() == PageType.QUIZ_SELECT) {
                        //We are in Quiz Friends
                        model.getActiveQuiz().setDeck(quizWith);
                        model.setSelectedDeck(quizWith);
                        model.setPreviousAsCurrent();
                        model.setCurrentPage(PageType.QUIZ_WAITING);
                    }
                    else {
                        //We are in Quiz Self
                        model.setSelectedDeck(quizWith);
                        model.setCurrentPage(PageType.QUIZ_SELF);
                    }
                    view.updateView();
                }
            }
            //TODO - what should happen if nothing is selected?
        }
    
    }
}
