CREATE DATABASE IF NOT EXISTS 'db';
USE 'db';

DROP TABLE IF EXISTS 'account';
CREATE TABLE 'account'(
    'Name'                  varchar(50),
    'Address'               varchar(50),
    'CardInfo'              int,
    'BillingName'           varchar(50),
    'BillingAddress'        varchar(50),
    'Email'                 varchar(50),
    'Password'              varchar(50),
    'PhoneNumber'           int,
    'BillingPhoneNumber'    int,
    PRIMARY KEY ('Email')
)


DROP TABLE IF EXISTS 'ticket';
CREATE TABLE 'ticket'
    (
    'SeatNumber'            int,
    'Title'                 varchar(50),
    'Cost'                  float,
    'Date'                  String,
    'UniqueTicket'          int AUTOINCREMENT,
    PRIMARY KEY ('UniqueTicket')
    )


DROP TABLE IF EXISTS 'reciept';
CREATE TABLE 'reciept'
    (
    'UniqueNumber'          int,
    PRIMARY KEY('UniqueNumber')
    )
