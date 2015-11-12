
import java.util.List;
import java.util.ArrayList; 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maha Alkhairy 
 */
public class Deck {
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
}


