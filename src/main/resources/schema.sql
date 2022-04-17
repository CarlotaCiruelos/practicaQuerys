

create table USER (
	id integer identity primary key,
	USER_NAME VARCHAR(45) NOT NULL,
	PASSWORD VARCHAR(45) NOT NULL,
	EMAIL VARCHAR(100),
	USER_TYPE VARCHAR(45)

);

CREATE TABLE ACCOUNT(
    id integer identity primary key,
    USER_NAME varchar(30),
    iban varchar(20),
    card_type varchar(45),
    AMOUNT INTEGER
);