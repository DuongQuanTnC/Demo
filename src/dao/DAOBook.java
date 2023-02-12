package dao;

import database.JDBCConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOBook implements daoInterface<Book> {

    @Override
    public void insert(Book book) {
        try {
            Connection connection = JDBCConnection.getConnection();

            String sql = "INSERT INTO book (id, tenSach, giaBan)" + "VALUES(?, ?, ?)";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, book.getId());
            pst.setString(2, book.getTenSach());
            pst.setInt(3, book.getGiaBan());

            pst.executeUpdate();

            JDBCConnection.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        try {
            Connection connection = JDBCConnection.getConnection();

            String sql = "UPDATE book SET " + "tenSach = ?, " + "giaBan = ?" + "WHERE id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, book.getId());

            pst.executeUpdate();

            JDBCConnection.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Book book) {
        try {
            Connection connection = JDBCConnection.getConnection();

            String sql = "DELETE FROM book WHERE " + "id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, book.getId());

            pst.executeUpdate();

            JDBCConnection.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Book> selectAll() {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();

            String sql = "SELECT * FROM book ";

            PreparedStatement pst = connection.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tenSach = rs.getString("tenSach");
                int giaBan = rs.getInt("giaBan");

                Book book = new Book(id, tenSach, giaBan);
                bookList.add(book);
            }

            JDBCConnection.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public Book seclectById(Book b) {
        Book book = null;
        try {
            Connection connection = JDBCConnection.getConnection();

            String sql = "SELECT * FROM book " + "WHERE id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, b.getId());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tenSach = rs.getString("tenSach");
                int giaBan = rs.getInt("giaBan");

                book = new Book(id, tenSach, giaBan);
            }

            JDBCConnection.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }
}
