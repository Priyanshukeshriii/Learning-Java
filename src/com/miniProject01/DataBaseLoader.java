package com.miniProject01;

import java.sql.*;

public class DataBaseLoader {
    public static  ResultSet  loadStudent() throws SQLException, ClassNotFoundException {
        String user= "root";
        String password = "password";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miniproject01";
        Connection con = null;
        Statement st = null;

        String query = "select * from student";
        Class.forName(Driver);
        con = DriverManager.getConnection(url,user, password);

        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
        return st.executeQuery(query);
    }

    public static ResultSet loadComplain() throws ClassNotFoundException, SQLException {
        String user= "root";
        String password = "password";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miniproject01";
        Connection con = null;
        Statement st = null;

        String query = "select * from complaints";
        Class.forName(Driver);
        con = DriverManager.getConnection(url,user, password);

        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
        return st.executeQuery(query);

    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String user= "root";
        String password = "password";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miniproject01";
        Class.forName(Driver);
        Connection con = DriverManager.getConnection(url,user,password);

        return con;
    }

    public static Statement getStatment() throws SQLException {
        String user= "root";
        String password = "password";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miniproject01";
        Connection con = DriverManager.getConnection(url,user,password);
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
        return st;
    }
    public static ResultSet loadCourse() throws SQLException, ClassNotFoundException {
        String user= "root";
        String password = "password";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miniproject01";
        Connection con = null;
        Statement st = null;

        String query = "select * from course";
        Class.forName(Driver);
        con = DriverManager.getConnection(url,user, password);

        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
        return st.executeQuery(query);
    }
    public static ResultSet loadSchedule() throws SQLException, ClassNotFoundException {
        String user= "root";
        String password = "password";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miniproject01";
        Connection con = null;
        Statement st = null;

        String query = "select * from schedule";
        Class.forName(Driver);
        con = DriverManager.getConnection(url,user, password);

        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
        return st.executeQuery(query);
    }
    public static ResultSet loadProfessor() throws SQLException, ClassNotFoundException {
        String user= "root";
        String password = "password";
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/miniproject01";
        Connection con = null;
        Statement st = null;

        String query = "select * from professors";
        Class.forName(Driver);
        con = DriverManager.getConnection(url,user, password);

        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
        return st.executeQuery(query);
    }
}
