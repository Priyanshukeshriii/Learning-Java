package finalMiniProject.Users;

import finalMiniProject.RoleMenu;
import finalMiniProject.dao.*;
import finalMiniProject.data.Complaint;
import finalMiniProject.data.Course;
import finalMiniProject.data.RegisterCourse;
import finalMiniProject.services.StudentServices;
import finalMiniProject.services.UserServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student extends UserServices implements RoleMenu ,User{

    String sudentName;
    String rollNumber;
    String email;
    String password;
    int currentSemester;
    double cgpa;
    int total_credit;
    public Student student = null;

    public Student(double cgpa, int currentSemester, String email, String password, String rollNumber, String sudentName, int total_credit) {
        this.cgpa = cgpa;
        this.currentSemester = currentSemester;
        this.email = email;
        this.password = password;
        this.rollNumber = rollNumber;
        this.sudentName = sudentName;
        this.total_credit = total_credit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("cgpa=").append(cgpa);
        sb.append(", sudentName='").append(sudentName).append('\'');
        sb.append(", rollNumber='").append(rollNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", currentSemester=").append(currentSemester);
        sb.append(", total_credit=").append(total_credit);
        sb.append('}');
        return sb.toString();
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSudentName() {
        return sudentName;
    }

    public void setSudentName(String sudentName) {
        this.sudentName = sudentName;
    }

    public int getTotal_credit() {
        return total_credit;
    }

    public void setTotal_credit(int total_credit) {
        this.total_credit = total_credit;
    }

    @Override
    public void showMenu() {

    }

    @Override
    public void login(String email, String password) {
        String sql = "select * from students where email = ? and password = ?";
        try {
            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                student = StudentDAO.get_Student(rs.getString("roll_number"));
            }else {
                System.out.println("You have entered a wrong password or username");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void logout() {
        if(student != null){
            student = null;
        }
    }


    boolean registerCourse(String courseCode,String rollNumber,int semester, String msg) throws SQLException, ClassNotFoundException {
        String sql = "select * from courses where course_code = ?";
        String sql1 = "select * from students where roll_number = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps1  = con.prepareStatement(sql1);
        ps.setString(1,courseCode);
        ps1.setString(1,rollNumber);
        ResultSet rs  = ps.executeQuery();
        ResultSet rs1 = ps1.executeQuery();
        if(rs != null &&  rs.getInt("semester") == semester){
            RegisterCourse registerCourse = new RegisterCourse(-1,rs1.getInt("student_id"), rs.getInt("course_id"),semester,null);
            boolean result = RegisterCourseDAO.add(registerCourse);
            if(result == false){
                System.out.println("Something went wrong!");
                return false;
            }
            return true;
        }
        return false;
    }

    boolean dropCourse( String course_code) throws SQLException, ClassNotFoundException {
        boolean result = RegisterCourseDAO.deleteCourse(this.rollNumber,course_code);
        if(result == false){
            System.out.println("Something went wrong!");
            return false;
        }
        return true;
    }
    void fileComplaint( String msg ) throws SQLException, ClassNotFoundException {
        String sql1 = "select * from students where roll_number = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql1);
        ps.setString(1,this.rollNumber);
        ResultSet rs = ps.executeQuery();
        Complaint complaint = new Complaint(-1,rs.getInt("student_id" ),msg,"Pending",null);
        boolean result = ComplaintDAO.add(complaint);
        if(result == false){
            System.out.println("Somthing went wrong!");
        }

    }

    void  viewComplaints() throws SQLException, ClassNotFoundException {
        List<Complaint> complaintList = ComplaintDAO.getByRollNumber(this.rollNumber);
        if(complaintList == null){
            System.out.println("something went wrong!");
        }else {
            System.out.println(complaintList);
        }
    }
    void viewCourse(int semester) throws SQLException, ClassNotFoundException {
        List<Course> courses = CourseDAO.getAll_Courses_By_Semester(semester);
    }
    void viewCourse() throws SQLException, ClassNotFoundException {
        List<Course> courses = CourseDAO.getAll_Courses_By_Semester(this.currentSemester);
    }
    void viewGrades(String course_code) throws SQLException, ClassNotFoundException {
        String sql = "select * from students where roll_number = ?";
        String sql1 = "select * from courses where course_code = ?";
        Connection con  = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps.setString(1,this.rollNumber);
        ps1.setString(1,course_code);
        ResultSet rs = ps.executeQuery();
        ResultSet rs1 = ps1.executeQuery();
        String sql2 = "select * form registercourse where student_id = ? and course_id = ?";
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, rs.getInt("student_id"));
        ps2.setInt(2,rs1.getInt("course_id"));
        ResultSet rs2 =ps2.executeQuery();
        List<RegisterCourse> list = new ArrayList<>();
        while (rs2.next()) {
            int studentId = rs2.getInt("student_id");
            int enrollmentId = rs2.getInt("enrollment_id");
            int courseId = rs2.getInt("course_id");
            int semester = rs2.getInt("semester");
            String grade = rs2.getString("grade");
            list.add(new RegisterCourse(enrollmentId, studentId, courseId, semester, grade));
        }
        System.out.println(list);
    }

}
