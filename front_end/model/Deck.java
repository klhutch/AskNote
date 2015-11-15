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
    private List<FlashCard> cards; 
       
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
    
    
    // 
    
    public boolean equals(Deck deck) { 
        return (this.title.equals(deck.title) && 
                this.cards.containsAll(deck.cards)
                && deck.cards.containsAll(this.cards)); 
        
    }
    
    
    
}
