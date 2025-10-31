package JDBC.firstdatabase;

import com.miniproject.Student.StudentInterface;

import java.sql.*;

public class demo {

    final static String user = "root";
    final static String password = "password";
    final static String url = "jdbc:mysql://localhost:3306/gsv";
    final static String driver = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        String query0 = "create table studentmarks(id int ,name varchar(30) , marks1 int, marks2 int , marks3 int );";
        String query = "insert into studentmarks(id  , name , marks1  , marks2  , marks3 ) values(1, 'priyanshu', 90,90,90);";
        String query1 = "INSERT INTO studentmarks (id, name, marks1, marks2, marks3) VALUES (1, 'Rupam', 85, 90, 80);";
        String query2 = "INSERT INTO studentmarks(id, name, marks1, marks2, marks3) VALUES (1, 'ujjwal', 85, 90, 80);";
        String query3 = "INSERT INTO studentmarks (id, name, marks1, marks2, marks3) VALUES (1, 'riya', 85, 90, 80);";
        String query4 = "select * from studentmarks";
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, user , password);
            Statement st = con.createStatement();
//            st.executeUpdate(query0);
//             st.executeUpdate(query);
//             st.executeUpdate(query1);
//             st.executeUpdate(query2);
//             st.executeUpdate(query3);

            ResultSet resultSet = st.executeQuery(query4);
            while (resultSet.next()){
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" name: "+resultSet.getString("name"));
                System.out.print(" marks1: "+resultSet.getInt("marks1"));
                System.out.print(" marks2: "+resultSet.getInt("marks2"));
                System.out.print(" marks3: "+resultSet.getInt("marks3"));
                System.out.println();
            }
            System.out.println("done");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        int a =10;
        String s = String.valueOf(a);
        Integer i = a;
        String s1= i.toString().intern();
    }
}
