package model;

import java.util.List;
import java.util.ArrayList; 

/**
 *
 * @author Maha Alkhairy 
 */

//A deck has flashcards and a UNIQUE title
public class Deck {
    // a unique title 
    private String title; 
    private List<Flashcard> cards; 
       
    public Deck(String title, List<Flashcard> cards) { 
        this.title = title; 
        this.cards = cards; 
    }
    
    public Deck(String title) { 
        this(title,  new ArrayList<Flashcard>()); 
         
    }
    
    public Deck(List<Flashcard> cards) { 
        this("New Deck", cards); 
    }
    
    public Deck() { 
        this("New Deck", new ArrayList<Flashcard>()); 
    }
    
    public List<Flashcard> getCards() {
         return this.cards; 
    }
    
    public Flashcard getCard(int index) {
        return getCards().get(index);
    }
    
    public int getSize() {
        return this.cards.size();
    }
    
    // adds card to deck 
    public void add(Flashcard card) {
        cards.add(card); 
    }
    
    public void remove(Flashcard card) { 
        cards.remove(card); 
    }
    
    public String getTitle() { 
        return this.title; 
    }
    
    public void setTitle(String title) { 
        this.title = title; 
    } 

    public boolean equals(Deck deck) { 
        return (this.title.equals(deck.title) && 
                this.cards.containsAll(deck.cards)
                && deck.cards.containsAll(this.cards));        
    }
}
