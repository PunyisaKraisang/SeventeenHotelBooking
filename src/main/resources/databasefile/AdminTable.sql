-- Admin table
CREATE TABLE Admin (
    admin_id NUMBER NOT NULL PRIMARY KEY,
    username VARCHAR(20),
    password VARCHAR(20)
);
-- Admin record
INSERT INTO Admin VALUES (101, 'admin', 'admin');

SELECT * FROM Admin;