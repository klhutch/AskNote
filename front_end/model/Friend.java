/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Maha Alkhairy
 */

public class Friend {
    private String name; 
    private boolean quiz; 
    
    Friend(String name, boolean quiz) { 
        this.name = name; 
        this.quiz = quiz; 
    }
    
    Friend() { 
        this("", false); 
    }
    
    public String getName() { 
        return this.name; 
    }
    
    public boolean getQuiz() { 
        return this.quiz; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public void setQuiz(boolean quiz) { 
        this.quiz = quiz; 
    }
       
}

