package finalMiniProject.data;



public class Complaint {
    private int complaintId;
    private int studentId;
    private String description;
    private String status;
    private String resolution;

    public Complaint(int complaintId, int studentId, String description, String status, String resolution) {
        this.complaintId = complaintId;
        this.studentId = studentId;
        this.description = description;
        this.status = status;
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Complaint{");
        sb.append("complaintId=").append(complaintId);
        sb.append(", studentId=").append(studentId);
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", resolution='").append(resolution).append('\'');
        sb.append('}');
        return sb.toString();
    }

    // Getters and Setters
    public int getComplaintId() { return complaintId; }
    public int getStudentId() { return studentId; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public String getResolution() { return resolution; }


    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setResolution(String resolution) { this.resolution = resolution; }
}
