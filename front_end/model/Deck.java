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
    
    public Deck() { 
        this("New Deck", new ArrayList<FlashCard>()); 
    }
    
    public List<FlashCard> getCards() {
         return this.cards; 
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
