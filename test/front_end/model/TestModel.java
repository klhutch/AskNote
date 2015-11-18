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
    
    Flashcard card1Math = new Flashcard("1 + 1", "2");
    Flashcard card2Math = new Flashcard("2 + 1", "3");
    Flashcard card3Math = new Flashcard("1 * 1", "1");
    
    @Test
    public void testFlashcardEquals() {
        
        Flashcard c = new Flashcard("1 + 1", "2");
        
        assertTrue(card1Math.equals(c));
        assertFalse(card1Math.equals(card2Math));      
    }
    
    @Test
    public void testDeckEquals() {
        
        List<Flashcard> cards = new ArrayList<>(); 
        cards.add(card1Math); 
        cards.add(card2Math); 
        cards.add(card3Math);
        
        Deck deckMath1 = new Deck("math", cards);
        Deck deckMath2 = new Deck("math", cards);
        
        assertTrue(deckMath1.equals(deckMath2));        
    }
    
    @Test
    public void testQuizEquals() { 
   
        List<Flashcard> cards = new ArrayList<>(); 
        cards.add(card1Math); 
        cards.add(card2Math); 
        cards.add(card3Math); 
   
        Deck math = new Deck("math", cards); 
    
        
    
       Quiz quizMath1 = new Quiz(math, "", true);  
       Quiz quizMath3 = new Quiz(math, "", true); 
       Quiz quizMath2 = new Quiz(math, "", false); 
        
    
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
        List<Flashcard> cards = new ArrayList<>(); 
        
        Deck math = new Deck("math", cards); 
        Deck blue = new Deck("blue", new ArrayList<Flashcard>()); 
        List<Deck> decks = new ArrayList<Deck>();
        decks.add(math); 
        decks.add(blue);
    
        Quiz quizMath1 = new Quiz(math, "", true);  
        Quiz quizMath2 = new Quiz(math, "", false); 
        List<Quiz> quizzes = new ArrayList<>(); 
        quizzes.add(quizMath2); 
        quizzes.add(quizMath1); 
        List<String> friends = new ArrayList<>(); 
        friends.add("Tom"); 
        friends.add("Jeff"); 
        friends.add("Jane"); 
        Stack<PageType> pages = new Stack<PageType>(); 
        pages.add(PageType.QUIZ); 
        pages.add(currentPage); 
        List<String> notifications = new ArrayList<String>(); 
        notifications.add("Jane wants to start a quiz with you using math"); 
        
        
        AsknoteModel modelExample = new  AsknoteModel(user, currentPage,
                decks, null, null,  quizzes, friends, pages, notifications); 
        
        assertEquals(modelExample.getCurrentPage(), currentPage);
        assertEquals(modelExample.getDeck("blue"), blue); 
        
    }
    
}