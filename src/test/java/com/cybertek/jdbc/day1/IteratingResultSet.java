package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.90.25.217:1521:XE";
        String username = "hr" ;
        String password = "hr" ;
        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement();
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

        //as long as rs.next() return true I know that I have next row to print the data
        // we will keep looping as long as rs.next() return true

        while (rs.next() == true){ // while (rs.next()){
            System.out.println( rs.getString("Region_id") + " " + rs.getString("Region_name") );
        }


//        rs.next(); // currently we are at the first row
//        System.out.println( rs.getString("Region_id") + " " + rs.getString("Region_name") );
//
//        rs.next(); // 2nd row
//        System.out.println( rs.getString(1) + " " + rs.getString(2) );
//
//        rs.next(); //3rd row
//        System.out.println( rs.getString("Region_id") + " " + rs.getString("Region_name") );
//
//        System.out.println( rs.next() ); // currently we are at the 4th row
//        //System.out.println( rs.getString(1) + " " + rs.getString(2) );

    }
}
