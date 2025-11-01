package finalMiniProject.data;

public class RegisterCourse {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private int semester;
    private String grade;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisterCourse{");
        sb.append("courseId=").append(courseId);
        sb.append(", enrollmentId=").append(enrollmentId);
        sb.append(", studentId=").append(studentId);
        sb.append(", semester=").append(semester);
        sb.append(", grade='").append(grade).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public RegisterCourse(int enrollmentId,int studentId, int courseId, int semester, String grade) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.grade = grade;
    }

    // Getters and setters
    public int getEnrollmentId() { return enrollmentId; }
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public int getSemester() { return semester; }
    public String getGrade() { return grade; }

    public void setEnrollmentId(int enrollmentId) { this.enrollmentId = enrollmentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public void setSemester(int semester) { this.semester = semester; }
    public void setGrade(String grade) { this.grade = grade; }
}

