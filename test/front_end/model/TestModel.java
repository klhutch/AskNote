package front_end.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.*;

import org.junit.*;
import static org.junit.Assert.*;
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
    
        
    
       Quiz quizMath1 = new Quiz(math, "", true, "");  
       Quiz quizMath3 = new Quiz(math, "", true, ""); 
       Quiz quizMath2 = new Quiz(math, "", false, ""); 
        
    
        assertTrue(quizMath1.equals(quizMath3));   
        assertFalse(quizMath2.equals(quizMath3)); 
    }
    
    
    @Test
    public void testUserEquals() { 
        User jane = new User("Jane", 90); 
        User janet = new User("Jane", 90); 
        User jeff = new User("Jeff", 89); 
    
        assertTrue(jane.equals(janet)); 
        assertFalse(jane.equals(jeff)); 
    
    }
    
    @Test 
    public void testModel() { 
        User user = new User("TestUser", 901); 
        PageType currentPage = PageType.HOME; 
        List<FlashCard> cards = new ArrayList<>(); 
        
        Deck math = new Deck("math", cards); 
        Deck blue = new Deck("blue", new ArrayList<FlashCard>()); 
        List<Deck> decks = new ArrayList<Deck>();
        decks.add(math); 
        decks.add(blue);
    
        Quiz quizMath1 = new Quiz(math, "", true, "");  
        Quiz quizMath2 = new Quiz(math, "", false, ""); 
        List<Quiz> quizzes = new ArrayList<>(); 
        quizzes.add(quizMath2); 
        quizzes.add(quizMath1); 
        List<String> friends = new ArrayList<>(); 
        friends.add("Tom"); 
        friends.add("Jeff"); 
        friends.add("Jane"); 
        Stack<PageType> pages = new Stack<PageType>(); 
        
        List<String> notifications = new ArrayList<String>(); 
        notifications.add("Jane wants to start a quiz with you using math"); 
        
        
        AskNoteModel modelExample = AskNoteModel.instance();
        modelExample.setUser(user);
        modelExample.setCurrentPage(currentPage);
        modelExample.setDecks(decks);
        modelExample.setQuizzes(quizzes);
        modelExample.setFriends(friends);
        modelExample.setNotifications(notifications);
        
        modelExample.setCurrentPage(PageType.QUIZ); 
        modelExample.setCurrentPage(currentPage); 
        
        assertEquals(modelExample.getCurrentPage(), currentPage);
        assertEquals(modelExample.getDeck("blue"), blue); 
        
    }
    
}