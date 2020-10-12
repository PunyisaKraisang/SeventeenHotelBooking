package com.spring.dao;

import com.spring.dao.AdminLoginDAO;
import com.spring.dao.BaseRepository;
import com.spring.entity.AdminEntity;
import com.spring.entity.MenuEntity;
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
    public List<AdminEntity> fetchAll() {
        return fetchAll(getSession(), AdminEntity.class, "id");
    }

    @Override
    public AdminEntity getById(int adminId) {
        return getById(getSession(), AdminEntity.class, adminId, "adminId");
    }

    @Override
    public void saveNewEntity(AdminEntity admin) {
        saveNewEntity(getSession(), admin);
    }

    @Override
    public void updateExistEntity(AdminEntity adminEntity) {
        AdminEntity existingAdmin = getById(adminEntity.getId());
        existingAdmin.setUsername(adminEntity.getUsername());
        existingAdmin.setPassword(adminEntity.getPassword());
        getSession().update(existingAdmin);
    }

    @Override
    public void deleteEntity(int adminId) {
        deleteEntity(getSession(), adminId);
    }

}
