/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Maha Alkhairy
 */
public class LoginPanel extends JPanel{
    public LoginPanel() { 
        
        GridLayout grid = new GridLayout(); 
        grid.setColumns(2);
        grid.setRows(3);
        grid.setVgap(90);
        grid.setHgap(20);
        
        this.setLayout(grid);
        
        
        
        // components 
        JButton signin = new JButton("SIGN IN"); 
        JLabel username = new JLabel("Username"); 
        JLabel password = new JLabel("Password"); 
        JPasswordField passwordType = new JPasswordField();
        JTextField usernameType = new JTextField(); 
        
        usernameType.setColumns(9);
        passwordType.setColumns(9);
        
        this.add(username); 
        this.add(usernameType); 
        this.add(password); 
        this.add(passwordType); 
        this.add(new JPanel());
        this.add(signin); 
        this.validate();
        
    }
    
}
