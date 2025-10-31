package finalMiniProject.dao;



import finalMiniProject.Users.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {


    public static boolean add_Professor(Professor professor) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO professors (name, email, password, department) VALUES (?, ?, ?, ?)";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, professor.getName());
        ps.setString(2, professor.getEmail());
        ps.setString(3, professor.getPassword());
        ps.setString(4, professor.getDepartment());
        int rows = ps.executeUpdate();

        DataBase.closeConnection(con);
        return rows > 0;
    }

    public static Professor get_Professor(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM professors WHERE email = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("professor_id");
            String name = rs.getString("name");
            String mail = rs.getString("email");
            String password = rs.getString("password");
            String department = rs.getString("department");

            DataBase.closeConnection(con);
            return new Professor(id, name, mail, password, department);
        }

        DataBase.closeConnection(con);
        return null;
    }
    public static Professor get_Professor(int professor_id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM professors WHERE professor_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, professor_id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("professor_id");
            String name = rs.getString("name");
            String mail = rs.getString("email");
            String password = rs.getString("password");
            String department = rs.getString("department");

            DataBase.closeConnection(con);
            return new Professor(id, name, mail, password, department);
        }

        DataBase.closeConnection(con);
        return null;
    }

    public static List<Professor> getAll_Professors() throws SQLException, ClassNotFoundException {
        List<Professor> professors = new ArrayList<>();

        String sql = "SELECT * FROM professors";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("professor_id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String department = rs.getString("department");

            professors.add(new Professor(id, name, email, password, department));
        }

        DataBase.closeConnection(con);
        return professors;
    }

    public static boolean update_Professor(Professor p) {
        String sql = "UPDATE professors SET name = ?, email = ?, password = ?, department = ? WHERE professor_id = ?";
        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getPassword());
            ps.setString(4, p.getDepartment());
            ps.setInt(5, p.getProfessorId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete_Professor(int professorId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM professors WHERE professor_id = ?";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, professorId);

        int rows = ps.executeUpdate();
        DataBase.closeConnection(con);
        return rows > 0;
    }
}

