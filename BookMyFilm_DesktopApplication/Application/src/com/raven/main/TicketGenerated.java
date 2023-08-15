package com.raven.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketGenerated extends JFrame {
    
    int BookingID ; int totalSeatsBooked;
    
    TicketGenerated(int BookingID , int totalSeatsBooked){
        
        this.BookingID = BookingID;
        this.totalSeatsBooked = totalSeatsBooked;
        
//        System.out.println(totalSeatsBooked);
         //Layout of the Frame  
        setLayout(null);
        
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
        setIconImage(icon.getImage());
        //Cursor on Button
        Cursor c = new Cursor(Cursor.HAND_CURSOR);
        
        //Resize of JFrame
        setResizable(false);
        
        //JFrame Title
        setTitle("Confirm Ticket Booking!");
        
        //Background Color
        getContentPane().setBackground(Color.WHITE);
        
        //Icon On JFrame
//        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons//bankicon.png"));
//        setIconImage(icon.getImage());


        //Image over the JLabel
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/ticket.png"));
        Image i = img.getImage().getScaledInstance(560, 660, Image.SCALE_DEFAULT);
        ImageIcon Img = new ImageIcon(i);
        JLabel lblImg = new JLabel(Img);
        lblImg.setBounds(0 , 0 , 600 , 660);
        add(lblImg);
        
        JLabel lblHeading = new JLabel(" We’re so glad that you chose us!");
        lblHeading.setFont(new Font("Raelway" , Font.BOLD, 22));
        lblHeading.setBounds(135 , 102 , 400 , 30);
        add(lblHeading);
        lblImg.add(lblHeading);
        
        
        JLabel lblTheater = new JLabel(" PVR: Phoenix United, Bareilly ");
        lblTheater.setFont(new Font("Raelway" , Font.BOLD, 22));
        lblTheater.setBounds(130 , 280 , 400 , 30);
        add(lblTheater);
        lblImg.add(lblTheater);
        
        
        //Getting the data 
         try{
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyticket", "root", "root");

    // Create a statement to execute the SQL query
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from bookedseats where bookingID = '"+BookingID+"' AND totalBookedSeats = '"+totalSeatsBooked+"'");

    // Retrieve the data [Movie fare Details and The Audi Details] from the result set and display it in the JLabels
            while(rs.next()) {
                String MovieName = rs.getString("MovieName");
                String MovieDate = rs.getString("MovieDate");
                String MovieTiming = rs.getString("MovieTiming");
                String totalFare = rs.getString("totalFare");
                String seatsBooked = rs.getString("seatsBooked");
                
//                System.out.println(seatsBooked);
                
                        JLabel lblMovieBookingID = new JLabel("Booking ID : "+this.BookingID);
                        lblMovieBookingID.setBounds(420, 70, 180, 25);
                        lblMovieBookingID.setFont(new Font("Raelway", Font.PLAIN, 18));
                        add(lblMovieBookingID);
                        lblImg.add(lblMovieBookingID);


                        JLabel lblMovieName = new JLabel(MovieName);
                        lblMovieName.setBounds(140, 192, 800, 17);
                        lblMovieName.setFont(new Font("Raelway", Font.BOLD, 22));
                        add(lblMovieName);
                        lblImg.add(lblMovieName);

                        JLabel lblSeats = new JLabel(seatsBooked) ;
                        lblSeats.setBounds(140 , 390 , 800 , 25);
                        lblSeats.setFont(new Font("Raelway", Font.BOLD, 22));
                        add(lblSeats);
                        lblImg.add(lblSeats);

                        JLabel lblDate = new JLabel(MovieDate) ;
                        lblDate.setBounds(140 , 470 , 800 , 25);
                        lblDate.setFont(new Font("Raelway", Font.BOLD, 22));
                        add(lblDate);
                        lblImg.add(lblDate);

                        JLabel lblTime = new JLabel(MovieTiming) ;
                        lblTime.setBounds(140 , 500 , 800 , 25);
                        lblTime.setFont(new Font("Raelway", Font.BOLD, 22));
                        add(lblTime);
                        lblImg.add(lblTime);
                        
                                
                        JLabel lblCost = new JLabel("StreamSettle: ₹" + totalFare);
                        lblCost.setBounds(400 , 570 , 800 , 25);
                        lblCost.setFont(new Font("Raelway", Font.PLAIN, 16));
                        add(lblCost);
                        lblImg.add(lblCost);
         
            }
                
                
                // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
            
    }
         catch(Exception e){
             System.out.println(e);
         }
         
        
        JButton btnBook = new JButton("Binge & Bill");
        btnBook.setBounds(50 , 610 , 150 , 40);
        btnBook.setFocusable(false);
        btnBook.setForeground(Color.WHITE);
        btnBook.setBackground(new Color(216, 46, 47));
        btnBook.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                        String farePaid = "Un-Paid";
                        boolean payAfterWatch = true ;
                        try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                                PreparedStatement ps = conn.prepareStatement("UPDATE bookedseats SET Fare = '"+farePaid+"', PayAfterWatch = '"+payAfterWatch+"' where bookingID = '"+BookingID+"' AND totalBookedSeats = '"+totalSeatsBooked+"'");
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null , "Pay Movie Fare after watching the Movie!");
                                JOptionPane.showMessageDialog(null , "Movie Tickets Booked!");
                                dispose();
                                
                                
                                conn.close();
                                ps.close();
                        }catch(Exception ex){
                            System.out.print(ex);
                        }
            }
        });
        add(btnBook);
        lblImg.add(btnBook);
        
        
        JButton btnTrailer = new JButton("Pay Now!");
                btnTrailer.setBounds(400 , 610 , 150 , 40);
                btnTrailer.setFocusable(false);
                btnTrailer.setForeground(Color.WHITE);
                btnTrailer.setBackground(Color.BLACK);
                btnTrailer.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String farePaid = "Paid";
                        boolean payAfterWatch = false ;
                        try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                                PreparedStatement ps = conn.prepareStatement("UPDATE bookedseats SET Fare = '"+farePaid+"', PayAfterWatch = '"+payAfterWatch+"' where bookingID = '"+BookingID+"' AND totalBookedSeats = '"+totalSeatsBooked+"'");
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null , "Movie Tickets Booked!");
                                dispose();
                                
                                
                                conn.close();
                                ps.close();
                        }catch(Exception ex){
                            System.out.print(ex);
                        }
                    }
                });
                add(btnTrailer);
                lblImg.add(btnTrailer);
        
        
        
        
        //Frame Properties
        setSize(617 , 700);
        setLocation(350 , 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[]){
        new TicketGenerated(0 , 0);
    }
}
