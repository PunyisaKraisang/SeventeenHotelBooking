DROP TABLE Car;
CREATE TABLE Car (
    Car_id NUMBER NOT NULL PRIMARY KEY,
    Car_name VARCHAR(256),
    Car_type VARCHAR(256),
    Car_price FLOAT,
    Mileage FLOAT,
    AC VARCHAR(20),
    Car_manual VARCHAR(20),
    Trunk_size FLOAT,
    Car_status VARCHAR(20)
);
CREATE SEQUENCE carIdSeq
START WITH 1000
INCREMENT BY 1;

INSERT INTO Car
VALUES(carIdSeq.NEXTVAL, 'Lexus', 'Coupe', 20.5, 5000, 'Yes', 'Yes', 116, 'Unavailable');

INSERT INTO Car
VALUES(carIdSeq.NEXTVAL, 'Ford', 'SUV', 30, 8000, 'Yes', 'Yes', 116, 'Available');

select * from car;