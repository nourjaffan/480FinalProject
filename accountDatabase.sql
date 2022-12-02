DROP DATABASE IF EXISTS db;
CREATE DATABASE db; 
USE db;

DROP TABLE IF EXISTS account;
CREATE TABLE account(
    Name                  varchar(50),
    Address               varchar(50),
    CardNumber            varchar(50),
    BillingName           varchar(50),
    BillingAddress        varchar(50),
    Email                 varchar(50),
    Password              varchar(50),
    PhoneNumber           varchar(50),
    BillingPhoneNumber    varchar(50),
    PRIMARY KEY (Email)
);


DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket
    (
    SeatNumber            int,
    ShowTime              varchar(50),
    Title                 varchar(50),
    Cost                  float,
    Day                   int,
    Month                 int,
    Year                  int,
    UniqueTicket          int not null AUTO_INCREMENT,
    Email				  varchar(50),
    PRIMARY KEY (UniqueTicket)
    );


DROP TABLE IF EXISTS reciept;
CREATE TABLE reciept
    (
    UniqueNumber          int,
    PRIMARY KEY(UniqueNumber)
    );
