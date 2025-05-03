package controller;

import dao.StudentDAO;
import model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentController {

    private StudentDAO studentDAO;

    public StudentController() throws ClassNotFoundException, SQLException {
        this.studentDAO = new StudentDAO();
    }

    public void addStudent(Student student) throws SQLException {
        studentDAO.insert(student);
    }

    public void updateStudent(Student student) throws SQLException {
        studentDAO.update(student);
    }

    public void deleteStudent(String studentid) throws SQLException {
        studentDAO.delete(studentid);
    }

    public List<Student> listStudents() throws SQLException {
        return studentDAO.getAllStudents();
    }

    public int countStudents() throws SQLException {
        return studentDAO.getTotalStudents();
    }
}
