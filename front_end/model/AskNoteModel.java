package model;

/**
 *
 * @author tiffanychao
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class AskNoteModel {
    User user; 
    PageType currentPage;
    List<Deck> decks; 
    Deck activeDeck;
    Flashcard activeFlashcard;
    List<Quiz> quizzes; 
    List<String> friends; 
    Stack<PageType> pages;
    List<String> notifications; 
    
    /**
     *
     * @param user
     * @param currentPage
     * @param decks
     * @param activeDeck
     * @param activeFlashCard
     * @param quizzes
     * @param friends
     * @param pages
     * @param notifications
     */
    public AskNoteModel(User user, PageType currentPage,
            List<Deck> decks, Deck activeDeck, Flashcard activeFlashcard,
            List<Quiz> quizzes, List<String> friends,
            Stack<PageType> pages, List<String> notifications) {
        
            this.user = user; 
            this.currentPage  = currentPage; 
            this.decks = decks; 
            this.activeFlashcard = activeFlashcard;
            this.activeDeck = activeDeck;
            this.quizzes = quizzes; 
            this.friends = friends; 
            this.pages = pages; 
            this.notifications = notifications; 
    }
    
    public AskNoteModel() { 
        // 0 is home page
        this(new User(), PageType.HOME, new ArrayList<>(), null, null,
                new ArrayList<>(), new ArrayList<>(),
                new Stack<>(), new ArrayList<>()); 
    }
      
    // methods used
    
    
    public List<Deck> getDecks() { 
        return this.decks; 
    }
    
    public Deck getDeck(String title) { 
        // should have based on the title or something 
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getTitle().equals(title)) { 
                return decks.get(i); 
            }
        } 
        return new Deck(); 
    }
    
    public Deck getActiveDeck() {
        return activeDeck;
    }
    
    public Flashcard getActiveFlashcard() {
        return activeFlashcard;
    }
    
    public PageType getCurrentPage() {
        if (pages.empty()) {
            return PageType.HOME;
        } else {
            return pages.peek();
        }
    }  
    
    public void goToLastPage() { 
        //Should pop the top of the page stack and make it the current page
        this.currentPage = pages.pop(); 
    }
    
    public List<String> getFriends() { 
        return this.friends; 
    }
    
    public List<String> getNotifications() { 
        return this.notifications; 
    }
    
    public List<Quiz> getQuizzes() { 
        return this.quizzes; 
    }
    
    
} 
