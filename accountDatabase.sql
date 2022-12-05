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
    PRIMARY KEY (Email)
);


DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket
    (
    SeatNumber            int,
    ShowTime              varchar(50),
    Title                 varchar(50),
    Cost                  double,
    Day                   int,
    Month                 int,
    Year                  int,
    Email				  varchar(50),
    UniqueTicket          int not null AUTO_INCREMENT,
    
    PRIMARY KEY (UniqueTicket)
    );


DROP TABLE IF EXISTS reciept;
CREATE TABLE reciept
    (
    UniqueNumber          int,
    PRIMARY KEY(UniqueNumber)
    );
DROP TABLE IF EXISTS news;
CREATE TABLE news
    (
    Title          varchar(50),
    Day           int,
    Month         int,
    Year          int,
    PRIMARY KEY(Title)
    );  
