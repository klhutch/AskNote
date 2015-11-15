package model;

/**
 *
 * @author tiffanychao
 */

import java.util.List;
import java.util.Stack;

public class AsknoteModel {
    User user; 
    PageType currentPage;
    List<Deck> decks; 
    List<Quiz> quizzes; 
    List<User> friends; 
    Stack<PageType> pages;
    List<String> notifications; 
    
    /**
     *
     * @param user
     * @param currentPage
     * @param decks
     * @param quizzes
     * @param friends
     * @param pages
     * @param notifications
     */
    public AsknoteModel(User user, PageType currentPage,
            List<Deck> decks, List<Quiz> quizzes, List<User> friends,
            Stack<PageType> pages, List<String> notifications) {
        
            this.user = user; 
            this.currentPage  = currentPage; 
            this.decks = decks; 
            this.quizzes = quizzes; 
            this.friends = friends; 
            this.pages = pages; 
            this.notifications = notifications;         
    }
    
    public AsknoteModel() { 
        // 0 is home page
        this(new User(), 0 , new ArrayList<Deck>(), 
                new ArrayList<Quiz>(), new ArrayList<String>(),
                new Stack<int>(), new ArrayList<String>()); 
    }
      
    // methods used
    
    
    public List<Deck> getDecks() { 
        return this.decks; 
    }
    
    public Deck getDeck(String title) { 
        // should have based on the title or something 
        return this.decks.get(0); 
    }
    
    public PageType getCurrentPage() {
       /* if (pages.empty()) {
            return PageType.HOME;
        } else {
            return pages.peek();
        }*/ 
        return this.currentPage; 
    }  
    
    public void goToLastPage() { 
        //Should pop the top of the page stack and make it the current page
        this.currentPage = pages.pop(); 
    }
    
    public List<User> getFriends() { 
        return this.friends; 
    }
    
    public List<String> getNotifications() { 
        return this.notifications; 
    }
    
    public List<Quiz> getQuizzes() { 
        return this.quizzes; 
    }
    
    
} 
