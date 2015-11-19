package model;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FlashCard)) {
            return false;
        }
        FlashCard that = (FlashCard)o;
        
        return (this.side1.equals(that.side1) 
                && this.side2.equals(that.side2));     
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.side1);
        hash = 97 * hash + Objects.hashCode(this.side2);
        return hash;
    }
}