/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Maha Alkhairy
 */
import java.awt.*;
import javax.swing.*;

// Extend JPanel to override its paintComponent() method: 

public class NewPanel extends JPanel {

  // Set background in constructor. 

  public NewPanel () {
    this.setBackground (Color.PINK);
   
    this.doLayout();
    
  }
  

  // Override paintComponent(): 

  public void paintComponent (Graphics g)
  {
    // Always call super.paintComponent (g): 
    super.paintComponent(g);

    // drawString() is a Graphics method. 
    // Draw the string "Hello World" at location 100,100 
    g.drawString ("Hello World!", 100, 100); 

    // Let's find out when paintComponent() is called. 
    System.out.println ("Inside paintComponent");
  }

}
