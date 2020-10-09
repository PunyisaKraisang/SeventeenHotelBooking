DROP TABLE Room_Reservation;
DROP TABLE Room;
-- Table creation
-- Room table
CREATE TABLE Room (
    Room_id NUMBER,
    Room_floor NUMBER,
    Room_price FLOAT,
    Room_type VARCHAR(20),
    Room_number NUMBER,
    Room_status VARCHAR(256),
    Hotel_id NUMBER,
    Bed_number NUMBER,
    Room_view VARCHAR(256),
    Max_capacity NUMBER,
    Bathtub NUMBER(1) DEFAULT 1,
    CONSTRAINT pk_room_id PRIMARY KEY(Room_id)
);
-- Room property table
--CREATE TABLE Room_Property (
--    Room_type NUMBER,
--    Bed_number NUMBER,
--    Room_view VARCHAR(256),
--    Max_capacity NUMBER,
--    Bathtub VARCHAR(20),
--    CONSTRAINT pk_room_type PRIMARY KEY (Room_type)
--);
-- Room reservatio table
CREATE TABLE Room_Reservation (
    Reservation_id NUMBER,
    Room_id NUMBER,
    Checkin_time DATE,
    Checkout_time DATE,
    Tax FLOAT,
    Service_charge FLOAT,
    Total_bill FLOAT,
    Reservation_status VARCHAR(256),
    CONSTRAINT pk_reservation_id PRIMARY KEY(Reservation_id),
    CONSTRAINT fk_room_id FOREIGN KEY(Room_id) REFERENCES Room(Room_id)
);

-- Insert some data
-- Room_Property
--INSERT INTO Room_Property VALUES (1, 1, 'Ocean', 1, 'No');
--INSERT INTO Room_Property VALUES (2, 4, 'City View', 4, 'Yes');
--INSERT INTO Room_Property VALUES (3, 2, 'Ocean', 3, 'Yes');
-- Room
INSERT INTO Room VALUES (1, 1, 80.35, 'Single', 101, 'Available', 1, 1, 'Ocean', 1, 0);
INSERT INTO Room VALUES (2, 1, 81.35, 'Single', 102, 'Available', 1, 1, 'Ocean', 1, 1);
INSERT INTO Room VALUES (3, 1, 172.7, 'Triple', 103, 'Available', 1, 2, 'City', 3, 1);
INSERT INTO Room VALUES (4, 1, 164.3, 'Triple', 104, 'Available', 1, 3, 'City', 3, 1);
INSERT INTO Room VALUES (5, 1, 77.4, 'Single', 105, 'Occupied', 1, 1, 'Ocean', 1, 0);
INSERT INTO Room VALUES (6, 1, 110.5, 'Double', 106, 'Available', 1, 2, 'Ocean', 2, 1);
INSERT INTO Room VALUES (7, 1, 108.69, 'Double', 107, 'Available', 1, 2, 'City', 2, 1);
INSERT INTO Room VALUES (8, 1, 80.35, 'Single', 108, 'Available', 1, 1, 'City', 1, 1);
INSERT INTO Room VALUES (9, 1, 176.2, 'Triple', 109, 'Available', 1, 2, 'Ocean', 3, 1);

-- Room_Reservation
INSERT INTO Room_Reservation VALUES (1, 5, '07-OCT-2020', '09-OCT-2020', 8.51, 20.1, 183.31, 'Complete');
INSERT INTO Room_Reservation VALUES (2, 7, '09-OCT-2020', '11-OCT-2020', 10.3, 20.0, 247.86, 'Pending');
-- Show data
SELECT * FROM Room;
SELECT * FROM Room_Reservation;