package model;

import java.util.Date;

public class Borrow {
    private String bid;
    private String studentName;
    private String book;
    private Date dateBorrowed;
    private Date dateReturn;

    public Borrow(String bid, String studentName, String book, Date dateBorrowed, Date dateReturn) {
        this.bid = bid;
        this.studentName = studentName;
        this.book = book;
        this.dateBorrowed = dateBorrowed;
        this.dateReturn = dateReturn;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }
}
