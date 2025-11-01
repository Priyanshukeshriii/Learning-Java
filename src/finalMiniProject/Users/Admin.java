package finalMiniProject.Users;

import finalMiniProject.RoleMenu;
import finalMiniProject.dao.CourseDAO;
import finalMiniProject.dao.ProfessorDAO;
import finalMiniProject.dao.StudentDAO;
import finalMiniProject.data.*;
import java.util.Scanner;

import java.sql.SQLException;

public class Admin implements User , RoleMenu {
    @Override
    public void showMenu() {

    }

    @Override
    public Admin login(String email, String password) throws SQLException, ClassNotFoundException {

        return null;
    }

    @Override
    public void logout() {

    }

    void update_student(String roll_number) throws SQLException, ClassNotFoundException {
        Student student = StudentDAO.get_Student(roll_number);
        if (student == null) {
            System.out.println("Student not found with roll number: " + roll_number);
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter which field you want to update:");
        System.out.println("(roll_number / name / email / password / current_semester / cgpa / total_credits)");
        String field = input.next();

        switch (field.toLowerCase()) {

            case "roll_number":
                System.out.print("Enter new roll number: ");
                student.setRollNumber(input.next());
                break;

            case "name":
                System.out.print("Enter new name: ");
                input.nextLine(); // clear leftover newline
                student.setSudentName(input.nextLine());
                break;

            case "email":
                System.out.print("Enter new email: ");
                student.setEmail(input.next());
                break;

            case "password":
                System.out.print("Enter new password: ");
                student.setPassword(input.next());
                break;

            case "current_semester":
                System.out.print("Enter new current semester: ");
                student.setCurrentSemester(input.nextInt());
                break;

            case "cgpa":
                System.out.print("Enter new CGPA: ");
                student.setCgpa(input.nextDouble());
                break;

            case "total_credits":
                System.out.print("Enter new total credits: ");
                student.setTotal_credit(input.nextInt());
                break;

            default:
                System.out.println("Invalid field name!");
                return;
        }

        boolean r = StudentDAO.update_Student(student);
        if (r) {
            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Something went wrong while updating student data!");
        }
    }

    void update_professor(String email) throws SQLException, ClassNotFoundException {
        Professor professor = ProfessorDAO.get_Professor(email);
        if (professor == null) {
            System.out.println("No professor found with the given email!");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter which field you want to update:");
        System.out.println("(name / email / password / department)");
        String field = input.next();

        switch (field.toLowerCase()) {
            case "name":
                System.out.print("Enter new name: ");
                input.nextLine(); // consume leftover newline
                professor.setName(input.nextLine());
                break;

            case "email":
                System.out.print("Enter new email: ");
                professor.setEmail(input.next());
                break;

            case "password":
                System.out.print("Enter new password: ");
                professor.setPassword(input.next());
                break;

            case "department":
                System.out.print("Enter new department: ");
                input.nextLine(); // consume leftover newline
                professor.setDepartment(input.nextLine());
                break;

            default:
                System.out.println("Invalid field name!");
                return;
        }

        boolean result = ProfessorDAO.update_Professor(professor);
        if (!result) {
            System.out.println("Something went wrong while updating professor!");
        } else {
            System.out.println("Professor updated successfully!");
        }
    }

    void update_course(String courseCode) throws SQLException, ClassNotFoundException {
        Course course = CourseDAO.get_Course(courseCode);
        if (course == null) {
            System.out.println("No course found with the given course code!");
            return;
        }

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
                return;
        }

        boolean result = CourseDAO.update_Course(course);
        if (!result) {
            System.out.println("Something went wrong while updating course!");
        } else {
            System.out.println("Course updated successfully!");
        }
    }


}
