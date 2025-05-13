package controller;

import dao.BookDAO;
import model.Book;
import java.sql.SQLException;
import java.util.List;

public class BookController {

    private BookDAO bookDAO;

    public BookController() throws ClassNotFoundException, SQLException {
        this.bookDAO = new BookDAO();
    }

    public void addBook(Book book) throws SQLException {
        bookDAO.insert(book);
    }

    public void updateBook(Book book) throws SQLException {
        bookDAO.update(book);
    }

    public void deleteBook(String bookid) throws SQLException {
        bookDAO.delete(bookid);
    }

    public List<Book> listBooks() throws SQLException {
        return bookDAO.getAllBooks();
    }

    public int countBooks() throws SQLException {
        return bookDAO.getTotalBooks();
    }
}
