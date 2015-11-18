package controller;


import view.AskNoteView;
import model.AskNoteModel;


// import javax.swing.event.MouseInputListener;

/**
 *
 * @author tiffanychao
 */
public class AsknoteController {
    
    AskNoteModel model;
    AskNoteView view;
    
    public AsknoteController(AskNoteModel model, AskNoteView view) {
        this.model = model;
        this.view = view;
    }
    
    // mouse events here     
}
