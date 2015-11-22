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
    private JButton home;
    private JButton back;
    private JButton notification;
    private JLabel title;
    
    public HeaderPanel(String str, int number) { 
        this.setLayout(new BorderLayout());
        
        FlowLayout flow = new FlowLayout();
         

        //this.setBackground(Color.cyan);
        JPanel homeBack = new JPanel();
        homeBack.setLayout(flow);
        
        JPanel east = new JPanel();
        //east.setPreferredSize(homeBack.getPreferredSize());
        east.setSize(homeBack.getSize());
        
        title = new JLabel(str, SwingConstants.CENTER);
        title.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        title.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
        
        this.home = new JButton("Home"); 
        this.back = new JButton("Back");
        this.notification = new JButton("" + number);

        this.home.setVisible(false);
        this.home.addActionListener(new HomeButtonListener());

        this.back.setVisible(false);
        this.back.addActionListener(new BackButtonListener());

        this.notification.addActionListener(new NotificationButtonListener());
        this.notification.setVisible(false); //TODO remove once notificationPanel actually does something

        homeBack.add(home);
        homeBack.add(back);
        east.add(notification);
        
        this.add(homeBack, BorderLayout.WEST);
        this.add(title, BorderLayout.CENTER);
        this.add(Box.createRigidArea(homeBack.getSize()), BorderLayout.EAST);
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
    
    public void setTitle(String text){
        this.title.setText(text);
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
