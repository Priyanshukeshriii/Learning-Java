package finalMiniProject.data;

public class Course {

        private int courseId;
        private String courseCode;
        private String courseTitle;
        private int credits;
        private String prerequisites;
        private int hours;
        private int professorId;
        private int semester;

        public Course(int courseId, String courseCode, String courseTitle, int credits, String prerequisites, int hours, int professorId, int semester) {
            this.courseId = courseId;
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
            this.credits = credits;
            this.prerequisites = prerequisites;
            this.hours = hours;
            this.professorId = professorId;
            this.semester = semester;
        }

        public Course(String courseCode, String courseTitle, int credits, String prerequisites, int hours, int professorId, int semester) {
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
            this.credits = credits;
            this.prerequisites = prerequisites;
            this.hours = hours;
            this.professorId = professorId;
            this.semester = semester;
        }

        // Getters and Setters
        public int getCourseId() { return courseId; }
        public String getCourseCode() { return courseCode; }
        public String getCourseTitle() { return courseTitle; }
        public int getCredits() { return credits; }
        public String getPrerequisites() { return prerequisites; }
        public int getHours() { return hours; }
        public int getProfessorId() { return professorId; }
        public int getSemester() { return semester; }

        public void setCourseId(int courseId) { this.courseId = courseId; }
        public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
        public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }
        public void setCredits(int credits) { this.credits = credits; }
        public void setPrerequisites(String prerequisites) { this.prerequisites = prerequisites; }
        public void setHours(int hours) { this.hours = hours; }
        public void setProfessorId(int professorId) { this.professorId = professorId; }
        public void setSemester(int semester) { this.semester = semester; }
}


