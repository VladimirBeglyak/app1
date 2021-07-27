package com.beglyak_project.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {
    boolean add(T t) throws SQLException, ClassNotFoundException;

    boolean delete(T t);

    T findId(int id);

    List<T> findAll();
}
