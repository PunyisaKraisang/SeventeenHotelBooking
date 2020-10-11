DROP TABLE Menu_Order;
DROP TABLE Menu_Order_Item;

-- Table Creation
CREATE TABLE Menu_Order (
    Order_id NUMBER,
    Username nvarchar2(10),
    Ordering_time DATE,
    Tax FLOAT,
    Service_charge FLOAT,
    Total_bill FLOAT,
    CONSTRAINT pk_menu_order_id PRIMARY KEY(Order_id),
    CONSTRAINT fk_username_for_food FOREIGN KEY (username) REFERENCES Customer(username)
);

CREATE TABLE Menu_Order_Item (
    Order_id NUMBER,
    Menu_id NUMBER,
    Quantity NUMBER,
    Expected_deviler_datetime TIMESTAMP,
    Devilered_datetime TIMESTAMP,
    Status NVARCHAR2(10),
    CONSTRAINT pk_menu_order_item_id PRIMARY KEY(Order_id, Menu_id)
);

-- Insert data
INSERT INTO Menu_Order VALUES (1, 'dummy', '07-OCT-2020', 3.52, 3.00, 27.54);
INSERT INTO Menu_Order VALUES (2, 'dummy', '07-OCT-2020', 3.52, 3.00, 27.54);

-- Show data
SELECT * FROM Menu_Order;
select * from menu_order_item;
select moi.order_id
        , m.name as menu_name
        , c.first_name
        , c.last_name
        , moi.quantity
        , moi.expected_deviler_datetime
        , moi.status
from menu_order_item moi
inner join menu m on m.menu_id = moi.menu_id
inner join menu_order mo on mo.order_id = moi.order_id
inner join customer c on c.username = mo.username
where moi.devilered_datetime is null 
and moi.status = 'pending'
order by moi.expected_deviler_datetime, m.name;


commit;


