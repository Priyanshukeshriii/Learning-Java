package JDBC.firstdatabase;
import java.sql.*;

public class ConnectToMysql {
    private static final String url ="jdbc:mysql://localhost:3306/gsv" ;
    private static final String username = "root";
    private static final String password = "password";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            //update the database
            String query2 = String.format("update students SET NAME = '%s' where id = %d" , "sakshi",4);
            int rowsAffected1 = statement.executeUpdate(query2);
            if(rowsAffected1 > 0){
                System.out.println("Data updated Successfully!");
            }else{
                System.out.println("Data not updated!");
            }
            //this statement is to update the database
//            String query = String.format("insert into students(name ) values ('%s')","ujjwal");
//            int rowAffected = statement.executeUpdate(query);
//            if(rowAffected > 0){
//                System.out.println("Data inserted Successfully!");
//            }else{
//                System.out.println("Data not Inserted!");
//            }
//            this is to take data from the data base

            String query1 = "select * from students";
            ResultSet resultSet = statement.executeQuery(query1);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("NAME");
                System.out.println("ID :"+id +" name :"+name);
            }
//            this statement is to delete the row from database
            String query3 = "delete from students where id = 6 ";
            int rowAffected2  = statement.executeUpdate(query3);
            if(rowAffected2 > 0){
                System.out.println("Data deleted Successfully!");
            }else{
                System.out.println("Data not deleted!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
