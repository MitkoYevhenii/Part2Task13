package ua.goit.entity;

import java.util.List;

public interface DAO<T, ID> {
    void save(T entity);
    T findById(ID id);
    List<T> readAll();
    void update(T entity);
    void delete(T entity);
    void deleteById(ID id);
}
