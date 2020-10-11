package com.spring.dao;

import com.spring.entity.MenuEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Transactional
@Repository
public class AdminFoodDAOImpl extends BaseRepository implements AdminFoodDAO {
    @Override
    public void saveUpdateFood(MenuEntity food) {
        getSession().saveOrUpdate(food);
    }

    @Override
    public void deleteFood(int menuId) {
        MenuEntity target = getFoodById(menuId);
        getSession().delete(target);
    }

    private MenuEntity getFoodById(int menuId) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<MenuEntity> cq = cb.createQuery(MenuEntity.class);
        Root<MenuEntity> foods = cq.from(MenuEntity.class);
        Predicate condition = cb.equal(foods.get("menuId"), menuId);
        cq.where(condition);
        return getSession().createQuery(cq).getSingleResult();
    }
}
