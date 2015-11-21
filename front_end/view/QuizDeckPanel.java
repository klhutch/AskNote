package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import model.AskNoteModel;
import model.Deck;
import model.PageType;

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
        
        confirm.addActionListener(new ConfirmDeckListener());
        
        add(decksPanel, BorderLayout.CENTER);
        add(confirm, BorderLayout.SOUTH);
        validate();
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
