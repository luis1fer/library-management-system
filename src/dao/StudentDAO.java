package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
    }

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Student student) throws SQLException {
        String sql = "INSERT INTO student (studentid, studentname, email, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, student.getStudentId());
            pst.setString(2, student.getStudentName());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getAddress());
            pst.executeUpdate();
            
        }
    }

    public void update(Student student) throws SQLException {
        String sql = "UPDATE student SET studentname = ?, email = ?, address = ? WHERE studentid = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, student.getStudentName());
            pst.setString(2, student.getEmail());
            pst.setString(3, student.getAddress());
            pst.setString(4, student.getStudentId());
            pst.executeUpdate();
        }
    }

    public void delete(String studentid) throws SQLException {
        String sql = "DELETE FROM student WHERE studentid = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, studentid);
            pst.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("studentid"),
                        rs.getString("studentname"),
                        rs.getString("email"),
                        rs.getString("address")
                );
                list.add(student);
            }
        }
        return list;
    }

    public int getTotalStudents() throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM student";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        }
        return 0;
    }
}
