package dao;

import database.JDBCConnection;

import java.sql.Connection;
import java.util.ArrayList;

public interface daoInterface<T> {
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public ArrayList<T> selectAll();
    public T seclectById(T t);

}
