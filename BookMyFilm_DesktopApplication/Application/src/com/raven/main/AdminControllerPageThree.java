package com.raven.main;

import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class AdminControllerPageThree extends JFrame implements ActionListener{

	JPanel contentPane;
        JFileChooser j;
	JTextField txtMovieRating;
	private JTextField txtMovieDuration , txtMovieCast;
	private JTextField txtMovieRelease;
        private JTextField txtMovieTrailer;
	JButton btnSelectFile , btnNextPage;
	JLabel l;
	private JButton btnDeleteMovie;
	private JLabel lblAddMovieDetails;
        String MovieRating , MovieDuration , MovieRelease , MovieCast , MovieTrailer;
        String MovieID , MovieName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControllerPageThree frame = new AdminControllerPageThree("" , "");
					frame.setVisible(true);
                                        frame.setTitle("ADD MOVIE DETAILS : PAGE-2");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminControllerPageThree(String MovieID , String MovieName) {
            
           this.MovieID = MovieID;
           this.MovieName = MovieName;
                
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
        setIconImage(icon.getImage());
            
            
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 552, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 252, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                
                setTitle("ADD SHOW DETAILS : PAGE 2");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeading = new JLabel("Admin Panel");
		lblHeading.setFont(new Font("Raleway", Font.BOLD, 25));
		lblHeading.setForeground(new Color(0, 0, 0));
		lblHeading.setBounds(200 , 20 , 600 , 40);
		contentPane.add(lblHeading);
		
		JLabel lblMovieRating = new JLabel("Movie Rating:");
		lblMovieRating.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieRating.setForeground(new Color(0,0,0));
		lblMovieRating.setBounds(67, 102, 150, 38);
		contentPane.add(lblMovieRating);
		
		txtMovieRating = new JTextField();
		txtMovieRating.setToolTipText("Enter Movie Rating!");
		txtMovieRating.setBounds(211, 110, 160, 29);
		contentPane.add(txtMovieRating);
		txtMovieRating.setColumns(10);
		
		JLabel lblMovieDuration = new JLabel("Movie Duration:");
		lblMovieDuration.setForeground(Color.BLACK);
		lblMovieDuration.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieDuration.setBounds(67, 185, 150, 38);
		contentPane.add(lblMovieDuration);
		
		txtMovieDuration = new JTextField();
		txtMovieDuration.setToolTipText("Enter Movie Duration!");
		txtMovieDuration.setColumns(10);
		txtMovieDuration.setBounds(211, 193, 160, 29);
		contentPane.add(txtMovieDuration);
		
		JLabel lblMovieRelease = new JLabel("Release Date:");
		lblMovieRelease.setForeground(Color.BLACK);
		lblMovieRelease.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieRelease.setBounds(67, 268, 132, 38);
		contentPane.add(lblMovieRelease);
		
		txtMovieRelease = new JTextField();
		txtMovieRelease.setToolTipText("Enter Release Date!");
		txtMovieRelease.setColumns(10);
		txtMovieRelease.setBounds(211, 276, 160, 29);
		contentPane.add(txtMovieRelease);
		
		JLabel lblMovieLogo = new JLabel("Movie Logo:");
		lblMovieLogo.setForeground(Color.BLACK);
		lblMovieLogo.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieLogo.setBounds(67, 358, 126, 38);
		contentPane.add(lblMovieLogo);
                
                JLabel lblMovieCast = new JLabel("Movie Cast:");
		lblMovieCast.setForeground(Color.BLACK);
		lblMovieCast.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieCast.setBounds(67, 428, 126, 38);
		contentPane.add(lblMovieCast);
                
                txtMovieCast = new JTextField();
		txtMovieCast.setToolTipText("Enter Movie Cast!");
		txtMovieCast.setColumns(10);
		txtMovieCast.setBounds(211, 445, 160, 29);
		contentPane.add(txtMovieCast);
		
		l = new JLabel();
		l.setBounds(325 , 373 , 320 , 12);
		l.setFont(new Font("SansSerif", Font.BOLD, 12));
		l.setForeground(Color.BLACK);
		contentPane.add(l);
		
		btnNextPage = new JButton("Next Page");
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNextPage.setBounds(350, 580, 154, 38);
		btnNextPage.setFocusable(false);
                btnNextPage.addActionListener(this);
                btnNextPage.setBackground(Color.BLACK);
                btnNextPage.setForeground(Color.WHITE);
		contentPane.add(btnNextPage);
		
		btnSelectFile = new JButton("Select File");
		btnSelectFile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelectFile.setBounds(211, 367, 110, 27);
		btnSelectFile.addActionListener(this);
		btnSelectFile.setFocusable(false);
                btnSelectFile.setBackground(Color.BLACK);
                btnSelectFile.setForeground(Color.WHITE);
		contentPane.add(btnSelectFile);
		
//		lblAddMovieDetails = new JLabel("Add Movie Details");
//		lblAddMovieDetails.setForeground(Color.BLACK);
//		lblAddMovieDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
//		lblAddMovieDetails.setBounds(67, 60, 175, 38);
//		contentPane.add(lblAddMovieDetails);
                
                JLabel lblMovieTrailer = new JLabel("Trailer Link:");
		lblMovieTrailer.setForeground(Color.BLACK);
		lblMovieTrailer.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieTrailer.setBounds(67, 518, 150, 38);
		contentPane.add(lblMovieTrailer);
                
                txtMovieTrailer = new JTextField();
		txtMovieTrailer.setToolTipText("Enter Trailer Link!");
		txtMovieTrailer.setColumns(10);
		txtMovieTrailer.setBounds(211, 523, 160, 29);
		contentPane.add(txtMovieTrailer);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSelectFile) {
			// create an object of JFileChooser class
			j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			// invoke the showsSaveDialog function to show the save dialog
			int r = j.showSaveDialog(null);

			if (r == JFileChooser.APPROVE_OPTION) {
				// set the label to the path of the selected directory
				l.setText(j.getSelectedFile().getAbsolutePath());
			}
			// if the user cancelled the operation
			else
				l.setText("the user cancelled the operation");
		}
                
                if(e.getSource() == btnNextPage){
                    MovieRating = txtMovieRating.getText();
                    MovieDuration = txtMovieDuration.getText();
                    MovieRelease = txtMovieRelease.getText();
                    MovieCast = txtMovieCast.getText();
                    MovieTrailer = txtMovieTrailer.getText();
//                    String Trailer = MovieTrailer.replace("\\","#");
//                    System.out.println(Trailer);
                    if(MovieRating.equals("")){
                        JOptionPane.showMessageDialog(null, "Movie Rating Field is Empty!");
                        return;
                    }
                    else if(MovieDuration.equals("")){
                        JOptionPane.showMessageDialog(null, "Movie Duation Field is Empty!");
                        return;
                    }
                    else if(MovieRelease.equals("")){
                        JOptionPane.showMessageDialog(null, "Movie Release Field is Empty!");
                        return;
                    }
                    else if(MovieCast.equals("")){
                        JOptionPane.showMessageDialog(null, "Movie Cast Field is Empty!");
                        return;
                    }
                    //Establishing Connection with the Database[Adding Simple Data]
                    else{
                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                            //for Image to the DataBase
                            String file = j.getSelectedFile().getAbsolutePath();
//                            System.out.println(file);
                            String file1 = file.replace("\\","#");
//                            System.out.println(file1);
                            PreparedStatement ps = conn.prepareStatement("UPDATE movieDetails SET MovieRating = '"+MovieRating+"', MovieDuration = '"+MovieDuration+"', MovieReleaseDate = '"+MovieRelease+"', MovieLogo = '"+file1+"', MovieCast = '"+MovieCast+"' , MovieTrailer = '"+MovieTrailer+"' WHERE MovieID = '"+MovieID+"'");
//                            ps.setBinaryStream(1, fis , fis.available());
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null , "Information added to the DataBase!");
                            dispose();
                            new AdminControllerPageTwo(MovieID , MovieName).setVisible(true);
                    }
                        
                        catch(Exception exx){
                            System.out.println(exx);
                        }
                    }
                }
    }
}

	





















/*
3-Movie Cast
4-About The Movie
*/


