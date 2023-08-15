
package com.raven.main;

import java.sql.*;

public class Conn{
    
    Connection c;
    Statement st;
    
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/bookmyticket?user=root&password=root");
            st = c.createStatement();
        
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
