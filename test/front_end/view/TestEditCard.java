/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end.view;

import java.awt.EventQueue;
import javax.swing.JDialog;
import model.FlashCard;
import view.EditCardPanel;

/**
 *
 * @author tiffanychao
 */
public class TestEditCard extends JDialog {
    public static void main (String[] argv) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestEditCard().setVisible(true);
            }
        });
    }

    private TestEditCard() {
        FlashCard c = new FlashCard("a", "is for alphabet");
        EditCardPanel ed = new EditCardPanel(c);
        getContentPane().add(ed);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }   
}
