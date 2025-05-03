package model;

public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private String publisher;

    public Book(String bookid, String bookname, String author, String publisher) {
        this.bookId = bookid;
        this.bookName = bookname;
        this.author = author;
        this.publisher = publisher;
    }

    public String getBookid() {
        return bookId;
    }

    public void setBookid(String bookid) {
        this.bookId = bookid;
    }

    public String getBookname() {
        return bookName;
    }

    public void setBookname(String bookname) {
        this.bookName = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}


