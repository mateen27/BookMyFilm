package com.raven.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
    
public class AdminHomePage extends JFrame implements ActionListener{
    
    JTextField txtcardno;
    JTextField txtpin;
    JButton signIn , clear , signUp;
    String cardNumber , pinNumber;
    
    AdminHomePage(){
        
        setTitle("ADMIN PANEL");
        //For The Icon Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
	setIconImage(icon.getImage());
        //Cursor on Buttons
            Cursor c = new Cursor(Cursor.HAND_CURSOR);
        setLayout(null);
        
                invalidate();
                validate();
                repaint();
        
        //Setting the Logo on the JFrame
        //ForLoading the Image from the System{Desired Location}
        ImageIcon logoImg = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 1.png"));
                JLabel lblLogo = new JLabel(logoImg);
                lblLogo.setBounds(200 , -5 , 360 , 100);
                add(lblLogo);
        
                invalidate();
                validate();
                repaint();
        
        //JLabel for Heading on JFrame
        JLabel heading = new JLabel("Welcome to the Admin Panel");
        heading.setFont(new Font("Osward" , Font.BOLD , 38));
        heading.setBounds(130 , 120 , 600 , 40);
        add(heading);
        
        JLabel heading2 = new JLabel("Please select any one option to Continue!");
        heading2.setFont(new Font("Raelway" , Font.PLAIN , 20));
        heading2.setBounds(207 , 180 , 600 , 40);
        add(heading2);
        
        //JLabel for Card Number
//        JLabel cardno = new JLabel("Movie ID:");
//        cardno.setFont(new Font("Raleway" , Font.BOLD , 28));
//        cardno.setBounds(120 , 150 , 150 , 30);
//        add(cardno);
//        
//        //JTextField for CardNumber
//        txtcardno = new JTextField();
//        txtcardno.setToolTipText("Please Enter Movie ID!");
//        txtcardno.setBounds(360 , 150 , 230 , 30);
//        txtcardno.setFont(new Font("Arial" , Font.BOLD , 14));
//        add(txtcardno);
//        
//        
//        JLabel OR = new JLabel("OR");
//        OR.setBounds(320 , 205 , 100 , 25);
//        OR.setFont(new Font("Raleway" , Font.BOLD , 25));
//        add(OR);
//        
//        //JLabel for PIN
//        JLabel pin = new JLabel("Movie Name:");
//        pin.setFont(new Font("Raleway" , Font.BOLD , 28));
//        pin.setBounds(120 , 260 , 180 , 30);
//        add(pin);
//        
//        //JPasswordField for PIN
//        txtpin = new JTextField();
//        txtpin.setToolTipText("Please Enter Movie Name!");
//        txtpin.setBounds(360 , 260 , 230 , 30);
//        txtpin.setFont(new Font("Arial" , Font.BOLD , 14));
//        add(txtpin);
        
        //Clear Button on JFrame
        clear = new JButton("Add Movie");
        clear.setBounds(130 , 250 , 200 , 40);
        clear.setFont(new Font("Raelway" , Font.PLAIN , 20));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFocusable(false);
        clear.setCursor(c);
        clear.addActionListener(this);
        add(clear);
        
        //SignUp Button on JFrame
        signUp = new JButton("Update Movie");
        signUp.setBounds(420 , 250 , 230 , 40);
        signUp.setFont(new Font("Raelway" , Font.PLAIN , 20));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.setFocusable(false);
        signUp.setCursor(c);
        signUp.addActionListener(this);
        add(signUp);
        
        //Frame Properties
        //for Background Color
        getContentPane().setBackground(Color.WHITE);
        setSize(800 , 480);
        setVisible(true);
        setLocation(350 , 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == clear){
            new AdminController().setVisible(true);
            dispose();
        }
        
        else if(e.getSource () == signUp){
            new UpdateMovie().setVisible(true);
            dispose();
        }
        
}
    
    public static void main(String args[]){
        new AdminHomePage();
    }
}
