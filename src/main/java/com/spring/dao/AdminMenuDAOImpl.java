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
public class AdminMenuDAOImpl extends BaseRepository implements AdminDAO<MenuEntity> {
    @Override
    public List<MenuEntity> fetchAll() {
        return fetchAll(getSession(), MenuEntity.class, "menuId");
    }
    @Override
    public void saveNewEntity(MenuEntity food) {
        saveNewEntity(getSession(), food);
    }

    @Override
    public void deleteEntity(int menuId) {
        deleteEntity(getSession(), menuId);
    }

    @Override
    public MenuEntity getById(int menuId) {
        return getById(getSession(), MenuEntity.class, menuId, "menuId");
    }

    @Override
    public void updateExistEntity(MenuEntity food) {
        MenuEntity existingDish = getById(food.getMenuId());
        existingDish.setDescription(food.getDescription());
        //existingDish.setKeywords(food.getKeywords());
        existingDish.setName(food.getName());
        existingDish.setPrice(food.getPrice());
        existingDish.setRecommended(food.getIsRecommended());
        getSession().update(existingDish);
    }
}
