package finalMiniProject.dao;



import finalMiniProject.data.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {


    public static boolean add_Course(Course course) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO courses (course_code, course_title, credits, prerequisites, hours, professor_id, semester) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, course.getCourseCode());
        ps.setString(2, course.getCourseTitle());
        ps.setInt(3, course.getCredits());
        ps.setString(4, course.getPrerequisites());
        ps.setInt(5, course.getHours());
        ps.setInt(6, course.getProfessorId());
        ps.setInt(7, course.getSemester());

        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }


    public static Course get_Course_By_Id(int courseId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, courseId);
        ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_code"),
                        rs.getString("course_title"),
                        rs.getInt("credits"),
                        rs.getString("prerequisites"),
                        rs.getInt("hours"),
                        rs.getInt("professor_id"),
                        rs.getInt("semester")
                );
                DataBase.closeConnection(con);
                return course;
            }
            DataBase.closeConnection(con);
            return null;
        }


        public static List<Course> getAll_Courses_By_Semester(int semester) throws SQLException, ClassNotFoundException {
            List<Course> courses = new ArrayList<>();
            String sql = "SELECT * FROM courses WHERE semester = ?";
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, semester);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_code"),
                        rs.getString("course_title"),
                        rs.getInt("credits"),
                        rs.getString("prerequisites"),
                        rs.getInt("hours"),
                        rs.getInt("professor_id"),
                        rs.getInt("semester")
                ));
            }

            DataBase.closeConnection(con);
            return courses;
        }


        public static boolean update_Course(Course course) throws SQLException, ClassNotFoundException {
            String sql = "UPDATE courses SET course_code = ?, course_title = ?, credits = ?, prerequisites = ?, hours = ?, professor_id = ?, semester = ? WHERE course_id = ?";
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, course.getCourseCode());
            ps.setString(2, course.getCourseTitle());
            ps.setInt(3, course.getCredits());
            ps.setString(4, course.getPrerequisites());
            ps.setInt(5, course.getHours());
            ps.setInt(6, course.getProfessorId());
            ps.setInt(7, course.getSemester());
            ps.setInt(8, course.getCourseId());

            int rows = ps.executeUpdate();
            DataBase.closeConnection(con);
            return rows > 0;
        }


        public static boolean delete_Course(int courseId) throws SQLException, ClassNotFoundException {
            String sql = "DELETE FROM courses WHERE course_id = ?";
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            int rows = ps.executeUpdate();
            DataBase.closeConnection(con);
            return rows > 0;
        }


        public static List<Course> getAll_Courses() throws SQLException, ClassNotFoundException {
            List<Course> courses = new ArrayList<>();
            String sql = "SELECT * FROM courses";
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_code"),
                        rs.getString("course_title"),
                        rs.getInt("credits"),
                        rs.getString("prerequisites"),
                        rs.getInt("hours"),
                        rs.getInt("professor_id"),
                        rs.getInt("semester")
                ));
            }

            DataBase.closeConnection(con);
            return courses;
        }
}


