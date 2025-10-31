package com.miniProject01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ScheduleDatabase {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/miniproject01";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        // Enhanced schedule data
        String[][] enhancedScheduleData = {
                {"MATH101", "Mon", "10:00", "11:30", "Dr. Anil Sharma", "Room-101", "A", "4", "CORE", "60"},
                {"MATH101", "Wed", "10:00", "11:30", "Dr. Anil Sharma", "Room-101", "A", "4", "CORE", "60"},
                {"CS102", "Tue", "09:00", "10:30", "Dr. Priya Gupta", "Lab-201", "B", "4", "CORE", "40"},
                {"CS102", "Thu", "09:00", "10:30", "Dr. Priya Gupta", "Lab-201", "B", "4", "CORE", "40"},
                {"ECE201", "Mon", "12:00", "13:30", "Dr. Rajesh Kumar", "Room-105", "C", "2", "ELECTIVE", "30"},
                {"ECE201", "Wed", "12:00", "13:30", "Dr. Rajesh Kumar", "Room-105", "C", "2", "ELECTIVE", "30"},
                {"CS202", "Tue", "11:00", "12:30", "Dr. Meena Patel", "Lab-205", "A", "4", "CORE", "50"},
                {"CS202", "Thu", "11:00", "12:30", "Dr. Meena Patel", "Lab-205", "A", "4", "CORE", "50"},
                {"CHEM301", "Fri", "10:00", "11:30", "Dr. Sanjay Verma", "Room-110", "B", "2", "ELECTIVE", "35"},
                {"CS302", "Mon", "14:00", "15:30", "Dr. Anjali Nair", "Lab-210", "A", "4", "CORE", "45"}
        };

        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS schedule (
                    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
                    course_code VARCHAR(20) NOT NULL,
                    day VARCHAR(20),
                    start_time VARCHAR(10),
                    end_time VARCHAR(10),
                    instructor_name VARCHAR(100),
                    room_number VARCHAR(20),
                    section VARCHAR(10),
                    credits INT,
                    course_type VARCHAR(20),
                    max_students INT,
                    current_enrollment INT DEFAULT 0,
                    is_active BOOLEAN DEFAULT TRUE
                );
                """;

        String insertSQL = """
                INSERT INTO schedule (course_code, day, start_time, end_time, instructor_name, 
                                      room_number, section, credits, course_type, max_students) 
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Step 1: Create table
            st.executeUpdate(createTableSQL);

            // Step 2: Insert data
            for (String[] schedule : enhancedScheduleData) {
                pstmt.setString(1, schedule[0]); // course_code
                pstmt.setString(2, schedule[1]); // day
                pstmt.setString(3, schedule[2]); // start_time
                pstmt.setString(4, schedule[3]); // end_time
                pstmt.setString(5, schedule[4]); // instructor_name
                pstmt.setString(6, schedule[5]); // room_number
                pstmt.setString(7, schedule[6]); // section
                pstmt.setInt(8, Integer.parseInt(schedule[7])); // credits
                pstmt.setString(9, schedule[8]); // course_type
                pstmt.setInt(10, Integer.parseInt(schedule[9])); // max_students

                pstmt.executeUpdate();
                System.out.println("Inserted schedule for course: " + schedule[0] + " - Section " + schedule[6]);
            }

            System.out.println("✅ All schedules inserted successfully!");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
