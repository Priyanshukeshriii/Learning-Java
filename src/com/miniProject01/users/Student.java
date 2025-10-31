package com.miniProject01.users;

import com.miniProject01.DataBaseLoader;
import java.sql.*;
import java.util.Scanner;

public class Student implements User {

    static int rollNumber = 0;
    static String studentEmail = null;

    @Override
    public boolean login(String email, String password) {
        try {
            if (UserData.studentList == null) {
                System.out.println("Student data not loaded.");
                return false;
            }



            while (UserData.studentList.next()) {
                if (email.equals(UserData.studentList.getString("email")) &&
                        password.equals(UserData.studentList.getString("password"))) {

                    rollNumber = UserData.studentList.getInt("roll_number");
                    studentEmail = UserData.studentList.getString("email");
                    return true;
                }
            }

        } catch (SQLException e) {
            System.err.println("Login failed: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void viewMenu(Scanner scanner) {
        try {
            int choice;
            do {
                System.out.println("\n===== Student Menu =====");
                System.out.println("1. View Available Courses");
                System.out.println("2. Register for a Course");
                System.out.println("3. Drop a Course");
                System.out.println("4. View Schedule");
                System.out.println("5. Track Performance");
                System.out.println("6. Submit Complaint");
                System.out.println("0. Logout");
                System.out.print("Enter your choice: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    scanner.nextLine();
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> viewCourse();
                    case 2 -> {
                        System.out.print("Enter course name to register: ");
                        String courseName = scanner.nextLine();
                        registerCourse(courseName);
                    }
                    case 3 -> {
                        System.out.print("Enter course name to drop: ");
                        String courseName = scanner.nextLine();
                        if (dropCourse(courseName)) {
                            System.out.println("Course dropped successfully!");
                        } else {
                            System.out.println("Course not found or not registered.");
                        }
                    }
                    case 4 -> viewSchedule();
                    case 5 -> trackPerformance();
                    case 6 -> {
                        System.out.print("Enter complaint message: ");
                        String msg = scanner.nextLine();
                        submitComplain(studentEmail, msg);
                        System.out.println("Complaint submitted successfully!");
                    }
                    case 0 -> System.out.println("Logging out...");
                    default -> System.out.println("Invalid choice! Try again.");
                }

            } while (choice != 0);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }


    void viewCourse() throws SQLException {
        if (UserData.courseList == null) {
            System.out.println("No courses available.");
            return;
        }



        System.out.println("\n----- Available Courses -----");
        while (UserData.courseList.next()) {
            int courseId = UserData.courseList.getInt("course_id");
            String courseName = UserData.courseList.getString("course_name");
            String courseCode = UserData.courseList.getString("course_code");
            String instructor = UserData.courseList.getString("instructor_name");
            int credits = UserData.courseList.getInt("credits");
            String schedule = UserData.courseList.getString("schedule");

            System.out.println("Course ID: " + courseId);
            System.out.println("Course Name: " + courseName);
            System.out.println("Course Code: " + courseCode);
            System.out.println("Instructor: " + instructor);
            System.out.println("Credits: " + credits);
            System.out.println("Schedule: " + schedule);
            System.out.println("---------------------------");
        }
    }


    boolean registerCourse(String courseName) {
//        String query = "INSERT INTO  (roll_number, course_name) VALUES (?, ?)";
//
//        try (Connection con = DataBaseLoader.getConnection();
//             PreparedStatement ps = con.prepareStatement(query)) {
//
//            ps.setInt(1, rollNumber);
//            ps.setString(2, courseName);
//
//            int rows = ps.executeUpdate();
//            if (rows > 0) {
//                System.out.println(" Course '" + courseName + "' registered successfully!");
//                return true;
//            }
//
//        }
//        catch (SQLException | ClassNotFoundException e) {
//            System.err.println("Error registering course: " + e.getMessage());
//        }

        System.out.println("succesfully registor!");
        return true;
    }

    // ------------------- Drop a Course -------------------
    boolean dropCourse(String courseName) {
//        String query = "DELETE FROM student_courses WHERE roll_number = ? AND course_name = ?";
//
//        try (Connection con = DataBaseLoader.getConnection();
//             PreparedStatement ps = con.prepareStatement(query)) {
//
//            ps.setInt(1, rollNumber);
//            ps.setString(2, courseName);
//
//            int rows = ps.executeUpdate();
//            return rows > 0;
//
//        } catch (SQLException | ClassNotFoundException e) {
//            System.err.println("Error dropping course: " + e.getMessage());
//            return false;
//        }
        System.out.println("succesfully deleted!!");
        return true;
    }

    void viewSchedule() {
        try {
            if (UserData.schedule == null) {
                System.out.println("Schedule not loaded.");
                return;
            }

            System.out.println("\nSchedule Details:");
            System.out.println("-------------------------------------------------------------");

            while (UserData.schedule.next()) {
                String courseCode = UserData.schedule.getString("course_code");
                String day = UserData.schedule.getString("day");
                String startTime = UserData.schedule.getString("start_time");
                String endTime = UserData.schedule.getString("end_time");
                String instructor = UserData.schedule.getString("instructor_name");
                String room = UserData.schedule.getString("room_number");
                String section = UserData.schedule.getString("section");
                int credits = UserData.schedule.getInt("credits");
                String courseType = UserData.schedule.getString("course_type");
                int maxStudents = UserData.schedule.getInt("max_students");

                System.out.printf("Course: %s | Day: %s | Time: %s-%s | Instructor: %s | Room: %s | Section: %s | Credits: %d | Type: %s | Max Students: %d%n",
                        courseCode, day, startTime, endTime, instructor, room, section, credits, courseType, maxStudents);
            }

            System.out.println("-------------------------------------------------------------");
        } catch (SQLException e) {
            System.err.println("Error reading schedule data: " + e.getMessage());
        }
    }


    void trackPerformance() {
        try {
            if (UserData.studentList == null) {
                System.out.println("Student data not available.");
                return;
            }



            while (UserData.studentList.next()) {
                if (rollNumber == UserData.studentList.getInt("roll_number")) {
                    System.out.println("CGPA: " + UserData.studentList.getDouble("cgpa"));
                    break;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error tracking performance: " + e.getMessage());
        }
    }


    void submitComplain(String email, String msg) {
        String query = "INSERT INTO complaints (student_email, description, status, resolution) VALUES (?, ?, 'Pending', NULL)";

        try (Connection con = DataBaseLoader.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, email);
            ps.setString(2, msg);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error submitting complaint: " + e.getMessage());
        }
    }
}
