package finalMiniProject.dao;

import finalMiniProject.data.RegisterCourse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterCourseDAO {

    // Add new registration
    public static boolean add(RegisterCourse rc) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO registerCourse (student_id, course_id, semester, grade) VALUES (?, ?, ?, ?)";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, rc.getStudentId());
        ps.setInt(2, rc.getCourseId());
        ps.setInt(3, rc.getSemester());
        ps.setString(4, rc.getGrade());
        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }

    // Delete all registrations by student_id
    public static boolean deleteCourse(String roll_number , String course_code) throws SQLException, ClassNotFoundException {
        String sql3 = "DELETE FROM registerCourse WHERE student_id = ? and course_id = ?";
        String sql = "select * from courses where course_code = ?";
        String sql1 = "select * from students where roll_number = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps1  = con.prepareStatement(sql1);
        PreparedStatement ps2  = con.prepareStatement(sql3);
        ps.setString(1,course_code);
        ps1.setString(1,roll_number);
        ResultSet rs  = ps.executeQuery();
        ResultSet rs1 = ps1.executeQuery();
        ps2.setInt(1, rs1.getInt("student_id"));
        ps2.setInt(2,rs.getInt("course_id"));
        int rows = ps2.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }

    // Update grade or semester for a registration
    public static boolean update(RegisterCourse rc) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE registerCourse SET semester = ?, grade = ? WHERE enrollment_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, rc.getSemester());
        ps.setString(2, rc.getGrade());
        ps.setInt(3, rc.getEnrollmentId());
        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }


    public static List<RegisterCourse> getCoursesByStudentId(int studentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM registerCourse WHERE student_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, studentId);
        ResultSet rs = ps.executeQuery();

        List<RegisterCourse> list = new ArrayList<>();
        while (rs.next()) {
            int enrollmentId = rs.getInt("enrollment_id");
            int courseId = rs.getInt("course_id");
            int semester = rs.getInt("semester");
            String grade = rs.getString("grade");
            list.add(new RegisterCourse(enrollmentId, studentId, courseId, semester, grade));
        }

        DataBase.closeConnection(con);
        return list;
    }
}

