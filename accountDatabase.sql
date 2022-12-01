DROP DATABASE IF EXISTS db;
CREATE DATABASE db; 
USE db;

DROP TABLE IF EXISTS account;
CREATE TABLE account(
    Name                  varchar(50),
    Address               varchar(50),
    CardNumber            int,
    cardName              varchar(50);
    BillingName           varchar(50),
    BillingAddress        varchar(50),
    Email                 varchar(50),
    Password              varchar(50),
    PhoneNumber           int,
    BillingPhoneNumber    int,
    PRIMARY KEY (Email)
);


DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket
    (
    SeatNumber            int,
    ShowTime              varchar(50),
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
