drop table customer CASCADE CONSTRAINTS;
drop table account;

CREATE TABLE customer (
    username nvarchar2(10) primary key,
    first_name nvarchar2(20),
    last_name nvarchar2(20),
    birth_date DATE,
    phone nvarchar2(20),
    email_address nvarchar2(30)
);

CREATE TABLE account (
    customer_id number primary key,
    username nvarchar2(10) unique,
    password nvarchar2(20) not null
);

-- create dummy customer
insert into customer (username, first_name, last_name, birth_date, phone, email_address) 
values ( 'dummy', 'Dummif', 'Dummilastier', '01-JAN-1990', '1111111111', 'dummy@email.com');

insert into account (username, password) 
values ( 'dummy', 'dummy1234');

select * from customer;
select * from account;

