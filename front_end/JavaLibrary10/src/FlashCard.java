/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maha Alkhairy
 */
class FlashCard {
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
    
    
}
