package model;

/**
 *
 * @author tiffanychao
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class AskNoteModel {
    private static class AskNoteModelSingleton {
        private static final AskNoteModel SINGLETON = new AskNoteModel();
    }
    public static AskNoteModel instance(){
        return AskNoteModelSingleton.SINGLETON;
    }
    
    User user = null; 
    PageType currentPage = null;
    List<Deck> decks; 
    
    
    List<Quiz> quizzes = null; 
    List<String> friends = null; 
    Stack<PageType> pageHistory = new Stack();
    List<String> notifications = null; 
    
    
    Deck selectedDeck = null;
    FlashCard selectedFlashCard = null;
    Quiz activeQuiz = null;
    /**
     *
     * @param user
     * @param currentPage
     * @param decks
     * @param quizzes
     * @param friends
     * @param notifications
     */
    private AskNoteModel(User user, PageType currentPage,
        List<Deck> decks,
        List<Quiz> quizzes, List<String> friends,
        List<String> notifications) {

        this.user = user; 
        this.currentPage  = currentPage; 
        this.decks = decks; 
        this.quizzes = quizzes; 
        this.friends = friends; 
        this.notifications = notifications; 
    }
    
    private AskNoteModel() {
        this(new User(), PageType.HOME, new ArrayList<Deck>(),
                new ArrayList<Quiz>(), new ArrayList<String>(),
                new ArrayList<String>()); 
    }
      
    
    
    
    
    /**************************** methods used ******************************/
    
    public List<Deck> getDecks() { 
        return this.decks; 
    }
    public void setDecks(List<Deck> decks) {
        //TODO make it not work if decks is set
        this.decks = decks;
    }
    
    public List<String> getFriends() { 
        return this.friends; 
    }
    public void setFriends(List<String> friends){
        //TODO make it not work if friends is set
        this.friends = friends;
    }
    
    public List<String> getNotifications() { 
        return this.notifications; 
    }
    public void setNotifications(List<String> notifications) {
        //TODO make it so that it won't work if notifications is not null
        this.notifications = notifications;
    }
    
    public List<Quiz> getQuizzes() { 
        return this.quizzes; 
    }
    public void setQuizzes(List<Quiz> quizzes){
        //TODO make this not work if quizzes is already set
        this.quizzes = quizzes;
    }
    
    public User getUser(){
        return this.user;
    }
    public void setUser(User user) {
        //TODO make this not work if user is set
        this.user = user;
    }
    
    
    /* 
     * Should pop the top of the page stack and make it the current page
    */
    public void setPreviousAsCurrent() { 
        this.currentPage = pageHistory.pop(); 
    }
    public void setCurrentPage(PageType page) {
        this.pageHistory.push(currentPage);
        this.currentPage = page;
    }
    public void wipePageHistory() {
        this.pageHistory.clear();
    }
    public PageType getCurrentPage() {
        return this.currentPage;
    } 
    
    
    public Deck getDeck(String title) { 
        // should have based on the title or something 
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getTitle().equals(title)) { 
                return decks.get(i); 
            }
        } 
        return null; 
    }
    
    
    public Deck getSelectedDeck() {
        return this.selectedDeck;
    }
    public void setSelectedDeck(Deck deck) {
        this.selectedDeck = deck;
    }
    
    public FlashCard getSelectedFlashCard() {
        return this.selectedFlashCard;
    }
    public void setSelectedFlashCard(FlashCard card) {
        this.selectedFlashCard = card;
    }
    
    public Quiz getActiveQuiz(){
        return this.activeQuiz;
    }
    public void setActiveQuiz(Quiz quiz){
        this.activeQuiz = quiz;
    }
     
} 
