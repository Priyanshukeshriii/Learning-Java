package com.miniproject.collegeData;

public class Schedule {
    private String courseCode;
    private String courseName;
    private String day;
    private String time;
    private String room;
    private String professor;

    // Constructor
    public Schedule(String courseCode,String courseName, String day, String time, String room, String professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.day = day;
        this.time = time;
        this.room = room;
        this.professor = professor;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getProfessor() {
        return professor;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
