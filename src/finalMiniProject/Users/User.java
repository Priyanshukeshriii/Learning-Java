package finalMiniProject.Users;

import java.sql.SQLException;

public interface User {
     void login(String email,String password) throws SQLException, ClassNotFoundException;
     void logout();
}
