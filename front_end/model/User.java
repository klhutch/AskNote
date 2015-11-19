/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User that = (User)o;
        return (this.userID == that.userID && this.username.equals(that.username)); 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + this.userID;
        return hash;
    }
}
