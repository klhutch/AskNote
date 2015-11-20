/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import model.AskNoteModel;
import model.PageType;

/**
 *
 * @author Maha Alkhairy
 */
public class HeaderPanel extends JPanel {
    JButton home;
    JButton back;
    JButton notification;
    
    public HeaderPanel(String str, int number) { 
    FlowLayout flow = new FlowLayout(); 
    flow.setAlignment(FlowLayout.CENTER);
    this.setLayout(flow);
    flow.setHgap(40); 
    
    //this.setBackground(Color.cyan);
    
    
    JLabel title = new JLabel(str);
    this.home = new JButton("Home"); 
    this.back = new JButton("Back");
    this.notification = new JButton("" + number);
    
    this.home.setVisible(false);
    this.home.addActionListener(new HomeButtonListener());
    
    this.back.setVisible(false);
    this.back.addActionListener(new BackButtonListener());
    
    this.notification.addActionListener(new NotificationButtonListener());
    this.notification.setVisible(false); //TODO remove once notificationPanel actually does something
    
    this.add(home);
    this.add(back);
    this.add(title);
    this.add(notification);
    this.setPreferredSize(new Dimension(500, 40));
    
    this.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
    this.validate();
    
    
    
    }
    
    public void setHomeVisible(Boolean visible) {
        this.home.setVisible(visible);
    }
    
    public void setBackVisible(Boolean visible) {
        this.back.setVisible(visible);
    }

    
    
    
    
    private class NotificationButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
  
    private class HomeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.wipePageHistory();
            model.setCurrentPage(PageType.HOME);
            
            AskNoteView.instance().updateView();
        }

    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AskNoteModel model = AskNoteModel.instance();
            model.setPreviousAsCurrent();
            
            AskNoteView.instance().updateView();
        }

        
    }
      
}
