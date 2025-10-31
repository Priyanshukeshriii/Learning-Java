package com.miniProject01.users;

import com.miniProject01.DataBaseLoader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserData {
    static ResultSet studentList =null;
    static ResultSet courseList = null;
    static ResultSet schedule = null;
    static ResultSet professor = null;
    static {
        try{
            courseList = DataBaseLoader.loadCourse();
            studentList = DataBaseLoader.loadStudent();
            schedule = DataBaseLoader.loadSchedule();
            professor = DataBaseLoader.loadProfessor();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
