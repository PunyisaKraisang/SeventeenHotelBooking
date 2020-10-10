package com.spring.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity @Table(name = "Room_reservation")
public class RoomReservationEntity {
    @Id @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @Column(name = "Checkin_time")
    //@Temporal(TemporalType.DATE)
    private Date checkinTime;

    @Column(name = "Checkout_time")
    //@Temporal(TemporalType.DATE)
    private Date checkoutTime;

    @Column(name = "Tax")
    private float tax;

    @Column(name = "Service_charge")
    private float serviceCharge;

    @Column(name = "Total_bill")
    private float totalBill;

    @Column(name = "Reservation_status")
    private String reservationStatus;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Column(name = "Room_id")
    private int roomId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "room_id")
//    private RoomEntity roomEntity;

    public int getReservationId() {
        return reservationId;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public float getTax() {
        return tax;
    }

    public float getServiceCharge() {
        return serviceCharge;
    }

    public float getTotalBill() {
        return totalBill;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public void setServiceCharge(float serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public void setTotalBill(float totalBill) {
        this.totalBill = totalBill;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
