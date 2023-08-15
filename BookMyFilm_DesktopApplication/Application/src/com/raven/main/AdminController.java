package com.raven.main;

import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class AdminController extends JFrame implements ActionListener{

	JPanel contentPane;
        JFileChooser j;
	JTextField txtMovieID;
	private JTextField txtMovieName;
	private JTextField txtMovieCategory;
	JButton btnSelectFile , btnNextPage , btnDeleteMovie;
	JLabel l;
	private JLabel lblAddMovieDetails;
        String MovieID , MovieName , MovieCategory;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminController frame = new AdminController();
					frame.setVisible(true);
                                        frame.setTitle("ADD MOVIE DETAILS : PAGE-1");
                                        frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminController() {
                
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
                setIconImage(icon.getImage());
                
                setTitle("ADD MOVIE DETAILS : PAGE-1");

                //Generaring Random Number 
                Random randomNumber = new Random();
  
                // Generate random integers in range 0 to 999
                int rand_int1 = randomNumber.nextInt(1000);
//                System.out.println(rand_int1);
            
            
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 252, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeading = new JLabel("Admin Panel");
		lblHeading.setFont(new Font("Raleway", Font.BOLD, 25));
		lblHeading.setForeground(new Color(0, 0, 0));
		lblHeading.setBounds(200 , 20 , 600 , 40);
		contentPane.add(lblHeading);
		
		JLabel lblNewLabel = new JLabel("Movie ID:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0,0,0));
		lblNewLabel.setBounds(67, 102, 100, 38);
		contentPane.add(lblNewLabel);
		
		txtMovieID = new JTextField();
                txtMovieID.setText(""+rand_int1);
		txtMovieID.setToolTipText("Movie ID!");
		txtMovieID.setBounds(211, 110, 160, 29);
                txtMovieID.setEditable(false);
		contentPane.add(txtMovieID);
		txtMovieID.setColumns(10);
		
		JLabel lblMovieName = new JLabel("Movie Name:");
		lblMovieName.setForeground(Color.BLACK);
		lblMovieName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieName.setBounds(67, 185, 100, 38);
		contentPane.add(lblMovieName);
		
		txtMovieName = new JTextField();
		txtMovieName.setToolTipText("Enter Movie Name!");
		txtMovieName.setColumns(10);
		txtMovieName.setBounds(211, 193, 160, 29);
		contentPane.add(txtMovieName);
		
		JLabel lblMovieCategory = new JLabel("Movie Category:");
		lblMovieCategory.setForeground(Color.BLACK);
		lblMovieCategory.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieCategory.setBounds(67, 268, 132, 38);
		contentPane.add(lblMovieCategory);
		
		txtMovieCategory = new JTextField();
		txtMovieCategory.setToolTipText("Enter Movie Category!");
		txtMovieCategory.setColumns(10);
		txtMovieCategory.setBounds(211, 276, 160, 29);
		contentPane.add(txtMovieCategory);
		
		JLabel lblMovieBanner = new JLabel("Movie Banner:");
		lblMovieBanner.setForeground(Color.BLACK);
		lblMovieBanner.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMovieBanner.setBounds(67, 358, 126, 38);
		contentPane.add(lblMovieBanner);
		
		l = new JLabel();
		l.setBounds(325 , 373 , 320 , 12);
		l.setFont(new Font("SansSerif", Font.BOLD, 12));
		l.setForeground(Color.BLACK);
		contentPane.add(l);
		
		btnNextPage = new JButton("Next Page");
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNextPage.setBounds(350, 438, 154, 38);
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
		
		btnDeleteMovie = new JButton("Update Movie");
		btnDeleteMovie.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteMovie.setFocusable(false);
		btnDeleteMovie.setBounds(27, 438, 154, 38);
                btnDeleteMovie.addActionListener(this);
                btnDeleteMovie.setBackground(Color.BLACK);
                btnDeleteMovie.setForeground(Color.WHITE);
		contentPane.add(btnDeleteMovie);
		
		lblAddMovieDetails = new JLabel("Add Movie Details:");
		lblAddMovieDetails.setForeground(Color.WHITE);
		lblAddMovieDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddMovieDetails.setBounds(67, 51, 175, 38);
		contentPane.add(lblAddMovieDetails);
                
//                JLabel lbl
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
                    MovieID = txtMovieID.getText();
                    MovieName = txtMovieName.getText();
                    MovieCategory = txtMovieCategory.getText();
                    if(MovieID.equals("")){
                        JOptionPane.showMessageDialog(null, "Movie ID Field is Empty!");
                        return;
                    }
                    else if(MovieName.equals("")){
                        JOptionPane.showMessageDialog(null, "Movie Name Field is Empty!");
                        return;
                    }
                    else if(MovieCategory.equals("")){
                        JOptionPane.showMessageDialog(null, "Movie Category Field is Empty!");
                        return;
                    }
                    //Establishing Connection with the Database[Adding Simple Data]
                    else{
                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
                            //for Image to the DataBase
                            String file = j.getSelectedFile().getAbsolutePath();
                            String file1 = file.replace("\\","#");
                            PreparedStatement ps = conn.prepareStatement("insert into movieDetails (MovieID, MovieName, MovieCategory, MovieBanner) values('"+MovieID+"' , '"+MovieName+"' , '"+MovieCategory+"' , '"+file1+"')");
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null , "Information added to the DataBase!");
                            dispose();
                            new AdminControllerPageThree(MovieID , MovieName).setVisible(true);
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                        try{
                            
                        }
                        catch(Exception exx){
                            System.out.println(exx);
                        }
                    }
                }
                    //Button Delete 
                    if(e.getSource() == btnDeleteMovie){
                       dispose();
                       new UpdateMovie().setVisible(true);
        }
    }
}

	

