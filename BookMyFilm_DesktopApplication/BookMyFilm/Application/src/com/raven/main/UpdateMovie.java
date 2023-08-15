package com.raven.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateMovie extends JFrame implements ActionListener{
    
    JTextField txtcardno;
    JTextField txtpin;
    JButton signIn , clear , signUp;
    String cardNumber , pinNumber;
    
    UpdateMovie(){
        
        setTitle("UPDATE MOVIE DETAILS - Page-1");
        //For The Icon Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
	setIconImage(icon.getImage());
        //Cursor on Buttons
            Cursor c = new Cursor(Cursor.HAND_CURSOR);
        setLayout(null);
        
        //Setting the Logo on the JFrame
        //ForLoading the Image from the System{Desired Location}
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
//        For Image Width and Height
        Image imglogo = logo.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
        ImageIcon logoimg = new ImageIcon(imglogo);
        JLabel lblLogo = new JLabel(logoimg);
        lblLogo.setBounds(20 , 10 , 180 , 100);
        add(lblLogo);
        
        //JLabel for Heading on JFrame
        JLabel heading = new JLabel("UPDATE");
        heading.setFont(new Font("Osward" , Font.BOLD , 38));
        heading.setBounds(200 , 40 , 400 , 40);
        add(heading);
        
        JLabel heading2 = new JLabel("MOVIE DETAILS");
        heading2.setForeground(new Color(216, 46, 47));
        heading2.setFont(new Font("Osward" , Font.BOLD , 38));
        heading2.setBounds(370 , 40 , 400 , 40);
        add(heading2);
        
        //JLabel for Card Number
        JLabel cardno = new JLabel("Movie ID:");
        cardno.setFont(new Font("Raleway" , Font.BOLD , 28));
        cardno.setBounds(120 , 150 , 150 , 30);
        add(cardno);
        
        //JTextField for CardNumber
        txtcardno = new JTextField();
        txtcardno.setToolTipText("Please Enter Movie ID!");
        txtcardno.setBounds(360 , 150 , 230 , 30);
        txtcardno.setFont(new Font("Arial" , Font.BOLD , 14));
        add(txtcardno);
        
        
        JLabel OR = new JLabel("OR");
        OR.setBounds(320 , 205 , 100 , 25);
        OR.setFont(new Font("Raleway" , Font.BOLD , 25));
        add(OR);
        
        //JLabel for PIN
        JLabel pin = new JLabel("Movie Name:");
        pin.setFont(new Font("Raleway" , Font.BOLD , 28));
        pin.setBounds(120 , 260 , 180 , 30);
        add(pin);
        
        //JPasswordField for PIN
        txtpin = new JTextField();
        txtpin.setToolTipText("Please Enter Movie Name!");
        txtpin.setBounds(360 , 260 , 230 , 30);
        txtpin.setFont(new Font("Arial" , Font.BOLD , 14));
        add(txtpin);
        
        //SignIn Button on JFrame
        signIn = new JButton("UPDATE");
        signIn.setBounds(300 , 330 , 100 , 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.setFocusable(false);
        signIn.setCursor(c);
        signIn.addActionListener(this);
        add(signIn);
        
        //Clear Button on JFrame
        clear = new JButton("CLEAR");
        clear.setBounds(430 , 330 , 100 , 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFocusable(false);
        clear.setCursor(c);
        clear.addActionListener(this);
        add(clear);
        
        //SignUp Button on JFrame
        signUp = new JButton("Delete Movie");
        signUp.setBounds(300 , 380 , 230 , 30);
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
        if(e.getSource() == signIn){
            Conn conn = new Conn();
            cardNumber = txtcardno.getText();
            pinNumber = txtpin.getText();
            String query = "select * from moviedetails where MovieID = '"+cardNumber+"' OR MovieName = '"+pinNumber+"'";
            try{
            //can throw an error so using try catch
            ResultSet rs = conn.st.executeQuery(query);
            if(rs.next()){
                //Close current Login JFrame
                dispose();
                //Open Transaction JFrame
                new UpdateMoviePageTwo(cardNumber , pinNumber).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Movie ID or Movie Name");
            }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            
        
        }
        else if(e.getSource() == clear){
            txtcardno.setText("");
            txtpin.setText("");
        }
        
        else if(e.getSource () == signUp){
            Conn conn = new Conn();
            cardNumber = txtcardno.getText();
            pinNumber = txtpin.getText();
            String query = "DELETE from moviedetails where MovieID = '"+cardNumber+"' OR MovieName = '"+pinNumber+"'";
            try {
                // Execute the DELETE query
                int rowsAffected = conn.st.executeUpdate(query);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Movie Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null , "Movie deletion failed.");
}
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateMovie.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
}
    
    public static void main(String args[]){
        new UpdateMovie();
    }
}
