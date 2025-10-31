package finalMiniProject.Users;

public class Professor {

        private int professorId;
        private String name;
        private String email;
        private String password;
        private String department;

        public Professor(int professorId, String name, String email, String password, String department) {
            this.professorId = professorId;
            this.name = name;
            this.email = email;
            this.password = password;
            this.department = department;
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Professor{");
        sb.append("department='").append(department).append('\'');
        sb.append(", professorId=").append(professorId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getProfessorId() { return professorId; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getDepartment() { return department; }

        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) { this.email = email; }
        public void setPassword(String password) { this.password = password; }
        public void setDepartment(String department) { this.department = department; }
}


