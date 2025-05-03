package model;

public class Librarian {
    private String librarianId;
    private String librarianName;
    private String librarianEmail;
    private String librarianAddress;

    public Librarian(String librarianId, String librarianName, String librarianEmail, String librarianAddress) {
        this.librarianId = librarianId;
        this.librarianName = librarianName;
        this.librarianEmail = librarianEmail;
        this.librarianAddress = librarianAddress;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getLibrarianEmail() {
        return librarianEmail;
    }

    public void setLibrarianEmail(String librarianEmail) {
        this.librarianEmail = librarianEmail;
    }

    public String getLibrarianAddress() {
        return librarianAddress;
    }

    public void setLibrarianAddress(String librarianAddress) {
        this.librarianAddress = librarianAddress;
    }
}
