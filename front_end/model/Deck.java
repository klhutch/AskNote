package model;

import java.util.List;
import java.util.ArrayList; 
import java.util.Objects;

/**
 *
 * @author Maha Alkhairy 
 */

//A deck has flashcards and a UNIQUE title
public class Deck {
    // a unique title 
    private String title; 
    private List<FlashCard> cards; 
    private int currentCardIndex = 0;
    private Boolean isNewAddition = false;
    
    private Deck unsaved = null;
    
    public Deck(String title, List<FlashCard> cards) { 
        this.title = title; 
        this.cards = cards; 
    }
    
    public Deck(String title) { 
        this(title,  new ArrayList<FlashCard>()); 
         
    }
    
    public Deck(List<FlashCard> cards) { 
        this("New Deck", cards); 
    }
    
    public Deck(Deck deck){
        this.title = new String(deck.getTitle());
        List<FlashCard> oldCards = deck.getCards();
        this.setCards(deck.getCards());
        
        
        this.isNewAddition = deck.getIsNewAddition();
    }
    
    public Deck() { 
        this("New Deck", new ArrayList<FlashCard>()); 
    }
    
    public Boolean isEmpty(){
        return cards.isEmpty();
    }
    public List<FlashCard> getCards() {
         return this.cards; 
    }
    public void setCards(List<FlashCard> oldCards){
        this.cards = new ArrayList();
        for(FlashCard card : oldCards){
            this.cards.add(new FlashCard(card));
        }
    }
    
    public FlashCard getCard(int index) {
        return getCards().get(index);
    }
    
    public int getSize() {
        return this.cards.size();
    }
    
    // adds card to deck 
    public void add(FlashCard card) {
        cards.add(card); 
    }
    
    public void remove(FlashCard card) { 
        cards.remove(card); 
    }
    
    public String getTitle() { 
        return this.title; 
    }
    
    public void setTitle(String title) { 
        this.title = title; 
    } 
    
    public Boolean getIsNewAddition() {
        return this.isNewAddition;
    }
    public void setIsNewAddition(Boolean bool) {
        this.isNewAddition = bool;
    }
    
    
    public FlashCard getCurrentCard(){
        if(cards.isEmpty()){
            return null;
        }
        return this.getCard(currentCardIndex);
    }
    
    public FlashCard getNextCard() {
        if (cards.isEmpty()) {
            return null;
        }
        if (cards.size() > currentCardIndex + 1) {
            return this.getCard(++currentCardIndex);
        }
        currentCardIndex = 0;
        return this.getCard(currentCardIndex);    
    }

    public FlashCard getPreviousCard() {
        if (cards.isEmpty()) {
            return null;
        }
        if (currentCardIndex - 1 >= 0) {
            return this.getCard(--currentCardIndex);
        }
        currentCardIndex = cards.size() - 1;
        return this.getCard(currentCardIndex); 
    }
    
    public void startEdits() {
        if(this.unsaved == null){
            this.unsaved = new Deck(this);
        }
    }
    public void editAddCard(FlashCard card) {
        if(this.unsaved != null) {
            this.unsaved.add(card);
        }
    }
    public void editRemoveCard(FlashCard card) {
        if (this.unsaved != null) {
            this.unsaved.remove(card);    
        }
    }
    public void editTitle(String title){
        this.unsaved.setTitle(title);
    }
    public void saveEdits(){
        if (this.unsaved != null) {
            this.setTitle(this.unsaved.getTitle());
            this.setCards(this.unsaved.getCards());
            this.currentCardIndex = 0;
        }       
    }
    public void cancelEdits(){
        this.unsaved = null;
    }
    public List<FlashCard> getEditCards(){
        if (this.unsaved != null){
            return this.unsaved.getCards();
        }
        return null;
    }
    public String getEditTitle(){
        return this.unsaved.getTitle();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deck)) {
            return false;
        }
        Deck that = (Deck)o;
        return (this.title.equals(that.title) && 
            this.cards.containsAll(that.cards)
            && that.cards.containsAll(that.cards));    
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.cards);
        return hash;
    }

    
}
