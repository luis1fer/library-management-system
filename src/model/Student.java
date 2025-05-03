package model;

public class Student {
    private String studentId;
    private String studentName;
    private String email;
    private String address;

    public Student(String studentid, String studentname, String email, String address) {
        this.studentId = studentid;
        this.studentName = studentname;
        this.email = email;
        this.address = address;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentid) {
        this.studentId = studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentname) {
        this.studentName = studentname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
