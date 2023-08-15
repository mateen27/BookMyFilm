package com.raven.main;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class BookSeats extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel ScreenImage;
        String Movieid , MovieName , MovieTime , MovieDate , MovieNormalFare , MovieExecutiveFare , MoviePremiumFare , AudiNumber;
        String ShowID;
        JButton btnBookTickets;
        int countOfReclinerSeats , countOfExecutiveSeats , countOfNormalSeats = 0;
        int priceOfReclinerTickets , priceOfExecutiveFare , priceOfNormalFare = 0;
        int totalFare , totalSeatsBooked , randomBookingID = 0;
        String bookedSeats = "";
        
        //Recliner Seats
        JCheckBox cboxSeatOne , cboxSeatTwo , cboxSeatThree , cboxSeatFour , cboxSeatFive , cboxSeatSix , cboxSeatSeven;
        String RecSeatOne , RecSeatTwo , RecSeatThree , RecSeatFour , RecSeatFive , RecSeatSix , RecSeatSeven;
        
        //Classic Seats
        JCheckBox C1 , C2 , C3 , C4 , C5 , C6 , B1 , B2 , B3 , B4 , B5 , B6 , A1 , A2 , A3 , A4 , A5 , A6;
        String ClassicSeatOne , ClassicSeatTwo , ClassicSeatThree , ClassicSeatFour , ClassicSeatFive , ClassicSeatSix , ClassicSeatSeven , ClassicSeatEight , ClassicSeatNine , ClassicSeatTen , ClassicSeatEleven , ClassicSeatTwelve , ClassicSeatThirteen , ClassicSeatFourteen , ClassicSeatFifteen , ClassicSeatSixteen , ClassicSeatSeventeen , ClassicSeatEighteen;

	//Prime Seats
        JRadioButton F1 , F2 , F3 , F4  , F5 , F6 , F7 , F8 , E1 , E2 , E3 , E4 , E5 , E6 , E7 , E8 , D1 , D2 , D3 , D4 , D5 , D6 , D7 , D8;
        String PrimeSeatOne , PrimeSeatTwo , PrimeSeatThree , PrimeSeatFour , PrimeSeatFive , PrimeSeatSix , PrimeSeatSeven , PrimeSeatEight , PrimeSeatNine , PrimeSeatTen , PrimeSeatEleven , PrimeSeatTwelve , PrimeSeatThirteen , PrimeSeatFourteen , PrimeSeatFifthteen ,PrimeSeatSixteen ,PrimeSeatSeventeen ,PrimeSeatEighteen ,PrimeSeatNineteen ,PrimeSeatTwenty ,PrimeSeatTwentyOne , PrimeSeatTwentyTwo , PrimeSeatTwentyThree , PrimeSeatTwentyFour;
        
        //
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSeats frame = new BookSeats("" , "" , "" , "");
					frame.setVisible(true);
					frame.setResizable(false);
                                        Container c =frame.getContentPane();
                                        c.setBackground(Color.WHITE);
                                        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
                                        frame.setIconImage(icon.getImage());
					frame.setTitle("Book Your Tickets");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookSeats(String MovieID , String MovieName , String MovieTime , String MovieDate) {
                this.Movieid = MovieID;
                this.MovieName = MovieName;
                this.MovieTime = MovieTime;
                this.MovieDate = MovieDate;
                
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                setTitle("Book Your Tickets");
                setResizable(false);
                
//                Container c = getContentPane();
//                c.setBackground(Color.WHITE);

                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
                setIconImage(icon.getImage());
                
                contentPane.setBackground(Color.white);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(845, 0, 17, 485);
		contentPane.add(scrollBar);
		
		JLabel lblRec = new JLabel("RECLINER-Rs. ");
		lblRec.setBounds(10, 11, 142, 17);
		lblRec.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(lblRec);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(61, 26, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 26, 826, 7);
		contentPane.add(separator_1);
		
		JLabel lblRecRow = new JLabel("R");
		lblRecRow.setBounds(20, 42, 17, 25);
		lblRecRow.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		contentPane.add(lblRecRow);
		
		cboxSeatOne = new JCheckBox("");
                cboxSeatOne.setBackground(Color.white);
		cboxSeatOne.setBounds(84, 38, 21, 23);
		contentPane.add(cboxSeatOne);
		
		JLabel RecSeatOne = new JLabel("R-1");
		RecSeatOne.setBounds(88, 60, 51, 14);
		RecSeatOne.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(RecSeatOne);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 112, 826, 7);
		contentPane.add(separator_1_1);
		
		cboxSeatTwo = new JCheckBox("");
                cboxSeatTwo.setBackground(Color.white);
		cboxSeatTwo.setBounds(172, 38, 21, 23);
		contentPane.add(cboxSeatTwo);
		
		JLabel lblSeatTwo = new JLabel("R-2");
		lblSeatTwo.setBounds(175, 60, 51, 14);
		lblSeatTwo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblSeatTwo);
                
                cboxSeatSeven = new JCheckBox("");
                cboxSeatSeven.setBackground(Color.white);
		cboxSeatSeven.setBounds(747, 38, 21, 23);
		contentPane.add(cboxSeatSeven);
		
		cboxSeatFour = new JCheckBox("");
                cboxSeatFour.setBackground(Color.white);
		cboxSeatFour.setBounds(397, 38, 21, 23);
		contentPane.add(cboxSeatFour);
		
		cboxSeatThree = new JCheckBox("");
                cboxSeatThree.setBackground(Color.white);
		cboxSeatThree.setBounds(279, 40, 21, 23);
		contentPane.add(cboxSeatThree);
                		
		JLabel lblSeatThree = new JLabel("R-3");
		lblSeatThree.setBounds(282, 60, 51, 14);
		lblSeatThree.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblSeatThree);
		
		cboxSeatFive = new JCheckBox("");
                cboxSeatFive.setBackground(Color.white);
		cboxSeatFive.setBounds(503, 40, 21, 23);
		contentPane.add(cboxSeatFive);
                
                		
		JLabel lblSeatFour = new JLabel("R-4");
		lblSeatFour.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSeatFour.setBounds(399, 60, 51, 14);
		contentPane.add(lblSeatFour);
		
		JLabel lblSeatFive = new JLabel("R-5");
		lblSeatFive.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSeatFive.setBounds(506, 60, 51, 14);
		contentPane.add(lblSeatFive);
		
		JLabel lblSeatSix = new JLabel("R-6");
		lblSeatSix.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSeatSix.setBounds(631, 60, 51, 14);
		contentPane.add(lblSeatSix);
		
		JLabel lblSeatSeven = new JLabel("R-7");
		lblSeatSeven.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSeatSeven.setBounds(750, 60, 51, 14);
		contentPane.add(lblSeatSeven);
		
		cboxSeatSix = new JCheckBox("");
                cboxSeatSix.setBackground(Color.white);
		cboxSeatSix.setBounds(628, 38, 21, 23);
		contentPane.add(cboxSeatSix);
		
		JLabel lblPrime = new JLabel("PRIME-Rs.");
		lblPrime.setBounds(10, 95, 95, 17);
		lblPrime.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(lblPrime);
		
		JLabel lblPrimeRowF = new JLabel("F");
		lblPrimeRowF.setBounds(20, 130, 17, 25);
		lblPrimeRowF.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		contentPane.add(lblPrimeRowF);
		
		F1 = new JRadioButton("F - Seat 1");
                F1.setBackground(Color.white);
		F1.setBounds(61, 129, 77, 23);
		F1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F1);
		
		F2 = new JRadioButton("F - Seat 2");
                F2.setBackground(Color.white);
		F2.setBounds(150, 129, 77, 23);
		F2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F2);
		
		F3 = new JRadioButton("F - Seat 3");
                F3.setBackground(Color.white);
		F3.setBounds(239, 129, 77, 23);
		F3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F3);
                
                F4 = new JRadioButton("F - Seat 4");
                F4.setBackground(Color.white);
		F4.setBounds(334, 129, 77, 23);
		F4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F4);
                
                F5 = new JRadioButton("F - Seat 5");
                F5.setBackground(Color.white);
		F5.setBounds(433, 129, 77, 23);
		F5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F5);
		
                		
		F6 = new JRadioButton("F - Seat 6");
                F6.setBackground(Color.white);
		F6.setBounds(538, 129, 77, 23);
		F6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F6);
                
                		
		F7 = new JRadioButton("F - Seat 7");
                F7.setBackground(Color.white);
		F7.setBounds(640, 129, 77, 23);
		F7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F7);
                
                		
		F8 = new JRadioButton("F - Seat 8");
                F8.setBackground(Color.white);
		F8.setBounds(747, 129, 77, 23);
		F8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(F8);
                
		JLabel lblPrimeRowE = new JLabel("E");
		lblPrimeRowE.setBounds(20, 166, 17, 25);
		lblPrimeRowE.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		contentPane.add(lblPrimeRowE);
		
		E1 = new JRadioButton("E - Seat 1");
                E1.setBackground(Color.white);
		E1.setBounds(61, 165, 77, 23);
		E1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E1);
		
		E2 = new JRadioButton("E - Seat 2");
                E2.setBackground(Color.white);
		E2.setBounds(150, 165, 77, 23);
		E2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E2);
		
		E3 = new JRadioButton("E - Seat 3");
                E3.setBackground(Color.white);
		E3.setBounds(239, 165, 77, 23);
		E3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E3);
		
		E4 = new JRadioButton("E - Seat 4");
                E4.setBackground(Color.white);
		E4.setBounds(334, 165, 77, 23);
		E4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E4);
                
                		
		E5 = new JRadioButton("E - Seat 5");
                E5.setBackground(Color.white);
		E5.setBounds(433, 165, 77, 23);
		E5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E5);
                
                		
		E6 = new JRadioButton("E - Seat 6");
                E6.setBackground(Color.white);
		E6.setBounds(538, 165, 77, 23);
		E6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E6);
                
                		
		E7 = new JRadioButton("E - Seat 7");
                E7.setBackground(Color.white);
		E7.setBounds(640, 165, 77, 23);
		E7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E7);
                
                		
		E8 = new JRadioButton("E - Seat 8");
                E8.setBackground(Color.white);
		E8.setBounds(747, 165, 77, 23);
		E8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(E8);
		
		D1 = new JRadioButton("D - Seat 1");
                D1.setBackground(Color.white);
		D1.setBounds(61, 201, 77, 23);
		D1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D1);
		
		D2 = new JRadioButton("D - Seat 2");
                D2.setBackground(Color.white);
		D2.setBounds(150, 201, 77, 23);
		D2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D2);
		
		D3 = new JRadioButton("D - Seat 3");
                D3.setBackground(Color.white);
		D3.setBounds(239, 201, 77, 23);
		D3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D3);
		
		D4 = new JRadioButton("D - Seat 4");
                D4.setBackground(Color.white);
		D4.setBounds(334, 201, 77, 23);
		D4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D4);
                
                D5 = new JRadioButton("D - Seat 5");
                D5.setBackground(Color.white);
		D5.setBounds(433, 201, 77, 23);
		D5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D5);
		
		D6 = new JRadioButton("D - Seat 6");
                D6.setBackground(Color.white);
		D6.setBounds(538, 201, 77, 23);
		D6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D6);
		
		D7 = new JRadioButton("D - Seat 7");
                D7.setBackground(Color.white);
		D7.setBounds(640, 201, 77, 23);
		D7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D7);
		
		D8 = new JRadioButton("D - Seat 8");
                D8.setBackground(Color.white);
		D8.setBounds(747, 201, 77, 23);
		D8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(D8);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(9, 246, 826, 7);
		contentPane.add(separator_1_1_1);
		
		JLabel lblPrime_1 = new JLabel("CLASSIC-Rs.");
		lblPrime_1.setBounds(10, 231, 95, 17);
		lblPrime_1.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(lblPrime_1);
		
		C1 = new JCheckBox("C - Seat 1");
                C1.setBackground(Color.white);
		C1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C1.setBounds(61, 260, 97, 23);
		contentPane.add(C1);
		
		C2 = new JCheckBox("C - Seat 2");
                C2.setBackground(Color.white);
		C2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C2.setBounds(187, 260, 97, 23);
		contentPane.add(C2);
		
		C3 = new JCheckBox("C - Seat 3");
                C3.setBackground(Color.white);
		C3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C3.setBounds(314, 260, 97, 23);
		contentPane.add(C3);
		
		C4 = new JCheckBox("C - Seat 4");
                C4.setBackground(Color.white);
		C4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C4.setBounds(433, 260, 97, 23);
		contentPane.add(C4);
		
		C5 = new JCheckBox("C - Seat 5");
                C5.setBackground(Color.white);
		C5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C5.setBounds(566, 260, 97, 23);
		contentPane.add(C5);
		
		C6 = new JCheckBox("C - Seat 6");
                C6.setBackground(Color.white);
		C6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		C6.setBounds(688, 260, 97, 23);
		contentPane.add(C6);
		
		B1 = new JCheckBox("B - Seat 1");
                B1.setBackground(Color.white);
		B1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B1.setBounds(61, 286, 97, 23);
		contentPane.add(B1);
		
		B2 = new JCheckBox("B - Seat 2");
                B2.setBackground(Color.white);
		B2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B2.setBounds(187, 286, 97, 23);
		contentPane.add(B2);
		
		B3 = new JCheckBox("B - Seat 3");
                B3.setBackground(Color.white);
		B3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B3.setBounds(314, 286, 97, 23);
		contentPane.add(B3);
		
		B4 = new JCheckBox("B - Seat 4");
                B4.setBackground(Color.white);
		B4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B4.setBounds(433, 286, 97, 23);
		contentPane.add(B4);
		
		B5 = new JCheckBox("B - Seat 5");
                B5.setBackground(Color.white);
		B5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B5.setBounds(566, 286, 97, 23);
		contentPane.add(B5);
		
		B6 = new JCheckBox("B - Seat 6");
                B6.setBackground(Color.white);
		B6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		B6.setBounds(688, 286, 97, 23);
		contentPane.add(B6);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(26, 478, 826, 7);
		contentPane.add(separator_1_1_1_1);
		
		JRadioButton rbtnAvailable = new JRadioButton("Available");
		rbtnAvailable.setFont(new Font("Tahoma", Font.BOLD, 8));
//		rbtnAvailable.setEnabled(false);
//                rbtnAvailable.setBackground(Color.white);
		rbtnAvailable.setBounds(36, 481, 69, 23);
		contentPane.add(rbtnAvailable);
		
		JCheckBox cboxAvailable = new JCheckBox("Available");
		cboxAvailable.setFont(new Font("Tahoma", Font.BOLD, 8));
//		cboxAvailable.setEnabled(false);
//                cboxAvailable.setBackground(Color.white);
		cboxAvailable.setBounds(102, 481, 69, 23);
		contentPane.add(cboxAvailable);
		
		JCheckBox cboxSold = new JCheckBox("Sold");
		cboxSold.setFont(new Font("Tahoma", Font.BOLD, 8));
		cboxSold.setEnabled(false);
		cboxSold.setBackground(Color.white);
		cboxSold.setBounds(187, 481, 45, 23);
		contentPane.add(cboxSold);
		
		JRadioButton rbtnSold = new JRadioButton("Sold");
		rbtnSold.setFont(new Font("Tahoma", Font.BOLD, 8));
		rbtnSold.setBackground(Color.white);
		rbtnSold.setEnabled(false);
		rbtnSold.setBounds(234, 481, 45, 23);
		contentPane.add(rbtnSold);
		
		btnBookTickets = new JButton("Book Tickets");
		btnBookTickets.setFont(new Font("Tahoma", Font.BOLD, 10));
                btnBookTickets.setFocusable(false);
                btnBookTickets.setBackground(Color.black);
                btnBookTickets.setForeground(Color.white);
		btnBookTickets.setBounds(730, 480, 105, 30);
                btnBookTickets.addActionListener(this);
		contentPane.add(btnBookTickets);
		
		JCheckBox cboxSelected = new JCheckBox("Selected");
		cboxSelected.setFont(new Font("Tahoma", Font.BOLD, 8));
		cboxSelected.setSelected(true);
		cboxSelected.setBounds(316, 481, 69, 23);
		contentPane.add(cboxSelected);
		
		JRadioButton rbtnSelected = new JRadioButton("Selected");
		rbtnSelected.setFont(new Font("Tahoma", Font.BOLD, 8));
		rbtnSelected.setSelected(true);
		rbtnSelected.setBounds(383, 481, 69, 23);
		contentPane.add(rbtnSelected);
		
		A1 = new JCheckBox("A - Seat 1");
                A1.setBackground(Color.white);
		A1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A1.setBounds(61, 312, 97, 23);
		contentPane.add(A1);
		
		A2 = new JCheckBox("A - Seat 2");
                A2.setBackground(Color.white);
		A2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A2.setBounds(187, 312, 97, 23);
		contentPane.add(A2);
		
		A3 = new JCheckBox("A - Seat 3");
                A3.setBackground(Color.white);
		A3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A3.setBounds(314, 312, 97, 23);
		contentPane.add(A3);
		
		A4 = new JCheckBox("A - Seat 4");
                A4.setBackground(Color.white);
		A4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A4.setBounds(433, 312, 97, 23);
		contentPane.add(A4);
		
		A5 = new JCheckBox("A - Seat 5");
                A5.setBackground(Color.white);
		A5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A5.setBounds(566, 312, 97, 23);
		contentPane.add(A5);
		
		A6 = new JCheckBox("A - Seat 6");
                A6.setBackground(Color.white);
		A6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		A6.setBounds(688, 312, 97, 23);
		contentPane.add(A6);
		
		JLabel lblWay = new JLabel("All eyes this way please!");
		lblWay.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblWay.setBounds(346, 458, 164, 14);
		contentPane.add(lblWay);
		
		JLabel lblPrimeRowD = new JLabel("D");
		lblPrimeRowD.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblPrimeRowD.setBounds(20, 202, 17, 25);
		contentPane.add(lblPrimeRowD);
		
		JLabel lblClassicRowB = new JLabel("B");
		lblClassicRowB.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblClassicRowB.setBounds(20, 290, 17, 25);
		contentPane.add(lblClassicRowB);
		
		JLabel lblClassicRowC = new JLabel("C");
		lblClassicRowC.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblClassicRowC.setBounds(20, 264, 17, 25);
		contentPane.add(lblClassicRowC);
		
		JLabel lblClassicRowA = new JLabel("A");
		lblClassicRowA.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblClassicRowA.setBounds(20, 316, 17, 25);
		contentPane.add(lblClassicRowA);

		ImageIcon screenimg = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Screen.png"));
		ScreenImage = new JLabel(screenimg);
		ScreenImage.setBounds(307 , 382 , 210 , 135);
		contentPane.add(ScreenImage);
                
                try{
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyticket", "root", "root");

    // Create a statement to execute the SQL query
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from shows where MovieID = '"+Movieid+"'");
    //(SELECT * FROM movieDetails ORDER BY MovieID DESC LIMIT 3)\n" +
//"ORDER BY MovieID DESC;

    // Retrieve the data [Movie fare Details and The Audi Details] from the result set and display it in the JLabels
    while(rs.next()) {
        ShowID = rs.getString("showID");
        MovieNormalFare = rs.getString("movieNormalFare");
        MovieExecutiveFare = rs.getString("movieExecutiveFare");
        MoviePremiumFare = rs.getString("moviePremiumFare");
        AudiNumber = rs.getString("audiNumber");
           
                
                JLabel lblPremiumFare = new JLabel(MoviePremiumFare);
                lblPremiumFare.setBounds(90, 11, 142, 17);
		lblPremiumFare.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(lblPremiumFare);
                
                JLabel lblExecutiveFare = new JLabel(MovieExecutiveFare);
		lblExecutiveFare.setBounds(70, 95, 95, 17);
		lblExecutiveFare.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(lblExecutiveFare);
            
		JLabel lblNormalFare = new JLabel(MovieNormalFare);
		lblNormalFare.setBounds(85, 231, 95, 17);
		lblNormalFare.setFont(new Font("Serif", Font.PLAIN, 13));
		contentPane.add(lblNormalFare);
//            
//            	JLabel category = new JLabel(movieCategory);
//                category.setBounds(520 , 170 , 450 , 50);
//                category.setFont(new Font("Raelway" , Font.BOLD , 16));
//                add(category);
//                
//                JLabel release = new JLabel(movieReleased);
//                release.setBounds(520 , 210 , 450 , 50);
//                release.setFont(new Font("Raelway" , Font.BOLD , 16));
//                add(release);
//                
//                JLabel cast = new JLabel(movieCast);
//                cast.setBounds(480 , 250 , 450 , 50);
//                cast.setFont(new Font("Raelway" , Font.BOLD , 16));
//                add(cast);
        }
                
    
                
    // Close the result set, statement, and connection
    rs.close();
    stmt.close();
    conn.close();
    
    }         
    
    catch(SQLException e){
        System.out.println(e);
    }
                
        //Retrieving Booked Seats from the dataBase!
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyticket", "root", "root");
            String query = "SELECT RSeatOne, RSeatTwo, RSeatThree, RSeatFour, RSeatFive, RSeatSix, RSeatSeven, PSeatOne, PSeatTwo, PSeatThree, PSeatFour, PSeatFive, PSeatSix, PSeatSeven, PSeatEight, PSeatNine, PSeatTen, PSeatEleven, PSeatTwelve, PSeatThirteen, PSeatFourteen, PSeatFifteen, PSeatSixteen, PSeatSeventeen, PSeatEighteen, PSeatNineteen, PSeatTwenty, PSeatTwentyOne, PSeatTwentyTwo, PSeatTwentyThree, PSeatTwentyFour, CSeatOne, CSeatTwo, CSeatThree, CSeatFour, CSeatFive, CSeatSix, CSeatSeven, CSeatEight, CSeatNine, CSeatTen, CSeatEleven, CSeatTwelve, CSeatThirteen, CSeatFourteen, CSeatFifteen, CSeatSixteen, CSeatSeventeen, CSeatEighteen FROM booking where MovieID = '"+MovieID+"' AND MovieTiming = '"+MovieTime+"'";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            // Loop through the result set
       // Loop through the result set
            while (rs.next()) {
                //Recliner Seats
                String rSeatOne = rs.getString("RSeatOne");
                String rSeatTwo = rs.getString("RSeatTwo");
                String rSeatThree = rs.getString("RSeatThree");
                String rSeatFour = rs.getString("RSeatFour");
                String rSeatFive = rs.getString("RSeatFive");
                String rSeatSix = rs.getString("RSeatSix");
                String rSeatSeven = rs.getString("RSeatSeven");
                
                //Prime Seats
                String pSeatOne = rs.getString("PSeatOne");
                String pSeatTwo = rs.getString("PSeatTwo");
                String pSeatThree = rs.getString("PSeatThree");
                String pSeatFour = rs.getString("PSeatFour");
                String pSeatFive = rs.getString("PSeatFive");
                String pSeatSix = rs.getString("PSeatSix");
                String pSeatSeven = rs.getString("PSeatSeven");
                String pSeatEight = rs.getString("PSeatEight");
                String pSeatNine = rs.getString("PSeatNine");
                String pSeatTen = rs.getString("PSeatTen");
                String pSeatEleven = rs.getString("PSeatEleven");
                String pSeatTwelve = rs.getString("PSeatTwelve");
                String pSeatThirteen = rs.getString("PSeatThirteen");
                String pSeatFourteen = rs.getString("PSeatFourteen");
                String pSeatFifteen = rs.getString("PSeatFifteen");
                String pSeatSixteen = rs.getString("PSeatSixteen");
                String pSeatSeventeen = rs.getString("PSeatSeventeen");
                String pSeatEighteen = rs.getString("PSeatEighteen");
                String pSeatNineteen = rs.getString("PSeatNineteen");
                String pSeatTwenty = rs.getString("PSeatTwenty");
                String pSeatTwentyOne = rs.getString("PSeatTwentyOne");
                String pSeatTwentyTwo = rs.getString("PSeatTwentyTwo");
                String pSeatTwentyThree = rs.getString("PSeatTwentyThree");
                String pSeatTwentyFour = rs.getString("PSeatTwentyFour");
                
                //Classic Seats
                String cSeatOne = rs.getString("CSeatOne");
                String cSeatTwo = rs.getString("CSeatTwo");
                String cSeatThree = rs.getString("CSeatThree");
                String cSeatFour = rs.getString("CSeatFour");
                String cSeatFive = rs.getString("CSeatFive");
                String cSeatSix = rs.getString("CSeatSix");
                String cSeatSeven = rs.getString("CSeatSeven");
                String cSeatEight = rs.getString("CSeatEight");
                String cSeatNine = rs.getString("CSeatNine");
                String cSeatTen = rs.getString("CSeatTen");
                String cSeatEleven = rs.getString("CSeatEleven");
                String cSeatTwelve = rs.getString("CSeatTwelve");
                String cSeatThirteen = rs.getString("CSeatThirteen");
                String cSeatFourteen = rs.getString("CSeatFourteen");
                String cSeatFifteen = rs.getString("CSeatFifteen");
                String cSeatSixteen = rs.getString("CSeatSixteen");
                String cSeatSeventeen = rs.getString("CSeatSeventeen");
                String cSeatEighteen = rs.getString("CSeatEighteen");
                

                // Disable the JRadioButton if the seat is filled
                if (rSeatOne != null && !rSeatOne.equals("null")) {
                    cboxSeatOne.setEnabled(false);
//                    cboxSeatOne.setSelected(true);
                }

                if (rSeatTwo != null && !rSeatTwo.equals("null")) {
                    cboxSeatTwo.setEnabled(false);
//                    cboxSeatTwo.setSelected(true);
                }

                if (rSeatThree != null && !rSeatThree.equals("null")) {
                    cboxSeatThree.setEnabled(false);
//                    cboxSeatThree.setSelected(true);
                }

                if (rSeatFour != null && !rSeatFour.equals("null")) {
                    cboxSeatFour.setEnabled(false);
//                    cboxSeatFour.setSelected(true);
                }

                if (rSeatFive != null && !rSeatFive.equals("null")) {
                    cboxSeatFive.setEnabled(false);
//                    cboxSeatFive.setSelected(true);
                }

                if (rSeatSix != null && !rSeatSix.equals("null")) {
                    cboxSeatSix.setEnabled(false);
//                    cboxSeatSix.setSelected(true);
                }

                if (rSeatSeven != null && !rSeatSeven.equals("null")) {
                    cboxSeatSeven.setEnabled(false);
//                    cboxSeatSeven.setSelected(true);
                }
                
                //Prime Seats
                if (pSeatOne != null && !pSeatOne.equals("null")) {
                    F1.setEnabled(false);
//                    F1.setSelected(true);
                }

                if (pSeatTwo != null && !pSeatTwo.equals("null")) {
                    F2.setEnabled(false);
//                    F2.setSelected(true);
                }

                if (pSeatThree != null && !pSeatThree.equals("null")) {
                    F3.setEnabled(false);
//                    F3.setSelected(true);
                }
                
                if (pSeatFour != null && !pSeatFour.equals("null")) {
                    F4.setEnabled(false);
//                    F4.setSelected(true);
                }

                if (pSeatFive != null && !pSeatFive.equals("null")) {
                    F5.setEnabled(false);
//                    F5.setSelected(true);
                }

                if (pSeatSix != null && !pSeatSix.equals("null")) {
                    F6.setEnabled(false);
//                    F6.setSelected(true);
                }

                if (pSeatSeven != null && !pSeatSeven.equals("null")) {
                    F7.setEnabled(false);
//                    F7.setSelected(true);
                }

                if (pSeatEight != null && !pSeatEight.equals("null")) {
                    F8.setEnabled(false);
//                    F8.setSelected(true);
                }

                if (pSeatNine != null && !pSeatNine.equals("null")) {
                    E1.setEnabled(false);
//                    E1.setSelected(true);
                }

                if (pSeatTen != null && !pSeatTen.equals("null")) {
                    E2.setEnabled(false);
//                    E2.setSelected(true);
                }

                if (pSeatEleven != null && !pSeatEleven.equals("null")) {
                    E3.setEnabled(false);
//                    E3.setSelected(true);
                }

                if (pSeatTwelve != null && !pSeatTwelve.equals("null")) {
                    E4.setEnabled(false);
//                    E4.setSelected(true);
                }

                if (pSeatThirteen != null && !pSeatThirteen.equals("null")) {
                    E5.setEnabled(false);
//                    E5.setSelected(true);
                }

                if (pSeatFourteen != null && !pSeatFourteen.equals("null")) {
                    E6.setEnabled(false);
//                    E6.setSelected(true);
                }

                if (pSeatFifteen != null && !pSeatFifteen.equals("null")) {
                    E7.setEnabled(false);
//                    E7.setSelected(true);
                }

                if (pSeatSixteen != null && !pSeatSixteen.equals("null")) {
                    E8.setEnabled(false);
//                    E8.setSelected(true);
                }

                if (pSeatSeventeen != null && !pSeatSeventeen.equals("null")) {
                    D1.setEnabled(false);
//                    D1.setSelected(true);
                }

                if (pSeatEighteen != null && !pSeatEighteen.equals("null")) {
                    D2.setEnabled(false);
//                    D2.setSelected(true);
                }

                if (pSeatNineteen != null && !pSeatNineteen.equals("null")) {
                    D3.setEnabled(false);
//                    D3.setSelected(true);
                }

                if (pSeatTwenty != null && !pSeatTwenty.equals("null")) {
                    D4.setEnabled(false);
//                    D4.setSelected(true);
                }

                if (pSeatTwentyOne != null && !pSeatTwentyOne.equals("null")) {
                    D5.setEnabled(false);
//                    D5.setSelected(true);
                }

                if (pSeatTwentyTwo != null && !pSeatTwentyTwo.equals("null")) {
                    D6.setEnabled(false);
//                    D6.setSelected(true);
                }

                if (pSeatTwentyThree != null && !pSeatTwentyThree.equals("null")) {
                    D7.setEnabled(false);
//                    D7.setSelected(true);
                }

                if (pSeatTwentyFour != null && !pSeatTwentyFour.equals("null")) {
                    D8.setEnabled(false);
//                    D8.setSelected(true);
                }
                
                //Classic Seats
                
                if (cSeatOne != null && !cSeatOne.equals("null")) {
                    C1.setEnabled(false);
//                    C1.setSelected(true);
                }

                if (cSeatTwo != null && !cSeatTwo.equals("null")) {
                    C2.setEnabled(false);
//                    C2.setSelected(true);
                }

                if (cSeatThree != null && !cSeatThree.equals("null")) {
                    C3.setEnabled(false);
//                    C3.setSelected(true);
                }

                if (cSeatFour != null && !cSeatFour.equals("null")) {
                    C4.setEnabled(false);
//                    C4.setSelected(true);
                }
                

                if (cSeatFive != null && !cSeatFive.equals("null")) {
                    C5.setEnabled(false);
//                    C5.setSelected(true);
                }

                if (cSeatSix != null && !cSeatSix.equals("null")) {
                    C6.setEnabled(false);
//                    C6.setSelected(true);
                }

                if (cSeatSeven != null && !cSeatSeven.equals("null")) {
                    B1.setEnabled(false);
//                    B1.setSelected(true);
                }

                if (cSeatEight != null && !cSeatEight.equals("null")) {
                    B2.setEnabled(false);
//                    B2.setSelected(true);
                }

                if (cSeatNine != null && !cSeatNine.equals("null")) {
                    B3.setEnabled(false);
//                    B3.setSelected(true);
                }

                if (cSeatTen != null && !cSeatTen.equals("null")) {
                    B4.setEnabled(false);
//                    B4.setSelected(true);
                }

                if (cSeatEleven != null && !cSeatEleven.equals("null")) {
                    B5.setEnabled(false);
//                    B5.setSelected(true);
                }

                if (cSeatTwelve != null && !cSeatTwelve.equals("null")) {
                    B6.setEnabled(false);
//                    B6.setSelected(true);
                }

                if (cSeatThirteen != null && !cSeatThirteen.equals("null")) {
                    A1.setEnabled(false);
//                    A1.setSelected(true);
                }

                if (cSeatFourteen != null && !cSeatFourteen.equals("null")) {
                    A2.setEnabled(false);
//                    A2.setSelected(true);
                }

                if (cSeatFifteen != null && !cSeatFifteen.equals("null")) {
                    A3.setEnabled(false);
//                    A3.setSelected(true);
                }

                if (cSeatSixteen != null && !cSeatSixteen.equals("null")) {
                    A4.setEnabled(false);
//                    A4.setSelected(true);
                }

                if (cSeatSeventeen != null && !cSeatSeventeen.equals("null")) {
                    A5.setEnabled(false);
//                    A5.setSelected(true);
                }

                if (cSeatEighteen != null && !cSeatEighteen.equals("null")) {
                    A6.setEnabled(false);
//                    A6.setSelected(true);
                }
                
//                if(cboxSeatOne.setEnabled() == true){
//                bookedSeats = "";
//                }
                

            }
            con.close();
            rs.close();
            pstmt.close();
//            con.close();
            
        }catch (SQLException e) {
            System.out.println(e);
        }
        }
        
        
        //Logic for Booking Movie Tickets 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBookTickets){
            bookedSeats = "";
            //Main Logic for price and total Number of Seats!!            
            if(cboxSeatOne.isSelected()){
                RecSeatOne = "R-1";
                bookedSeats += RecSeatOne + " , ";
                ++countOfReclinerSeats;
                priceOfReclinerTickets = Integer.parseInt(MoviePremiumFare) * countOfReclinerSeats;
            }
            if(cboxSeatTwo.isSelected()){
                RecSeatTwo = "R-2";
                bookedSeats += RecSeatTwo + " , ";
                ++countOfReclinerSeats;
                priceOfReclinerTickets = Integer.parseInt(MoviePremiumFare) * countOfReclinerSeats;
            }
            if(cboxSeatThree.isSelected()){
                RecSeatThree = "R-3";
                bookedSeats += RecSeatThree + " , ";
                ++countOfReclinerSeats;
                priceOfReclinerTickets = Integer.parseInt(MoviePremiumFare) * countOfReclinerSeats;
            }
            if(cboxSeatFour.isSelected()){
                RecSeatFour = "R-4";
                bookedSeats += RecSeatFour + " , ";
                ++countOfReclinerSeats;
                priceOfReclinerTickets = Integer.parseInt(MoviePremiumFare) * countOfReclinerSeats;
            }
            if(cboxSeatFive.isSelected()){
                RecSeatFive = "R-5";
                bookedSeats += RecSeatFive + " , ";
                ++countOfReclinerSeats;
                priceOfReclinerTickets = Integer.parseInt(MoviePremiumFare) * countOfReclinerSeats;
            }
            if(cboxSeatSix.isSelected()){
                RecSeatSix = "R-6";
                bookedSeats += RecSeatSix + " , ";
                ++countOfReclinerSeats;
                priceOfReclinerTickets = Integer.parseInt(MoviePremiumFare) * countOfReclinerSeats;
            }
            if(cboxSeatSeven.isSelected()){
                RecSeatSeven = "R-7";
                bookedSeats += RecSeatSeven + " , ";
                ++countOfReclinerSeats;
                priceOfReclinerTickets = Integer.parseInt(MoviePremiumFare) * countOfReclinerSeats;
            }
            
            //Prime Seats 
            //Row One
            if(F1.isSelected()){
                PrimeSeatOne = "F-1";
                bookedSeats += PrimeSeatOne + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(F2.isSelected()){
                PrimeSeatTwo = "F-2";
                bookedSeats += PrimeSeatTwo + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(F3.isSelected()){
                PrimeSeatThree = "F-3";
                bookedSeats += PrimeSeatThree + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(F4.isSelected()){
                PrimeSeatFour = "F-4";
                bookedSeats += PrimeSeatFour + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(F5.isSelected()){
                PrimeSeatFive = "F-5";
                bookedSeats += PrimeSeatFive + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(F6.isSelected()){
                PrimeSeatSix = "F-6";
                bookedSeats += PrimeSeatSix + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(F7.isSelected()){
                PrimeSeatSeven = "F-7";
                bookedSeats += PrimeSeatSeven + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(F8.isSelected()){
                PrimeSeatEight = "F-8";
                bookedSeats += PrimeSeatEight + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            
            //Row Two
            if(E1.isSelected()){
                PrimeSeatNine = "E-1";
                bookedSeats += PrimeSeatNine + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(E2.isSelected()){
                PrimeSeatTen = "E-2";
                bookedSeats += PrimeSeatTen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(E3.isSelected()){
                PrimeSeatEleven = "E-3";
                bookedSeats += PrimeSeatEleven + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(E4.isSelected()){
                PrimeSeatTwelve = "E-4";
                bookedSeats += PrimeSeatTwelve + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(E5.isSelected()){
                PrimeSeatThirteen = "E-5";
                bookedSeats += PrimeSeatThirteen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(E6.isSelected()){
                PrimeSeatFourteen = "E-6";
                bookedSeats += PrimeSeatFourteen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(E7.isSelected()){
                PrimeSeatFifthteen = "E-7";
                bookedSeats += PrimeSeatFifthteen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(E8.isSelected()){
                PrimeSeatSixteen = "E-8";
                bookedSeats += PrimeSeatSixteen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            //Row Three
            if(D1.isSelected()){
                PrimeSeatSeventeen = "D-1";
                bookedSeats += PrimeSeatSeventeen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(D2.isSelected()){
                PrimeSeatEighteen = "D-2";
                bookedSeats += PrimeSeatEighteen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(D3.isSelected()){
                PrimeSeatNineteen = "D-3";
                bookedSeats += PrimeSeatNineteen + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(D4.isSelected()){
                PrimeSeatTwenty = "D-4";
                bookedSeats += PrimeSeatTwenty + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(D5.isSelected()){
                PrimeSeatTwentyOne = "D-5";
                bookedSeats += PrimeSeatTwentyOne + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(D6.isSelected()){
                PrimeSeatTwentyTwo = "D-6";
                bookedSeats += PrimeSeatTwentyTwo + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(D7.isSelected()){
                PrimeSeatTwentyThree = "D-7";
                bookedSeats += PrimeSeatTwentyThree + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            if(D8.isSelected()){
                PrimeSeatTwentyFour = "D-8";
                bookedSeats += PrimeSeatTwentyFour + " , ";
                ++countOfExecutiveSeats;
                priceOfExecutiveFare = Integer.parseInt(MovieExecutiveFare) * countOfExecutiveSeats;
            }
            
            //Normal Seats [Classic Seats]
            if(C1.isSelected()){
                ClassicSeatOne = "C-1";
                bookedSeats += ClassicSeatOne + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(C2.isSelected()){
                ClassicSeatTwo = "C-2";
                bookedSeats += ClassicSeatTwo + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(C3.isSelected()){
                ClassicSeatThree = "C-3";
                bookedSeats += ClassicSeatThree + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(C4.isSelected()){
                ClassicSeatFour = "C-4";
                bookedSeats += ClassicSeatFour + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(C5.isSelected()){
                ClassicSeatFive = "C-5";
                bookedSeats += ClassicSeatFive + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(C6.isSelected()){
                ClassicSeatSix = "C-6";
                bookedSeats += ClassicSeatSix + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            
            //Row 2 of Normal Seats
            if(B1.isSelected()){
                ClassicSeatSeven = "B-1";
                bookedSeats += ClassicSeatSeven + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(B2.isSelected()){
                ClassicSeatEight = "B-2";
                bookedSeats += ClassicSeatEight + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(B3.isSelected()){
                ClassicSeatNine = "B-3";
                bookedSeats += ClassicSeatNine + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(B4.isSelected()){
                ClassicSeatTen = "B-4";
                bookedSeats += ClassicSeatTen + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(B5.isSelected()){
                ClassicSeatEleven = "B-5";
                bookedSeats += ClassicSeatEleven + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(B6.isSelected()){
                ClassicSeatTwelve = "B-6";
                bookedSeats += ClassicSeatTwelve + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(A1.isSelected()){
                ClassicSeatThirteen = "A-1";
                bookedSeats += ClassicSeatThirteen + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(A2.isSelected()){
                ClassicSeatFourteen = "A-2";
                bookedSeats += ClassicSeatFourteen + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(A3.isSelected()){
                ClassicSeatFifteen = "A-3";
                bookedSeats += ClassicSeatFifteen + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(A4.isSelected()){
                ClassicSeatSixteen = "A-4";
                bookedSeats += ClassicSeatSixteen + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(A5.isSelected()){
                ClassicSeatSeventeen = "A-5";
                bookedSeats += ClassicSeatSeventeen + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            if(A6.isSelected()){
                ClassicSeatEighteen = "A-6";
                bookedSeats += ClassicSeatEighteen + " , ";
                ++countOfNormalSeats;
                priceOfNormalFare = Integer.parseInt(MovieNormalFare) * countOfNormalSeats;
            }
            
            System.out.println();
            
            totalFare = priceOfReclinerTickets + priceOfExecutiveFare + priceOfNormalFare;
//            System.out.println(totalFare);
            totalSeatsBooked = countOfReclinerSeats + countOfExecutiveSeats + countOfNormalSeats;
//            System.out.println(totalSeatsBooked);
            
            //generating a Random Number for Booking-ID
            Random randomNumber = new Random();
  
                // Generate random integers in range 0 to 9999
              randomBookingID = randomNumber.nextInt(10000);
//              System.out.println(randomNum);


            //In this code, the replaceAll() method is used with the regular expression pattern ",\\s*$". 
            //This pattern matches the comma followed by any number of whitespace characters (\\s*) at the end of the string ($). 
            //It replaces this pattern with an empty string, effectively removing the comma and any trailing spaces.
            bookedSeats = bookedSeats.replaceAll(",\\s*$", "");
            System.out.println(bookedSeats);

            //Base Condition if not selected any seat
                        //base Condition
            if(!cboxSeatOne.isSelected() && !cboxSeatTwo.isSelected() && !cboxSeatThree.isSelected() && !cboxSeatFour.isSelected() && !cboxSeatFive.isSelected() && !cboxSeatSix.isSelected() && !cboxSeatSeven.isSelected()
                && !F1.isSelected() && !F2.isSelected() && !F3.isSelected() && !F4.isSelected() && !F5.isSelected() && !F6.isSelected()){
                JOptionPane.showMessageDialog(null , "Select atleast One Seat!");
                    return;
            }
            else {
                try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                            PreparedStatement ps = conn.prepareStatement("insert into booking (MovieID , bookingID , showID , audiNumber , MovieName, MovieTiming, MovieDate, totalBookedSeats , totalFare , RSeatOne , RSeatTwo , RSeatThree , RSeatFour , RSeatFive , RSeatSix , RSeatSeven , PSeatOne, PSeatTwo, PSeatThree, PSeatFour, PSeatFive, PSeatSix, PSeatSeven, PSeatEight, PSeatNine, PSeatTen, PSeatEleven, PSeatTwelve, PSeatThirteen, PSeatFourteen, PSeatFifteen, PSeatSixteen, PSeatSeventeen, PSeatEighteen, PSeatNineteen, PSeatTwenty, PSeatTwentyOne, PSeatTwentyTwo, PSeatTwentyThree, PSeatTwentyFour , CSeatOne, CSeatTwo, CSeatThree, CSeatFour, CSeatFive, CSeatSix, CSeatSeven, CSeatEight, CSeatNine, CSeatTen, CSeatEleven, CSeatTwelve, CSeatThirteen, CSeatFourteen, CSeatFifteen, CSeatSixteen, CSeatSeventeen, CSeatEighteen) values('"+Movieid+"' , '"+randomBookingID+"' , '"+ShowID+"' , '"+AudiNumber+"' , '"+MovieName+"' , '"+MovieTime+"' , '"+MovieDate+"' , '"+totalSeatsBooked+"' , '"+totalFare+"' , '"+RecSeatOne+"' , '"+RecSeatTwo+"' , '"+RecSeatThree+"' , '"+RecSeatFour+"' , '"+RecSeatFive+"' , '"+RecSeatSix+"' , '"+RecSeatSeven+"' , '"+PrimeSeatOne+"' , '"+PrimeSeatTwo+"' , '"+PrimeSeatThree+"' , '"+PrimeSeatFour+"' , '"+PrimeSeatFive+"' , '"+PrimeSeatSix+"' , '"+PrimeSeatSeven+"' , '"+PrimeSeatEight+"' , '"+PrimeSeatNine+"' , '"+PrimeSeatTen+"' , '"+PrimeSeatEleven+"' , '"+PrimeSeatTwelve+"' , '"+PrimeSeatThirteen+"' , '"+PrimeSeatFourteen+"' , '"+PrimeSeatFifthteen+"' , '"+PrimeSeatSixteen+"' , '"+PrimeSeatSeventeen+"' , '"+PrimeSeatEighteen+"' , '"+PrimeSeatNineteen+"' , '"+PrimeSeatTwenty+"' , '"+PrimeSeatTwentyOne+"' , '"+PrimeSeatTwentyTwo+"' , '"+PrimeSeatTwentyThree+"' , '"+PrimeSeatFour+"' , '"+ClassicSeatOne+"' , '"+ClassicSeatTwo+"' , '"+ClassicSeatThree+"' , '"+ClassicSeatFour+"' , '"+ClassicSeatFive+"' , '"+ClassicSeatSix+"' , '"+ClassicSeatSeven+"' , '"+ClassicSeatEight+"' , '"+ClassicSeatNine+"' , '"+ClassicSeatTen+"' , '"+ClassicSeatEleven+"' , '"+ClassicSeatTwelve+"' , '"+ClassicSeatThirteen+"' , '"+ClassicSeatFourteen+"' , '"+ClassicSeatFifteen+"' , '"+ClassicSeatSixteen+"' , '"+ClassicSeatSeventeen+"' , '"+ClassicSeatEighteen+"')");
                            ps.executeUpdate();
//                            JOptionPane.showMessageDialog(null , "Movie Booked!");
//                            dispose();
//                            new AdminControllerPageThree(MovieID).setVisible(true);
                                            // Close the result set, statement, and connection
            ps.close();
//            stmt.close();
            conn.close();
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
            }
            
            
            //finalizing the Booked Tickets into the bookedSeats Database!
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                PreparedStatement ps = conn.prepareStatement("insert into bookedSeats(MovieID , MovieName , bookingID , showID , audiNumber , MovieTiming , MovieDate , totalBookedSeats , totalFare , seatsBooked) values('"+Movieid+"' , '"+MovieName+"' , '"+randomBookingID+"' , '"+ShowID+"' , '"+AudiNumber+"' , '"+MovieTime+"' , '"+MovieDate+"' , '"+totalSeatsBooked+"' , '"+totalFare+"' , '"+bookedSeats+"' )");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null , "Movie Seats Selected!");
                setVisible(false);
                new TicketGenerated(randomBookingID , totalSeatsBooked).setVisible(true);
                                // Close the result set, statement, and connection
            ps.close();
            conn.close();
            
            }
            catch(Exception ex){
                        System.out.println(ex);
            }
        }
    }
}