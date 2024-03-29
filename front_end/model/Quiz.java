/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

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
    private String response;
    private FlashCard currentCard;
    private Boolean side1Shown;
    
    
    private Boolean notYetAccepted = false;
    private Boolean waitingOnResponse = false;
    
    private Boolean correct = null;
    
    public Quiz(Deck deck, String friend, Boolean userIsTester, String response) { 
        this.deck = deck; 
        this.friend = friend; 
        this.userIsTester = userIsTester;
        this.response = response;
        if (deck != null)
            this.currentCard = deck.getCurrentCard();
        else
            this.currentCard = null;
        this.side1Shown = true;
    }
    
 
    public Quiz() {
        this(new Deck(), "--Friend--" , false, ""); 
    }
    
    public void setDeck(Deck deck) { 
        this.deck = deck; 
        this.currentCard = deck.getCurrentCard();
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
    
    public void setResponse(String response) {
        this.response = response;
    }
    public String getResponse(){
        return this.response;
    }
    
    public void setSide1Shown(Boolean bool) {
        this.side1Shown = bool;
    }
    public Boolean getSide1Shown(){
        return this.side1Shown;
    }
    
    public FlashCard getCurrentCard() {
        return this.currentCard;
    }
    
    public String getShownSide(){
        if (this.currentCard == null){
            return "No Cards Found - Test";
        }
        if(side1Shown) {
            return this.currentCard.getSide1();
        }
        return this.currentCard.getSide2();
    }
    public String getReverseSide(){
        if(side1Shown) {
            return this.currentCard.getSide2();
        }
        return this.currentCard.getSide1();
    }
    
    public Boolean getWaitingOnResponse(){
        return this.waitingOnResponse;
    }
    public void setWaitingOnResponse(Boolean bool){
        this.waitingOnResponse = bool;
    }
    
    public Boolean getNotYetAccepted() {
        return this.notYetAccepted;
    }
    public void setNotYetAccepted(Boolean bool) {
        this.notYetAccepted = bool;
    }
    
    public Boolean inWaitingState() {
        return (this.notYetAccepted || this.waitingOnResponse);
    }
    
    public void setCorrect(Boolean bool) {
        this.correct = bool;
    }
    public Boolean getCorrect(){
        return this.correct;
    }
    
    @Override
    public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Quiz)) {
            return false;
        }
        Quiz quiz = (Quiz)o;
        
        if (this.deck == null && quiz.getDeck() != null)
            return false;
        if (this.deck != null && quiz.getDeck() == null)
            return false;
        if (this.deck == quiz.getDeck())
            return this.friend.equals(quiz.getFriend());
        
        return (this.deck.equals(quiz.deck)  && this.friend.equals(quiz.friend));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.deck);
        hash = 97 * hash + Objects.hashCode(this.friend);
        return hash;
    }
    
    
    
 }
