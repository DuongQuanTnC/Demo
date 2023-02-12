package test;

import dao.DAOBook;
import model.Book;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*Book book = new Book(122,"Siam", 128);
        DAOBook daoBook = new DAOBook();
        ArrayList<Book> bookList = daoBook.seclectById();
        for(Book b : bookList) {
            System.out.println(b.toString());
        }*/

        Book book = new Book(120);
        DAOBook daoBook = new DAOBook();
        Book b = daoBook.seclectById(book);
        System.out.println(b.toString());
    }
}
