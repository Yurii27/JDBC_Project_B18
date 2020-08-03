package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingCountryTable {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.90.25.217:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");

        //TASK 1:
        //CREATE A NEW CLASS, ADD CONNECTION , STATEMENT, RESULTSET
        //AND TRY TO PRINT OUT EACH AND EVERYTHING UNDER COUNTRIES TABLE


        while (rs.next() == true) { // while (rs.next()){
            System.out.println(rs.getString("country_id") + " "
                    + rs.getString("country_name") + " "
                    + rs.getInt(3)); // THIS IS GETTING REGION_ID AS NUMBER INSTEAD OF STRING
        }
        rs.previous();
    }
}