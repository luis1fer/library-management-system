package dao;

import model.Borrow;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowDAO {
    private Connection conn;

    public BorrowDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
    }

    public BorrowDAO(Connection conn){
        this.conn = conn;
    }

    public void insert(Borrow borrow) throws SQLException {
        String sql = "INSERT INTO borrow (bid,studentname,book,date_borrowed,date_return)VALUES(?,?,?,?,?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, borrow.getBid());
            pst.setString(2, borrow.getStudentName());
            pst.setString(3, borrow.getBook());
            pst.setTimestamp(4, new Timestamp(borrow.getDateBorrowed().getTime()));
            pst.setTimestamp(5, new Timestamp(borrow.getDateReturn().getTime()));
            pst.executeUpdate();
        }
    }

    public void update(Borrow borrow) throws SQLException {
        String sql = "UPDATE borrow SET studentname= ?,book=?,date_borrowed=?,date_return=? WHERE bid=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, borrow.getStudentName());
            pst.setString(2, borrow.getBook());
            pst.setTimestamp(3, new Timestamp(borrow.getDateBorrowed().getTime()));
            pst.setTimestamp(4, new Timestamp(borrow.getDateReturn().getTime()));
            pst.setString(5, borrow.getBid());
            pst.executeUpdate();
        }
    }

    public void delete(String bid) throws SQLException {
    String sql = "DELETE FROM borrow WHERE bid = ?";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, bid);
        pst.executeUpdate();
    }
}


    public List<Borrow> getAllBorrows() throws SQLException {
        List<Borrow> list = new ArrayList<>();
        String sql = "SELECT * FROM borrow";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Borrow borrow = new Borrow(
                    rs.getString("bid"),
                    rs.getString("studentname"),
                    rs.getString("book"),
                    rs.getTimestamp("date_borrowed"),
                    rs.getTimestamp("date_return")
                );
                list.add(borrow);
            }
        }
        return list;
    }

    public int getTotalBorrows() throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM borrow";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        }
        return 0;
    }
}

