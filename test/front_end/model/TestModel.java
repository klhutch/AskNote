package front_end.model;

import java.util.ArrayList;
import java.util.List;
import model.*;

import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Maha Alkhairy
 */
public class TestModel {
    
    FlashCard card1Math = new FlashCard("1 + 1", "2");
    FlashCard card2Math = new FlashCard("2 + 1", "3");
    FlashCard card3Math = new FlashCard("1 * 1", "1");
    
    @Test
    public void testFlashcardEquals() {
        
        FlashCard c = new FlashCard("1 + 1", "2");
        
        assertTrue(card1Math.equals(c));
        assertFalse(card1Math.equals(card2Math));      
    }
    
    @Test
    public void testDeckEquals() {
        
        List<FlashCard> cards = new ArrayList<>(); 
        cards.add(card1Math); 
        cards.add(card2Math); 
        cards.add(card3Math);
        
        Deck deckMath1 = new Deck("math", cards);
        Deck deckMath2 = new Deck("math", cards);
        
        assertTrue(deckMath1.equals(deckMath2));        
    }
    
    @Test
    public void testQuizEquals() { 
   
        List<FlashCard> cards = new ArrayList<>(); 
        cards.add(card1Math); 
        cards.add(card2Math); 
        cards.add(card3Math); 
   
        Deck math = new Deck("math", cards); 
    
        User jane = new User("Jane", 90); 
        User jeff = new User("Jeff", 89); 
    
        Quiz quizMath1 = new Quiz(math, jane, jeff);    
        Quiz quizMath2 = new Quiz(math, jane, jeff); 
    
        assertTrue(quizMath1.equals(quizMath2));   
    }
} 
