package finalMiniProject.Users;

import finalMiniProject.RoleMenu;

import java.sql.SQLException;

public interface User {
     RoleMenu login(String email, String password) throws SQLException, ClassNotFoundException;
     void logout();
}
