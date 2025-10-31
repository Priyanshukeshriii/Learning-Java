package com.miniProject01.users;

import com.miniProject01.DataBaseLoader;

import java.sql.*;
import java.util.Scanner;

public class Administrator implements User {
    @Override
    public boolean login(String email, String password) {
        String pass = "admin@123";
        if(pass.equals(password)){
            return true;

        }
        return false;
    }

    @Override
    public void viewMenu(Scanner scanner) {
        int choice = -1;

        do {
            try {
                System.out.println("\n=====  ADMINISTRATOR MENU =====");
                System.out.println("1  Add Student");
                System.out.println("2  Add Professor");
                System.out.println("3  View All Students");
                System.out.println("4  View Student Details");
                System.out.println("5  View Schedule");
                System.out.println("6  Update Schedule Section");
                System.out.println("7  View Courses");
                System.out.println("8  Update Course");
                System.out.println("9  Resolve Complaint");
                System.out.println("10  Update Student CGPA");
                System.out.println("11 View Complaints");
                System.out.println("0  Logout");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Student Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter CGPA: ");
                        double cgpa = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phone = scanner.nextLine();
                        System.out.println("Enter the Student Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the Roll Number: ");
                        int roll = scanner.nextInt();
                        addStudent(email, password, cgpa, phone, name,roll);
                    }

                    case 2 -> {

                        addProfessor();
                    }

                    case 3 -> viewAllstudent();

                    case 4 -> {
                        System.out.print("Enter Roll Number to View: ");
                        int roll = scanner.nextInt();
                        scanner.nextLine();
                        viewStudentDetails(roll);
                    }

                    case 5 -> viewSchedule();

                    case 6 -> {
                        System.out.print("Enter Course Code: ");
                        String courseCode = scanner.nextLine();
                        System.out.print("Enter Section: ");
                        String section = scanner.nextLine();
                        System.out.print("Enter New Day: ");
                        String day = scanner.nextLine();
                        System.out.print("Enter New Start Time: ");
                        String startTime = scanner.nextLine();
                        System.out.print("Enter New End Time: ");
                        String endTime = scanner.nextLine();
                        System.out.print("Enter New Instructor: ");
                        String instructor = scanner.nextLine();
                        System.out.print("Enter New Room: ");
                        String room = scanner.nextLine();
                        System.out.print("Enter New Credits: ");
                        int credits = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Course Type: ");
                        String courseType = scanner.nextLine();
                        System.out.print("Enter Max Students: ");
                        int maxStudents = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Is Active (true/false): ");
                        boolean isActive = scanner.nextBoolean();
                        scanner.nextLine();

                        updateScheduleSection(courseCode, section, day, startTime, endTime, instructor, room, credits, courseType, maxStudents, isActive);
                    }

                    case 7 -> viewCourse();

                    case 8 -> updateCourse(scanner);

                    case 9 -> {
                        System.out.print("Enter Complaint ID: ");
                        int complaintId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Resolution Message: ");
                        String resolution = scanner.nextLine();
                        resolveComplain(complaintId, resolution);
                    }

                    case 10 -> {
                        System.out.print("Enter Roll Number: ");
                        int roll = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New CGPA: ");
                        double newCgpa = scanner.nextDouble();
                        scanner.nextLine();
                        updeteCGPA(roll,newCgpa);
                    }
                    case 11 -> {
                        viewComplaint();
                    }

                    case 0 -> System.out.println("Logging out...");

                    default -> System.out.println("Invalid choice, please try again!");
                }

            } catch (SQLException  e) {
                System.err.println("Error executing menu action: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
                scanner.nextLine();
            }

        } while (choice != 0);
    }


    void addStudent(String email, String password, double cgpa, String phoneNumber,String name,int roll_number) {
        String query = "INSERT INTO student (roll_number,name, email,password,cgpa,phone_number) VALUES (?, ?, ?, ?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject01","root","password");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, roll_number);
            pstmt.setString(2, name);
            pstmt.setDouble(5, cgpa);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setString(6, phoneNumber);


            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!");
            } else {
                System.out.println("Failed to add student.");
            }

        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
            e.printStackTrace();
        }
    }



    void viewSchedule() {
        try {
            System.out.println("Schedule Details:");
            System.out.println("-------------------------------------------------------------");

            UserData.schedule.beforeFirst();
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
    boolean updateScheduleSection(String courseCode, String section,
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
                System.out.println("Schedule updated successfully for " + courseCode + " - Section " + section);
                return true;
            } else {
                System.out.println("No matching course found for " + courseCode + " - Section " + section);
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Error updating schedule: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    void viewCourse() throws SQLException {

        UserData.courseList.beforeFirst();
        if (UserData.courseList == null) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("----- Available Courses -----");
        UserData.courseList.beforeFirst();

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
    public boolean updateCourse(Scanner scanner) {
        System.out.print("\nEnter the Course ID to update: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Enter new Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter new Course Code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter new Credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Schedule: ");
        String schedule = scanner.nextLine();

        System.out.print("Enter new Instructor Name: ");
        String instructor = scanner.nextLine();

        String query = """
                UPDATE course
                SET course_name = ?, course_code = ?, credits = ?, schedule = ?, instructor_name = ?
                WHERE course_id = ?;
                """;

        try (PreparedStatement pstmt =DataBaseLoader.getConnection().prepareStatement(query)) {
            pstmt.setString(1, courseName);
            pstmt.setString(2, courseCode);
            pstmt.setInt(3, credits);
            pstmt.setString(4, schedule);
            pstmt.setString(5, instructor);
            pstmt.setInt(6, courseId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Course updated successfully!");
                return true;
            } else {
                System.out.println("No course found with ID: " + courseId);
                return false;
            }

        } catch (SQLException | ClassNotFoundException e ) {
            System.out.println("Error updating course: " + e.getMessage());
            return false;
        }
    }
    void resolveComplain(int complaintId, String resolutionMessage) {
        String query = "UPDATE complaints SET status = 'Resolved', resolution = ? WHERE id = ?";

        try (Connection conn = DataBaseLoader.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, resolutionMessage);
            pstmt.setInt(2, complaintId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Complaint ID " + complaintId + " marked as resolved successfully!");
            } else {
                System.out.println("No complaint found with ID " + complaintId);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error resolving complaint: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void updeteCGPA(int rollNummber,double cgpa) throws SQLException {
        UserData.studentList.beforeFirst();
        while (UserData.studentList.next()){
            if(rollNummber == UserData.studentList.getInt("roll_number")){
                String query = "update student set cgpa "+cgpa;
                Statement st = DataBaseLoader.getStatment();
                st.executeUpdate(query);
            }
            else {
                System.out.println("Roll number not found!!");
            }
        }

   }

    void viewStudentDetails(int rollNumber) {
        try {
            UserData.studentList.beforeFirst();
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
            UserData.studentList.beforeFirst();
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

    void addProfessor() {


        String insertSQL = "INSERT INTO professors (name, email, password, course, course_code, credits, total_hours) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
             PreparedStatement pstmt = DataBaseLoader.getConnection().prepareStatement(insertSQL);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Professor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            System.out.print("Enter Course Name: ");
            String course = sc.nextLine();

            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();

            System.out.print("Enter Credits: ");
            int credits = sc.nextInt();

            System.out.print("Enter Total Hours: ");
            int totalHours = sc.nextInt();

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, pass);
            pstmt.setString(4, course);
            pstmt.setString(5, courseCode);
            pstmt.setInt(6, credits);
            pstmt.setInt(7, totalHours);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Professor added successfully!");
            } else {
                System.out.println("Failed to add professor.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void viewComplaint() throws SQLException, ClassNotFoundException {
        ResultSet rs = DataBaseLoader.loadComplain();
        while (rs.next()){
            System.out.println("id "+ rs.getInt("id"));
            System.out.println(" Student email "+ rs.getString("student_email"));
            System.out.println(" description "+ rs.getString("description"));
            System.out.println(" status "+ rs.getString("status"));
            System.out.println(" resolution "+ rs.getString("resolution"));

        }
    }

}
