package com.satyamgupta;
import  java.sql.*;

public class conn {
//  2  interfaces
    Connection c;
    Statement s;
    public conn() {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/academy", "root", "2818098");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
