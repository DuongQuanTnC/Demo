package model;

public class Book {
    private int id;
    private String tenSach;
    private int giaBan;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String tenSach, int giaBan) {
        this.id = id;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tenSach='" + tenSach + '\'' +
                ", giaBan=" + giaBan +
                '}';
    }
}
