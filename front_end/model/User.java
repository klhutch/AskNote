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
// A user has a username and a user ID 
public class User {
    String username; 
    int userID;
    
    public User() { 
        this("", 0); 
    }
    
    public User(String username, int userID) { 
        this.username = username; 
        this.userID = userID; 
    }
    
    public void setUsername(String username) { 
         this.username = username; 
    }
    
    public void setUserID(int userID) { 
        this.userID = userID; 
    }
    
    public String getUsername() { 
        return this.username; 
    }
    
    public int getUserID() { 
        return this.userID; 
    }
    
    // 
    public boolean equals(User user) { 
        return (this.userID == user.userID && this.username.equals(user.username)); 
    }
}
