package com.spring.entity;

import javax.persistence.*;

@Entity @Table(name = "Car")
public class CarEntity {
    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carIdSeq")
    @SequenceGenerator(
            name = "carIdSeq",
            sequenceName = "carIdSeq",
            initialValue = 1000,
            allocationSize = 1
    )
    private int carId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "car_price")
    private float carPrice;

    @Column(name = "Mileage")
    private float mileage;

    @Column(name = "ac")
    private String ac;

    @Column(name = "car_manual")
    private String manual;

    @Column(name = "trunk_size")
    private float trunkSize;

    @Column(name = "status")
    private String carStatus;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int id) {
        this.carId = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String name) {
        this.carName = name;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String type) {
        this.carType = type;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float price) {
        this.carPrice = price;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public float getTrunkSize() {
        return trunkSize;
    }

    public void setTrunkSize(float trunkSize) {
        this.trunkSize = trunkSize;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String status) {
        this.carStatus = status;
    }
}
