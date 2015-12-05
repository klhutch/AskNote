/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.AskNoteModel;
import model.PageType;

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
        signin.addActionListener(new LoginButtonListener());
        
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
    
    private class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO validate username and password stuff before doing this stuff
            AskNoteModel model = AskNoteModel.instance();
            model.setCurrentPage(PageType.HOME);
            
            try {
                AskNoteView.instance().updateView();
            } catch (MalformedURLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
}
