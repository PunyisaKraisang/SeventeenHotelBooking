-- Hotel Table Creation
CREATE TABLE Hotel (
    Hotel_id NUMBER,
    Hotel_name VARCHAR(256),
    Hotel_star NUMBER,
    Hotel_rating FLOAT,
    Hotel_address VARCHAR(256),
    CONSTRAINT pk_hotel_id PRIMARY KEY(Hotel_id)
);

-- Insert data
INSERT INTO Hotel
VALUES(1, 'Leisure Inn', 3, 3.3, '882 Lost Creek Road, Leesport, PA 19533');

