package JDBC.firstdatabase;

import java.sql.*;

abstract class jdbcnew
{
    public static void main(String[] args) {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/gsv";
    String user = "root";
    String password ="password";
    Connection con = null;
    Statement stmt = null;
    ResultSet resultSet = null;

//    String query = "create table gsvstudent(sno int , sname varchar(40) , branch varchar(30))";
    String query1 = "insert into gsvstudent values(2,'priyanshu', 'AI' )";
    try
    {
        Class.forName(driver);
        con = DriverManager.getConnection(url,user,password);
        stmt = con.createStatement();
//        stmt.execute(query);
        stmt.executeUpdate(query1);

    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }
    catch (SQLException e ){
        e.printStackTrace();
    }
    finally {
        try{
                if(stmt != null){
                    stmt.close();
                    stmt = null;
                }
            }catch (SQLException e ){
                e.printStackTrace();
            }
            try{
                if(con != null){
                    con.close();
                    con = null;
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
    }
}
