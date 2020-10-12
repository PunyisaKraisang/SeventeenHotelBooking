drop table customer CASCADE CONSTRAINTS;

CREATE TABLE customer (
    customer_id number primary key,
    username nvarchar2(10),
    first_name nvarchar2(20),
    last_name nvarchar2(20),
    birth_date DATE,
    phone nvarchar2(20),
    email_address nvarchar2(30)
);
create sequence customer_id_seq 
start with 100
increment by 1;
CREATE TABLE account (
    username nvarchar2(10) primary key,
    password nvarchar2(20) not null
);

-- create dummy customer
insert into customer (customer_id, username, first_name, last_name, birth_date, phone, email_address) 
values ( customer_id_seq.nextval, 'dummy', 'Dummif', 'Dummilastier', '01-JAN-1990', '1111111111', 'dummy@email.com');

insert into account (username, password) 
values ( 'dummy', 'dummy1234');
select * from customer;
select * from account;