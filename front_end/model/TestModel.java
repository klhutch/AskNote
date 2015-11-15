/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maha Alkhairy
 */
public class TestModel {
    
    
    
    public void testEquals() { 
    FlashCard card1Math = new FlashCard("1 + 1", "2");
    FlashCard card2Math = new FlashCard("2 + 1", "3");
    FlashCard card3Math = new FlashCard("1 * 1", "1");
   
    List<FlashCard> cards = new ArrayList<FlashCard>(); 
    cards.add(card1Math); 
    cards.add(card2Math); 
    cards.add(card3Math); 
   
    Deck math = new Deck("math", cards); 
    
    User jane = new User("Jane", 90); 
    User jeff = new User("Jeff", 89); 
    
    Quiz quizMath = new Quiz(math, jane, jeff); 
    
    Quiz quizMathS = new Quiz(math, jane, jeff); 
    
    assert(quizMath.equals(quizMathS)); 
    

    
        
    
    
}
} 
