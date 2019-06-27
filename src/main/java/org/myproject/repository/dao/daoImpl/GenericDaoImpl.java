package org.myproject.repository.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.myproject.repository.dao.hibernateDao.GenericDao;
import org.myproject.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class GenericDaoImpl<T, ID extends Number> implements GenericDao<T, ID> {


    private final Class<T> entityClass;

    protected SessionFactory sessionFactory;

    @Autowired
    public GenericDaoImpl(Class<T> clazz) {
        entityClass = clazz;

    }

    @Override
    public T add(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public T getById(ID id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Product> from_product_p = session.createQuery("FROM " + entityClass.getName(), Product.class);
        List<Product> list = from_product_p.list();
        transaction.commit();
        session.close();

        return (List<T>) list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T update(T entity) {
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public boolean delete(T entity) {
        if (entity != null) {
            getCurrentSession().delete(getCurrentSession().merge(entity));
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ID id) {
        return delete(getById(id));
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
