create schema SWASS;
use swass;

create table if not exists transactions(
transactionID int primary key auto_increment,
date varchar(45), 
amount int,
sender varchar(45),
reciever int
);


create table if not exists users(
userId int primary key auto_increment,
name varchar(45),
lastname varchar(45),
socialsecuritynumber int,
gender varchar(15),
username varchar(25),
password varchar(20),
phonenumber int,
balance int
);
