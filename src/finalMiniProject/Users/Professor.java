package finalMiniProject.Users;

import finalMiniProject.RoleMenu;
import finalMiniProject.dao.CourseDAO;
import finalMiniProject.dao.DataBase;
import finalMiniProject.dao.ProfessorDAO;
import finalMiniProject.dao.StudentDAO;
import finalMiniProject.data.Course;
import finalMiniProject.services.UserServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    public void login(String email, String password) throws ClassNotFoundException, SQLException {

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
}


