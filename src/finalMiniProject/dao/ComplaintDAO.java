package finalMiniProject.dao;

import finalMiniProject.data.Complaint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    public static boolean add(Complaint complaint) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO complaint (student_id, description, status, resolution) VALUES (?, ?, ?, ?)";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, complaint.getStudentId());
        ps.setString(2, complaint.getDescription());
        ps.setString(3, complaint.getStatus());
        ps.setString(4, complaint.getResolution());
        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }


    public static boolean deleteById(int complaintId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM complaint WHERE complaint_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, complaintId);
        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }

    public static boolean update(Complaint complaint) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE complaint SET description = ?, status = ?, resolution = ? WHERE complaint_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, complaint.getDescription());
        ps.setString(2, complaint.getStatus());
        ps.setString(3, complaint.getResolution());
        ps.setInt(4, complaint.getComplaintId());
        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }

    public static List<Complaint> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM complaint";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Complaint> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("complaint_id");
            int studentId = rs.getInt("student_id");
            String description = rs.getString("description");
            String status = rs.getString("status");
            String resolution = rs.getString("resolution");
            list.add(new Complaint(id, studentId, description, status, resolution));
        }

        DataBase.closeConnection(con);
        return list;
    }

    public static List<Complaint> getByRollNumber(String roll_number) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM complaint WHERE student_id = ?";
        String sql1 = "select * from students where roll_number = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps1  = con.prepareStatement(sql1);
        PreparedStatement ps = con.prepareStatement(sql);
        ps1.setString(1,roll_number);
        ResultSet rs1 = ps1.executeQuery();
        ps.setInt(1, rs1.getInt("student_id"));
        ResultSet rs = ps.executeQuery();

        List<Complaint> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("complaint_id");
            int studentId = rs.getInt("student_id");
            String description = rs.getString("description");
            String status = rs.getString("status");
            String resolution = rs.getString("resolution");
            list.add(new Complaint(id, studentId, description, status, resolution));
        }

        DataBase.closeConnection(con);
        return list;
    }
    public static Complaint getById(int complaintId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM complaint WHERE complaint_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, complaintId);
        ResultSet rs = ps.executeQuery();

        Complaint complaint = null;
        if (rs.next()) {
            int id = rs.getInt("complaint_id");
            int studentId = rs.getInt("student_id");
            String description = rs.getString("description");
            String status = rs.getString("status");
            String resolution = rs.getString("resolution");

            complaint = new Complaint(id, studentId, description, status, resolution);
        }

        DataBase.closeConnection(con);
        return complaint;
    }
}
