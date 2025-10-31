package com.miniProject01.users;

import com.miniProject01.DataBaseLoader;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Professor implements User {
    @Override
    public boolean login(String email, String password) {
        try{
            while (UserData.professor.next()){
                if (email.equals(UserData.professor.getString("email")) && password.equals(UserData.professor.getString("password")));
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void viewMenu(Scanner scanner) {
        int choice = -1;

        try {
            do {
                System.out.println("\n===== Professor Menu =====");
                System.out.println("1. View Schedule");
                System.out.println("2. Update Schedule");
                System.out.println("3. View Student Details by Roll Number");
                System.out.println("4. View All Students");
                System.out.println("5. View Course");
                System.out.println("0. Logout");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        viewSchedule();
                        break;

                    case 2:
                        System.out.print("Enter Course Code: ");
                        String courseCode = scanner.nextLine();

                        System.out.print("Enter Section to Update: ");
                        String section = scanner.nextLine();

                        System.out.print("Enter New Day: ");
                        String newDay = scanner.nextLine();

                        System.out.print("Enter New Start Time (HH:MM): ");
                        String newStartTime = scanner.nextLine();

                        System.out.print("Enter New End Time (HH:MM): ");
                        String newEndTime = scanner.nextLine();

                        System.out.print("Enter New Instructor Name: ");
                        String newInstructor = scanner.nextLine();

                        System.out.print("Enter New Room Number: ");
                        String newRoom = scanner.nextLine();

                        System.out.print("Enter New Credits: ");
                        int newCredits = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter New Course Type (CORE/ELECTIVE): ");
                        String newCourseType = scanner.nextLine();

                        System.out.print("Enter Max Students: ");
                        int newMaxStudents = Integer.parseInt(scanner.nextLine());

                        System.out.print("Is Active? (true/false): ");
                        boolean isActive = Boolean.parseBoolean(scanner.nextLine());

                        updateSchedule(courseCode, section, newDay, newStartTime, newEndTime,
                                newInstructor, newRoom, newCredits, newCourseType, newMaxStudents, isActive);
                        break;

                    case 3:
                        System.out.print("Enter Student Roll Number: ");
                        int rollNumber = Integer.parseInt(scanner.nextLine());
                        viewStudentDetails(rollNumber);
                        break;

                    case 4:
                        viewAllstudent();
                        break;
                    case 5:
                        viewCourse();
                        break;
                    case 0:
                        System.out.println("Logging out...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } while (choice != 0);
        } catch (Exception e) {
            System.err.println("Error in menu: " + e.getMessage());
            e.printStackTrace();
        }
    }



    void viewSchedule() {
        try {
            UserData.schedule.beforeFirst();
            System.out.println("📋 Schedule Details:");
            System.out.println("-------------------------------------------------------------");

            // Iterate over the ResultSet
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
            e.printStackTrace();
        }
    }
    boolean updateSchedule(String courseCode, String section,
                                  String newDay, String newStartTime, String newEndTime,
                                  String newInstructor, String newRoom, int newCredits,
                                  String newCourseType, int newMaxStudents, boolean isActive) {
        try {
            // Update the row for the specific course and section
            String query = "UPDATE schedule SET " +
                    "day = '" + newDay + "', " +
                    "start_time = '" + newStartTime + "', " +
                    "end_time = '" + newEndTime + "', " +
                    "instructor_name = '" + newInstructor + "', " +
                    "room_number = '" + newRoom + "', " +
                    "credits = " + newCredits + ", " +
                    "course_type = '" + newCourseType + "', " +
                    "max_students = " + newMaxStudents + ", " +
                    "is_active = " + isActive + " " +
                    "WHERE course_code = '" + courseCode + "' AND section = '" + section + "'";

            Statement st = DataBaseLoader.getStatment();
            int updatedRows = st.executeUpdate(query);

            if (updatedRows > 0) {
                System.out.println(" Schedule updated successfully for " + courseCode + " - Section " + section);
                return true;
            } else {
                System.out.println(" No matching course found for " + courseCode + " - Section " + section);
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Error updating schedule: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }




    void viewStudentDetails(int rollNumber) {
        try {

            while (UserData.studentList.next()) {
                if (rollNumber == UserData.studentList.getInt("roll_number")) {
                    System.out.println("----- Student Details -----");
                    System.out.println("Roll Number: " + UserData.studentList.getInt("roll_number"));
                    System.out.println("Name: " + UserData.studentList.getString("name"));
                    System.out.println("Email: " + UserData.studentList.getString("email"));
                    System.out.println("CGPA: " + UserData.studentList.getDouble("cgpa"));
                    System.out.println("----------------------------");
                    return;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching student details: " + e.getMessage());
        }
    }
    void viewAllstudent(){
        try {

            while (UserData.studentList.next()) {

                    System.out.println("----- Student Details -----");
                    System.out.println("Roll Number: " + UserData.studentList.getInt("roll_number"));
                    System.out.println("Name: " + UserData.studentList.getString("name"));
                    System.out.println("Email: " + UserData.studentList.getString("email"));
                    System.out.println("CGPA: " + UserData.studentList.getDouble("cgpa"));
                    System.out.println("----------------------------");
                    return;
                }


        } catch (SQLException e) {
            System.err.println("Error fetching student details: " + e.getMessage());
        }
    }

    void viewCourse() throws SQLException {


        if (UserData.courseList == null) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("----- Available Courses -----");


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

}
