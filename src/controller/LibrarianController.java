package controller;

import dao.LibrarianDAO;
import model.Librarian;

import java.sql.SQLException;
import java.util.List;

public class LibrarianController {

    private LibrarianDAO librarianDAO;

    public LibrarianController() throws ClassNotFoundException, SQLException {
        this.librarianDAO = new LibrarianDAO();
    }

    public void addLibrarian(Librarian librarian) throws SQLException {
        librarianDAO.insert(librarian);
    }

    public void updateLibrarian(Librarian librarian) throws SQLException {
        librarianDAO.update(librarian);
    }

    public void deleteLibrarian(String librarianId) throws SQLException {
        librarianDAO.delete(librarianId);
    }

    public List<Librarian> listLibrarians() throws SQLException {
        return librarianDAO.getAllLibrarians();
    }

    public int countLibrarians() throws SQLException {
        return librarianDAO.getTotalLibrarians();
    }
}
