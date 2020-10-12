package com.spring.dao;

import com.spring.entity.MenuEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
    @Override
    public void saveUpdateFood(MenuEntity food) {
        getSession().saveOrUpdate(food);
    }

    @Override
    public void deleteFood(int menuId) {
        MenuEntity target = getFoodById(menuId);
        getSession().delete(target);
    }

    @Override
    public MenuEntity getFoodById(int menuId) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<MenuEntity> cq = cb.createQuery(MenuEntity.class);
        Root<MenuEntity> foods = cq.from(MenuEntity.class);
        Predicate condition = cb.equal(foods.get("menuId"), menuId);
        cq.where(condition);
        return getSession().createQuery(cq).getSingleResult();
    }

    @Override
    public void updateExistingDish(MenuEntity food) {
        MenuEntity existingDish = getFoodById(food.getMenuId());
        existingDish.setDescription(food.getDescription());
        //existingDish.setKeywords(food.getKeywords());
        existingDish.setName(food.getName());
        existingDish.setPrice(food.getPrice());
        existingDish.setRecommended(food.getIsRecommended());
        getSession().update(existingDish);
    }
}
