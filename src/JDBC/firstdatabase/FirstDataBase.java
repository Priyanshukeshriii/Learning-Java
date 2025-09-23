//package JDBC.firstdatabase;
//
//import java.sql.*;
//
//
//
//public class FirstDataBase {
//    public static void main(String[] args) {
//    String driver = "com.msql.jdbc.Driver";
//    String URL = "jdbc:mysql://localhost:3306/gsv";
//    String user = "root";
//    String password = "root";
//    Connection con = null;
//    Statement stmt = null;
//    ResultSet rs = null;
//    String query1 = "insert into student(1 , priyanshu)";
//        try{
//            //Register the driver
//            try {
//                Class.forName(driver);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            //establish connection b/w java program and java.sql.*
//            try {
//                con = DriverManager.getConnection(URL, user, password);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //transfer query
//            try {
//                stmt = con.createStatement();
//                stmt.execute("create table student(sno int , sname varchar(30))");
//                rs = stmt.executeUpdate(query1);
//                String sname =
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }finally {
//            try{
//                if(stmt != null){
//                    stmt.close();
//                    stmt = null;
//                }
//            }catch (SQLException e ){
//                e.printStackTrace();
//            }
//            try{
//                if(con != null){
//                    con.close();
//                    con = null;
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
