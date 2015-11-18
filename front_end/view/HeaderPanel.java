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
public class HeaderPanel extends JPanel {
    
    public HeaderPanel(String str, int number) { 
    FlowLayout flow = new FlowLayout(); 
    flow.setAlignment(FlowLayout.CENTER);
    this.setLayout(flow);
    flow.setHgap(40); 
    
    JLabel title = new JLabel(str);
    JButton home = new JButton("Home"); 
    JButton back = new JButton("Back");
    JButton notification = new JButton("" + number);
    this.add(home);
    this.add(back);
    this.add(title);
    this.add(notification);
    this.setPreferredSize(new Dimension(500, 40));
    this.validate();
    
    
    
    } 
    
}
