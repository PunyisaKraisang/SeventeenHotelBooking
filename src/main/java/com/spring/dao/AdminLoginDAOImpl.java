package com.spring.dao;

import com.spring.dao.AdminLoginDAO;
import com.spring.dao.BaseRepository;
import com.spring.entity.AdminEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class AdminLoginDAOImpl extends BaseRepository implements AdminLoginDAO {

    @Override
    public boolean getAdmin(String username, String password) {
        AdminEntity admin = null;
        Query query = getSession().createQuery("SELECT a FROM AdminEntity a WHERE a.username = :username AND a.password = :password", AdminEntity.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            admin = (AdminEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        return admin != null;
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<AdminEntity> query = cb.createQuery(AdminEntity.class);
        Root<AdminEntity> root = query.from(AdminEntity.class);
        query.select(root);
        List<AdminEntity> result = getSession().createQuery(query).getResultList();
        return result;
    }

    @Override
    public void save(AdminEntity admin) {
        getSession().save(admin);
    }

    @Override
    public void delete(AdminEntity admin) {
        getSession().delete(admin);
    }

    @Override
    public void update(AdminEntity admin) {
        getSession().update(admin);
    }
}
