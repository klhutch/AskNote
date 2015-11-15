package model;

/*
 *
 * @author Maha Alkhairy
 */
// A flashcard has two sides, each containing text
public class FlashCard {
    String side1; 
    String side2; 
    
    public FlashCard(String side1, String side2) { 
        this.side1 = side1; 
        this.side2 = side2; 
    }
    public FlashCard() { 
        this("", ""); 
    }    
    
    public String getSide1() { 
        return this.side1;
    }
    
    public String getSide2() { 
        return this.side2; 
    }
    
    public void setSide1(String side1) { 
        this.side1 = side1; 
    }
    
    
    public void setSide2(String side2) { 
        this.side2 = side2; 
    }
    
    // 
    
    public boolean equals(FlashCard card) {
        return (this.side1.equals(card.side1) && this.side2.equals(card.side2)); 
        
    }
    
    
}
