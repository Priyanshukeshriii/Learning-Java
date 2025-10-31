package com.miniProject01.users;

import java.util.Scanner;

public interface User {
    boolean login(String email, String password);
    void viewMenu(Scanner scanner); // Role-specific menu

}
