package com.miniProject01;

import java.sql.*;

public class ProfessorDatabase {



        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/miniproject01";
            String user = "root";
            String password = "password";

            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS professors (
                    professor_id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(100) NOT NULL UNIQUE,
                    password VARCHAR(100) NOT NULL,
                    course VARCHAR(100),
                    course_code VARCHAR(20),
                    credits INT,
                    total_hours INT
                );
                """;

            String insertSQL = "INSERT INTO professors (name, email, password, course, course_code, credits, total_hours) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection con = DriverManager.getConnection(url, user, password);
                 Statement stmt = con.createStatement();
                 PreparedStatement pstmt = con.prepareStatement(insertSQL)) {


                stmt.execute(createTableSQL);


                String[][] data = {
                        {"Dr. A Sharma", "a.sharma@college.edu", "pass123", "Mathematics", "MATH101", "4", "60"},
                        {"Dr. B Verma", "b.verma@college.edu", "pass123", "Physics", "PHY102", "3", "45"},
                        {"Dr. C Patel", "c.patel@college.edu", "pass123", "Chemistry", "CHEM103", "4", "60"},
                        {"Dr. D Rao", "d.rao@college.edu", "pass123", "Computer Science", "CS104", "3", "50"},
                        {"Dr. E Singh", "e.singh@college.edu", "pass123", "Biology", "BIO105", "4", "60"},
                        {"Dr. F Mehta", "f.mehta@college.edu", "pass123", "English", "ENG106", "2", "30"},
                        {"Dr. G Gupta", "g.gupta@college.edu", "pass123", "Economics", "ECO107", "3", "45"},
                        {"Dr. H Das", "h.das@college.edu", "pass123", "Electronics", "ECE108", "3", "50"},
                        {"Dr. I Roy", "i.roy@college.edu", "pass123", "Data Science", "DS109", "4", "60"},
                        {"Dr. J Khan", "j.khan@college.edu", "pass123", "Artificial Intelligence", "AI110", "4", "60"}
                };


                for (String[] prof : data) {
                    pstmt.setString(1, prof[0]);
                    pstmt.setString(2, prof[1]);
                    pstmt.setString(3, prof[2]);
                    pstmt.setString(4, prof[3]);
                    pstmt.setString(5, prof[4]);
                    pstmt.setInt(6, Integer.parseInt(prof[5]));
                    pstmt.setInt(7, Integer.parseInt(prof[6]));
                    pstmt.addBatch(); // add to batch for faster execution
                }

                pstmt.executeBatch();
                System.out.println("inserted successfully!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}
