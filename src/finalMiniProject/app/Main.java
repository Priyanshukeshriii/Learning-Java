package finalMiniProject.app;

import finalMiniProject.Users.Student;
import finalMiniProject.dao.StudentDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student(9,3,"sk.priyanshu","pass","01","p",20);
        try {
            Student student = StudentDAO.get_Student("01");
            System.out.println(student);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
