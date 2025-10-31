package finalMiniProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class DataBase {
    private static String url = "jdbc:mysql://localhost:3306/finalminiproject";
    private static String user = "root";
    private static String password ="password";

    private DataBase(){};

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con= DriverManager.getConnection(url,user,password);

        return con;
    }
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
