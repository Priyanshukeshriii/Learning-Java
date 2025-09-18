package com.miniproject.collegeData;

public class Course {

    private String courseCode;
    private String courseName;
    private int credits;
    private String professor;

        // Constructor
    public Course(String courseCode, String courseName, int credits, String professor) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.credits = credits;
            this.professor = professor;
        }

        // Getters & Setters
        public String getCourseCode() {
            return courseCode;
        }

        public String getCourseName() {
            return courseName;
        }

        public int getCredits() {
            return credits;
        }

        public String getProfessor() {
            return professor;
        }

        public void setProfessor(String professor) {
            this.professor = professor;
        }
}
