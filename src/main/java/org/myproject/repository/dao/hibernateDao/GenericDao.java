package org.myproject.repository.dao.hibernateDao;

import java.util.List;

public interface GenericDao<T, ID extends Number> {

    T add(T entity);

    T getById(ID id);

    List<T> getAll();

    T update(T entity);

    boolean delete(T entity);

    boolean delete(ID id);

}
