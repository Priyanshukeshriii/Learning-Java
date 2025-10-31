package com.miniProject01;

import com.miniProject01.users.UserData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationsDatabase {


    public static void main(String[] args) {
        String query = "drop table registrations";
        try {
            Statement st = DataBaseLoader.getStatment();
            st.executeUpdate(query);
            System.out.println("done");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

//    public static void createRegistrationsTable() {
//        String createRegistrationsSQL = """
//            CREATE TABLE IF NOT EXISTS registrations (
//                registration_id INT AUTO_INCREMENT PRIMARY KEY,
//                student_email VARCHAR(100) NOT NULL,
//                course_id INT NOT NULL,
//                registored_Course json
//            );
//        """;

//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             Statement st = conn.createStatement()) {
//
//            st.executeUpdate(createRegistrationsSQL);
//            System.out.println("Registrations table created successfully!");
//
//        } catch (SQLException e) {
//            System.err.println("Error creating registrations table: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }


}
