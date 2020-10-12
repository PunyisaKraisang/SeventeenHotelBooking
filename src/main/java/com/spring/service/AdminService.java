package com.spring.service;

import java.util.List;

public interface AdminService<E> {
    List<E> fetchAll();
    void deleteEntity(int id);
    E getById(int id);
    void saveNewEntity(E e);
    void updateExistEntity(E e);
}
