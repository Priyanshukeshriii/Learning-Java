package com.GUIinJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {



        public static Connection getDBConnection()
        {
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/";
            String user="root";
            String password="password";
            Connection con =null;
            try
            {
                Class.forName(driver);
                con =  DriverManager.getConnection(url,user,password);
            }
            catch(ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }

            return con;

        }


}
