/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hieptran
 * @param <T>
 * @param <ID>
 */
@Repository
public abstract class GenericRepositoryImpl<T, ID extends Serializable> implements GenericRepository<T, ID> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> persistentClass;

    /**
     *
     * @return
     */
    public Class<T> getPersistentClass() {
        if (persistentClass == null) {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return persistentClass;
    }

    /**
     *
     * @return
     */
    public final Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    @Override
    public List<T> getAll() {
        return getByCriteria();
    }

    /**
     * Truy vấn dự trên Class đã mapping của hibernate
     *
     * @param criterion
     * @return
     */
    protected List<T> getByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    @Override
    public T getById(ID id) {
        T entity = (T) getSession().get(getPersistentClass(), id);//Class< T >
        return entity;
    }

    @Override
    public T getByProperty(String idName, Object idValue) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        crit.add(Restrictions.eq(idName, idValue));
        List lst = crit.list();
        if (lst != null && lst.size() > 0) {
            return (T) crit.list().get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<T> getAllByProperty(String idName, Object idValue) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        crit.add(Restrictions.eq(idName, idValue));
        List lst = crit.list();
        return lst;
    }

    @Override
    public ID create(T t) {
        if (t == null) {
            return null;
        }
        return (ID) getSession().save(t);
    }

    @Override
    public T createOrUpdate(T t) {
        if (t == null) {
            return null;
        }
        getSession().saveOrUpdate(t);
        return t;
    }

    @Override
    public void update(T t) {
        getSession().saveOrUpdate(t);
    }

    @Override
    public boolean deleteById(ID id) {
        T bean = getById(id);
        if (bean != null) {
            delete(bean);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(T t) {
        if (t != null) {
            getSession().delete(t);
            return true;
        }
        return false;
    }

    @Override
    public String getSortField(String sortField, String boAlias) {
        if (sortField == null || sortField.isEmpty()) {
            return null;
        }
        // replace
        StringBuilder result = new StringBuilder(10);
        String fields = sortField.replace(";", ",");
        String[] fieldArr = fields.split(",");
        for (int i = 0, len = fieldArr.length; i < len; i++) {
            String field = fieldArr[i];
            if (!field.isEmpty()) {
                if (field.indexOf('-') == 0) { // ORDER DESC
                    field = field.substring(1);
                    result.append(",").append(boAlias).append(".").append(field).append(" ").append("desc");
                } else {
                    result.append(",").append(boAlias).append(".").append(field);
                }
            }
        }

        return result.toString().substring(1);
    }
}
