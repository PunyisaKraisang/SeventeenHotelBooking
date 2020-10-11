package com.spring.dao;

import com.spring.entity.MenuEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class AdminMenuDAOImpl extends BaseRepository implements AdminMenuDAO {
    @Override
    public List<MenuEntity> listAllFoods() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<MenuEntity> query = cb.createQuery(MenuEntity.class);
        Root<MenuEntity> foods = query.from(MenuEntity.class);
        query.select(foods);
        query.orderBy(cb.asc(foods.get("menuId")));
        return getSession().createQuery(query).getResultList();
    }
}
