package com.miniProject01;

import java.sql.*;

public class courseDatabase {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/miniproject01";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        // Sample data for 10 courses
        String[][] coursesData = {
                {"Discrete Mathematics", "MATH101", "3", "Mon-Wed 10:00-11:30", "Dr. Anil Sharma"},
                {"Data Structures and Algorithms", "CS102", "4", "Tue-Thu 09:00-10:30", "Dr. Priya Gupta"},
                {"Digital Electronics", "ECE201", "3", "Mon-Wed 12:00-13:30", "Dr. Rajesh Kumar"},
                {"Database Management Systems", "CS202", "4", "Tue-Thu 11:00-12:30", "Dr. Meena Patel"},
                {"Organic Chemistry", "CHEM301", "3", "Fri 10:00-11:30", "Dr. Sanjay Verma"},
                {"Artificial Intelligence", "CS302", "4", "Mon-Wed 14:00-15:30", "Dr. Anjali Nair"},
                {"Fluid Mechanics", "ME401", "3", "Tue-Thu 13:00-14:30", "Dr. Vikram Singh"},
                {"Software Engineering", "CS402", "4", "Fri 12:00-15:00", "Dr. Sunita Reddy"},
                {"Power Systems", "EE501", "3", "Mon-Wed 16:00-17:30", "Dr. Rakesh Iyer"},
                {"Machine Learning", "CS502", "4", "Tue-Thu 15:00-16:30", "Dr. Pooja Shah"}
        };

        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS course (
                    course_id INT AUTO_INCREMENT PRIMARY KEY,
                    course_name VARCHAR(100) NOT NULL,
                    course_code VARCHAR(20) NOT NULL UNIQUE,
                    credits INT,
                    schedule VARCHAR(50),
                    instructor_name VARCHAR(100)
                );
                """;

        String insertSQL = "INSERT INTO course (course_name, course_code, credits, schedule, instructor_name) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Step 1: Create table
            st.executeUpdate(createTableSQL);

            // Step 2: Insert data
            for (String[] course : coursesData) {
                pstmt.setString(1, course[0]); // course_name
                pstmt.setString(2, course[1]); // course_code
                pstmt.setInt(3, Integer.parseInt(course[2])); // credits
                pstmt.setString(4, course[3]); // schedule
                pstmt.setString(5, course[4]); // instructor_name

                pstmt.executeUpdate();
                System.out.println("Inserted course: " + course[0] + " taught by " + course[4]);
            }

            System.out.println("✅ All courses inserted successfully!");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static class RegistrationsDatabase {

        private static final String URL = "jdbc:mysql://localhost:3306/miniproject01";
        private static final String USER = "root";
        private static final String PASSWORD = "password";

        public static void main(String[] args) {
            createRegistrationsTable();
        }

        public static void createRegistrationsTable() {
            String createRegistrationsSQL = """
                CREATE TABLE IF NOT EXISTS registrations (
                    registration_id INT AUTO_INCREMENT PRIMARY KEY,
                    student_email VARCHAR(100) NOT NULL,
                    course_id INT NOT NULL,
                    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (email) REFERENCES students(email) ON DELETE CASCADE,
                    FOREIGN KEY (course_id) REFERENCES course(course_id) ON DELETE CASCADE
                );
            """;

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement st = conn.createStatement()) {

                st.executeUpdate(createRegistrationsSQL);
                System.out.println("✅ Registrations table created successfully!");

            } catch (SQLException e) {
                System.err.println("Error creating registrations table: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
