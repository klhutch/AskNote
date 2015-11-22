
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import model.AskNoteModel;
import model.Deck;
import model.FlashCard;
import model.Quiz;
import view.AskNoteView;

/**
 *
 * @author Maha Alkhairy
 */
public class Main {

    public static void main(String[] argv) {
        AskNoteModel model = AskNoteModel.instance();

        /************* Decks ****************/
        /*** Easy Math ***/
        FlashCard card1Math = new FlashCard("1 + 1", "2");
        FlashCard card2Math = new FlashCard("2 + 1", "3");
        FlashCard card3Math = new FlashCard("1 * 1", "1");
        FlashCard card4Math = new FlashCard("100 + 21", "121");
        FlashCard card5Math = new FlashCard("2 / 1", "2");
        FlashCard card6Math = new FlashCard("100 - 9", "91");
        
        List<FlashCard> mathList = new ArrayList<> (); 
        mathList.add(card1Math); 
        mathList.add(card2Math); 
        mathList.add(card3Math); 
        mathList.add(card4Math); 
        mathList.add(card5Math); 
        mathList.add(card6Math); 
        
        Deck easyMath = new Deck ("Easy Math", mathList); 
        
        model.addDeck(easyMath);
        
        /*** SAT Vocab ***/
        FlashCard card1SAT = new FlashCard("relegate", "lower in position");
        FlashCard card2SAT = new FlashCard("spurn", "reject with contempt");
        FlashCard card3SAT = new FlashCard("vie", "compete for");
        FlashCard card4SAT = new FlashCard("squander", "waste");
        FlashCard card5SAT = new FlashCard("rankle", "get under one's skin");
        FlashCard card6SAT = new FlashCard("unprecendented", "never done before");
        
        List<FlashCard> satList = new ArrayList<> (); 
        satList.add(card1SAT); 
        satList.add(card2SAT); 
        satList.add(card3SAT); 
        satList.add(card4SAT); 
        satList.add(card5SAT); 
        satList.add(card6SAT); 
        
        Deck satVocab = new Deck ("SAT Vocab", satList); 
        
        model.addDeck(satVocab);
        
        /*** Networks ***/
        FlashCard card1Ntw = new FlashCard("TCP", "Transmission Control Protocol");
        FlashCard card2Ntw = new FlashCard("IP", "Internet Protocol");
        FlashCard card3Ntw = new FlashCard("Network", "A network is a group of two or more computer systems linked together");
        List<FlashCard> ntwList = new ArrayList<> (); 
        ntwList.add(card1Ntw); 
        ntwList.add(card2Ntw); 
        ntwList.add(card3Ntw); 
        
        Deck networks = new Deck ("Networks", ntwList); 
        
        model.addDeck(networks);
        
        /************** Quizzes ****************/
        Quiz activeQuizMATH = new Quiz(easyMath, "Kim", true, ""); 
        model.addQuiz(activeQuizMATH);
        
        Quiz activeQuizSAT = new Quiz(satVocab, "Henry", false, ""); 
        model.addQuiz(activeQuizSAT);
        
        Quiz activeQuizNTW = new Quiz(networks, "Dan", true, ""); 
        model.addQuiz(activeQuizNTW);

        /*************** Friends ***************/
        
        model.addFriend("Dan");
        model.addFriend("Henry");
        model.addFriend("Kim"); 
        model.addFriend("Frank");
        model.addFriend("Jim");
  
        /*************************/
        JFrame frame = new JFrame();
        frame.setTitle("AskNote");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 650);

        AskNoteView asknote = AskNoteView.instance();
        frame.add(asknote);

        // Show the frame. 
        frame.setVisible(true);
    }
}
