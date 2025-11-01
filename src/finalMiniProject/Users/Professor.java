package finalMiniProject.Users;

import finalMiniProject.RoleMenu;
import finalMiniProject.dao.*;
import finalMiniProject.data.Course;
import finalMiniProject.services.UserServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Professor extends UserServices implements User , RoleMenu {
    Professor professor = null;

        private int professorId;
        private String name;
        private String email;
        private String password;
        private String department;

        public Professor(int professorId, String name, String email, String password, String department) {
            this.professorId = professorId;
            this.name = name;
            this.email = email;
            this.password = password;
            this.department = department;
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Professor{");
        sb.append("department='").append(department).append('\'');
        sb.append(", professorId=").append(professorId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getProfessorId() { return professorId; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getDepartment() { return department; }

        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) { this.email = email; }
        public void setPassword(String password) { this.password = password; }
        public void setDepartment(String department) { this.department = department; }

    @Override
    public void showMenu() {

    }

    @Override
    public Admin login(String email, String password) throws ClassNotFoundException, SQLException {

        String sql = "select * from professors where email = ? and password = ?";

        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs != null){
        professor = ProfessorDAO.get_Professor(email);
        }else {
        System.out.println("You have entered a wrong password or username");
        }


        return null;
    }

    @Override
    public void logout() {
        if(professor != null){
            professor = null;
        }
    }

    void viewCourse(int semester) throws SQLException, ClassNotFoundException {
        List<Course> courses = CourseDAO.getAll_Courses_By_Semester(semester);
    }

    void update_course(String course_code) throws SQLException, ClassNotFoundException {
        Course course = CourseDAO.get_Course(course_code);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which field you want to update:");
        System.out.println("(courseCode / courseTitle / credits / prerequisites / hours / professorId / semester)");
        String field = input.next();

        switch (field.toLowerCase()) {
            case "coursecode":
                System.out.print("Enter new course code: ");
                course.setCourseCode(input.next());
                break;

            case "coursetitle":
                System.out.print("Enter new course title: ");
                input.nextLine(); // consume leftover newline
                course.setCourseTitle(input.nextLine());
                break;

            case "credits":
                System.out.print("Enter new credits: ");
                course.setCredits(input.nextInt());
                break;

            case "prerequisites":
                System.out.print("Enter new prerequisites: ");
                input.nextLine(); // consume leftover newline
                course.setPrerequisites(input.nextLine());
                break;

            case "hours":
                System.out.print("Enter new hours: ");
                course.setHours(input.nextInt());
                break;

            case "professorid":
                System.out.print("Enter new professor ID: ");
                course.setProfessorId(input.nextInt());
                break;

            case "semester":
                System.out.print("Enter new semester: ");
                course.setSemester(input.nextInt());
                break;

            default:
                System.out.println("Invalid field name!");

        }
        boolean r = CourseDAO.update_Course(course);
        if (r == false) {
            System.out.println("Something went wrong!");
        }


    }

    void updateGrade(String Student_roll , String course_code,String grade) throws SQLException, ClassNotFoundException {
        RegisterCourseDAO.update_grade(Student_roll,grade,course_code);
    }



}


