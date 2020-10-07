-- Table Creation
CREATE TABLE Menu_Order (
    Order_id NUMBER,
    Reservation_id NUMBER,
    Ordering_time DATE,
    Tax FLOAT,
    Service_charge FLOAT,
    Total_bill FLOAT,
    CONSTRAINT pk_menu_order_id PRIMARY KEY(Order_id),
    CONSTRAINT fk_reservation_id_for_food FOREIGN KEY (Reservation_id) REFERENCES Room_Reservation(Reservation_id)
);

-- Insert data
INSERT INTO Menu_Order VALUES (1, 1, '07-OCT-2020', 3.52, 3.00, 27.54);

-- Show data
SELECT * FROM Menu_Order;