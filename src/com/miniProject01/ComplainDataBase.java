package com.miniProject01;

import java.sql.*;
public class ComplainDataBase {


        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/miniproject01";
            String user = "root";
            String password = "password";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                String query = """
    CREATE TABLE IF NOT EXISTS complaints (
        id INT AUTO_INCREMENT PRIMARY KEY,
        student_email VARCHAR(100) NOT NULL,
        description TEXT NOT NULL,
        status VARCHAR(20) DEFAULT 'Pending',
        resolution TEXT,
        submission_date DATETIME DEFAULT CURRENT_TIMESTAMP
    );
""";

                st.executeUpdate(query);



                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('priyanshu.keshri@gmail.com', 'Unable to access course materials in the portal.', 'Pending', NULL)");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('aarav.mehta@gmail.com', 'Incorrect marks displayed in performance report.', 'Resolved', 'Marks recalculated and updated.')");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('isha.sharma@gmail.com', 'Delay in course registration confirmation email.', 'Pending', NULL)");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('rohan.patel@gmail.com', 'Unable to submit assignment due to server error.', 'Resolved', 'Assignment manually uploaded by admin.')");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('sneha.gupta@gmail.com', 'Course schedule not visible in dashboard.', 'In Progress', NULL)");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('arjun.verma@gmail.com', 'Password reset link not working properly.', 'Resolved', 'Password reset link reissued.')");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('kavya.nair@gmail.com', 'Mobile app crashes when viewing grades.', 'Pending', NULL)");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('rahul.yadav@gmail.com', 'Duplicate course registration detected.', 'Resolved', 'Duplicate entry removed successfully.')");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('ananya.singh@gmail.com', 'Issue in downloading lecture videos.', 'In Progress', NULL)");
                st.executeUpdate("INSERT INTO complaints (student_email, description, status, resolution) VALUES ('vikram.das@gmail.com', 'Feedback form not submitting properly.', 'Resolved', 'Form issue fixed and submission successful.')");

                System.out.println("✅ 10 complaint records inserted successfully!");

                st.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}


