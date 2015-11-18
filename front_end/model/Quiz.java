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
    private String friend;
    private Boolean userIsTester;
    
    public Quiz(Deck deck, String friend, Boolean UserIsTester) { 
        this.deck = deck; 
        this.friend = friend; 
        this.userIsTester = userIsTester;
    }
    
    public void setDeck(Deck deck) { 
        this.deck = deck; 
    }
    
    public Deck getDeck() {
        return this.deck;
    }
    
    // not sure about type
    public void setFriend(String friend) { 
        this.friend = friend; 
        
    }
    
    public String getFriend() {
        return this.friend;
    }
    
    public void setUserIsTester(Boolean userIsTester) {
        this.userIsTester = userIsTester;
    }
    
    public Boolean getUserIsTester() {
        return this.userIsTester;
    }
    
    @Override
    public boolean equals(Object obj) { 
        if (obj instanceof Quiz) {
            Quiz quiz = (Quiz) obj;
            return (this.deck.equals(quiz.deck)  && this.friend.equals(quiz.friend));
        }
        return false;
    }
    
    
    
 }
