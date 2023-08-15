//Main Page
package com.raven.main;

import com.raven.model.ModelUser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;

class MainPage implements ActionListener{

	JFrame f;
	Container c;
	JLabel heading , heading1 , lblImg , lblImg2 , lblImg3 , lblLogo , lblMovie1 , MovieType1 , MovieType2 , MovieType3 , lblMovie2 , lblMovie3;
	JMenu LogIn, SignUp , About , Theme , Profile;  
	JMenuItem userLogin, adminLogin , black , white , changePassword ,signOut ;
	JButton btn1 , btn2 , btn3;
        ImageIcon i , i2 , i3 , logoImg;
        JMenuBar mb;
        String userName;


	MainPage(String userName){
            
            userName = this.userName;
//            System.out.println(userName);

		//creating Frame
		f = new JFrame("BookMyTicket");
                
                
                f.invalidate();
                f.validate();
                f.repaint();
                
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
                black.addActionListener(this);
                white = new JMenuItem("Light");
                white.addActionListener(this);
                changePassword = new JMenuItem("Change Password");
                signOut = new JMenuItem("Sign Out");
                signOut.addActionListener(this);

                // Add menu items to menus
                Theme.add(black);
                Theme.addSeparator();
                Theme.add(white);
                LogIn.add(userLogin);
                LogIn.addSeparator();
                LogIn.add(adminLogin);
                Profile.add(changePassword);
                Profile.addSeparator();
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

                // Add an invisible menu item to the left of the "Profile" menu
                JMenuItem invisibleItem = new JMenuItem();
////                invisibleItem.setBackground(Color.WHITE);
////                invisibleItem.setEnabled(false);
                mb.add(invisibleItem);

                // Add the "Profile" menu to the right of the invisible item
                mb.add(Profile);
                mb.add(Theme);
                mb.add(About);

                f.setJMenuBar(mb);

		//Background Color On Frame
		c = f.getContentPane();
		c.setBackground(Color.WHITE);
                
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 3.png"));
                f.setIconImage(icon.getImage());
                f.setTitle("Welcome to BookMyFilm");
                
                logoImg = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 1.png"));
                lblLogo = new JLabel(logoImg);
                lblLogo.setBounds(460 , -5 , 360 , 100);
                f.add(lblLogo);

		//setting Label as Heading
//		heading = new JLabel("Welcome to BookMyFilm");
//		heading.setForeground(Color.black);
//		heading.setBounds(480 , 20 , 355 , 50);
//		Font font = new Font("Raleway",  1, 30);
//		heading.setFont(font);
//		f.add(heading); 

		//SubHeading Of Main Page
		heading1 = new JLabel("Recommended Movies");
		heading1.setForeground(Color.black);
		heading1.setBounds(30 , 100 , 250 , 50);
                heading1.setFont(new Font("Raleway" , Font.BOLD , 22));
//		Font myfont = new Font(Font.SANS_SERIF,  2, 20);
//		heading1.setFont(myfont);
		f.add(heading1);	
                
                
                // Create a connection to the database
try{
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyticket", "root", "root");

    // Create a statement to execute the SQL query
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM movieDetails ORDER BY MovieID DESC LIMIT 3");
//    (SELECT * FROM movieDetails ORDER BY MovieID DESC LIMIT 3)\n" +
//"ORDER BY MovieID DESC;

    // Retrieve the data from the result set and display it in the JLabels
    int i = 1;
    while(rs.next()) {
        String movieTitle = rs.getString("MovieName");
        String movieType = rs.getString("MovieCategory");
        String MovieBannerLink = rs.getString("MovieBanner");
        //Replaced \ with # as MySQL is not able to store \.
        String MovieLink = MovieBannerLink.replace("#","\\");
//        System.out.println(MovieLink);

        if(i == 1) {
            //Movie Banner
//            String img = rs.getString("MovieLink");
            ImageIcon iconOne = new ImageIcon(MovieLink);
            lblImg = new JLabel(iconOne);
            lblImg.setBounds(70 , 150 , 350, 470);
            f.add(lblImg);
            
            //Movie Title
            lblMovie1 = new JLabel(movieTitle);
            Font movieFont = new Font("Raelway" , Font.BOLD , 15);
            lblMovie1.setFont(movieFont);
            lblMovie1.setForeground(Color.black);
            lblMovie1.setBounds(215 , 590 , 300 , 90);
            f.add(lblMovie1);
            
            //Movie Category
            MovieType1 = new JLabel(movieType);
            Font movieTypeFont = new Font("Arial" , 1 , 13);
            MovieType1.setFont(movieTypeFont);
            MovieType1.setForeground(Color.black);
            MovieType1.setBounds(200 , 610 , 300 , 90);
            f.add(MovieType1);
            
            	//adding Buttons
		btn1 = new JButton("Book Tickets");
		//Cursor c = new Cursor(Cursor.HAND_CURSOR);
		//btn1.setCursor(c);
		btn1.setBounds(165 , 670 , 150 , 35);
		btn1.setFont(new Font("Raelway" , Font.BOLD , 15));
		btn1.setFocusable(false);
                btn1.setForeground(Color.white);
                btn1.setBackground(new Color(216, 46, 47));
                btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            f.dispose();
                new MovieInfo(movieTitle).setVisible(true);
            }
        });
		f.add(btn1);
        }
            else if(i == 2) {
            ImageIcon icon2 = new ImageIcon(MovieLink);
            lblImg2 = new JLabel(icon2);
            lblImg2.setBounds(500 , 150 , 350 , 470);
            f.add(lblImg2);
            
            //Movie Title
            lblMovie2 = new JLabel(movieTitle);
            Font movieFont = new Font("Raelway" , 1 , 15);
            lblMovie2.setFont(movieFont);
            lblMovie2.setForeground(Color.black);
            lblMovie2.setBounds(650 , 590 , 300 , 90);
            f.add(lblMovie2);
            
            //Movie Category
            MovieType2 = new JLabel(movieType);
            Font movieTypeFont = new Font("Arial" , 1 , 13);
            MovieType2.setFont(movieTypeFont);
            MovieType2.setForeground(Color.black);
            MovieType2.setBounds(580 , 610 , 300 , 90);
            f.add(MovieType2);
            
            btn2 = new JButton("Book Tickets");
		//Cursor c = new Cursor(Cursor.HAND_CURSOR);
		//btn1.setCursor(c);
		btn2.setBounds(600 , 670 , 150 , 35);
                btn2.setFont(new Font("Raelway" , Font.BOLD , 15));
//		btn2.setFont(movieFont);
                btn2.setBackground(new Color(216, 46, 47));
                btn2.setForeground(Color.white);
		btn2.setFocusable(false);
                btn2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new MovieInfo(movieTitle).setVisible(true);
            }
        });
		f.add(btn2);
        } 
        else if(i == 3) {
            ImageIcon icon3 = new ImageIcon(MovieLink);
            lblImg3 = new JLabel(icon3);
            lblImg3.setBounds(910 , 150 , 350 , 470);
            f.add(lblImg3);
            
            //Movie Title
            lblMovie3 = new JLabel(movieTitle);
            Font movieFont = new Font("Raelway" , 1 , 15);
            lblMovie3.setFont(movieFont);
            lblMovie3.setForeground(Color.black);
            lblMovie3.setBounds(1065 , 590 , 300 , 90);
            f.add(lblMovie3);
            
            //Movie Category
            MovieType3 = new JLabel(movieType);
            Font movieTypeFont = new Font("Arial" , 1 , 13);
            MovieType3.setFont(movieTypeFont);
            MovieType3.setForeground(Color.black);
            MovieType3.setBounds(1010 , 610 , 300 , 90);
            f.add(MovieType3);
            
            btn3 = new JButton("Book Tickets");
		//Cursor c = new Cursor(Cursor.HAND_CURSOR);
		//btn1.setCursor(c);
		btn3.setBounds(1015 , 670 , 150 , 35);
                btn3.setFont(new Font("Raelway" , Font.BOLD , 15));
//		btn3.setFont(movieFont);
                btn3.setForeground(Color.white);
                btn3.setBackground(new Color(216, 46, 47));
		btn3.setFocusable(false);
                btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new MovieInfo(movieTitle).setVisible(true);
            }
        });
		f.add(btn3);
        }

        i++;
    }

    // Close the result set, statement, and connection
    rs.close();
    stmt.close();
    conn.close();
    }
    catch(SQLException e){
        System.out.println("e");
    }
            //Frame Properties
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(800 , 800);
                f.setLocation(-10,0);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);f.setLayout(null);
		f.setVisible(true);
		f.setSize(1550 , 1550);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

public static void main(String args[]){
	
		MainPage m = new MainPage("");

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        //on click of Black Button
        if(e.getSource() == black){
            Container c = f.getContentPane();
            c.setBackground(Color.BLACK);


                // Set the border of the JMenuBar
                mb.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

                // Add an invisible menu item to the left of the "Profile" menu
                JMenuItem invisibleItem = new JMenuItem();
//                invisibleItem.setBackground(Color.WHITE);
                invisibleItem.setEnabled(false);
                mb.add(invisibleItem);

                // Add the "Profile" menu to the right of the invisible item
                mb.add(Profile);
                mb.add(Theme);
                mb.add(About);

                f.setJMenuBar(mb);
            
            
            
            
            
            
            
            
            
            
            
                //for removing the Previous Image Icon 
                lblLogo.setIcon(null);
                //adding new Image to the Icon
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 2.png"));
                lblLogo = new JLabel(icon);
                lblLogo.setBounds(460 , -5 , 360 , 100);
                f.add(lblLogo);
                
                //for refreshing the page
                f.revalidate();
                f.repaint();
                
                
            
            heading1.setForeground(Color.WHITE);
            lblMovie1.setForeground(Color.white);
            MovieType1.setForeground(Color.white);
            
            lblMovie2.setForeground(Color.white);
            MovieType2.setForeground(Color.white);
            
            lblMovie3.setForeground(Color.white);
            MovieType3.setForeground(Color.white);
            
            btn1.setForeground(Color.white);
            btn1.setBackground(new Color(216, 46, 47));
            
            btn2.setForeground(Color.white);
            btn2.setBackground(new Color(216, 46, 47));
            
            btn3.setForeground(Color.white);
            btn3.setBackground(new Color(216, 46, 47));
            
//            mb.setBackground(Color.BLACK);
//            mb.setForeground(Color.WHITE);
//            
//            LogIn.setForeground(Color.white);
        }
        
        //on click of White Button
        if(e.getSource() == white){
            Container c = f.getContentPane();
            c.setBackground(Color.WHITE);
            
            
            
            
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
                black.addActionListener(this);
                white = new JMenuItem("Light");
                white.addActionListener(this);
                changePassword = new JMenuItem("Change Password");
                signOut = new JMenuItem("Sign Out");
                signOut.addActionListener(this);

                // Add menu items to menus
                Theme.add(black);
                Theme.addSeparator();
                Theme.add(white);
                LogIn.add(userLogin);
                LogIn.addSeparator();
                LogIn.add(adminLogin);
                Profile.add(changePassword);
                Profile.addSeparator();
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

                // Add an invisible menu item to the left of the "Profile" menu
                JMenuItem invisibleItem = new JMenuItem();
//                invisibleItem.setBackground(Color.WHITE);
                invisibleItem.setEnabled(false);
                mb.add(invisibleItem);

                // Add the "Profile" menu to the right of the invisible item
                mb.add(Profile);
                mb.add(Theme);
                mb.add(About);

                f.setJMenuBar(mb);
            
                lblLogo.setIcon(null);

                //adding new Image to the Icon
                ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("com/raven/icon/Asset 1.png"));
                lblLogo = new JLabel(icon2);
                lblLogo.setBounds(460 , -5 , 360 , 100);
                f.add(lblLogo);
                
                //for refreshing the page
                f.revalidate();
                f.repaint();

            
            heading1.setForeground(Color.black);
            lblMovie1.setForeground(Color.black);
            MovieType1.setForeground(Color.black);
            
            lblMovie2.setForeground(Color.black);
            MovieType2.setForeground(Color.black);
            
            lblMovie3.setForeground(Color.black);
            MovieType3.setForeground(Color.black);
            
            btn1.setBackground(new Color(0,0,0));
            btn1.setForeground(Color.white);
            
            btn2.setBackground(new Color(0,0,0));
            btn2.setForeground(Color.white);
            
            btn3.setBackground(new Color(0,0,0));
            btn3.setForeground(Color.white);
        }
        
        
        // SignOut Functionality
        if(e.getSource() == signOut){
            f.dispose();
            new Main().setVisible(true);
        }
    }
}