package dao;

import model.Librarian;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDAO {
    private Connection conn;

    public LibrarianDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
    }

    public LibrarianDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Librarian librarian) throws SQLException {
        String sql = "INSERT INTO librarian (lid, name, email, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, librarian.getLibrarianId());
            pst.setString(2, librarian.getLibrarianName());
            pst.setString(3, librarian.getLibrarianEmail());
            pst.setString(4, librarian.getLibrarianAddress());
            pst.executeUpdate();
        }
    }

    public void update(Librarian librarian) throws SQLException {
        String sql = "UPDATE librarian SET name = ?, email = ?, address = ? WHERE lid = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, librarian.getLibrarianName());
            pst.setString(2, librarian.getLibrarianEmail());
            pst.setString(3, librarian.getLibrarianAddress());
            pst.setString(4, librarian.getLibrarianId());
            pst.executeUpdate();
        }
    }

    public void delete(String librarianId) throws SQLException {
        String sql = "DELETE FROM librarian WHERE lid = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, librarianId);
            pst.executeUpdate();
        }
    }

    public List<Librarian> getAllLibrarians() throws SQLException {
        List<Librarian> list = new ArrayList<>();
        String sql = "SELECT * FROM librarian";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Librarian librarian = new Librarian(
                        rs.getString("lid"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address")
                );
                list.add(librarian);
            }
        }
        return list;
    }

    public int getTotalLibrarians() throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM librarian";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        }
        return 0;
    }
}
