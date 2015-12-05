/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.net.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author farahalshammari
 */
public class Constants {
   public ImageIcon ideck;
   public ImageIcon iwrong;
   public ImageIcon icorrect;
   public ImageIcon iadd;
   public ImageIcon iback;
   public ImageIcon ihome;
   public ImageIcon ifriend;
   public ImageIcon idelete;
   public ImageIcon iedit;
   public ImageIcon iquiz;
   public ImageIcon iflip;
   public ImageIcon inext;
   public ImageIcon ibefore;
   public ImageIcon isave;
   public ImageIcon icancel;
   public Font titleFont; 
   public Font labelFont; 
   public Font regFont; 
   
    public Constants() throws MalformedURLException {
            this.ideck = new ImageIcon(new URL("http://i65.tinypic.com/2u3xlqd.png")); 
            this.ihome = new ImageIcon(new URL("http://i68.tinypic.com/qs59ut.png"));       
            this.iwrong = new ImageIcon(new URL("http://i66.tinypic.com/2zqy2h4.png"));
            this.icorrect = new ImageIcon(new URL("http://i67.tinypic.com/66eux5.png"));
            this.ifriend = new ImageIcon(new URL("http://i65.tinypic.com/9ih9mq.png"));
            this.iadd = new ImageIcon(new URL("http://i65.tinypic.com/ezpy1h.png"));
            this.iback = new ImageIcon (new URL("http://i65.tinypic.com/1676v79.png"));
            this.idelete = new ImageIcon(new URL("http://i67.tinypic.com/30ucx91.png"));
            this.iedit =  new ImageIcon(new URL("http://i66.tinypic.com/502ni9.png"));
            this.iquiz =  new ImageIcon(new URL("http://i63.tinypic.com/i5btih.png"));
            this.iflip = new ImageIcon(new URL("http://i67.tinypic.com/2u6clc4.png"));
            this.ibefore = new ImageIcon(new URL("http://i68.tinypic.com/1glxt5.png"));
            this.inext = new ImageIcon(new URL("http://i65.tinypic.com/t55cgy.png"));
            this.isave = new ImageIcon(new URL("http://i65.tinypic.com/v4mqvt.png")); 
            this.icancel = new ImageIcon(new URL("http://i65.tinypic.com/2d8ozmg.png"));
            this.labelFont = new Font("SanSarif", Font.BOLD, 13); 
            this.titleFont = new Font("SanSarif", Font.BOLD, 14); 
            this.regFont = new Font("SanSarif", Font.PLAIN, 12); 
    }
    
    public ImageIcon getImage(String str) {
        
        if(str.equals("Deck")) {
            return this.ideck;
        }
        if(str.equals("Home")) {
            return this.ihome;
        }
        if(str.equals("Back")) {
            return this.iback;
        }
        if(str.equals("Correct")) {
            return this.icorrect;
        }
        if(str.equals("Wrong")) {
            return this.iwrong;
        }
        
        if(str.equals("Friend")) {
            return this.ifriend;
        }
        
        if(str.equals("Add")) {
            return this.iadd;
        }
        if(str.equals("Edit")) {
            return this.iedit;
        }
        
        if(str.equals("Quiz")) {
            return this.iquiz;
        }
        
        if(str.equals(">")) {
            return this.inext;
        }
        if(str.equals("<")) {
            return this.ibefore;
        }
        
        if(str.equals("Flip")) {
            return this.iflip;
        }
        if(str.equals("Save")) {
            return this.isave;
        }
        if(str.equals("Cancel")) {
            return this.icancel;
        }
        
        else {
            return this.idelete;
        }
        
    }
    
    public Font getFont(String str) { 
        if (str.equals("Label")) { 
            return this.labelFont; 
        }
        if (str.equals("Title")) { 
            return this.titleFont; 
        }
        else { 
            return this.regFont; 
        }
    }
}
