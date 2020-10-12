package com.spring.dao;

import com.spring.entity.CarEntity;
import com.spring.entity.RoomEntity;
import com.spring.entity.RoomReservationEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class AdminRoomReservationDAOImpl extends BaseRepository implements AdminRoomReservationDAO {
    @Override
    public List<RoomReservationEntity> fetchAll() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomReservationEntity> query = cb.createQuery(RoomReservationEntity.class);
        Root<RoomReservationEntity> roots = query.from(RoomReservationEntity.class);
        query.select(roots);
        query.orderBy(cb.asc(roots.get("reservationId")));
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public RoomReservationEntity getById(int rid) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomReservationEntity> cq = cb.createQuery(RoomReservationEntity.class);
        Root<RoomReservationEntity> cars = cq.from(RoomReservationEntity.class);
        Predicate condition = cb.equal(cars.get("reservationId"), rid);
        cq.where(condition);
        return getSession().createQuery(cq).getSingleResult();
    }

    @Override
    public void deleteEntity(int rid) {
        getSession().delete(getById(rid));
    }

    @Override
    public void changeStatus(int rid, String statusChangeTo) {
        String updateHQL = "UPDATE RoomReservationEntity r SET r.reservationStatus = :status WHERE r.reservationId = :id";
        Query query = getSession().createQuery(updateHQL);
        query.setParameter("status", statusChangeTo);
        query.setParameter("id", rid);
        query.executeUpdate();
    }

}
