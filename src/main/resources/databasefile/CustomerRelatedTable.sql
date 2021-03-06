drop table customer CASCADE CONSTRAINTS;
drop table account;

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
    customer_id number primary key,
    username nvarchar2(10) unique,
    password nvarchar2(20) not null
);

-- create dummy customer
insert into customer (customer_id, username, first_name, last_name, birth_date, phone, email_address) 
values ( customer_id_seq.nextval, 'dummy', 'Dummif', 'Dummilastier', '01-JAN-1990', '1111111111', 'dummy@email.com');
insert into customer (customer_id, username, first_name, last_name, birth_date, phone, email_address) 
values ( customer_id_seq.nextval, 'pkuser', 'Pipii', 'Kekeke', '01-JAN-1990', '1111111111', 'pk@email.com');

insert into account (customer_id, username, password) 
values (100, 'dummy', 'dummy1234');

insert into account (customer_id, username, password) 
values (101, 'pkuser', '12341234');

select * from customer;
select * from account;

commit;
