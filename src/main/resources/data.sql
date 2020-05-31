insert into txn ( ACCOUNT_NUMBER, CUSTOMER_ID, DESCRIPTION, TXN_AMOUNT,TXN_DATE,TXN_TIME)
values ('123456782', 1, 'Testing', '2020.02', '2020-05-05', '11:11:11');
insert into txn ( ACCOUNT_NUMBER, CUSTOMER_ID, DESCRIPTION, TXN_AMOUNT,TXN_DATE,TXN_TIME)
values ('123456781', 1, 'Testing', '2020.03', '2020-05-05', '11:11:11');
INSERT INTO roles(description,name) values ('Admin', 'ADMIN');
INSERT INTO roles(description,name) values ('User', 'USER');

INSERT INTO user (username,password, name) values ('admin','$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 'admin');
INSERT INTO user (username,password, name) values ('user','$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 'user');

insert into USER_ROLES(USER_ID,ROLE_ID) values (1,1);
insert into USER_ROLES(USER_ID,ROLE_ID) values (2,2);