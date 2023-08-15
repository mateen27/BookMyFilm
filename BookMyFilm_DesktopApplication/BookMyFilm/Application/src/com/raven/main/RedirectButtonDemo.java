package com.raven.main;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RedirectButtonDemo extends JFrame{
    	JMenu LogIn, SignUp , About , Theme , Profile;  
	JMenuItem userLogin, adminLogin , black , white;
        public RedirectButtonDemo(){
            
JMenuBar mb = new JMenuBar();
JMenu logIn = new JMenu("LogIn");
JMenu signUp = new JMenu("SignUp");
JMenu theme = new JMenu("Theme");
JMenu about = new JMenu("About");
JMenu profile = new JMenu("Profile");
JMenuItem userLogin = new JMenuItem("User Login");
JMenuItem adminLogin = new JMenuItem("Admin Login");
JMenuItem black = new JMenuItem("Dark");
JMenuItem white = new JMenuItem("Light");
JMenuItem changePassword = new JMenuItem("Change Password");
JMenuItem signOut = new JMenuItem("Sign Out");

// Add menu items to menus
theme.add(black);
theme.addSeparator();
theme.add(white);
logIn.add(userLogin);
logIn.addSeparator();
logIn.add(adminLogin);
profile.add(changePassword);
profile.add(signOut);

// Set the font and color of the menu items
Font font = new Font("Arial", Font.PLAIN, 14);
Color color = Color.WHITE;
userLogin.setFont(font);
userLogin.setForeground(Color.BLACK);
userLogin.setBackground(color);
adminLogin.setFont(font);
adminLogin.setForeground(Color.BLACK);
adminLogin.setBackground(color);
black.setFont(font);
black.setForeground(Color.BLACK);
black.setBackground(color);
white.setFont(font);
white.setForeground(Color.BLACK);
white.setBackground(color);
changePassword.setFont(font);
changePassword.setForeground(Color.BLACK);
changePassword.setBackground(color);
signOut.setFont(font);
signOut.setForeground(Color.BLACK);
signOut.setBackground(color);

// Set the background color of the JMenuBar
mb.setBackground(Color.WHITE);

// Set the font and color of the JMenuBar
mb.setFont(font);
mb.setForeground(Color.WHITE);

// Set the border of the JMenuBar
mb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));


// Add menus to menu bar
mb.add(logIn); 
mb.add(signUp);
mb.add(theme);
mb.add(about);

// Add an invisible menu item to the left of the "Profile" menu
JMenuItem invisibleItem = new JMenuItem();
invisibleItem.setEnabled(false);
mb.add(invisibleItem);

// Add the "Profile" menu to the right of the invisible item
mb.add(profile);

setJMenuBar(mb);


            
                setLayout(null);
		setVisible(true);
		setSize(800 , 800);
                setLocation(-10,0);
		setVisible(true);
		setSize(1550 , 1550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
        public static void main(String[] args) {
        new RedirectButtonDemo();
    }
}

