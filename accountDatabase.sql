DROP DATABASE IF EXISTS db;
CREATE DATABASE db; 
USE db;

DROP TABLE IF EXISTS account;
CREATE TABLE account(
    Name                  varchar(45),
    Address               varchar(45),
    CardInfo              int,
    BillingName           varchar(45),
    BillingAddress        varchar(45),
    Email                 varchar(45),
    Password              varchar(45),
    PhoneNumber           int,
    BillingPhoneNumber    int,
    PRIMARY KEY (Email)
);


DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket
    (
    SeatNumber            int,
    ShowTime              varchar(45),
    Title                 varchar(50),
    Cost                  float,
    Date                  varchar(50),
    UniqueTicket          int not null AUTO_INCREMENT,
    PRIMARY KEY (UniqueTicket)
    );


DROP TABLE IF EXISTS reciept;
CREATE TABLE reciept
    (
    UniqueNumber          int,
    PRIMARY KEY(UniqueNumber)
    );
