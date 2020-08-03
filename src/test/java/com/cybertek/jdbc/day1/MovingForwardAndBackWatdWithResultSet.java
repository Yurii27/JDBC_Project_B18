package com.cybertek.jdbc.day1;

import java.sql.*;

public class MovingForwardAndBackWatdWithResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.90.25.217:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        //if we create the statement in this way, this will generate  a forward only resultSet
        //moving we can only move forward with next() and cannot move backward with previous
        //Statement stmnt = conn.createStatement();
        //ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultset created from this statement
        //to be able to move forward and backward
        //ResultSet.CONCUR_READ_ONLY will make resultSet read only and that's what we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");

        rs.next();
        System.out.println(rs.getString("country_id")+ " " + rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_id")+ " " + rs.getString("country_name"));
        //how do i go back to previous row

        rs.previous();
        System.out.println(rs.getString("country_id")+ " " + rs.getString("country_name"));




    }
}