package com.raven.main;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.awt.event.*;
import java.util.Random;

public class UpdateMoviePageTwo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNormalFare;
	private JTextField txtExecutiveFare , txtMovieRating;
	private JTextField txtPremiumFare;
        JDateChooser dateChooser , dateChooserTwo , dateChooserThree;
        JCheckBox cbxSessionOne , cbxSessionTwo , cbxSessionThree , cbxSessionFour , cbxSessionFive , cbxSessionSix;
        JButton btnUpdate , btnNextPage , btnBack;
        String MovieID , MovieName;
        JComboBox audiDetails;
        String sessionOne , sessionTwo , sessionThree , sessionFour , sessionFive , sessionSix ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMoviePageTwo frame = new UpdateMoviePageTwo("" , "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateMoviePageTwo(String MovieID , String MovieName) {
            
                this.MovieID = MovieID;
                this.MovieName = MovieName;
                
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
                setIconImage(icon.getImage());
                
                setTitle("UPDATE MOVIE DETAILS - Page-2");
                setResizable(false);
                
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setForeground(new Color(0,0,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMovieDetails = new JLabel("Edit Show Details");
		lblMovieDetails.setForeground(new Color(0,0,0));
		lblMovieDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMovieDetails.setBounds(357, 11, 195, 45);
		contentPane.add(lblMovieDetails);
		
		JLabel lblFareDetails = new JLabel("Fare Details:");
		lblFareDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFareDetails.setForeground(new Color(0,0,0));
		lblFareDetails.setBounds(10, 78, 117, 45);
		contentPane.add(lblFareDetails);
		
		JLabel lblNormalFare = new JLabel("Normal Fare:");
		lblNormalFare.setForeground(new Color(0,0,0));
		lblNormalFare.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNormalFare.setBounds(40, 123, 87, 36);
		contentPane.add(lblNormalFare);
		
		txtNormalFare = new JTextField();
		txtNormalFare.setToolTipText("Enter Normal Fare!");
		txtNormalFare.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNormalFare.setBounds(137, 129, 135, 27);
		contentPane.add(txtNormalFare);
		txtNormalFare.setColumns(10);
		
		JLabel lblExecutiveFare = new JLabel("Executive Fare:");
		lblExecutiveFare.setToolTipText("Enter Executive Fare!");
		lblExecutiveFare.setForeground(Color.BLACK);
		lblExecutiveFare.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExecutiveFare.setBounds(313, 123, 94, 36);
		contentPane.add(lblExecutiveFare);
		
		txtExecutiveFare = new JTextField();
		txtExecutiveFare.setToolTipText("Enter Normal Fare!");
		txtExecutiveFare.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtExecutiveFare.setColumns(10);
		txtExecutiveFare.setBounds(417, 129, 135, 27);
		contentPane.add(txtExecutiveFare);
		
		JLabel lblPremiumFare = new JLabel("Premium Fare:");
		lblPremiumFare.setToolTipText("Enter Executive Fare!");
		lblPremiumFare.setForeground(Color.BLACK);
		lblPremiumFare.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPremiumFare.setBounds(598, 123, 94, 36);
		contentPane.add(lblPremiumFare);
		
		txtPremiumFare = new JTextField();
		txtPremiumFare.setToolTipText("Enter Premium Fare!");
		txtPremiumFare.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPremiumFare.setColumns(10);
		txtPremiumFare.setBounds(702, 129, 135, 27);
		contentPane.add(txtPremiumFare);
		
		JLabel lblSessionDetails = new JLabel("Session Details:");
		lblSessionDetails.setForeground(Color.BLACK);
		lblSessionDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSessionDetails.setBounds(10, 189, 135, 45);
		contentPane.add(lblSessionDetails);
		
		cbxSessionOne = new JCheckBox("9:00 A.M - 12:00 P.M");
		cbxSessionOne.setToolTipText("select seesion for Show!");
		cbxSessionOne.setForeground(new Color(0,0,0));
		cbxSessionOne.setBackground(new Color(255,255,255));
		cbxSessionOne.setBounds(98, 236, 157, 27);
                cbxSessionOne.setFocusable(false);
		contentPane.add(cbxSessionOne);
		
		cbxSessionTwo = new JCheckBox("10:00 A.M - 1:00 P.M");
		cbxSessionTwo.setToolTipText("select seesion for Show!");
		cbxSessionTwo.setForeground(Color.BLACK);
		cbxSessionTwo.setBackground(Color.WHITE);
		cbxSessionTwo.setBounds(310, 236, 157, 27);
                cbxSessionTwo.setFocusable(false);
		contentPane.add(cbxSessionTwo);
		
		cbxSessionThree = new JCheckBox("12:00 P.M - 3:00 P.M");
		cbxSessionThree.setToolTipText("select seesion for Show!");
		cbxSessionThree.setForeground(Color.BLACK);
		cbxSessionThree.setBackground(Color.WHITE);
		cbxSessionThree.setBounds(535, 236, 157, 27);
                cbxSessionThree.setFocusable(false);
		contentPane.add(cbxSessionThree);
		
		cbxSessionFour = new JCheckBox("1:00 P.M - 4:00 P.M");
		cbxSessionFour.setToolTipText("select seesion for Show!");
		cbxSessionFour.setForeground(Color.BLACK);
		cbxSessionFour.setBackground(Color.WHITE);
		cbxSessionFour.setBounds(98, 278, 157, 27);
                cbxSessionFour.setFocusable(false);
		contentPane.add(cbxSessionFour);
		
		cbxSessionFive = new JCheckBox("3:00 P.M - 6:00 P.M");
		cbxSessionFive.setToolTipText("select seesion for Show!");
		cbxSessionFive.setForeground(Color.BLACK);
		cbxSessionFive.setBackground(Color.WHITE);
		cbxSessionFive.setBounds(313, 278, 154, 27);
                cbxSessionFive.setFocusable(false);
		contentPane.add(cbxSessionFive);
		
		cbxSessionSix = new JCheckBox("9:00 P.M - 12:00 A.M");
		cbxSessionSix.setToolTipText("select seesion for Show!");
		cbxSessionSix.setForeground(Color.BLACK);
		cbxSessionSix.setBackground(Color.WHITE);
		cbxSessionSix.setBounds(535, 278, 157, 27);
                cbxSessionSix.setFocusable(false);
		contentPane.add(cbxSessionSix);
		
		JLabel lblMovieAvailableOn = new JLabel("Movie Available on:");
		lblMovieAvailableOn.setForeground(Color.BLACK);
		lblMovieAvailableOn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMovieAvailableOn.setBounds(10, 303, 161, 45);
		contentPane.add(lblMovieAvailableOn);
		
		//JDateChooser (Class in JCalender Jar File) for date Of Birth
                dateChooser = new JDateChooser();
                dateChooser.setBounds(80 , 343 , 172 , 30);
                dateChooser.setForeground(new Color(105 , 105 , 105));
		dateChooser.setToolTipText("select session for Show!");
                dateChooser.setFocusable(false);
		contentPane.add(dateChooser);
		
		dateChooserTwo = new JDateChooser();
                dateChooserTwo.setBounds(340 , 343 , 172 , 30);
                dateChooserTwo.setForeground(new Color(105 , 105 , 105));
		dateChooserTwo.setToolTipText("select session for Show!");
                dateChooserTwo.setFocusable(false);
		contentPane.add(dateChooserTwo);
		
                dateChooserThree = new JDateChooser();
                dateChooserThree.setBounds(600 , 343 , 172 , 30);
                dateChooserThree.setForeground(new Color(105 , 105 , 105));
		dateChooserThree.setToolTipText("select session for Show!");
                dateChooserThree.setFocusable(false);
		contentPane.add(dateChooserThree);
                
                JLabel lblRating = new JLabel("Movie Rating: ");
                lblRating.setBounds(10 , 437 , 120 , 45);
                lblRating.setForeground(Color.BLACK);
                lblRating.setFont(new Font("Tahoma", Font.BOLD, 15));
                contentPane.add(lblRating);
                
                txtMovieRating = new JTextField();
                txtMovieRating.setToolTipText("Enter Movie Rating!");
		txtMovieRating.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMovieRating.setBounds(140, 448, 155, 27);
		contentPane.add(txtMovieRating);
		txtMovieRating.setColumns(10);
		
		btnNextPage = new JButton("Update Movie");
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNextPage.setBounds(702, 500, 145, 38);
                btnNextPage.setFocusable(false);
                btnNextPage.setBackground(Color.BLACK);
                btnNextPage.setForeground(Color.WHITE);
                btnNextPage.addActionListener(this);
		contentPane.add(btnNextPage);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(40, 500, 145, 38);
                btnBack.setFocusable(false);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
                btnBack.addActionListener(this);
		contentPane.add(btnBack);
		
		JLabel lblAudiDetails = new JLabel("Audi Details:");
		lblAudiDetails.setForeground(Color.BLACK);
		lblAudiDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAudiDetails.setBounds(10, 383, 117, 45);
		contentPane.add(lblAudiDetails);
                
                String audiNumbers[] = {"Select Audi Number" , "Audi 1" , "Audi 2" , "Audi 3" , "Audi 4"};
                audiDetails = new JComboBox(audiNumbers);
                audiDetails.setBounds(135 , 392 , 200 , 30);
                audiDetails.setFocusable(false);
                contentPane.add(audiDetails);
                
	}
        
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btnNextPage){
                String normalFare = txtNormalFare.getText();
                String executiveFare = txtExecutiveFare.getText();
                String premiumFare = txtPremiumFare.getText();
                String movieDateOne = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
                String movieDateTwo = ((JTextField)dateChooserTwo.getDateEditor().getUiComponent()).getText();
                String movieDateThree = ((JTextField)dateChooserThree.getDateEditor().getUiComponent()).getText();
//                System.out.println(movieDateTwo);
                String audiNumber =  String.valueOf(audiDetails.getSelectedItem());
                
                String movieRating = txtMovieRating.getText();

                if(cbxSessionOne.isSelected()){
                    sessionOne = "9:00 A.M - 12:00 P.M";
                }
                if(cbxSessionTwo.isSelected()){
                    sessionTwo = "10:00 A.M - 1:00 P.M";
                }
                if(cbxSessionThree.isSelected()){
                    sessionThree = "12:00 P.M - 3:00 P.M";
                }
                if(cbxSessionFour.isSelected()){
                    sessionFour = "1:00 P.M - 4:00 P.M";
                }
                if(cbxSessionFive.isSelected()){
                    sessionFive = "3:00 P.M - 6:00 P.M";
                }
                if(cbxSessionSix.isSelected()){
                    sessionSix = "9:00 P.M - 12:00 A.M";
                }

                //checking Conditions
                if(normalFare.equals("")){
                    JOptionPane.showMessageDialog(null , "The Normal Fare Field is Empty!");
                    return;
                }
                if(executiveFare.equals("")){
                    JOptionPane.showMessageDialog(null , "The Executive Fare Field is Empty!");
                    return;
                }
                if(premiumFare.equals("")){
                    JOptionPane.showMessageDialog(null , "The Premium Fare Field is Empty!");
                    return;
                }
                if(!cbxSessionOne.isSelected() && !cbxSessionTwo.isSelected() && !cbxSessionThree.isSelected() && !cbxSessionFour.isSelected() && !cbxSessionFive.isSelected() && !cbxSessionSix.isSelected()){
                    JOptionPane.showMessageDialog(null , "Atleast one CHeckBox must be Selected in the Session Field");
                    return;
                }
                if(audiNumber.equals("Select Audi Number")){
                    JOptionPane.showMessageDialog(null, "Select Audi Number");
                    return;
                }
                if(movieDateOne == null){
                    JOptionPane.showMessageDialog(null , "Please select the dates for the Show");
                    return;
                }
                if(movieDateTwo == null){
                    JOptionPane.showMessageDialog(null , "Please select the Movie Date for the Show");
                    return;
                }
                if(movieDateThree == null){
                    JOptionPane.showMessageDialog(null , "Please select the Movie Date for the show");
                    return;
                }
                else{
                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                            String query = "UPDATE shows SET movieNormalFare = ?, movieExecutiveFare = ?, moviePremiumFare = ?, movieTimingsOne = ?, movieTimingsTwo = ?, movieTimingsThree = ?, movieTimingsFour = ?, movieTimingsFive = ?, movieTimingsSix = ?, dateOfShowOne = ?, dateOfShowTwo = ?, dateOfShowThree = ?, audiNumber = ? WHERE movieID = ? OR movieName = ?";

                            PreparedStatement pstmt = conn.prepareStatement(query);
                            pstmt.setString(1, normalFare);
                            pstmt.setString(2, executiveFare);
                            pstmt.setString(3, premiumFare);
                            pstmt.setString(4, sessionOne);
                            pstmt.setString(5, sessionTwo);
                            pstmt.setString(6, sessionThree);
                            pstmt.setString(7, sessionFour);
                            pstmt.setString(8, sessionFive);
                            pstmt.setString(9, sessionSix);
                            pstmt.setString(10, movieDateOne);
                            pstmt.setString(11, movieDateTwo);
                            pstmt.setString(12, movieDateThree);
                            pstmt.setString(13, audiNumber);
                            pstmt.setString(14, MovieID);
                            pstmt.setString(15, MovieName);

                            int rowsAffected = pstmt.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Update successful.");
                            } else {
                                System.out.println("Update failed.");
                            }

                            pstmt.close();
//                            JOptionPane.showMessageDialog(null , "Movie Information Updated!");
//                            dispose();
                    }
                        
                        catch(Exception exx){
                            System.out.println(exx);
                        }
                        
                        
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                        String query = "UPDATE moviedetails SET MovieRating = ? WHERE movieID = ? OR movieName = ?";
                        PreparedStatement pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, movieRating);
                        pstmt.setString(2, MovieID);
                        pstmt.setString(3, MovieID);
                        int rowsAffected = pstmt.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("Update successful.");
                            } else {
                                System.out.println("Update failed.");
                            }

                            pstmt.close();
                            JOptionPane.showMessageDialog(null , "Movie Information Updated!");
                            dispose();

                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                }
        }
            
            if(e.getSource() == btnBack){
                dispose();
                new UpdateMovie().setVisible(true);
            }
    }
        
}