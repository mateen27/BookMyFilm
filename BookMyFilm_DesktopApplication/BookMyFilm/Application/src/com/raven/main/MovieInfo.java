package com.raven.main;


import javax.swing.*;
import java.awt.*;
import java.awt.Desktop;
import java.net.URI;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieInfo extends JFrame {
    
        JMenuBar mb;
    	JMenu LogIn, SignUp , About , Theme , Profile;  
	JMenuItem userLogin, adminLogin , black , white , changePassword ,signOut ;
        Container c;
        JLabel logo ;
        String MovieName , MovieID;
        String MovieDate , MovieTiming;
        JComboBox timingDetails , audiDetails;
    
        public MovieInfo(String movieTitle){
            
                this.MovieName = movieTitle;
//                System.out.println(MovieName);
            
                ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
                setIconImage(icon2.getImage());
                
                setResizable(false);
            
            //adding MenuBar 
		mb = new JMenuBar();
                LogIn = new JMenu("LogIn");
                SignUp = new JMenu("SignUp");
                Theme = new JMenu("Theme");
                About = new JMenu("About");
                Profile = new JMenu("Profile");
                userLogin = new JMenuItem("User Login");
                adminLogin = new JMenuItem("Admin Login");
                black = new JMenuItem("Dark");
//                black.addActionListener(this);
                white = new JMenuItem("Light");
//                white.addActionListener(this);
                changePassword = new JMenuItem("Change Password");
                signOut = new JMenuItem("Sign Out");

                // Add menu items to menus
                Theme.add(black);
                Theme.addSeparator();
                Theme.add(white);
                LogIn.add(userLogin);
                LogIn.addSeparator();
                LogIn.add(adminLogin);
                Profile.add(changePassword);
                Profile.add(signOut);

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
                mb.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));


                // Add menus to menu bar
//                mb.add(LogIn); 
//                mb.add(SignUp);
                mb.add(Theme);

                // Add an invisible menu item to the left of the "Profile" menu
                JMenuItem invisibleItem = new JMenuItem();
//                invisibleItem.setBackground(Color.WHITE);
//                invisibleItem.setEnabled(true);
                mb.add(invisibleItem);

                // Add the "Profile" menu to the right of the invisible item
                mb.add(About);
                mb.add(Profile);

                setJMenuBar(mb);
                
                
                //Heading for the Movie
                JLabel heading = new JLabel(MovieName);
                heading.setBounds(370 , 50 , 450 , 50);
                heading.setFont(new Font("Raelway" , Font.BOLD , 25));
                add(heading);
                
                
    // Create a connection to the database
    try{
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyticket", "root", "root");

    // Create a statement to execute the SQL query
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from movieDetails where MovieName = '"+MovieName+"'");
    //(SELECT * FROM movieDetails ORDER BY MovieID DESC LIMIT 3)\n" +
//"ORDER BY MovieID DESC;

    // Retrieve the data from the result set and display it in the JLabels
    while(rs.next()) {
        MovieID = rs.getString("MovieID");
        String movieRating = rs.getString("MovieRating");
        String movieDuration = rs.getString("MovieDuration");
        String movieCategory = rs.getString("MovieCategory");
        String movieReleased = rs.getString("MovieReleaseDate");
        String movieCast = rs.getString("MovieCast");
//        String movieCertificate = rs.getString("MovieCertificate");
        String movieLogo = rs.getString("MovieLogo");
        //Replaced \ with # as MySQL is not able to store \.
        String MovieLink = movieLogo.replace("#","\\");
//        System.out.println(MovieLink);
        String MovieTrailer = rs.getString("MovieTrailer");

            //Movie Banner
//            String img = rs.getString("MovieLink");
            //Image on the JLabel
                ImageIcon icon = new ImageIcon(MovieLink);
                logo = new JLabel(icon);
                logo.setBounds(10 , 20 , 360 , 470);
                add(logo);
            
                //Movie Rating
                JLabel rating = new JLabel(movieRating);
                rating.setBounds(520 , 90 , 450 , 50);
                rating.setFont(new Font("Raelway" , Font.BOLD , 16));
                add(rating);
            
                JLabel duration = new JLabel(movieDuration);
                duration.setBounds(520 , 130 , 450 , 50);
                duration.setFont(new Font("Raelway" , Font.BOLD , 16));
                add(duration);
            
            	JLabel category = new JLabel(movieCategory);
                category.setBounds(520 , 170 , 450 , 50);
                category.setFont(new Font("Raelway" , Font.BOLD , 16));
                add(category);
                
                JLabel release = new JLabel(movieReleased);
                release.setBounds(520 , 210 , 450 , 50);
                release.setFont(new Font("Raelway" , Font.BOLD , 16));
                add(release);
                
                JLabel cast = new JLabel(movieCast);
                cast.setBounds(480 , 250 , 450 , 50);
                cast.setFont(new Font("Raelway" , Font.BOLD , 16));
                add(cast);
                
//                JLabel certificate = new JLabel(movieCertificate);
//                certificate.setBounds(530 , 290 , 450 , 50);
//                certificate.setFont(new Font("Raelway" , Font.BOLD , 16));
//                add(certificate);


                JButton btnTrailer = new JButton("Watch Trailer");
                btnTrailer.setBounds(370 , 445 , 150 , 40);
                btnTrailer.setFocusable(false);
                btnTrailer.setForeground(Color.WHITE);
                btnTrailer.setBackground(Color.BLACK);
                btnTrailer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(MovieTrailer));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
                add(btnTrailer);
        }

    // Close the result set, statement, and connection
    rs.close();
    stmt.close();
    conn.close();

    }
    catch(SQLException e){
        System.out.println("e");
    }
                 
                JLabel movieRating = new JLabel("Movie Rating: ");
                movieRating.setBounds(370 , 90 , 150 , 50);
                movieRating.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieRating);

                
                JLabel movieDuration = new JLabel("Movie Duration: ");
                movieDuration.setBounds(370 , 130 , 180 , 50);
                movieDuration.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieDuration);
                
                
                JLabel movieCategory = new JLabel("Movie Category: ");
                movieCategory.setBounds(370 , 170 , 180 , 50);
                movieCategory.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieCategory);
               
                
                JLabel movieRelease = new JLabel("Released on: ");
                movieRelease.setBounds(370 , 210 , 180 , 50);
                movieRelease.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieRelease);
                
                
                JLabel movieCast = new JLabel("Movie Cast: ");
                movieCast.setBounds(370 , 250 , 180 , 50);
                movieCast.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieCast);
                
                
                JLabel movieCerticate = new JLabel("Movie Certificate: ");
                movieCerticate.setBounds(370 , 290 , 180 , 50);
                movieCerticate.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieCerticate);
                
                JLabel Certicate = new JLabel("UA");
                Certicate.setBounds(530 , 290 , 180 , 50);
                Certicate.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(Certicate);
                 
                JLabel movieDate = new JLabel("Select Date: ");
                movieDate.setBounds(370 , 332 , 180 , 50);
                movieDate.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieDate);
                
                
//                String audiNumbers[] = {"Select your Movie Date" , "29 Jan 2023" , "30 Jan 2023" , "31 Jan 2023"};
//                JComboBox audiDetails = new JComboBox(audiNumbers);
//                audiDetails.setBounds(555 , 342 , 200 , 30);
//                audiDetails.setFocusable(false);
//                add(audiDetails);
                
                
                JLabel movieTiming = new JLabel("Select Timings: ");
                movieTiming.setBounds(370 , 372 , 180 , 50);
                movieTiming.setFont(new Font("Raelway" , Font.BOLD , 18));
                add(movieTiming);
                
                
//                String timingMovie[] = {"Select your Movie Timings" , "29 Jan 2023" , "30 Jan 2023" , "31 Jan 2023"};
//                JComboBox timingDetails = new JComboBox(timingMovie);
//                timingDetails.setBounds(555 , 382 , 200 , 30);
//                timingDetails.setFocusable(false);
//                add(timingDetails);




            // Create a connection to the database
    try{
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyticket", "root", "root");

    // Create a statement to execute the SQL query
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from shows where movieID = '"+MovieID+"'");
    //(SELECT * FROM movieDetails ORDER BY MovieID DESC LIMIT 3)\n" +
//"ORDER BY MovieID DESC;

    // Retrieve the data from the result set and display it in the JLabels
    while(rs.next()) {
//        MovieID = rs.getString("MovieID");
        String movieTimingsOne = rs.getString("movieTimingsOne");
        String movieTimingsTwo = rs.getString("movieTimingsTwo");
        String movieTimingsThree = rs.getString("movieTimingsThree");
        String movieTimingsFour = rs.getString("movieTimingsFour");
        String movieTimingsFive = rs.getString("movieTimingsFive");
        String movieTimingsSix = rs.getString("movieTimingsSix");
        
        String ShowOneDate = rs.getString("dateOfShowOne");
        String ShowTwoDate = rs.getString("dateOfShowTwo");
        String ShowThreeDate = rs.getString("dateOfShowThree");

        String movieTimings[] = {"Select your Movie Timings" , movieTimingsOne , movieTimingsTwo , movieTimingsThree , movieTimingsFour , movieTimingsFive , movieTimingsSix};
        timingDetails = new JComboBox(movieTimings);
        timingDetails.setBounds(555 , 382 , 200 , 30);
        timingDetails.setFocusable(false);
        add(timingDetails);
        

        
        
        String audiNumbers[] = {"Select your Movie Date" , ShowOneDate , ShowTwoDate , ShowThreeDate};
        audiDetails = new JComboBox(audiNumbers);
        audiDetails.setBounds(555 , 342 , 200 , 30);
        audiDetails.setFocusable(false);
        add(audiDetails);

                
        }

    // Close the result set, statement, and connection
    rs.close();
    stmt.close();
    conn.close();

    }
    catch(SQLException e){
        System.out.println("e");
    }

                
                            JButton btnBook = new JButton("Book Tickets");
                btnBook.setBounds(700 , 445 , 150 , 40);
                btnBook.setFocusable(false);
                btnBook.setForeground(Color.WHITE);
                btnBook.setBackground(new Color(216, 46, 47));
                btnBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                            MovieTiming = (String) timingDetails.getSelectedItem();
//                            System.out.println(MovieTiming);
                                    
                             MovieDate = (String) audiDetails.getSelectedItem();
//                            System.out.println(MovieDate);
                    dispose();
                    new BookSeats(MovieID , MovieName , MovieTiming , MovieDate).setVisible(true);
            }
        });
                add(btnBook);
                
                
            

                c = getContentPane();
                c.setBackground(Color.WHITE);
            
            //frame Properties
            setResizable(false);
            setTitle(MovieName);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocation(100 , 100);
            setSize(950 , 555);
            setVisible(true);
            
        }
        
        public static void main(String[] args) {
        new MovieInfo("");
    }
}
