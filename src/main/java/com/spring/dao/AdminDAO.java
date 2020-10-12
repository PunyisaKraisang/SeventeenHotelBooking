package com.spring.dao;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public interface AdminDAO<E> {
    List<E> fetchAll();
    void deleteEntity(int id);
    E getById(int id);
    void saveNewEntity(E e);
    void updateExistEntity(E e);

    default List<E> fetchAll(Session session, Class<E> eClass, String id) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> query = cb.createQuery(eClass);
        Root<E> roots = query.from(eClass);
        query.select(roots);
        query.orderBy(cb.asc(roots.get(id)));
        return session.createQuery(query).getResultList();
    }

    default void deleteEntity(Session session, int id) {
        E e = getById(id);
        session.delete(e);
    }

    default E getById(Session session, Class<E> eClass, int id, String compareId) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(eClass);
        Root<E> cars = cq.from(eClass);
        Predicate condition = cb.equal(cars.get(compareId), id);
        cq.where(condition);
        return session.createQuery(cq).getSingleResult();
    }

    default void saveNewEntity(Session session, E e) {
        session.saveOrUpdate(e);
    }
}
