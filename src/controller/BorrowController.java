package controller;

import dao.BorrowDAO;
import model.Borrow;

import java.sql.SQLException;
import java.util.List;

public class BorrowController {

    private BorrowDAO borrowDAO;

    public BorrowController() throws ClassNotFoundException, SQLException {
        this.borrowDAO = new BorrowDAO();
    }

    public void addBorrow(Borrow borrow) throws SQLException {
        borrowDAO.insert(borrow);
    }

    public void updateBorrow(Borrow borrow) throws SQLException {
        borrowDAO.update(borrow);
    }

    public void deleteBorrow(String borrowid) throws SQLException {
        borrowDAO.delete(borrowid);
    }

    public List<Borrow> listBorrows() throws SQLException {
        return borrowDAO.getAllBorrows();
    }

    public int countBorrows() throws SQLException {
        return borrowDAO.getTotalBorrows();
    }
}
