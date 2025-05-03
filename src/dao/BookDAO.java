package dao;

import view.BookJFrame;
import model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
    private Connection conn;

    public BookDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
    }

    public BookDAO(Connection conn) {
        this.conn = conn;
    }

    public void insert(Book book) throws SQLException {
        String sql = "INSERT INTO book (bookid, bookname, author, publisher) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, book.getBookid());
            pst.setString(2, book.getBookname());
            pst.setString(3, book.getAuthor());
            pst.setString(4, book.getPublisher());
            pst.executeUpdate();
        }
    }

    public void update(Book book) throws SQLException {
        String sql = "UPDATE book SET bookname = ?, author = ?, publisher = ? WHERE bookid = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, book.getBookname());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getPublisher());
            pst.setString(4, book.getBookid());
            pst.executeUpdate();
        }
    }

    public void delete(String bookid) throws SQLException {
        String sql = "DELETE FROM book WHERE bookid = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, bookid);
            pst.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("bookid"),
                        rs.getString("bookname"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );
                list.add(book);
            }
        }
        return list;
    }

    public int getTotalBooks() throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM book";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        }
        return 0;
    }
}
