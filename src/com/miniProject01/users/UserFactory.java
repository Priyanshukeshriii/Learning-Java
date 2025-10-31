package com.miniProject01.users;

public class UserFactory {
    // Factory Class for Users

        public static User getUser(String role) {
            if ("STUDENT".equalsIgnoreCase(role)) {
                return new Student();
            } else if ("PROFESSOR".equalsIgnoreCase(role)) {
                return new Professor();
            } else if ("ADMIN".equalsIgnoreCase(role)) {
                return new Administrator(); // No params needed
            }
            return null; // Or throw IllegalArgumentException
        }

}
