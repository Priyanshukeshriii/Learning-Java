package finalMiniProject.dao;

import finalMiniProject.Users.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static boolean add_Student(Student student) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO students (roll_number ,name, email, password, current_semester, cgpa, total_credits) VALUES (?,?, ?, ?, ?, ?, ?)";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,student.getRollNumber());
        ps.setString(2,student.getSudentName());
        ps.setString(3,student.getEmail());
        ps.setString(4,student.getPassword());
        ps.setInt(5,student.getCurrentSemester());
        ps.setDouble(6,student.getCgpa());
        ps.setInt(7,student.getTotal_credit());
        int row_effected = ps.executeUpdate();
        if(row_effected > 0){
            DataBase.closeConnection(con);
            return true;
        }
        DataBase.closeConnection(con);
        return false;
    }


    public static Student get_Student(String roll_number) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM students where roll_number = ?";
        Connection con  = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,roll_number);
        ResultSet rs  = ps.executeQuery();
        if(rs.next()){
            String roll = rs.getString("roll_number");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            int current_semester = rs.getInt("current_semester");
            double cgpa = rs.getDouble("cgpa");
            int total_credits = rs.getInt("total_credits");
            DataBase.closeConnection(con);
            return new Student(cgpa , current_semester ,email,password,roll, name,total_credits);
        }
        DataBase.closeConnection(con);
        return null;
    }


    public static  List<Student> getAll_Student() throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String roll = rs.getString("roll_number");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            int current_semester = rs.getInt("current_semester");
            double cgpa = rs.getDouble("cgpa");
            int total_credits = rs.getInt("total_credits");

            students.add(new Student(cgpa, current_semester, email, password, roll, name, total_credits));
        }

        DataBase.closeConnection(con);
        return students;
    }

    public static boolean update_Student(Student o) {
        String sql = "UPDATE students SET name = ?, email = ?, password = ?, current_semester = ?, cgpa = ?, total_credits = ? WHERE roll_number = ?";
        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, o.getSudentName());
            ps.setString(2, o.getEmail());
            ps.setString(3, o.getPassword());
            ps.setInt(4, o.getCurrentSemester());
            ps.setDouble(5, o.getCgpa());
            ps.setInt(6, o.getTotal_credit());
            ps.setString(7, o.getRollNumber());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }



    public static boolean delete_Student(String roll_Number) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM students WHERE roll_number = ?";

        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, roll_Number);

        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }

}
