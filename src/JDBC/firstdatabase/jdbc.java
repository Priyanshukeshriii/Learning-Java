package JDBC.firstdatabase;

import  java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        String userName = "root";
        String password = "password";
        Connection con = null;
        ResultSet resultSet = null;
        try{

            Class.forName("com.mysql.cj.jdbc.driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost3306/gsv", userName, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try{
            Statement statement = con.createStatement();
            String query = "select * ";
            statement.executeUpdate(query);
            String query1 = "show databases";
            statement.executeQuery(query1);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
