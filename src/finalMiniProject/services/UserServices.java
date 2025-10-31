package finalMiniProject.services;

import finalMiniProject.Users.Professor;
import finalMiniProject.Users.Student;
import finalMiniProject.dao.CourseDAO;
import finalMiniProject.dao.ProfessorDAO;
import finalMiniProject.dao.StudentDAO;
import finalMiniProject.data.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {
    public void viewProfile(Student o){
        try {
            Student s = StudentDAO.get_Student(o.getRollNumber());
            assert s != null;//if it becomes false then throws an exception
            System.out.println(s);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
//    protected void viewProfile(Professor o){
//        try {
//            Professor p = ProfessorDAO.get_Professor(o.getEmail());
//            assert p != null;//if it becomes false then throws an exception
//            System.out.println(p);
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public boolean updateProfile(Student s){
        boolean bool = StudentDAO.update_Student(s);
        return bool;
    }
    public boolean updateProfile(Professor p){
        boolean bool = ProfessorDAO.update_Professor(p);
        return bool;
    }
    public void viewAvailableCourse(int semester){
        List<Course> allCourses = new ArrayList<>();
        try {
           allCourses = CourseDAO.getAll_Courses_By_Semester(semester);
            System.out.println(allCourses);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewAvailableCourse(){
        List<Course> allCourses = new ArrayList<>();
        try {
            allCourses = CourseDAO.getAll_Courses();
            System.out.println(allCourses);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
