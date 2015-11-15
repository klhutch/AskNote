/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maha Alkhairy
 */

// A quiz has one deck, a user who is a tester, and a user who is a testee

public class Quiz {
    
    private Deck deck; 
    private User testee; 
    private User tester; 
    
    public Quiz() { 
        this(new Deck(), new User(), new User()); 
    }
    
    public Quiz(Deck deck, User testee, User tester) { 
        this.deck = deck; 
        this.testee = testee; 
        this.tester = tester; 
    }
    
    public void setDeck(Deck deck) { 
        this.deck = deck; 
    }
    
    // not sure about type
    public void setTestee(User testee) { 
        this.testee = testee; 
        
    }
    
    // not sure about type 
    public void setTester(User tester) { 
        this.tester = tester; 
    }
    
    // 
    public boolean equals(Quiz quiz) { 
        return (this.deck.equals(quiz.deck) && this.testee.equals(quiz.testee) &&
                this.tester.equals(quiz.tester)); 
    }
    
    
    
 }
